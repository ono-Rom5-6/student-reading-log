//クラス画面の表示
package spring.readinglog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.readinglog.domain.user.service.UserService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String get(Model model) {
		model.addAttribute("memberList", userService.getMemberList());
		
		model.addAttribute("title", "member");
		return "member";
	}

}
