<%@page import="model.bean.Khoa"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- //jQuery -->
	<script src="js/jquery.dataTables.js"></script>
	<script src="js/dataTables.bootstrap.js"></script>
	<!-- tables -->
	<link rel="stylesheet" type="text/css" href="css/table-style.css" />
	<link rel="stylesheet" type="text/css" href="css/basictable.css" />
	<script type="text/javascript" src=".js/jquery.basictable.min.js"></script>
	<script src="js/jquery-datatable.js"></script>

<!-- //tables -->
</head>
<body>
<div class="container">
    <div class="row">
        <html:form action="/danh-sach" method="get">
            <div class="col-lg-4">
                <html:select property="maKhoa" styleClass="form-control">
					<option value="">-- Chọn khoa --</option>
					<html:optionsCollection name="danhSachSinhVienForm" property="listKhoa" 
						label="tenKhoa" value="maKhoa" />
				</html:select>
            </div>
            <script type="text/javascript">
            	$("[name='maKhoa']").val('<bean:write name="danhSachSinhVienForm" property="maKhoa"/>');
            </script>
            <html:submit styleClass="btn btn-primary">Xem</html:submit>
            <div class="col-lg-2 pull-right">
            	<html:link styleClass="btn btn-primary" action="/themSV">Thêm mới</html:link>
            </div>
        </html:form>
    </div>
    <br>
    <div class="bs-example">
        <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
            <thead>
            <tr>
                <th>MSV</th>
                <th>Họ Tên</th>
                <th>Giới Tính</th>
                <th>Khoa</th>
                <th>Hình Đại Diện</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachSinhVienForm" property="listSinhVien" id="sv">
            	<tr>
                <td scope="row">
                	<bean:write name="sv" property="msv"/>
				</td>
                <td>
                	<bean:write name="sv" property="hoTen"/>
                </td>
                <td>
                	<bean:write name="sv" property="gioiTinh"/>
				</td>
                <td>
                	<bean:write name="sv" property="tenKhoa"/>
                </td>
                <td>
                	<img src = "<bean:write name="sv" property="hinhDaiDien"/>" alt = "avatar" style = "height: 50px; weight: 50px"/>
                	
                </td>
                <td>
                	<bean:define id="msv" name="sv" property="msv"></bean:define>
                	<html:link action="/suaSV?msv=${msv}">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                	<html:link action="/xoaSV?msv=${msv}" style="margin-left: 30px;">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>
                </td>
            </tr>
            </logic:iterate>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>