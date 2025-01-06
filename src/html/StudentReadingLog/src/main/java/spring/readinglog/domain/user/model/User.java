package spring.readinglog.domain.user.model;

import lombok.Data;

@Data
public class User {
	private String id;
	private String user;
	private String pass;
	private String studentNumber;
	private String name;
	private String authority;
}
