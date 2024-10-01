package com.kiran.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.company.Company;
import com.kiran.company.CompanyRepository;
import com.kiran.company.CompanyService;

@Service
public class CompanyServiceImpl  implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public boolean updateCompanyById(Long id, Company updateCompany) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if(companyOptional.isPresent()) {
			 Company companyToUpdate = companyOptional.get();
			 companyToUpdate.setName(updateCompany.getName());
			 companyToUpdate.setDescription(updateCompany.getDescription());
			 companyRepository.save(companyToUpdate);
			 return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		if(companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
		
	}

}
