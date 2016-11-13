<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Admin</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<ul class="nav nav-tabs nav-justified">
    <li class="active"><a href="adminPage.jsp">Все автомобили</a></li>
    <li><a href="login.jsp">Выход</a></li>
    <br>
</ul>

<form class="form-inline" action="/AdminServlet">
    <div class="container">
        <div class="row">
            <div class="alert alert-success">
                <input class="input-medium" type="text" placeholder="Марка авто" name="marka">
                <input class="input-medium" type="text" placeholder="Модель авто" name="model">
                <button class="btn btn-success btn-large" type="submit">Добавить машину</button>
                <left> Текущая дата: <%= new java.util.Date()%>
                </left>
                <br>
            </div>
        </div>
    </div>
</form>

<form action="/DeleteCars">
    <div class="container">
        <div class="row">
            <div class="alert alert-info">
                <input class="input-medium" type="text" placeholder="ID" name="id_car">
                <button class="btn btn-success btn-large" type="submit">Удалить автомобиль</button>
                <br><br>
            </div>
        </div>
    </div>
</form>


<div class="container">
    <div class="row">
        <div class="alert alert-success">
            <h1>Список автомобилей</h1>
            <br>
            <div>
                <table width="200" border="1">
                    <tr>
                        <th>ID</th>
                        <th>Марка</th>
                        <th>Модель</th>
                        <th>Доступность</th>
                    </tr>
                    <c:forEach items="${arrListCar}" var="items">
                        <tr>
                            <th>${items.id}</th>
                            <th>${items.name_auto}</th>
                            <th>${items.model}</th>
                            <th>${items.take}</th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="">
                <h1>Свободные автомобили</h1>
                <br>

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
            </div>
            <div class="">
                <h1>Автомобили в прокате</h1>
                <br>

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
            </div>
        </div>
    </div>
</div>
</body>
</html>
