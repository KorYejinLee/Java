<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hrd.app.DBControl" %>
<%@ page import="com.hrd.app.BoardVO" %>
<%@ page import="com.hrd.app.UserVO" %>
<%@ page import="java.util.List" %>

<%! boolean isLoggedIn(HttpServletRequest request) {
    return request.getSession().getAttribute("userId") != null;
} %>
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
        }
        .navbar {
            overflow: hidden;
            background-color: #333;
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between; /* Align items horizontally */
            padding: 10px;
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
            width: 80%; /* Adjust width as needed */
            text-align: center;
            margin: auto; /* Center content horizontally */
        }
        .board-table {
            width: 100%;
            margin-bottom: 20px;
            border-collapse: collapse; /* Collapse borders for a cleaner look */
            table-layout: fixed; /* Fixed table layout */
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
            text-align: right;
        }
    </style>
</head>
<body>
    <!-- Navigation bar -->
    <div class="navbar">
        <a href="/board/list" class="active">게시판</a>
        <div class="navbar-right">
            <% if (isLoggedIn(request)) { %>
                <span style="color: #f2f2f2; padding: 14px 16px;"><%= request.getSession().getAttribute("userId") %>님 접속 중</span>
                <a href="/app/logout">로그아웃</a>
            <% } else { %>
                <a href="/app/login">로그인</a>
                <a href="/app/register">회원가입</a>
            <% } %>
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
                    <% List<BoardVO> boardList = DBControl.getListFromDatabase(); %>
                    <% for (BoardVO board : boardList) { %>
                        <tr>
                            <td><%= board.getSeq() %></td>
                            <td><%= board.getTitle() %></td>
                            <td><%= board.getWriter() %></td>
                            <td><%= board.getContent() %></td>
                            <td><%= board.getCnt() %></td>
                        </tr>
                    <% } %>
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
