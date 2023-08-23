<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>dc</title>
</head>
<body>
<form action="nhan-vien/update" method="post">
    ID: <input type="text" name="id" value="${update.id}"><br>
    Ma: <input type="text" name="ma" value="${update.ma}"><br>
    Ten: <input type="text" name="ten" value="${update.ten}"><br>
    GioiTinh: <input type="text" name="gioiTinh" value="${update.gioiTinh}"><br>
    NgaySinh: <input type="text" name="ngaySinh" value="${update.ngaySinh}"><br>
    <br>
    <button>update</button>
</form>
</body>
</html>