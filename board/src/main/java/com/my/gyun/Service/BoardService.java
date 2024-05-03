package com.my.gyun.Service;

import java.util.List;

import com.my.gyun.VO.Board;

public interface BoardService {

	void write(Board board);

	List<Board> list();

	Board findBySeq(int seq);

	void update(Board board);

	void delete(int seq);

}
