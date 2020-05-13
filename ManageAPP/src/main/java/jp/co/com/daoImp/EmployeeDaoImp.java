package jp.co.com.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.com.dao.EmployeeDao;
import jp.co.com.entity.EmployeeEntity;


@Repository
@Transactional
public class EmployeeDaoImp implements EmployeeDao{

	@Autowired
	private LocalContainerEntityManagerFactoryBean factory;

	@PersistenceContext
	private EntityManager manager;

	public EmployeeDaoImp() {

	}

	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> getAllEntity() {
		System.out.println("getAllEntity()");
		Query query = manager.createQuery("from employee");
		return query.getResultList();
	}

	public EmployeeEntity findById(String id) {
		System.out.println("findById(id)");
		Query query = manager.createQuery("from EmployeeEntity where id = :id").setParameter("id", id);
		return (EmployeeEntity) query.getSingleResult();
	}

	public void addEntity(EmployeeEntity entity) {
		System.out.println("addEntity(entity)");
		// Transactionは共通のmanagerでは使えないのでここでmanagerを取り直す
		EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		manager.flush();
		transaction.commit();
	}

	public void updateEntity(EmployeeEntity entity) {
		System.out.println("updateEntity(entity)");
		// Transactionは共通のmanagerでは使えないのでここでmanagerを取り直す
		EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(EmployeeEntity entity) {
		System.out.println("removeEntity(entity)");
		// Transactionは共通のmanagerでは使えないのでここでmanagerを取り直す
		EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(entity);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(String id) {
		System.out.println("removeEntity(id)");
		// Transactionは共通のmanagerでは使えないのでここでmanagerを取り直す
		EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
		// 前もって find して managed 状態にしておかないと remove で削除できない
		EmployeeEntity entity = manager.find(EmployeeEntity.class, id);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(entity);
		manager.flush();
		transaction.commit();
	}
}