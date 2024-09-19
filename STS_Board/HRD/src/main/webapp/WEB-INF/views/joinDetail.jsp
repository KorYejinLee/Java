<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <script>
        function formCheck(form) {
            var id = form.id.value.trim();
            var password = form.password.value.trim();
            var birth = form.birth.value.trim();

			var idRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,12}$/;
			var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,12}$/;
            var birthRegex = /^\d{4}-\d{2}-\d{2}$/;
            
            if (!idRegex.test(id)) {
                alert("아이디는 8~12자리의 영대소문자와 숫자 조합이어야 합니다.");
                return false;
            }

            if (!passwordRegex.test(password)) {
                alert("비밀번호는 8~12자리의 영대소문자와 숫자 조합이어야 합니다.");
                return false;
            }

            if (!birth.match(birthRegex)) {
                alert("생일은 yyyy-mm-dd 형식으로 입력해야 합니다.");
                return false;
            }

            return true;
        }
    </script>
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
            text-align: left; /* Align text to left */
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
        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center; /* Center title */
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
    </style>
</head>
<body>
    <div class="container">
        <form action="/app/member/save" method="post" onsubmit="return formCheck(this)">
            <div class="title">회원가입</div>
            <!-- Display error message if any -->
            <div id="msg" class="msg">${URLDecoder.decode(param.msg, "UTF-8")}</div>
            <div>
                <label for="id">아이디</label>
                <input id="id" class="input-field" type="text" name="id" placeholder="8~12자리의 영대소문자와 숫자 조합" required>
            </div>
            <div>
                <label for="password">비밀번호</label>
                <input id="password" class="input-field" type="password" name="password" placeholder="8~12자리의 영대소문자와 숫자 조합" required>
            </div>
            <div>
                <label for="name">이름</label>
                <input id="name" class="input-field" type="text" name="name" placeholder="홍길동" required>
            </div>
            <div>
                <label for="email">이메일</label>
                <input id="email" class="input-field" type="email" name="email" placeholder="user@gmail.com" required>
            </div>
            <div>
                <label for="birth">생일</label>
                <input id="birth" class="input-field" type="text" name="birth" placeholder="yyyy-mm-dd" required pattern="\d{4}-\d{2}-\d{2}">
            </div>
            <button type="submit">회원 가입</button>
        </form>
    </div>
</body>
</html>