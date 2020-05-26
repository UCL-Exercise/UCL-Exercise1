package jp.co.com.service;

import java.util.List;

import jp.co.com.entity.RemindUserEntity;

public interface  RemindInfoService {

	public List<RemindUserEntity> getRemindInfo();

	List<RemindUserEntity> getRemindInfo(String id, String name, String date);
}
