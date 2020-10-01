package com.rls.ids.repositories;

import com.rls.ids.entities.User;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, ExtendedUserRepository {
    User findUserByUserId(@NotNull @UniqueElements String userId);

    User findUserByUserIdAndCompanyId(@NotNull String userId, int cid);

    User findUserByCompanyId(int cid);

    List<User> findUsersByCompanyIdAndRole(int cid, String role);

    List<User> findUsersByUserIdIsIn(String[] userId);

    User findUserByAppKey(String appKey);

    // @Transactional(readOnly = true)
    User getUserByAppKey(String appKey);

    User getUserByCompanyIdAndUserId(int cid, String userId);
}
