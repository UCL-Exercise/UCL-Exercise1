package jp.co.com.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class EmployeeForm {

	@NotBlank(message = "職員IDを入力してください")
	private String id;

	@NotBlank(message = "職員氏名を入力してください")
	private String name;

	String sex;

	@NotBlank
	@Size(max = 100,message = "100桁数以下しか入力できない")
	String address;

	@NotBlank
	String nation;

	@NotBlank
	String skill;

	@NotBlank
	String exp_year;

	@Pattern(regexp = "[1-9]?[0-9]", message = "数字を入力してください。")
	String age;

	String comment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getExp_year() {
		return exp_year;
	}

	public void setExp_year(String exp_year) {
		this.exp_year = exp_year;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
