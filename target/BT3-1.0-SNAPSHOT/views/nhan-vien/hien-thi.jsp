<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>dc</title>
</head>
<body>
<form action="nhan-vien/add" method="post">
    ID: <input type="text" name="id" value="${detail.id}"><br>
    Ma: <input type="text" name="ma" value="${detail.ma}"><br>
    Ten: <input type="text" name="ten" value="${detail.ten}"><br>
    GioiTinh: <input type="text" name="gioiTinh" value="${detail.gioiTinh}"><br>
    NgaySinh: <input type="text" name="ngaySinh" value="${detail.ngaySinh}"><br>
    <br>
    <button>add</button>
</form>
<div>
    <table class="table">
       <thead>
            <tr>
                <th colspan="col">ID</th>
                <th colspan="col">Ma</th>
                <th colspan="col">Ten</th>
                <th colspan="col">GioiTinh</th>
                <th colspan="col">NgaySinh</th>
            </tr>
       </thead>
        <c:forEach  items="${lists}" var="nv">
            <tr>
                <td colspan="col">${nv.id}</td>
                <td colspan="col">${nv.ma}</td>
                <td colspan="col">${nv.ten}</td>
                <td colspan="col">${nv.gioiTinh}</td>
                <td colspan="col">${nv.ngaySinh}</td>
               <td>
                   <a href="/nhan-vien/delete?id=${nv.id}">delete</a>
                   <a href="/nhan-vien/detail?id=${nv.id}">detail</a>
                   <a href="/nhan-vien/view-update?id=${nv.id}">update</a>
               </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>