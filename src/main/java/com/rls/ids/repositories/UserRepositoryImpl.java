package com.rls.ids.repositories;

import com.rls.ids.converters.RequestParamsToSQLConverter;
import com.rls.ids.entities.User;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

// @SuppressWarnings("unused")
public class UserRepositoryImpl implements ExtendedUserRepository {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllPaged(MultiValueMap<String, String> requestParams) {
        String query = "SELECT * FROM user u" + RequestParamsToSQLConverter.getSQLQuery(requestParams, "u");

        return em.createNativeQuery(query, User.class).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUserWithCompanyByAppKey(String appKey) {
        String query = "SELECT u.user_id, u.role, c.name AS company_name, c.id AS company_id, c.domain FROM user u JOIN company c WHERE app_key='"
                + appKey + "'";

        Query queryObj = em.createNativeQuery(query);
        return queryObj.getResultList();
    }
}
