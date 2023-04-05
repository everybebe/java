package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.MybatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao {
	Scanner scan = new Scanner(System.in);
	
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao= new MemberDaoImpl();
		return dao;
	}
	@Override
	public int insertMember(MemberVO memVo) {

		SqlSession session = null;
		int cnt = 0; 	// 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.insert("member.insertMember", memVo);
		
	
		} finally {
			// 커밋과 닫기
			session.commit();
			session.close();
		}
		
		return cnt;
	}


	@Override
	public int deleteMember(String memId) {
		SqlSession session = null;
		int cnt = 0; 	// 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.insert("member.deleteMember", memId);

		} finally {
			// 커밋과 닫기
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		SqlSession session = null;
		int cnt = 0; 	// 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.insert("member.updateMember", memVo);
		
	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 커밋과 닫기
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
	SqlSession session = null;
	
	List<MemberVO> list = new ArrayList<>();
	
	try {
		session = MybatisSqlSessionFactory.getSqlSession();
		
		list = session.selectList("member.getAllMember");
		
	}catch(Exception e) {
		e.printStackTrace();
	} finally {
		// 커밋과 닫기
		session.commit();
		session.close();
	}
				
		return list;
	}
	
	@Override
	public int getMemberCount(String memId) {
		SqlSession session = null;
		int cnt = 0; 	// 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.insert("member.getMemIdCount", memId);
		
	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 커밋과 닫기
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
		System.out.println(paramMap);
		
		if(paramMap.size()==0)
			return 0;
		
		
		SqlSession session = null;
		int cnt = 0; 	// 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.insert("member.updateMember2", paramMap);
	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 커밋과 닫기
			session.commit();
			session.close();
		}
		
		return cnt;
	
	}

	@Override
	public int updateMember3(Map<String, String> dataMap) {
		if(dataMap.size()==0)
			return 0;
		
		
		SqlSession session = null;
		int cnt = 0; 	// 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			
			cnt = session.insert("member.updeteMember3", dataMap);
	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 커밋과 닫기
			session.commit();
			session.close();
		}
		
		return cnt;
	}
}
