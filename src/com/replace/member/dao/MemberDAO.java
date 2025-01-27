package com.replace.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.replace.mybatis.config.MyBatisConfig;
import com.replace.member.domain.MemberVO;

public class MemberDAO {
	public SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	회원가입
	public void join(MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}
	
//	이메일 중복검사
	public String selectEmail(String memberEmail) {
		return sqlSession.selectOne("member.selectEmail", memberEmail);
	}
//	password 확인
	public String selectPassword(String memberPassword) {
		return sqlSession.selectOne("member.selectPassword", memberPassword);
	}
	/*		
//	아이디 중복검사
	public String selectIdentification(String memberIdentification) {
		return sqlSession.selectOne("member.selectIdentification", memberIdentification);
	}


	
//	로그인
	public Long login(String memberIdentification, String memberPassword) {
		HashMap<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("memberIdentification", memberIdentification);
		loginMap.put("memberPassword", memberPassword);
		
		return sqlSession.selectOne("member.login", loginMap);
	}*/

//	회원정보 조회
	public MemberVO selectMember(String memberId) {
		return sqlSession.selectOne("member.myPage", memberId);
	}
	
}






















