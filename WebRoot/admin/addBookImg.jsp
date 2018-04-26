<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/base/Base.jsp"></jsp:include>
<!DOCTYPE>
<html>
<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Add Book Images</title>
</head>
<body>
<div align="center">
    <br> <br> <br>
    <form id="ImgForm" name="ImgForm" method="post" enctype="multipart/form-data"
          action="UploadServlet?method=upload">
        <input type="file" name="images" id="images"/>
        <input type="submit" value="提交"/>
        <input type="reset" value="取消"/>
    </form>
</div>
</body>
</html>