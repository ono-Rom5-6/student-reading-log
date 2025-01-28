package spring.readinglog.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import spring.readinglog.domain.user.model.Member;
import spring.readinglog.domain.user.model.User;

@Mapper
public interface UserMapper {
	public User findLoginUser(String user);
	
	public String findPasswordByName(@Param("user") String user);
	
	public void updatePass(@Param("user") String user, @Param("pass") String pass);
	
	public ArrayList<Member> selectMemberList();
	
}
