package jp.co.com.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.com.dao.EmployeeDao;
import jp.co.com.entity.EmployeeEntity;
import jp.co.com.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeDao dao;

	public EmployeeServiceImp() {

	}

	public List<EmployeeEntity> getEmployeeInfo(){

		List<EmployeeEntity> list = dao.getAllEntity();

		return list;
	}

	public EmployeeEntity getEmployeeInfo(String id) {

		EmployeeEntity employee = dao.findById(id);

		return employee;
	}

	public void removeEmployeeInfo(String id) {
		dao.removeEntity(id);
	}

	@Override
	public void updateEmployeeInfo(EmployeeEntity entity) {
		dao.updateEntity(entity);
	}

	@Override
	public void addEmployeeInfo(EmployeeEntity entity) {
		dao.addEntity(entity);
	}
}
