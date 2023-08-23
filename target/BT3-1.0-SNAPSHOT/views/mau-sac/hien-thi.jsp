<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>tf</title>
</head>

<body>
<form action="/mau-sac/add " method="post">
    ID: <input type="text" name="id" value="${detail.id}">
    <br/>
    Ma: <input type="text" name="ma" value="${detail.ma}">
    <br/>
    Tên: <input type="text" name="ten" value="${detail.ten}">

    <br/>
    <button type="submit">Add</button>
</form>

<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col"> ID</th>
            <th scope="col"> Ma</th>
            <th scope="col"> Tên</th>
        </tr>
        </thead>
    <c:forEach items="${lists}" var="ms">
        <tr>
            <td>${ms.id}</td>
            <td>${ms.ma}</td>
            <td>${ms.ten}</td>
            <td>
                <a href="/mau-sac/remove?id=${ms.id}" class="btn btn-primary">Delete</a>
                <a href="/mau-sac/view-update?id=${ms.id}" class="btn btn-primary">update</a>
                <a href="/mau-sac/detail?id=${ms.id}" class="btn btn-primary">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>