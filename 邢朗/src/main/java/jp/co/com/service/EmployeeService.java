package jp.co.com.service;

import java.util.List;

import jp.co.com.entity.EmployeeEntity;

public interface  EmployeeService {

	public List<EmployeeEntity> getEmployeeInfo();

	public EmployeeEntity getEmployeeInfo(String id);

	public void removeEmployeeInfo(String id);

	public void updateEmployeeInfo(EmployeeEntity entity);

	public void addEmployeeInfo(EmployeeEntity entity);
	
	public List<EmployeeEntity> getResultInfo(String name,String skill,String address,String exp_year);
//	public List<EmployeeEntity> getResultInfo(String name);
}
