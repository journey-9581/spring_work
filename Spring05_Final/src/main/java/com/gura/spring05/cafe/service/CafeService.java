package com.gura.spring05.cafe.service;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	//새 글을 저장하는 메소드 
	public void saveContent(CafeDto dto);
}