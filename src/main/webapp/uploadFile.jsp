<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <div>
         <form action="/cishicikejavaee/fileupload" enctype="multipart/form-data"
         name="fileUploadForm"
         method="post">
         <table>
             <tr>
                <td>upload</td>
                <td><input type="file" name="file"></td>
                <td><input type="submit" value="upload"></td>
             </tr>
         </table>
         </form>
         
     </div>

</body>
</html>