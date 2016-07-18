package com.example.daegam.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.example.daegam.vo.AppMember;
import com.example.daegam.vo.Item;
import com.example.daegam.vo.Member;

public class CommonDao extends SqlSessionDaoSupport {

	public void join(Member member) {
		this.getSqlSession().insert("Member.addMember", member);
	}

	public Member login(Member member) {
		return this.getSqlSession().selectOne("Member.loginMember", member);
	}

	public List<Member> getList(int cnt) {
		return this.getSqlSession().selectList("Member.getList", cnt);
	}

	public void mdelete(String id) {
		this.getSqlSession().delete("Member.deleteMember", id);
	}

	public Member getMemberOne(String id) {
		return this.getSqlSession().selectOne("Member.getMemberOne", id);
	}
	
	public void updateMember(Member member){
		this.getSqlSession().update("Member.updateMember", member);
	}
	
	public String searchId(String id){
		return this.getSqlSession().selectOne("Member.searchId", id);
	}
	
	public List<Item> getItemList(int start){
		return this.getSqlSession().selectList("Item.getItemList", start);
	}
	
	public AppMember getOneMember(String id){
		return this.getSqlSession().selectOne("Member.getOneMember", id);
	}
}