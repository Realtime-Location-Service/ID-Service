package com.rls.ids.converters;

import org.springframework.util.MultiValueMap;

import java.util.concurrent.atomic.AtomicBoolean;

public class RequestParamsToSQLConverter {
    public static String getSQLQuery(MultiValueMap<String, String> requestParams, String tableName) {
        StringBuilder sql = new StringBuilder();
        final int[] page = {1};
        final int[] size = {100};

        AtomicBoolean where_clause = new AtomicBoolean(false);
        requestParams.forEach((key, value) -> {
            if (key.equalsIgnoreCase("page")) page[0] = Integer.parseInt(value.get(0));
            else if (key.equalsIgnoreCase("size")) size[0] = Integer.parseInt(value.get(0));
            else {
                if (!where_clause.get()) sql.append(" WHERE ");
                else sql.append(" AND ");
                sql.append(tableName).append(".").append(key).append(" IN (").append(String.join(",", value)).append(")");
                where_clause.set(true);
            }
        });
        sql.append(" LIMIT ").append((page[0] - 1) * size[0]).append(", ").append(size[0]);

        return sql.toString();
    }
}
