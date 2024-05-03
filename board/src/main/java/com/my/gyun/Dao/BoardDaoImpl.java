package com.my.gyun.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.gyun.VO.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
    private SqlSession sql;

	private static String namespace="com.my.gyun.repository.BoardDao";

    @Override
    public void write(Board board) {
        sql.insert(namespace + ".insertBoard", board);
    }

	@Override
	public List<Board> list() {
		return sql.selectList(namespace + ".listBoard");
	}

	@Override
	public Board findByseq(int seq) {
		return sql.selectOne(namespace + ".findBySeq", seq);
	}

	@Override
	public void update(Board board) {
		sql.update(namespace + ".update", board);
	}

	@Override
	public void delete(int seq) {
		sql.delete(namespace + ".delete", seq);
	}
	
	
}
