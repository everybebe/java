package webMemberTest.service;

import java.util.List;

import webMemberTest.dao.ImemberDao;
import webMemberTest.dao.memberDaoImpl;
import webMemberTest.vo.memberVO;

public class memberServiceImpl implements ImemberService {

	private ImemberDao dao;
	
	private static memberServiceImpl service;
	
	public memberServiceImpl() {
		dao = memberDaoImpl.getInstance();
	}
	
	public static memberServiceImpl getInstance() {
		if(service == null) service = new memberServiceImpl();
		return service;
	}
	
	@Override
	public int insertMember(memberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public List<memberVO> getAllMemberList() {
		return dao.getAllMemberList();
	}

	@Override
	public int updateMember(memberVO vo) {
		return dao.updateMember(vo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

}
