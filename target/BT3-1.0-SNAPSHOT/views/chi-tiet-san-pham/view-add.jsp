<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/chi-tiet-san-pham/add" method="post">
    <table class="table table-borderless">
        <tbody>
        <tr>
            <td><label>Sản Phẩm </label>
                <select name="sanPham">
                    <c:forEach items="${sanPham}" var="sp">
                        <option value="${sp.id}" name="idSanPham">${sp.id}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td><label>Nhà Sản Xuất </label>
                <select name="nhaSanXuat">
                    <c:forEach items="${nhaSanXuat}" var="nsx">
                        <option value="${nsx.id}" name="idNhaSanXuat">${nsx.id}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td><label>Màu Sắc</label>
                <select name="mauSac">
                    <c:forEach items="${mauSac}" var="ms">
                        <option value="${ms.id}" name="idMauSac">${ms.id}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td><label>Dòng Sản Phẩm</label>
                <select name="dongSanPham">
                    <c:forEach items="${dongSanPham}" var="dsp">
                        <option value="${dsp.id}" name="idDongSanPham">${dsp.id}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td><label>Năm Bảo Hành</label>
                <input name="namBaoHanh" type="number"></td>
        </tr>
        <tr>
            <td><label>Mô Tả</label>
                <input name="moTa" type="text"></td>
        </tr>
        <tr>
            <td><label>Số Lượng Tồn</label>
                <input name="soLuongTon" type="text"></td>
        </tr>
        <tr>
            <td><label>Giá Bán</label>
                <input name="giaBan" type="text"></td>
        </tr>
        <tr>
            <td><label>Giá Nhập</label>
                <input name="giaNhap" type="text"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">ADD</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>