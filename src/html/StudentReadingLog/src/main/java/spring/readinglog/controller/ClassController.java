//クラス画面の表示
package spring.readinglog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.readinglog.domain.user.service.UserService;
import spring.readinglog.form.password.ChangePasswordForm;

@Controller
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String get(Model model, ChangePasswordForm form, BindingResult bindingResult) {
		model.addAttribute("classMemberList", userService.getClassMemberList());
		
		model.addAttribute("title", "class");
		return "class";
	}

}
