<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<form>
    ID : <input type="text" name="id" value="${detail.id}" readonly/>
    <br/>
    ID Sản Phẩm : <input type="text" name="idSanPham" value="${detail.idSanPham}" readonly/>
    <br/>
    ID Nhà Sản Xuất : <input type="text" name="idNhaSanXuat" value="${detail.idNhaSanXuat}" readonly/>
    <br/>
    ID Màu Sắc : <input type="text" name="idMauSac" value="${detail.idMauSac}" readonly/>
    <br/>
    ID Đồng Sản Phẩm : <input type="text" name="idDongSanPham" value="${detail.idDongSanPham}" readonly/>
    <br/>
    Năm Bảo Hành : <input type="text" name="namBaoHanh" value="${detail.namBaoHanh}" readonly/>
    <br/>
    Mô Tả : <input type="text" name="moTa" value="${detail.moTa}" readonly/>
    <br/>
    Số Lượng Tồn : <input type="text" name="soLuongTon" value="${detail.soLuongTon}" readonly/>
    <br/>
    Giá Nhập : <input type="text" name="giaNhap" value="${detail.giaNhap}" readonly/>
    <br/>
    Giá Bán : <input type="text" name="giaBan" value="${detail.giaBan}" readonly/>
    <br/>

</form>

<section>
    <a href="/chi-tiet-san-pham/view-add" class="btn btn-success " tabindex="-1" role="button"
       aria-disabled="true">Add</a>
</section>

<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">ID Sản Phẩm</th>
            <th scope="col">ID Nhà Sản Xuất</th>
            <th scope="col">ID Màu Sắc</th>
            <th scope="col">ID Đồng Sản phẩm</th>
            <th scope="col">Năm Bảo Hành</th>
            <th scope="col">Mô Tả</th>
            <th scope="col">Số Lượng Tồn</th>
            <th scope="col">Giá Nhập</th>
            <th scope="col">Giá Bán</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="ctsp">
            <tr>
                <td>${ctsp.id}</td>
                <td>${ctsp.idSanPham}</td>
                <td>${ctsp.idNhaSanXuat}</td>
                <td>${ctsp.idMauSac}</td>
                <td>${ctsp.idDongSanPham}</td>
                <td>${ctsp.namBaoHanh}</td>
                <td>${ctsp.moTa}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaNhap}</td>
                <td>${ctsp.giaBan}</td>
                <td>
                    <a href="/chi-tiet-san-pham/detail?id=${ctsp.id}" class="btn btn-primary">Detail</a>
                    <a href="/chi-tiet-san-pham/view-update?id=${ctsp.id}" class="btn btn-primary">Update</a>
                    <a href="/chi-tiet-san-pham/remove?id=${ctsp.id}" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
