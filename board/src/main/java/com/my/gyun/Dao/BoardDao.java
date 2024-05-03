package com.my.gyun.Dao;

import java.util.List;

import com.my.gyun.VO.Board;

public interface BoardDao {

	void write(Board board);

	List<Board> list();

	Board findByseq(int seq);

	void update(Board board);

	void delete(int seq);

}
