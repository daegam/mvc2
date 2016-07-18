package com.example.daegam.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.example.daegam.vo.Board;

public class BoardDao extends SqlSessionDaoSupport{

	public void boardWrite(Board board){
		this.getSqlSession().insert("Board.boardWrite", board);
	}
	
	public List<Board> getBoardList(){
		return this.getSqlSession().selectList("Board.getBoardList");
	}
	
	public Board getBoardContent(int no){
		return this.getSqlSession().selectOne("Board.getBoardContent", no);
	}
	
	public void boardUpdate(Board board){
		this.getSqlSession().update("Board.boardUpdate", board);
	}
	
	public void boardDelete(int no){
		this.getSqlSession().delete("Board.boardDelete", no);
	}
	
	public List<Board> getBoardListJson(int start){
		return this.getSqlSession().selectList("Board.getBoardListJson", start);
	}
}