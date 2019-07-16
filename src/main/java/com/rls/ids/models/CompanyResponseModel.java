package com.rls.ids.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.rls.ids.entities.Company;
import com.rls.ids.entities.User;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CompanyResponseModel {
    private String domain;
    private String companyId;
    private String companyName;
    private User admin;

    public CompanyResponseModel() { }

    public CompanyResponseModel(Company company, User admin) {
        this.domain = company.getDomain();
        this.companyName = company.getName();
        this.admin = admin;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
