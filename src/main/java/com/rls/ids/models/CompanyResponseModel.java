package com.rls.ids.models;

import com.rls.ids.entities.User;

import java.util.List;

public class CompanyResponseModel {
    private String domain;
    private String companyId;
    private User admin;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
