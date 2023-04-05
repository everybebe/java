package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.vo.BoardVO;




public class BoardServiceImpl implements IBoardService{
	private BoardDaoImpl dao;
	
	//1번
	private static IBoardService service;
	
	//2번
	private  BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
		

	//3번
	public static IBoardService getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}


	@Override
	public int insertBoard(BoardVO boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		//게시글 보기에서는 조회수를 증가하는 작업을 같이 수행해야 한다.
		int cnt = dao.setCountIncrement(boardNo);
		if(cnt==0) { //조회수 증가 실패!!
			return null;
		}
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return dao.getAllBoardList();
	}

	@Override
	public List<BoardVO> getSearchBoardList(String title) {
		return dao.getSearchBoardList(title);
	}

	@Override
	public int setCountIncrement(int boardNo) {
		return dao.setCountIncrement(boardNo);
	}


}
