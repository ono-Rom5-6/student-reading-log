package spring.readinglog.domain.user.service;


import org.springframework.stereotype.Service;

import spring.readinglog.domain.user.model.User;

@Service
public interface UserService {
	public User getLoginUser(String user);

}
