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
    @GetMapping(value="/board")
    public String boardPage(Model model) {
        model.addAttribute("boardList", getListFromDatabase());
        return "boardListPage";
    }
   
    @GetMapping(value="/board/write")
    public String boardWrite(Model model) {
        model.addAttribute("board", db_user);
        return "boardDetail";
    }
    
    @PostMapping(value = "/board/save")
    public String submitBoard(BoardVO board, HttpServletRequest request) {
        DBControl.insert_to_SPRING_TBL(board, request);
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
        DBControl.insert_to_SPRING_TBL_User(user); // DB에 사용자 정보 저장
        return "loginPage"; // 회원가입 완료 후 이동할 URL
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
        final String select_sql = "SELECT ID, PASSWORD FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
        final String select_sql_name = "SELECT * FROM MEMBER";
        db_user = new ArrayList<>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(select_sql);
            PreparedStatement preparedStatement1 = connection.prepareStatement(select_sql_name);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSet rs_1 = preparedStatement1.executeQuery();
            if (rs.next()) {
                isValidUser = true; // ID와 비밀번호가 일치하면 유효 사용자로 설정
                request.getSession().setAttribute("userId", userId); // 세션에 userId 저장
            }
            rs.close();
            preparedStatement.close();
            while(rs_1.next()) {
            	final UserVO user = new UserVO(
            			rs_1.getString(1),
            			rs_1.getString(2),
            			rs_1.getString(3),
            			rs_1.getString(4),
            			rs_1.getString(5));
            	db_user.add(user);	
//            	System.out.println("DB_USER : " + db_user.toString());
//            	System.out.println(user.toString());
            }
            ref_model.addAttribute("DB_USER", db_user);
            rs_1.close();
            preparedStatement1.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (isValidUser) {
        	return "redirect:/board"; // 로그인 성공 시 게시판 목록 페이지로 이동
        } else {
        	ref_model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다."); // 로그인 실패 시 에러 메시지 전달
            System.out.println("로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다."); // 로그 확인용 출력
            return "loginPage"; // 로그인 폼 페이지로 다시 이동
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate(); // 세션 무효화
        return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }


}