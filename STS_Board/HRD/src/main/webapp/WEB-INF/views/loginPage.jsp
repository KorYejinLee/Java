<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
    /* CSS for layout */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* Full height of viewport */
        background-color: #f0f0f0;
    }
    .container {
        width: 400px; /* Adjust width as needed */
        text-align: center;
        background-color: #fff;
        padding: 30px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    .input-field {
        width: calc(100% - 20px); /* Adjust width minus padding */
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
        font-size: 16px;
    }
    .title {
        font-size: 24px;
        font-weight: bold;
        margin-bottom: 20px;
    }
    .msg {
        color: #ff0000; /* Adjust color as needed */
        margin-bottom: 10px;
    }
    button {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50; /* Green background color */
        color: white;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 16px;
    }
    button:hover {
        background-color: #45a049; /* Darker green on hover */
    }
    .register-link {
        margin-top: 10px;
        font-size: 14px;
    }
</style>
</head>
<body>
	<div class="container">
	    <h2 class="title">로그인</h2>
	    <form action="/app/login" method="post">
	        <input class="input-field" type="text" name="id" placeholder="아이디" required>
	        <br>
	        <input class="input-field" type="password" name="password" placeholder="비밀번호" required>
	        <br>
	        <button type="submit">로그인</button>
	        <% if (request.getAttribute("error") != null) { %>
	           <p class="msg"><%= request.getAttribute("error") %></p>
	       <% } %>
	    </form>
	    
	    <div class="register-link">
	        계정이 없으신가요? <a href="/app/register">회원가입</a>
	    </div>
	</div>
</body>
</html>