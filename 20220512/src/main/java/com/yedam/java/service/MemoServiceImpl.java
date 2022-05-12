package com.yedam.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DataSource;



public class MemoServiceImpl implements MemoService {

	private DataSource dao = DataSource.getInstance(); //
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;


	@Override
	public void insertMemo(MemoVO memo) {
		String sql = "INSERT INTO MEMO_LIST VALUES(?,?,?,?)";

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memo.getNum());
			psmt.setString(2, memo.getTitle());
			psmt.setString(3, memo.getWriter());
			psmt.setString(4, memo.getContent());
			psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMemo(MemoVO memo) {
		try {
			conn = dao.getConnection();
			String sql = "UPDATE MEMO_LIST SET CONTENT = ? WHERE NUM = ?";
			psmt = conn.prepareStatement(sql);  // DB에 sql문을 전달
			psmt.setString(1, memo.getContent());
			psmt.setInt(2, memo.getNum());
			int result = psmt.executeUpdate(); // SQL문의 결과를 받음.
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMemo(MemoVO memo) {
		conn = dao.getConnection();
		String sql = "DELETE FROM MEMO_LIST WHERE NUM = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memo.getNum());

			int result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MemoVO selectMemoInfo(int num) {
		MemoVO memo = new MemoVO();
		try {
			conn = dao.getConnection(); // connection을 가져옴.
			String sql = "SELECT * FROM MEMO_LIST WHERE NUM = ?";
			psmt = conn.prepareStatement(sql); // sql문을 DB에 전송하여 쿼리문을 진행함.
			psmt.setInt(1, num); // ? 값채우기
			rs = psmt.executeQuery(); // 결과를 rs(result Set)에 받음.
			if (rs.next()) { // 하나씩 읽어서 리스트에 담음.
				memo.setNum(rs.getInt("NUM"));
				memo.setTitle(rs.getString("TITLE"));
				memo.setWriter(rs.getString("WRITER"));
				memo.setContent(rs.getString("CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memo;

	}

	@Override
	public List<MemoVO> selectAllList() {
		List<MemoVO> list = new ArrayList<MemoVO>();
		try {
			conn = dao.getConnection(); // connection을 가져옴.
			String sql = "SELECT * FROM MEMO_LIST";
			psmt = conn.prepareStatement(sql); // sql문을 DB에 전송하여 쿼리문을 진행함.
			rs = psmt.executeQuery(); // 결과를 rs(result Set)에 받음.
			while (rs.next()) { // 하나씩 읽어서 리스트에 담음.
				MemoVO memo = new MemoVO();
				memo.setTitle(rs.getString("TITLE"));
				memo.setWriter(rs.getString("WRITER"));
				memo.setContent(rs.getString("CONTENT"));
				memo.setNum(rs.getInt("NUM"));
				list.add(memo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
