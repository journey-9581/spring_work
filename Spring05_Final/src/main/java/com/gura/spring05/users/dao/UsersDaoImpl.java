package com.gura.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	//핵심 의존 객체
	@Autowired
	private SqlSession session;
	
	@Override
	public void updateProfile(UsersDto dto) {
		
	}

	@Override
	public boolean isExist(String id) {

		return false;
	}

	@Override
	public void updatePwd(UsersDto dto) {
		
	}

	@Override
	public void update(UsersDto dto) {
		
	}

	@Override
	public void delete(String id) {
		
	}

	@Override
	public UsersDto getData(String id) {

		return null;
	}

	@Override
	public boolean isValid(UsersDto dto) {

		return false;
	}

	@Override
	public void insert(UsersDto dto) {
		
	}

}
