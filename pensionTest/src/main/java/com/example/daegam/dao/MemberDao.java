package com.example.daegam.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.example.daegam.vo.Member;

public class MemberDao extends SqlSessionDaoSupport{
	
	//회원가입
	public int joinMember(Member member){
		return this.getSqlSession().insert("Member.join", member);
	}
}