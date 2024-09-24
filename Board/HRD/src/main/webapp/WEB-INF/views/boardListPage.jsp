<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.hrd.app.UserVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrd.app.BoardVO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board List</title>
    <style>
        /* CSS for layout */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh; /* Full viewport height */
        }
        .navbar {
            background-color: #333;
            display: flex;
            justify-content: space-between; /* Align items horizontally */
            padding: 10px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1); /* Optional shadow for navbar */
            z-index: 1000; /* Ensure navbar is above other content */
        }
        .navbar a {
            color: #f2f2f2;
            text-align: center;
            text-decoration: none;
            padding: 14px 16px;
            display: block;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .navbar a.active {
            background-color: #4CAF50;
            color: white;
        }
        .navbar-right {
            display: flex;
            align-items: center; /* Align items vertically */
        }
        .container {
            flex: 1; /* Allow container to expand and fill available space */
            padding: 20px;
            box-sizing: border-box; /* Include padding in element's total width and height */
            display: flex;
            flex-direction: column;
            align-items: center; /* Center align content horizontally */
        }
        .board-table {
            width: 100%;
            max-width: 1200px; /* Maximum width for large screens */
            border-collapse: collapse; /* Collapse borders for a cleaner look */
        }
        .board-table th, .board-table td {
            padding: 10px; /* Adjust cell padding */
            border: 1px solid black; /* Add border for cells */
            text-align: center; /* Center align text in cells */
            overflow: hidden; /* Hide overflow content */
            white-space: nowrap; /* Prevent text wrapping */
            text-overflow: ellipsis; /* Show ellipsis for overflow text */
        }
        .board-table th {
            background-color: #f2f2f2; /* Light gray background for headers */
        }
        .write-button {
            width: 100%;
            max-width: 1200px; /* Align button with the table width */
            text-align: right;
            margin-top: 20px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 4px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<% 
	    // "board" 속성에서 UserVO 리스트를 가져옵니다.
	    List<UserVO> db_user = (List<UserVO>) request.getAttribute("board");
	    String userId = ""; 
	
	    // db_user가 null이 아니고 비어있지 않은 경우
	    if (db_user != null && !db_user.isEmpty()) {
	        userId = db_user.get(0).getId(); // 첫 번째 UserVO 객체에서 ID를 가져옵니다.
	    }
	%>

	<!-- Navigation bar -->
	<div class="navbar">
	    <a href="${pageContext.request.contextPath}/board" class="active">게시판</a>
	    <div class="navbar-right">
	        <% 
	            // 리스트에서 가져온 userId를 출력합니다.
	            if (userId != null && !userId.isEmpty()) { 
	        %>
	            <span style="color: #f2f2f2; padding: 14px 16px;">
	                <%= userId %>님 접속 중
	            </span>
	        <% 
	            } 
	        %>
            <a href="/app/logout">로그아웃</a>
        </div>
    </div>

    <div class="container">
        <h1>Board List</h1>
        <div class="board-table">
            <table>
                <thead>
                    <tr>
                        <th style="width: 10%;">Seq</th>
                        <th style="width: 25%;">Title</th>
                        <th style="width: 10%;">Writer</th>
                        <th style="width: 45%;">Content</th>
                        <th style="width: 10%;">Count</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="board" items="${boardList}">
                        <tr>
                            <td>${board.seq}</td>
                            <td>${board.title}</td>
                            <td>${board.writer}</td>
                            <td>${board.content}</td>
                            <td>${board.cnt}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
       
        <!-- Write button -->
        <div class="write-button">
            <form action="/app/board/write" method="get">
                <button type="submit">글쓰기</button>
            </form>
        </div>
    </div>
</body>
</html>
