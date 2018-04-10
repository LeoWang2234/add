<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
    String importMsg="";
    if(request.getSession().getAttribute("msg")!=null){
        importMsg=request.getSession().getAttribute("msg").toString();
    }
    request.getSession().setAttribute("msg", "");
%>
<head>
    <title>批导入编译文件</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<div><font color="bule">导入编译文件</font></div>
<form action="/upload/uploadExcel" method="post" enctype="multipart/form-data" onsubmit="return check();">
    <div style="margin: 30px;"><input id="excel_file" type="file" name="filename" accept="xlsx" size="80"/>
        <input id="excel_button" type="submit" value="导入Excel"/></div>
    <font id="importMsg" color="red"><%=importMsg%></font><input type="hidden"/>
</form>
</body>
<script type="text/javascript">
//    function check() {
////        alert('here')
//        var excel_file = document.getElementById("excel_file").value;
////        alert(excel_file)
//        if (excel_file == "" || excel_file.length == 0) {
//            alert("请选择文件路径！");
//            return false;
//        } else {
//            return true;
//        }
//    }

    $(document).ready(function () {
        var msg="";
        if(document.getElementById("importMsg").text()!=null){
            msg=document.getElementById("importMsg").text();
        }
        if(msg!=""){
            alert(msg);
        }
    });
</script>

</html>