package com.my.gyun.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.gyun.Dao.BoardDao;
import com.my.gyun.VO.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public void write(Board board) {
		boardDao.write(board);
	}

	@Override
	public List<Board> list() {
		return boardDao.list();
	}

	@Override
	public Board findBySeq(int seq) {
		return boardDao.findByseq(seq);
	}

	@Override
	public void update(Board board) {
		boardDao.update(board);
	}

	@Override
	public void delete(int seq) {
		boardDao.delete(seq);	
	}

}
