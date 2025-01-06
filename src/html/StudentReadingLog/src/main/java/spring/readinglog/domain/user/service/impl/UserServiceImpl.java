package spring.readinglog.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.readinglog.domain.user.model.User;
import spring.readinglog.domain.user.service.UserService;
import spring.readinglog.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getLoginUser(String user) {
		return userMapper.findLoginUser(user);
	}
}