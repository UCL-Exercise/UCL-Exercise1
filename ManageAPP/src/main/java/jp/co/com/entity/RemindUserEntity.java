package jp.co.com.entity;

/**
 * @author UCL_0511
 *
 */
public class RemindUserEntity {

	String name;

	String work_place;

	String pre_interview;

	String post_interview;

	String bikou;

	String customer;

	String project;

	String money;

	public RemindUserEntity(String name, String work_place, String post_interview, String bikou, String customer) {

		super();
		this.name = name;
		this.work_place = work_place;
		this.post_interview = post_interview;
		this.bikou = bikou;
		this.customer = customer;
	}

	public RemindUserEntity(String name, String work_place, String pre_interview, String post_interview, String bikou, String customer, String project) {

		super();
		this.name = name;
		this.work_place = work_place;
		this.pre_interview = pre_interview;
		this.post_interview = post_interview;
		this.bikou = bikou;
		this.customer = customer;
		this.project = project;
	}

	public RemindUserEntity(String name, String work_place, String pre_interview, String post_interview, String bikou, String customer, String project, String money) {

		super();
		this.name = name;
		this.work_place = work_place;
		this.pre_interview = pre_interview;
		this.post_interview = post_interview;
		this.bikou = bikou;
		this.customer = customer;
		this.project = project;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWork_place() {
		return work_place;
	}

	public void setWork_place(String work_place) {
		this.work_place = work_place;
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPre_interview() {
		return pre_interview;
	}

	public void setPre_interview(String pre_interview) {
		this.pre_interview = pre_interview;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
}
