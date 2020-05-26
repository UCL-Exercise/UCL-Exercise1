package jp.co.com.daoImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.com.dao.RemindInfoDao;
import jp.co.com.entity.RemindUserEntity;


@Repository
@Transactional
public class RemindInfoDaoImp implements RemindInfoDao{

	@Autowired
	private LocalContainerEntityManagerFactoryBean factory;

	@PersistenceContext
	private EntityManager manager;

	SimpleDateFormat sdf;

	@Override
	@SuppressWarnings("unchecked")
	public List<RemindUserEntity> getAllRemindEntity() {

		String sql = "select new jp.co.com.entity.RemindUserEntity(e.name,c.work_place,r.post_interview,r.bikou,c.customer) "
				+ "from EmployeeEntity e,RemindInfoEntity r, ContractInfoEntity c where r.user_id = e.id and c.user_id = e.id and r.post_interview <= :system_time";

		sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

		Query query = manager.createQuery(sql).setParameter("system_time", sdf.format(new Date()));
		List<RemindUserEntity> list = query.getResultList();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<RemindUserEntity> getAllRemindEntity(String id, String name, String date) {

		Query query;
		String sql = "select new jp.co.com.entity.RemindUserEntity(e.name,c.work_place,r.post_interview,r.post_interview,r.bikou,c.customer,c.project) ";

		if(id.isEmpty() && name.isEmpty() && date.isEmpty()) {
			sql += "from EmployeeEntity e,RemindInfoEntity r, ContractInfoEntity c where r.user_id = e.id and c.user_id = e.id";
			query = manager.createQuery(sql);
		}else {
			if(date.isEmpty()) {
				sql += "from EmployeeEntity e,RemindInfoEntity r, ContractInfoEntity c where r.user_id = e.id and c.user_id = e.id and (e.id=:id or e.name=:name)";
				query = manager.createQuery(sql).setParameter("id", id).setParameter("name", name);
			}else {
				sql += "from EmployeeEntity e,RemindInfoEntity r, ContractInfoEntity c where r.user_id = e.id and c.user_id = e.id and (e.id=:id or e.name=:name or r.post_interview like :date)";
				query = manager.createQuery(sql).setParameter("id", id).setParameter("name", name).setParameter("date", date + "%");
			}
		}
		List<RemindUserEntity> list = query.getResultList();

		return list;
	}
}
