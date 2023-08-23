<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<form action="/nha-san-xuat/add" method="post">
    ID : <input type="text" name="id" value="${detail.id}" readonly/>
    <br/>
    Mã : <input type="text" name="ma" value="${detail.ma}"/>
    <br/>
    Tên : <input type="text" name="ten" value="${detail.ten}"/>
    <br/>

    <button type="submit">Add</button>
</form>

<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="nhaSanXuat">
            <tr>
                <td>${nhaSanXuat.id}</td>
                <td>${nhaSanXuat.ma}</td>
                <td>${nhaSanXuat.ten}</td>
                <td>
                    <a href="/nha-san-xuat/detail?id=${nhaSanXuat.id}" class="btn btn-primary">Detail</a>
                    <a href="/nha-san-xuat/view-update?id=${nhaSanXuat.id}" class="btn btn-primary">Update</a>
                    <a href="/nha-san-xuat/remove?id=${nhaSanXuat.id}" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>