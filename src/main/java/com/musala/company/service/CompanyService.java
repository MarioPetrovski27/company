package com.musala.company.service;

import java.util.List;

import com.musala.company.exception.DataNotFoundException;
import com.musala.company.jpa.hibernate.model.Company;

public interface CompanyService {

	public List<Company> getCompanies();

	public Company getCompany(long id) throws DataNotFoundException;

	public Company postCompany(Company c);

	public Company updateCompany(Company c);

	public void deleteCompany(Company c);
}
