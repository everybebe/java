package kr.or.ddit.basic.fileupload.service;

import java.util.List;

import kr.or.ddit.basic.fileupload.dao.FileinfoDaoImpl;
import kr.or.ddit.basic.fileupload.dao.IFileinfoDao;
import kr.or.ddit.vo.FileInfoVO;

public class FileinfoServiceImpl implements IFileinfoService{
	private IFileinfoDao dao;
	
	private static FileinfoServiceImpl service;
	
	private FileinfoServiceImpl() {
		dao = FileinfoDaoImpl.getInstance();
	}
	
	public static FileinfoServiceImpl getInstance() {
		if(service==null) service = new FileinfoServiceImpl();
		return service;
	}
	
	
	
	
	@Override
	public int insertFileinfo(FileInfoVO fileVo) {
		// TODO Auto-generated method stub
		return dao.insertFileinfo(fileVo);
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		// TODO Auto-generated method stub
		return dao.getAllFileinfo();
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		// TODO Auto-generated method stub
		return dao.getFileInfo(fileNo);
	}

	
}
