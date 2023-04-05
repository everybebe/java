package webMemberTest.controller;

import java.util.List;

import webMemberTest.service.memberServiceImpl;
import webMemberTest.vo.memberVO;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		memberServiceImpl service = memberServiceImpl.getInstance();
		
		List<memberVO> vo = service.getAllMemberList();
		
		System.out.println(vo);
		
	}

}
