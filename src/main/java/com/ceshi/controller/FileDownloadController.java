package com.ceshi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {
   
	@SuppressWarnings("unused")
	@RequestMapping("/filedownload")
	public String filedown(HttpServletRequest request,HttpServletResponse response){
		
		/**
    	 * filename 文件的全路径
    	 * attache文件的名称
    	 * 
    	 * */    
    	String filename = request.getParameter("filename");
    	String filepath = request.getPathInfo();
    	String filepath2 = request.getRealPath("filename");
        
        if (filename == null)
            filename = "";
        
        filename = filename.trim();

        InputStream inStream = null;
        String attchname = "";

        byte[] b = new byte[100];
        int len = 0;
        try {            
            attchname = getAttachName(filename);    //取得附件的名称
//            filename = getRealName(request, filename);    //取得附件的全路径
            
//            if (filename == null) {
//                System.out.println("文件不存在,或者禁止下载");
//                return "false";
//            }
            attchname = toUtf8String(attchname);    //将文件转码 UTF-8
//            inStream = new FileInputStream(filename);
            inStream = new FileInputStream(filename);
            response.reset();    //必须reset，否则会出现文件不完整
            
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment; filename=\""    + attchname + "\"");
            
            //循环取出流中的数据 
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "success";
	}
	
	  //取得附件的名称
    public static String getAttachName(String filename) {
        if (filename == null)
            return "";
        filename = filename.trim();
        int pos = 0;
        
        pos = filename.lastIndexOf("\\");        
        if (pos > -1) {
            filename = filename.substring(pos + 1);
        }        
        
        pos = filename.lastIndexOf("/");        
        if (pos > -1) {
            filename = filename.substring(pos + 1);
        }
        
        pos = filename.lastIndexOf(File.separator);        
        if (pos > -1) {
            filename = filename.substring(pos + 1);
        }
        
        return filename;
    }

    //UTF8转码
    public static String toUtf8String(String string) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        String s_utf8 = sb.toString();
        sb.delete(0, sb.length());
        sb.setLength(0);
        sb = null;
        return s_utf8;
    }

    //取得下载文件的真实全路径名称
    @SuppressWarnings("deprecation")
	private String getRealName(HttpServletRequest request, String filename) {
        if (request == null || filename == null)
            return null;
        filename = filename.trim();
        if (filename.equals(""))
            return null;

        String filepath = request.getRealPath(filename);
        if (filepath == null)
            return null;
        File file = new File(filepath);
        if (!file.exists())
            return null;
        return filepath;
    }
}
