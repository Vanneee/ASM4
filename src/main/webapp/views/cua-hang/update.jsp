<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ch</title>
</head>
<body>
<form action="/mau-sac/update" method="post">

    ID:<input type="text" name="id" value="${update.id}">

    Ma:<input type="text" name="ma" value="${update.ma}">

    Ten:<input type="text" name="ten" value="${update.ten}">

    DC:<input type="text" name="diaChi" value="${update.diaChi}">

    Thanh Pho:<input type="text" name="thanhPho" value="${update.thanhPho}">

    QG:<input type="text" name="quocGia" value="${update.quocGia}">

</form>
</body>
</html>