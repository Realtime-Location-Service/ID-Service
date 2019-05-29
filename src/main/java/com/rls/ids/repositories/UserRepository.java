package com.rls.ids.repositories;

import com.rls.ids.entities.Company;
import com.rls.ids.entities.User;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, ExtendedUserRepository {
    User findUserByUserId(@NotNull @UniqueElements String userId);
    User findUserByUserIdAndCid(@NotNull String userId, String cid);
    User findUserByCid(String cid);
    List<User> findUsersByCidAndRole(String cid, String role);
    List<User> findUsersByUserIdIsIn(String[] userId);
    User findUserByAppKey(String appKey);

//    @Transactional(readOnly = true)
    User getUserByAppKey(String appKey);
}
