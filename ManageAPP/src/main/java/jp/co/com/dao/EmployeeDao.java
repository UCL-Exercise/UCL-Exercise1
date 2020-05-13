package jp.co.com.dao;

import java.util.List;

import jp.co.com.entity.EmployeeEntity;

public interface EmployeeDao {

		public List<EmployeeEntity> getAllEntity();
		public EmployeeEntity findById(String id);
		public void addEntity(EmployeeEntity entity);
		public void updateEntity(EmployeeEntity entity);
		public void removeEntity(EmployeeEntity data);
		public void removeEntity(String id);

}
