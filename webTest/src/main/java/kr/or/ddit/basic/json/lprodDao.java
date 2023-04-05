package kr.or.ddit.basic.json;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.lprodVO;

public class lprodDao {
	
	
	private static lprodDao dao;
	
	
	public lprodDao() {

	}
	
	public static lprodDao getInstance() {
		if(dao == null) dao = new lprodDao();
		return dao;
	}
	
	
	public List<lprodVO> getLprod() {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<lprodVO> list = null;
		
		try {
			
			list= session.selectList("lprod.getLprod");
			
		} finally {
			 session.commit();
			if(session!=null) session.close();
		}
		
		return list;
		
	}

}
