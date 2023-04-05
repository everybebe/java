package kr.or.ddit.basic.json;

import java.util.List;

import kr.or.ddit.vo.lprodVO;

public class lprodService {

	private lprodDao dao;
	private static lprodService service;
	
	public lprodService() {
		dao = lprodDao.getInstance();
	}
	
	public static lprodService getLprodService() {
		if(service==null) service = new lprodService();
		
		return service;
	}
	public List<lprodVO> getLprod() {
		return dao.getLprod() ;
	}
	
}
