package com.gura.spring05.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService{
	//의존객체 DI 
	@Autowired
	private CafeDao cafeDao;

	@Override
	public void saveContent(CafeDto dto) {
		cafeDao.insert(dto);
	}

}