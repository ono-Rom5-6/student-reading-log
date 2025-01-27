//ログイン画面の表示
package spring.readinglog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
	@GetMapping("/login")
	public String get() {
		return "login";
	}

}
