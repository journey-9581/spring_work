package com.gura.spring04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.member.dto.MemberDto;

//component scan을 통해서 bean이 되도록 어노테이션을 붙여준다
//Dao에는 @Repository라는 어노테이션을 붙여야 한다
@Repository
public class MemberDaoImpl implements MemberDao{
	/*
	 * servlet-context.xml 문서에 bean 설정으로 bean이 된
	 * SqlSessionTemplate 객체의 참조값을 필드에 주입(DI) 받는 방법은
	 * @AutoWired 어노테이션을 필드 선언 앞이나 위에 붙여주면 된다
	 * 단, MemberDaoImpl 객체도 bean이 되어야 한다 
	 */
	@Autowired
	private SqlSession session; //sqlSessionTemplate 객체의 참조값이 @Autowired를 통해 주입됨

	@Override
	public List<MemberDto> getList() {
		/*
		 * Mapper.xml 문서의 namespace => member
		 * sql의 id => getList
		 * parameterType => 없음
		 * resultType => MemberDto
		 */
		//.selectList()를 호출했을 때 List가 리턴되고 resultType이 곧 List의 Generic type이 된다
		List<MemberDto> list=session.selectList("member.getList"); //("mapper.xml's namespace.sql id in mapper xml")
		
		return list;
	}

	@Override
	public void insert(MemberDto dto) {
		/*
		 * Mapper.xml 문서의 namespace => member
		 * sql의 id => insert
		 * parameterType => MemberDto
		 */
		session.insert("member.insert", dto);
	}

	@Override
	public void update(MemberDto dto) {
		/*
		 * Mapper.xml 문서의 namespace => member
		 * sql의 id => update
		 * parameterType => MemberDto
		 */
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		/*
		 * Mapper.xml 문서의 namespace => member
		 * sql의 id => delete
		 * parameterType => int
		 */
		session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 * Mapper.xml 문서의 namespace => member
		 * sql의 id => getData
		 * parameterType => int
		 * resultType => MemberDto
		 */
		//.selectOne()을 호출 했을 때 resultType이 곧 리턴 타입이 된다
		// = 리턴 타입이 동적이다 (int, String, ...)
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}

}
