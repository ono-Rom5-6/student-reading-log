package spring.readinglog.form.password;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ChangePasswordForm {
	@NotBlank
	private String currentPassword;
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9]{8,24}$")
	private String newPassword;
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9]{8,24}$")
	private String confirmNewPassword;

}
