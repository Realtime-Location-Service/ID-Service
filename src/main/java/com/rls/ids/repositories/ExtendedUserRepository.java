package com.rls.ids.repositories;

import org.springframework.util.MultiValueMap;

import java.util.List;

public interface ExtendedUserRepository {
    List findAllPaged(MultiValueMap<String, String> requestParams);
}
