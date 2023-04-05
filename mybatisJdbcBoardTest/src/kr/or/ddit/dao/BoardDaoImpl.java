package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.BoardVO;


public class BoardDaoImpl implements IBoardDao {
	//싱글톤 1번
	private static BoardDaoImpl dao;
	
	//2번
	private BoardDaoImpl() {}
	
	//3번
	public static BoardDaoImpl getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
	
		SqlSession session = null;
		int cnt = 0; //반환값이 저장될 변수 
		
		try { 
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.insert("board.insertBoard",boardVo);
				
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		

		SqlSession session = null;
		int cnt = 0; //반환값이 저장될 변수 
		
		try { 
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.delete("board.deleteBoard",boardNo);
				
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}



	@Override
	public int updateBoard(BoardVO boardVo) {

		SqlSession session = null;
		int cnt = 0; //반환값이 저장될 변수 
		
		try { 
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.update("board.updateBoard",boardVo);
				
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public BoardVO getBoard(int boardNo) {

		SqlSession session = null;
		BoardVO vo = null;
		
		try { 
			session = MybatisSqlSessionFactory.getSqlSession();
			
			vo = session.selectOne("board.getBoard", boardNo);
				
		} finally {
			session.commit();
			session.close();
		}
		return vo;
		
	}

	@Override
	public List<BoardVO> getAllBoardList() {

		SqlSession session = null;
		List<BoardVO> list; //반환값이 저장될 변수 
		
		try { 
			session = MybatisSqlSessionFactory.getSqlSession();
			
			list = session.selectList("board.getAllBoard");
				
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> getSearchBoardList(String title) {

		SqlSession session = null;
		List<BoardVO> list = new ArrayList<>(); //반환값이 저장될 변수 
		
		try { 
			session = MybatisSqlSessionFactory.getSqlSession();
			
			list = session.selectList("board.getSearchBoard",title);
				
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}


	@Override
	public int setCountIncrement(int boardNo) {

		SqlSession session = null;
		int cnt = 0; //반환값이 저장될 변수 
		
		try { 
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.update("board.getCount",boardNo);
				
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}
}
