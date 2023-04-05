package webMemberTest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisSqlSessionFactory;
import webMemberTest.vo.memberVO;

public class memberDaoImpl implements ImemberDao {
	//자신의 객체
	private static ImemberDao dao;
	
	//기본생성자
	public memberDaoImpl() {

	}
	//자신의 객체 생성하고 리턴
	public static ImemberDao getInstance() {
		if(dao==null) dao = new memberDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMember(memberVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("member.insertMember",vo);
		} finally  {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public List<memberVO> getAllMemberList() {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		List<memberVO> list = null;
		
		try {
			list = session.selectList("member.getAllMemberList");
		} finally  {
			session.close();
		}
		return list;
	}

	@Override
	public int updateMember(memberVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("member.updateMember",vo);
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.delete("member.deleteMember",memId);
		} finally  {
			session.commit();
			session.close();
		}
		return cnt;
	}
}
