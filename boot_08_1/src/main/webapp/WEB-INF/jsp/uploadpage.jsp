<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
</head>
<body>
	<form method="post" action="/uploadOne" enctype="multipart/form-data">
	    <input type="file" name="file"><br>
	    <input type="submit" value="提交一个文件表单">
	</form>
	
	<hr/>
	<form method="post" action="/uploadMany" enctype="multipart/form-data">
	    <input type="file" name="file"><br>
	    <input type="file" name="file"><br>
	    <input type="file" name="file"><br>
	    <input type="file" name="file"><br>
	    <input type="submit" value="提交多个文件表单">
	</form>
</body>
</html>