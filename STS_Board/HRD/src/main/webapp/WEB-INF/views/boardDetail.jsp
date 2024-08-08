<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hrd.app.BoardVO" %>
<%@ page import="com.hrd.app.UserVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
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
            width: 50%; /* Adjust width as needed */
            text-align: center;
            background-color: #fff;
            padding: 20px;
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
        .input-label {
            text-align: left;
            margin-left: 10px;
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        .submit-button {
            width: 100px;
            margin-top: 10px;
            margin-right: 10px;
        }
        .cancel-button {
            width: 100px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>게시글</h2>
        <form action="/app/board/save" method="post">
            <div>
                <label for="title" class="input-label">Title</label>
                <input id="title" class="input-field" type="text" name="title" placeholder="제목을 입력해주세요" required>
            </div>
            <div>
                <label for="content" class="input-label">Content</label>
                <textarea id="content" class="input-field" name="content" rows="5" placeholder="내용을 입력해주세요" required></textarea>
            </div>
            <div>
                <button type="submit" class="submit-button">Save</button>
                <button type="button" class="cancel-button" onclick="history.back()">Cancel</button>
            </div>
        </form>            
            <div>
            	<%
            		response.setCharacterEncoding("UTF-8");
                	response.setContentType("text/html");
                	List<UserVO> db_user = (List<UserVO>)request.getAttribute("board");
            		for(UserVO row : db_user){
            			out.println("<h1>" + row + "</h1>");
            			out.println("<br>");
            		}
                	//System.out.println("<h1>" + db_user.get(3) + "</h1>");
            	%>
            </div>

    </div>
</body>
</html>