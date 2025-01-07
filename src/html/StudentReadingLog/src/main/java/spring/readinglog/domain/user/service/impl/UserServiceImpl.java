//ログイン処理、パスワード変更処理
package spring.readinglog.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.readinglog.domain.user.model.User;
import spring.readinglog.domain.user.service.UserService;
import spring.readinglog.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User getLoginUser(String user) {
		return userMapper.findLoginUser(user);
	}
	
	@Override
    public boolean checkPassword(String name, String currentPassword) {
        return passwordEncoder.matches(currentPassword, userMapper.findPasswordByName(name));
    }

	@Override
    public void updatePassword(String username, String newPassword) {
        String hashedPassword = passwordEncoder.encode(newPassword);
        userMapper.updatePass(username, hashedPassword);
    }
	
	
}