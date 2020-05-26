package jp.co.com.dao;

import java.util.List;

import jp.co.com.entity.RemindUserEntity;

public interface RemindInfoDao {

		public List<RemindUserEntity> getAllRemindEntity();

		public List<RemindUserEntity> getAllRemindEntity(String id, String name, String date);
}
