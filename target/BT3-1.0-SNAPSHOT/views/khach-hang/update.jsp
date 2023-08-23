<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/khach-hang/update" method="post">
    ID : <input type="text" name="id" value="${update.id}" readonly/>
    <br/>
    Mã: <input type="text" name="ma" value="${update.ma}"/>
    <br/>
    Tên : <input type="text" name="ten" value="${update.ten}"/>
    <br/>
    Tên Đệm : <input type="date" name="tenDem" value="${update.tenDem}"/>
    <br/>
    Họ : <input type="text" name="ho" value="${update.ho}"/>
    <br/>
    Ngày Sinh : <input type="text" name="ngaySinh" value="${update.ngaySinh}"/>
    <br/>
    Số Điện Thoai : <input type="text" name="soDienThoai" value="${update.soDienThoai}"/>
    <br/>
    Địa Chỉ : <input type="text" name="diaChi" value="${update.diaChi}"/>
    <br/>
    Thành Phố : <input type="text" name="thanhPho" value="${update.thanhPho}"/>
    <br/>
    Quốc Gia : <input type="text" name="quocGia" value="${update.quocGia}"/>
    <br/>
    Mật Khẩu : <input type="text" name="matKhau" value="${update.matKhau}"/>
    <br/>
    <button type="submit">Update</button>
</form>

</body>
</html>
