<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="/mau-sac/add" method="post">

    ID:<input type="text" name="id" value="${detail.id}"><br/>

    Ma:<input type="text" name="ma" value="${detail.ma}"><br/>

    Ten:<input type="text" name="ten" value="${detail.ten}"><br/>

    DC:<input type="text" name="diaChi" value="${detail.diaChi}"><br/>

    Thanh Pho:<input type="text" name="thanhPho" value="${detail.thanhPho}"><br/>

    QG:<input type="text" name="quocGia" value="${detail.quocGia}"><br/>
    <br/>
    <button type="submit">add</button>

</form>
<div>
<table class="table">
    <thead>
    <tr>
        <th colspan="col">ID</th>
        <th colspan="col">Ma</th>
        <th colspan="col">Ten</th>
        <th colspan="col">DiaChi</th>
        <th colspan="col">ThanhPho</th>
        <th colspan="col">QuocGia</th>

    </tr>
    </thead>
    <c:forEach items="${lists}" var="ch">
        <tr>
            <td>${ch.id}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td>
                <a href="/cua-hang/delete?id=${ch.id}">delete</a>
                <a href="/cua-hang/detail?id=${ch.id}">detail</a>
                <a href="/cua-hang/view-update?id=${ch.id}">update</a>
            </td>

        </tr>
    </c:forEach>
</table>
</div>
</body>

</html>