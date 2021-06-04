<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>로그인</div>
    <div>${requestScope.errMsg }</div>
    <form action="login" method="post">
        <div>
            아이디 : <input type="text" name="uid"  value="1515" placeholder="id">
        </div>
        <div>
            비밀번호 : <input type="password" name="upw" value="1515" placeholder="password">
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </form>

    <div>
        <a href="join">join</a>
    </div>
</body>
</html>
