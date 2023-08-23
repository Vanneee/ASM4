<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/chi-tiet-san-pham/update" method="post">
    ID : <input type="text" name="id" value="${update.id}" readonly/>
    <br/>
    ID Sản Phẩm : <input type="text" name="idSanPham" value="${update.idSanPham}" readonly/>
    <br/>
    ID Nhà Sản Xuất : <input type="text" name="idNhaSanXuat" value="${update.idNhaSanXuat}" readonly/>
    <br/>
    ID Màu Sắc : <input type="text" name="idMauSac" value="${update.idMauSac}" readonly/>
    <br/>
    ID Đồng Sản Phẩm : <input type="text" name="idDongSanPham" value="${update.idDongSanPham}" readonly/>
    <br/>
    Năm Bảo Hành : <input type="text" name="namBaoHanh" value="${update.namBaoHanh}"/>
    <br/>
    Mô Tả : <input type="text" name="moTa" value="${update.moTa}"/>
    <br/>
    Số Lượng Tồn : <input type="text" name="soLuongTon" value="${update.soLuongTon}"/>
    <br/>
    Giá Nhập : <input type="text" name="giaNhap" value="${update.giaNhap}"/>
    <br/>
    Giá Bán : <input type="text" name="giaBan" value="${update.giaBan}"/>
    <br/>
    <button type="submit">Update</button>
</form>

</body>
</html>
