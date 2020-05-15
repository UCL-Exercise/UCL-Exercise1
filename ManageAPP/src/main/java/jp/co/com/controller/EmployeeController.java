package jp.co.com.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value="id") String id, Model model) {
		service.removeEmployeeInfo(id);
		List<EmployeeEntity> list = service.getEmployeeInfo();
		model.addAttribute("list", list);
		return "show";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(value="id") String id, Model model,EmployeeForm form) {
		EmployeeEntity entity =  service.getEmployeeInfo(id);
		form.setId(entity.getId());
		form.setName(entity.getName());
		form.setAddress(entity.getAddress());
		form.setAge(entity.getAge());
		form.setComment(entity.getComment());
		form.setExp_year(entity.getExp_year());
		form.setNation(entity.getNation());
		form.setSex(entity.getSex());
		form.setSkill(entity.getSkill());
		model.addAttribute("form", form);
		return "update";
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String show(EmployeeForm form, Model model) {

		EmployeeEntity entity =  service.getEmployeeInfo(form.getId());

		form.setId(entity.getId());
		form.setName(entity.getName());
		model.addAttribute("form", form);

		List<EmployeeEntity> list = service.getEmployeeInfo();
		model.addAttribute("list", list);
		return "show";
	}

	@RequestMapping(value = "/data_update", method = RequestMethod.POST)
	public String data_update(EmployeeForm form, Model model) {

		EmployeeEntity entity =  new EmployeeEntity();
		entity.setId(form.getId());
		entity.setName(form.getName());
		entity.setAddress(form.getAddress());
		entity.setAge(form.getAge());
		entity.setComment(form.getComment());
		entity.setExp_year(form.getExp_year());
		entity.setNation(form.getNation());
		entity.setSex(form.getSex());
		entity.setSkill(form.getSkill());
		service.updateEmployeeInfo(entity);

		List<EmployeeEntity> list = service.getEmployeeInfo();
		model.addAttribute("list", list);
		return "show";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {

		return "add";
	}

	@RequestMapping(value = "/data_add", method = RequestMethod.POST)
	public String data_add(@Validated EmployeeForm form, BindingResult result, Model model) {

		if(result.hasErrors()) {
			return "add";
		}

		EmployeeEntity entity =  new EmployeeEntity();
		entity.setId(form.getId());
		entity.setName(form.getName());
		entity.setAddress(form.getAddress());
		entity.setAge(form.getAge());
		entity.setComment(form.getComment());
		entity.setExp_year(form.getExp_year());
		entity.setNation(form.getNation());
		entity.setSex(form.getSex());
		entity.setSkill(form.getSkill());
		service.addEmployeeInfo(entity);

		List<EmployeeEntity> list = service.getEmployeeInfo();
		model.addAttribute("list", list);
		return "show";
	}
}
