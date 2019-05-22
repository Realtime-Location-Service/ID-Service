package com.rls.ids.repositories;

import com.rls.ids.converters.RequestParamsToSQLConverter;
import com.rls.ids.models.User;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("unused")
public class UserRepositoryImpl implements ExtendedUserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List findAllPaged(MultiValueMap<String, String> requestParams) {
        String query = "SELECT * FROM user u" +
                RequestParamsToSQLConverter.getSQLQuery(requestParams, "u");

        return em.createNativeQuery(query, User.class).getResultList();
    }
}
