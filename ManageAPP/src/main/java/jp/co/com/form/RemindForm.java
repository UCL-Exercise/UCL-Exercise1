package jp.co.com.form;

import javax.validation.constraints.Pattern;

public class RemindForm {

	private String id;

	private String name;

	@Pattern(regexp = "(^$)|(^\\d{4}-(0[1-9]|1[0-2])$)", message = "年月を入力してください")
	String date;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
