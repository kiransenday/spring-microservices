package com.kiran.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private CompanyService companyService;
	
	
	public CompanyController() {
		super();
	}

	@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Company>> getAllCompanies(){
	    List<Company> allCompanies = companyService.getAllCompanies();
	    return new ResponseEntity<>(allCompanies, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompanyById(@PathVariable("id") Long id, @RequestBody Company updateCompany){
		boolean isComapnyUpdated = companyService.updateCompanyById(id, updateCompany);
		if(isComapnyUpdated) {
			return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Company not updated successfully", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable("id") Long id){
		boolean isComapnyDeleted = companyService.deleteCompanyById(id);
		if(isComapnyDeleted) {
			return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Company not deleted successfully", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id){
		Company companyById = companyService.getCompanyById(id);
		if (companyById != null) {
            return new ResponseEntity<>(companyById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@PostMapping()
	public ResponseEntity<String> addCompany(@RequestBody Company company){
		 companyService.createCompany(company);
		 return new ResponseEntity<String>("Company object added successfully", HttpStatus.OK);
	}
	

}
