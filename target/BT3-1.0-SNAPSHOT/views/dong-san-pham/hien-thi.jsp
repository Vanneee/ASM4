<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<form action="/dong-san-pham/add" method="post">
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
        <c:forEach items="${lists}" var="dsp">
            <tr>
                <td>${dsp.id}</td>
                <td>${dsp.ma}</td>
                <td>${dsp.ten}</td>
                <td>
                    <a href="/dong-san-pham/detail?id=${dsp.id}" class="btn btn-primary">Detail</a>
                    <a href="/dong-san-pham/view-update?id=${dsp.id}" class="btn btn-primary">Update</a>
                    <a href="/dong-san-pham/remove?id=${dsp.id}" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
