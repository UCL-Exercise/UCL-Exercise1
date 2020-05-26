package jp.co.com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="remind_info")
public class RemindInfoEntity {

	@Id
	String id;

	String user_id;

	String pre_interview;

	String post_interview;

	String bikou;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPre_interview() {
		return pre_interview;
	}

	public void setPre_interview(String pre_interview) {
		this.pre_interview = pre_interview;
	}

	public String getPost_interview() {
		return post_interview;
	}

	public void setPost_interview(String post_interview) {
		this.post_interview = post_interview;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}
}
