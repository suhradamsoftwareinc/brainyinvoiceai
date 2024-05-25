package com.brainyinvoiceai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brainyinvoiceai.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
