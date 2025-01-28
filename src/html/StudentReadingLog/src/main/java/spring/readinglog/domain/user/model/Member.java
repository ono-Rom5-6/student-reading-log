package spring.readinglog.domain.user.model;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String name;
	private String NumberOfBooksReadThisMonth;

}
