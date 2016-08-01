package com.ds201604.pension.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ds201604.pension.vo.Member;

public class MemberDao extends SqlSessionDaoSupport{
	
	//회원가입
	public int joinMember(Member member){
		return this.getSqlSession().insert("Member.join", member);
	}
	
	//로그인
	public Member loginMember(Member member){
		return this.getSqlSession().selectOne("Member.login", member);
	}
}