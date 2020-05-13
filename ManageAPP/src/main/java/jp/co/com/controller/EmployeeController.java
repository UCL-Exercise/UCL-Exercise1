package jp.co.com.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.com.entity.EmployeeEntity;
import jp.co.com.form.EmployeeForm;
import jp.co.com.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@ModelAttribute
    public EmployeeForm setUpEmployeeForm() {
        EmployeeForm form = new EmployeeForm();
        return form;
    }

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {
		return "input";
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String show(EmployeeForm form, Model model) {

		EmployeeEntity entity =  service.getEmployeeInfo(form.getId());

		form.setId(entity.getId());
		form.setName(entity.getName());
		model.addAttribute("form", form);
		return "show";
	}

}
