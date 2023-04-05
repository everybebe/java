package webMemberTest.dao;

import java.util.List;

import webMemberTest.vo.memberVO;

public interface ImemberDao {

	public int insertMember(memberVO vo);
	
	public List<memberVO> getAllMemberList();
	
	public int updateMember(memberVO vo);
	
	public int deleteMember(String memId);
}
