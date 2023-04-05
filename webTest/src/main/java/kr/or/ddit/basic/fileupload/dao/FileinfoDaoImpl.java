package kr.or.ddit.basic.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.FileInfoVO;

public class FileinfoDaoImpl implements IFileinfoDao{

	
	private static FileinfoDaoImpl dao;
	
	private FileinfoDaoImpl() {
	
	}
	
	public static FileinfoDaoImpl getInstance() {
		if(dao == null) dao = new FileinfoDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertFileinfo(FileInfoVO fileVo) {
		SqlSession session = null;
		
		int cnt = 0; //반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo", fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		SqlSession session = null;
		List<FileInfoVO> fileList = null; //반환값
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			fileList = session.selectList("fileinfo.getAllFileinfo");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return fileList;
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		SqlSession session = null;
		FileInfoVO filevo = null; //반환값
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			filevo = session.selectOne("fileinfo.getFileinfo", fileNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return filevo;
	}


}
