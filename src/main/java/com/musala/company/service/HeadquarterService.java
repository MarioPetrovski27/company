package com.musala.company.service;

import java.util.List;

import com.musala.company.jpa.hibernate.model.Headquarter;

public interface HeadquarterService {

	public List<Headquarter> getHeadquarters();

	public Headquarter getHeadquarter(long id);

	public Headquarter postHeadquarter(Headquarter h);

	public Headquarter updateHeadquarter(Headquarter h);

	public void deleteHeadquarter(Headquarter h);
}
