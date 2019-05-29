package com.rls.ids.repositories;

import com.rls.ids.entities.Company;
import com.rls.ids.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
//    @Transactional(readOnly = true)
    Company getCompanyByCid(String cid);
}
