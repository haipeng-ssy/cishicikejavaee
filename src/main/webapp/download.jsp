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
    <script type="text/javascript">
               String str=document.getElementById("filename").value;
               
    </script>
    <form action="/cishicikejavaee/filedownload">
        <table>
            <tr>
               <td><input type="text" value="D:\workcode\Android\widgetTest\WidgetTest\res\drawable-hdpi\ic_launcher.png"
                name="filename"/></td>
               <td><input type="submit" value="download" /></td>
            </tr>
        </table>
        </form>
        
         <form action="/cishicikejavaee/filedownselect">
        <table>
            <tr>
               <td><input type="file" /></td>
               <td><input type="submit" value="filedownselect" /></td>
            </tr>
        </table>
        </form>
        
         <form action="/cishicikejavaee/filedownlocal">
        <table>
            <tr>
        
               <td><input type="submit" value="filedownlocal" /></td>
            </tr>
        </table>
        </form>
        
        
    </div>
</body>
</html>