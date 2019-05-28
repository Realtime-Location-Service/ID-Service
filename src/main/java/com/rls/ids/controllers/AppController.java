package com.rls.ids.controllers;

import com.rls.ids.constants.Role;
import com.rls.ids.entities.Company;
import com.rls.ids.entities.User;
import com.rls.ids.exceptions.InvalidAppKeyException;
import com.rls.ids.exceptions.MissingHeaderException;
import com.rls.ids.models.CompanyResponseModel;
import com.rls.ids.models.SignUpRequestModel;
import com.rls.ids.models.UserSignUpResponseModel;
import com.rls.ids.repositories.CompanyRepository;
import com.rls.ids.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyGenerator;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@RestController    // This means that this class is a Controller
public class AppController {
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Value("application.secretKey")
    private String secretKey;

    @Autowired
    public AppController(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    @RequestMapping(path="company/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public ResponseEntity<CompanyResponseModel> companySignUp(@Valid @RequestBody Company company, @RequestHeader("SecretKey") String secretKey) throws NoSuchAlgorithmException {
        if (isInvalidRequest(secretKey) && secretKey.equals(this.secretKey))
            throw new MissingHeaderException(secretKey + " is missing or invalid.");

        companyRepository.save(company);

        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits

        User admin = new User(UUID.randomUUID().toString(), company.getCid(), Role.ADMIN);
        admin.setAppKey(Base64.getEncoder().encodeToString(generator.generateKey().getEncoded()));
        userRepository.save(admin);

        CompanyResponseModel companyResponseModel = new CompanyResponseModel(company.getDomain(), company.getCid(), admin);
        return new ResponseEntity<>(companyResponseModel, HttpStatus.OK);
    }

    @RequestMapping(path="user/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public ResponseEntity<User> userSignUp(@Valid @RequestBody SignUpRequestModel signUpModel) {
        User admin = userRepository.getUserByAppKey(signUpModel.getAppKey());

        if (admin == null)
            throw new InvalidAppKeyException(signUpModel.getAppKey()+" is invalid!");

        User user = new User(signUpModel.getUserId(), admin.getCid(), Role.USER);
        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(path="user/resolve", method = RequestMethod.GET) // Map ONLY POST Requests
    public ResponseEntity<UserSignUpResponseModel> resolveUser(@RequestParam String appKey) {
        if (isInvalidRequest(appKey))
            throw new MissingHeaderException(appKey + " is missing or invalid.");

        User admin = userRepository.getUserByAppKey(appKey);

        if (admin == null)
            throw new InvalidAppKeyException(appKey+" is invalid!");

        UserSignUpResponseModel model = new UserSignUpResponseModel(admin.getUserId(), admin.getRole(),
                admin.getAppKey(), admin.getCid());
        model.setSubordinates(userRepository.findUsersByCidAndRole(admin.getCid(), Role.USER));
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    private boolean isInvalidRequest(String value) {
        if (value == null)
            return true;
        return value.isBlank();
    }
}