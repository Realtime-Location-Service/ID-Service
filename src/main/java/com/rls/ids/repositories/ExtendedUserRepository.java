package com.rls.ids.repositories;

import org.springframework.util.MultiValueMap;

import java.util.List;

import com.rls.ids.entities.User;

public interface ExtendedUserRepository {
    List<User> findAllPaged(MultiValueMap<String, String> requestParams);

    List<User> getUserWithCompanyByAppKey(String appKey);
}
