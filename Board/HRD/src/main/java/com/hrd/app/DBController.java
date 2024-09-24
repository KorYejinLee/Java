package com.hrd.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DBController extends DBControl {
	private List<UserVO> db_user;
	private String userName = null;
    @GetMapping(value="/board")
    public String boardPage(Model model) {
        model.addAttribute("boardList", getListFromDatabase());
    	model.addAttribute("board", db_user);
        return "boardListPage";
    }
   
    @GetMapping(value="/board/write")
    public String boardWrite(Model model, HttpServletRequest request) {
    	model.addAttribute("board", db_user);
        return "boardDetail";
    }
    
    @PostMapping(value = "/board/save")
    public String submitBoard(BoardVO board, HttpServletRequest request) {
        String userName = request.getParameter("userName");
    	DBControl.insert_to_SPRING_TBL(board, userName);
        return "redirect:/board";
    }
   
	@GetMapping(value="/login")
    public String writeForm() {
        return "loginPage";
    }
	
	@GetMapping(value="/register")
    public String joinDetail() {
        return "joinDetail";
    }
	
    @PostMapping("/member/save")
    public String saveUser(UserVO user) {
        DBControl.insert_to_SPRING_TBL_User(user); 
        return "loginPage"; 
    }
   
    @PostMapping("/login")
    public String login(@RequestParam("id") String userId, @RequestParam("password") String password, HttpServletRequest request, Model ref_model) {
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
        final String select_sql_login_info = "SELECT ID, PASSWORD FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
        final String select_sql_user_info = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
        final String select_sql_username = "SELECT NAME FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
        db_user = new ArrayList<>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(select_sql_login_info);
            PreparedStatement preparedStatement1 = connection.prepareStatement(select_sql_user_info);
            PreparedStatement preparedStatement2 = connection.prepareStatement(select_sql_username);

            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            preparedStatement1.setString(1, userId);
            preparedStatement1.setString(2, password);
            preparedStatement2.setString(1, userId);
            preparedStatement2.setString(2, password);

            
            ResultSet rs_loginInfo = preparedStatement.executeQuery();
            ResultSet rs_user = preparedStatement1.executeQuery();
            ResultSet rs_userName = preparedStatement2.executeQuery();
            
            if (rs_loginInfo.next()) {
                isValidUser = true; 
                request.setAttribute("userId", userId);
                System.out.println("REQUEST : userId Setting " + userId);
                
                if (rs_userName.next()) {
                	userName = rs_userName.getString(1);
                    request.setAttribute("userName", userName);
                    System.out.println("REQUEST : userName Setting " + userName);
                }
            }
            rs_loginInfo.close();
            rs_userName.close();
            preparedStatement.close();
            preparedStatement2.close();
            while(rs_user.next()) {
            	final UserVO user = new UserVO(
            			rs_user.getString(1),
            			rs_user.getString(2),
            			rs_user.getString(3),
            			rs_user.getString(4),
            			rs_user.getString(5));
            	db_user.add(user);	
            }
            ref_model.addAttribute("DB_USER", db_user);
            System.out.println("MODEL : " + db_user);
            
            rs_user.close();
            preparedStatement1.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (isValidUser) {
        	return "redirect:/board";
        	// push test
        } else {
            request.setAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
        	System.out.println("로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
            return "loginPage"; 
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        return "redirect:/login"; 
    }


}