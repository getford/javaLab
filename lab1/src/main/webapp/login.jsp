<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>login</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>

<body>
<ul class="nav nav-tabs nav-justified">
    <li class="active"><a href="login.jsp">Авторизация</a></li>
    <li class="disabled"><a href="adminPage.jsp">Все автомобили</a></li>
    <br><br>
</ul>
<form action="/LoginController" class="">
    <div class="container">
        <div class="row">
            <h1>Авторизация</h1>
        </div>
    </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="form-inline">
                <input type="text" name="login" placeholder="Login" required autofocus>
                <br>
                <br>
                <input type="password" name="password" placeholder="Password">
                <br>
                <br>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <button class="btn btn-success btn-large" type="submit">Enter</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>