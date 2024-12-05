package spring.readinglog.repository;

import org.apache.ibatis.annotations.Mapper;

import spring.readinglog.domain.user.model.User;

@Mapper
public interface UserMapper {
	public User findLoginUser(String user);

}
