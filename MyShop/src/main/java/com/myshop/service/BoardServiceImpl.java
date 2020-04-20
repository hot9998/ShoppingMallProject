package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.domain.BoardVO;
import com.myshop.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;

//	�۾���
	@Override
	public void boardInsert(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.boardInsert(board);
	}
//	����Ʈ
	public List<BoardVO> boardList(int type){
		return boardMapper.boardList(type);
	}
//	�󼼺���
	@Override
	public BoardVO boardGet(Long bnum) {
		// TODO Auto-generated method stub
		return boardMapper.boardGet(bnum);
	}
//	����
	@Override
	public void boardUpdate(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.boardUpdate(board);
	}
//	����
	@Override
	public void boardDelete(Long bnum) {
		// TODO Auto-generated method stub
		boardMapper.boardDelete(bnum);
	}
	@Override
	public void viewcnt(Long bnum) {
		// TODO Auto-generated method stub
		boardMapper.viewcnt(bnum);
	}
	@Override
	public void getcount(int type) {
		// TODO Auto-generated method stub
		boardMapper.getcount(type);
	}

}