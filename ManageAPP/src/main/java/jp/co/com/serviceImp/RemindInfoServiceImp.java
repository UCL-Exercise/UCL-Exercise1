package jp.co.com.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.com.dao.RemindInfoDao;
import jp.co.com.entity.RemindUserEntity;
import jp.co.com.service.RemindInfoService;

@Service
public class RemindInfoServiceImp implements RemindInfoService{

	@Autowired
	private RemindInfoDao dao;

	@Override
	public List<RemindUserEntity> getRemindInfo() {

		List<RemindUserEntity> remindList = dao.getAllRemindEntity();

		return remindList;
	}

	@Override
	public List<RemindUserEntity> getRemindInfo(String id, String name, String date) {

		List<RemindUserEntity> remindList = dao.getAllRemindEntity(changeNullToSpace(id),changeNullToSpace(name),changeNullToSpace(date));

		return remindList;
	}

	private String changeNullToSpace(String str) {
		if(str == null) {
			str = "";
		}
		return str;
	}
}
