<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/chuc-vu/update" method="post">
    ID : <input type="text" name="id" value="${update.id}" readonly/>
    <br/>
    Mã : <input type="text" name="ma" value="${update.ma}"/>
    <br/>
    Tên : <input type="text" name="ten" value="${update.ten}"/>
    <br/>
    <button type="submit">Update</button>
</form>

</body>
</html>