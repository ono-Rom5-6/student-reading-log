//パスワード変更画面の表示、変更処理、パスワード変更完了画面の表示
package spring.readinglog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.readinglog.domain.user.service.UserService;
import spring.readinglog.form.password.ChangePasswordForm;

@Controller
@RequestMapping("/change-password")
public class ChangePasswordController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("index")
	public String get(Model model, ChangePasswordForm form, BindingResult bindingResult) {
		return "change-password/index";
	}

	@PostMapping("index")
	public String post(Model model, @ModelAttribute @Validated ChangePasswordForm form, BindingResult bindingResult,
			Authentication authentication) {
		String username = authentication.getName();

		String currentPassword = form.getCurrentPassword();
		String newPassword = form.getNewPassword();
		String confirmNewPassword = form.getConfirmNewPassword();

		if (!userService.checkPassword(username, currentPassword)) {
			bindingResult.rejectValue("currentPassword", "mismatch.password",
					new Object[] { messageSource.getMessage("mismatch.password", null, null) }, null);
		}

		if (!newPassword.equals(confirmNewPassword)) {
			bindingResult.rejectValue("confirmNewPassword", "mismatch.password",
					new Object[] { messageSource.getMessage("mismatch.password", null, null) }, null);
		}

		if (bindingResult.hasErrors()) {
			return get(model, form, bindingResult);
		}

		try {
			userService.updatePassword(username, newPassword);
		} catch (Exception e) {
			return "redirect:/error";
		}

		return "redirect:/change-password/finish";
	}

	@GetMapping("/finish")
	public String getFinish() {
		return "change-password/finish";
	}
}
