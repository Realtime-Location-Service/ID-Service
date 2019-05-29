package com.rls.ids.models;

import com.rls.ids.entities.User;

public class CompanyResponseModel {
    private String domain;
    private String companyId;
    private User admin;

    public CompanyResponseModel() { }

    public CompanyResponseModel(String domain, String companyId, User admin) {
        this.domain = domain;
        this.companyId = companyId;
        this.admin = admin;
    }

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
