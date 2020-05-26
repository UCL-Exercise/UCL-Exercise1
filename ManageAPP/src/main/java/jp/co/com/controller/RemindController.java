package jp.co.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.com.entity.RemindUserEntity;
import jp.co.com.form.RemindForm;
import jp.co.com.service.RemindInfoService;

@Controller
public class RemindController {

	@ModelAttribute
    public RemindForm setUpRemindForm() {
		RemindForm form = new RemindForm();
        return form;
    }

	@Autowired
	RemindInfoService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {
		List<RemindUserEntity> remindList = service.getRemindInfo();
		model.addAttribute("remindList", remindList);
		return "home";
	}

	@RequestMapping(value = "/remind_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String remind_info(@Validated RemindForm form, BindingResult result, Model model) {

		if(result.hasErrors()) {
			return "remind";
		}

		List<RemindUserEntity> remindList = service.getRemindInfo(form.getId(),form.getName(),form.getDate());
		model.addAttribute("remindList", remindList);
		return "remind";
	}
}
