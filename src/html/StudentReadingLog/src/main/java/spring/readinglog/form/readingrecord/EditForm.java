package spring.readinglog.form.readingrecord;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditForm {
	private String id;
	private String userId;

	@NotBlank
	@Length(max = 100)
	private String title;

	@Length(max = 50)
	private String author;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startingDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date finishedDate;

	@Length(max = 3000)
	private String memos;


}
