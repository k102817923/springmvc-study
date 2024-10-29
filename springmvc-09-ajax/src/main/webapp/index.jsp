<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Ajax Example</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script>
        function checkName() {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/ajax/test1",
                data: {'name': $("#name").val()},
                success: function (data) {
                    if (data === 'OK') {
                        $("#userInfo").css("color", "green");
                    } else {
                        $("#userInfo").css("color", "red");
                    }
                    $("#userInfo").html(data);
                },
                error: function () {
                    $("#userInfo").css("color", "red").html("ERROR");
                }
            });
        }

        function checkPwd() {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/ajax/test1",
                data: {'pwd': $("#pwd").val()},
                success: function (data) {
                    if (data === 'OK') {
                        $("#pwdInfo").css("color", "green");
                    } else {
                        $("#pwdInfo").css("color", "red");
                    }
                    $("#pwdInfo").html(data);
                },
                error: function () {
                    $("#pwdInfo").css("color", "red").html("ERROR");
                }
            });
        }
    </script>
</head>

<body>
<p>
    <label for="name">用户名:</label>
    <input type="text" id="name" onblur="checkName()" />
    <span id="userInfo"></span>
</p>
<p>
    <label for="pwd">密码:</label>
    <input type="password" id="pwd" onblur="checkPwd()" />
    <span id="pwdInfo"></span>
</p>
</body>
</html>
