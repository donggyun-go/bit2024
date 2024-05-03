package com.bit2024.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit2024.mysite.vo.UserVo;

public class UserDao {

	public boolean insert(UserVo vo) {
		
		boolean result = false;
		// JDBC 코드
		try {
			
			//0. JDBC Driver Loading
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 1. 연결(서버(IP,port)+dbname) 연결URL, 사용자아이디, 비밀번호
			String url = "jdbc:mariadb://192.168.100.9:3307/webdb?charset=utf8";
			Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			System.out.println("connection success!");
			// 2. sql 준비
			String sql = "insert into user values(null, ?, ?, password(?), ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 3. 파라미터 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			
			//4. sql 실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
			//    select인 경우 ResultSet
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail:" + e);
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} 
	
		return result;
	}

	public UserVo findByEmailAndPassword(String email, String password) {
		UserVo result = null;
		
		try {
			
			//0. JDBC Driver Loading
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 1. 연결(서버(IP,port)+dbname) 연결URL, 사용자아이디, 비밀번호
			String url = "jdbc:mariadb://192.168.100.9:3307/webdb?charset=utf8";
			Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			System.out.println("connection success!");
			// 2. sql 준비
			String sql = "select no, name from user where email=? and password=password(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 3. 파라미터 바인딩
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			//4. sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//5. 결과 처리
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
			}
			
			//    select인 경우 ResultSet
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail:" + e);
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		}		
		
		return result;
	}

	public UserVo findByNo(Long no) {
		UserVo result = null;
		
		try {
			
			//0. JDBC Driver Loading
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 1. 연결(서버(IP,port)+dbname) 연결URL, 사용자아이디, 비밀번호
			String url = "jdbc:mariadb://192.168.100.9:3307/webdb?charset=utf8";
			Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			System.out.println("connection success!");
			// 2. sql 준비
			String sql = "select no, name, email, password, gender from user where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 3. 파라미터 바인딩
			pstmt.setLong(1, no);

			//4. sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//5. 결과 처리
			while(rs.next()) {
				no = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				String gender = rs.getString(5);
				
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
				result.setEmail(email);
				result.setPassword(password);
				result.setGender(gender);
			}
			
			//    select인 경우 ResultSet
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail:" + e);
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		}		
		
		return result;
	}

	public boolean update(UserVo vo) {
	    
	    boolean result = false;
	    try {
	        //0. JDBC Driver Loading
	        Class.forName("org.mariadb.jdbc.Driver");
	        
	        // 1. 연결(서버(IP,port)+dbname) 연결URL, 사용자아이디, 비밀번호
	        String url = "jdbc:mariadb://192.168.100.9:3307/webdb?charset=utf8";
	        Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
	        
	        System.out.println("connection success!");
	        // 2. sql 준비
	        String sql = "UPDATE user SET name = ?, email = ?, password = password(?), gender = ? WHERE no = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	        // 3. 파라미터 바인딩
	        pstmt.setString(1, vo.getName());
	        pstmt.setString(2, vo.getEmail());
	        pstmt.setString(3, vo.getPassword());
	        pstmt.setString(4, vo.getGender());
	        pstmt.setLong(5, vo.getNo());
	        
	        //4. sql 실행
	        int count = pstmt.executeUpdate();
	        
	        result = count == 1;
	        
	    } catch (ClassNotFoundException e) {
	        System.out.println("Driver Loading Fail:" + e);
	    } catch (SQLException e) {
	        System.out.println("Error:" + e);
	    }

	    return result;
	}

	public boolean updateNopassowrd(UserVo vo) {
		boolean result = false;
	    try {
	        //0. JDBC Driver Loading
	        Class.forName("org.mariadb.jdbc.Driver");
	        
	        // 1. 연결(서버(IP,port)+dbname) 연결URL, 사용자아이디, 비밀번호
	        String url = "jdbc:mariadb://192.168.100.9:3307/webdb?charset=utf8";
	        Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
	        
	        System.out.println("connection success!");
	        // 2. sql 준비
	        String sql = "UPDATE user SET name = ?, email = ?, gender = ? WHERE no = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	        // 3. 파라미터 바인딩
	        pstmt.setString(1, vo.getName());
	        pstmt.setString(2, vo.getEmail());
	        pstmt.setString(3, vo.getGender());
	        pstmt.setLong(4, vo.getNo());
	        
	        //4. sql 실행
	        int count = pstmt.executeUpdate();
	        
	        result = count == 1;
	        
	    } catch (ClassNotFoundException e) {
	        System.out.println("Driver Loading Fail:" + e);
	    } catch (SQLException e) {
	        System.out.println("Error:" + e);
	    }

	    return result;
		
	}
		
	
}
