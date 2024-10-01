package com.kiran.company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
	List<Company> getAllCompanies();
	boolean updateCompanyById(Long id, Company updateCompany);
	boolean deleteCompanyById(Long id);
	Company getCompanyById(Long id);
	void createCompany(Company company);
	

}
