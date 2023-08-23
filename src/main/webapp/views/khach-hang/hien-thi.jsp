<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<form action="/khach-hang/add" method="post">
    ID : <input type="text" name="id" value="${detail.id}" readonly/>
    <br/>
    Mã : <input type="text" name="ma" value="${detail.ma}"/>
    <br/>
    Tên : <input type="text" name="ten" value="${detail.ten}"/>
    <br/>
    Tên Đệm : <input type="text" name="tenDem" value="${detail.tenDem}"/>
    <br/>
    Họ : <input type="text" name="ho" value="${detail.ho}"/>
    <br/>
    Ngày Sinh : <input type="date" name="ngaySinh" value="${detail.ngaySinh}"/>
    <br/>
    Số Điện Thoại : <input type="text" name="soDienThoai" value="${detail.soDienThoai}"/>
    <br/>
    Địa Chỉ : <input type="text" name="diaChi" value="${detail.diaChi}"/>
    <br/>
    Thành Phố : <input type="text" name="thanhPho" value="${detail.thanhPho}"/>
    <br/>
    Quốc Gia : <input type="text" name="quocGia" value="${detail.quocGia}"/>
    <br/>
    Mật Khẩu : <input type="text" name="matKhau" value="${detail.matKhau}"/>
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
            <th scope="col">Tên Đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">SDT</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="kh">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.tenDem}</td>
                <td>${kh.ho}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.soDienThoai}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.thanhPho}</td>
                <td>${kh.quocGia}</td>
                <td>${kh.matKhau}</td>
                <td>
                    <a href="/khach-hang/detail?id=${kh.id}" class="btn btn-primary">Detail</a>
                    <a href="/khach-hang/view-update?id=${kh.id}" class="btn btn-primary">Update</a>
                    <a href="/khach-hang/remove?id=${kh.id}" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
