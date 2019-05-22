package com.rls.ids.repositories;

import com.rls.ids.models.User;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, ExtendedUserRepository {
    User findUserByUserId(@NotNull @UniqueElements String userId);
    List<User> findUsersByUserIdIsIn(String[] userId);
    User findUserByAppKey(String appKey);
}
