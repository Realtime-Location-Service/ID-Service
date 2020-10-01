package com.rls.ids.repositories;

import com.rls.ids.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    // @Transactional(readOnly = true)
    Company getCompanyById(int id);

    Company getCompanyByDomain(String domain);
}
