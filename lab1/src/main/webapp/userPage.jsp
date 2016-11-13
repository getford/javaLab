<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>User</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<ul class="nav nav-tabs nav-justified">
    <li class="active"><a href="userPage.jsp">Ваши автомобили</a></li>
    <li><a href="login.jsp">Выход</a></li>
    <br>
</ul>


<div class="container">
    <div class="row">
        <div class="alert alert-success">
            <form action="/userPage.jsp">
                <h1>Ваши автомобили</h1>
                <table width="200" border="1">
                    <tr>
                        <th>ID</th>
                        <th>Марка</th>
                        <th>Модель</th>
                    </tr>
                    <c:forEach items="${arrTakeListCar}" var="items">
                        <tr>
                            <th>${items.id}</th>
                            <th>${items.name_auto}</th>
                            <th>${items.model}</th>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <form action="/UserCars">
                <label>Для отказа от автомобиля, введите его ID.</label>
                <div class="">
                    <input class="input-medium" type="text" placeholder="id" name="id_auto">
                    <button class="btn btn-danger btn-large">Отказаться</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="alert alert-info">
            <h1>Доступные автомобили для заказа</h1>
            <table width="200" border="1">
                <tr>
                    <th>ID</th>
                    <th>Марка</th>
                    <th>Модель</th>
                </tr>
                <c:forEach items="${arrFreeListCar}" var="items">
                    <tr>
                        <th>${items.id}</th>
                        <th>${items.name_auto}</th>
                        <th>${items.model}</th>
                    </tr>
                </c:forEach>
            </table>
            <form action="/UserAddCars">
                <label>Для заказа автомобиля, введите его ID.</label>
                <div>
                    <input class="input-medium" type="text" placeholder="id" name="id_auto">
                    <button class="btn btn-success btn-large">Заказать</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
