package com.hrd.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBControl {
	public static void insert_to_SPRING_TBL(BoardVO board, HttpServletRequest request) {
	    final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/xe";
	    final String DB_USER = "admin";
	    final String DB_PASSWORD = "admin";
	    final String DB_DRIVER = "oracle.jdbc.OracleDriver";
	    
	    DriverManagerDataSource ds = new DriverManagerDataSource();
	    ds.setDriverClassName(DB_DRIVER);
	    ds.setUrl(CONNECTION_URL);
	    ds.setUsername(DB_USER);
	    ds.setPassword(DB_PASSWORD);
	    
	    final String insert_sql = "INSERT INTO BOARD(seq, title, writer, content, cnt) VALUES (0, ?, ?, ?, 0)";
	    
	    try {
	    	Connection connection = ds.getConnection();
	        //String userId = (String) request.getSession().getAttribute("userId");
	        String userName = (String) request.getAttribute("DB_USER");
			PreparedStatement preparedStatement = connection.prepareStatement(insert_sql);

	        preparedStatement.setString(1, board.getTitle());
	        preparedStatement.setString(2, "홍길동"); // Use retrieved username as writer
	        preparedStatement.setString(3, board.getContent());
	        
	        // Execute the update
	        int row = preparedStatement.executeUpdate();
	        System.out.println("Inserted rows: " + row);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public static List<BoardVO> getListFromDatabase(){
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/xe";
        final String DB_USER = "admin";
        final String DB_PASSWORD = "admin";
        final String DB_DRIVER = "oracle.jdbc.OracleDriver";
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(DB_DRIVER);
        ds.setUrl(CONNECTION_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PASSWORD);
        final String select_sql = "SELECT * FROM BOARD";
        try {
			Connection connection = ds.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(select_sql);
			ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BoardVO board = new BoardVO(
                    rs.getInt("seq"),
                    rs.getString("title"),
                    rs.getString("writer"),
                    rs.getString("content"),
                    rs.getInt("cnt")
                );
                boardList.add(board);
                System.out.println(boardList);
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boardList;
	}
	public static void insert_to_SPRING_TBL_User(UserVO user) {
		   final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/xe";
		   final String DB_USER = "admin";
		   final String DB_PASSWORD = "admin";
		   final String DB_DRIVER = "oracle.jdbc.OracleDriver";
		   DriverManagerDataSource ds = new DriverManagerDataSource();
		   ds.setDriverClassName(DB_DRIVER);
	       ds.setUrl(CONNECTION_URL);
	       ds.setUsername(DB_USER);
	       ds.setPassword(DB_PASSWORD);
	       String name = new String();
	    
	       final String insert_sql = "INSERT INTO MEMBER(id, password, name, email, birth) VALUES (?, ?, ?, ?, ?)";
	       try {
			Connection connection = ds.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert_sql);
			preparedStatement.setString(1, user.getId());
	        preparedStatement.setString(2, user.getPassword());
	        preparedStatement.setString(3, user.getName());
	        preparedStatement.setString(4, user.getEmail());
	        preparedStatement.setString(5, user.getBirth());
	        int row = preparedStatement.executeUpdate();
	        System.out.println("입력된 사용자:" + row);

	       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	       }
	}
    // 로그인 체크 메소드
    public static boolean checkLogin(String userId, String password) {
        boolean isValidUser = false;
        final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/xe";
        final String DB_USER = "admin";
        final String DB_PASSWORD = "admin";
        final String DB_DRIVER = "oracle.jdbc.OracleDriver";
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(DB_DRIVER);
        ds.setUrl(CONNECTION_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PASSWORD);
        final String select_sql = "SELECT ID, PASSWORD FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(select_sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                isValidUser = true; // ID와 비밀번호가 일치하면 유효 사용자로 설정
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValidUser;
    }
}