package com.ceshi.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUploadController {

	@RequestMapping("/fileupload")
	public String fileUpload(HttpServletRequest request,HttpServletResponse response){
	        
	        File tmp = new File("c:\\tmp\\");
	        if(! tmp.exists()) {
	            tmp.mkdirs();
	        }
	        
	        DiskFileItemFactory factory = new DiskFileItemFactory();    //创建磁盘工厂
	        factory.setRepository(tmp);    //文件缓存路径
	        factory.setSizeThreshold(10 * 1096 );
	        
	        ServletFileUpload sfu = new ServletFileUpload(factory);        //创建处理工具
	        sfu.setSizeMax(10*1024*1024); //服务器端可以接收的最大文件大小，-1表示无上限
	        
	        String filename = null;
	        try {
	            @SuppressWarnings("unchecked")
				List<FileItem> list = sfu.parseRequest(request);        //解析
	            FileItem item= list.get(0);
	            filename = item.getName();
	            if(filename.equals("")) {
	                return "fail";
	            }            
	            int pos = filename.lastIndexOf(".");                    //取图片文件格式
	            if(pos > 0) {
	                Date date = new Date();
	                filename ='/'+ date.getTime()+filename.substring(pos);
	            }
	            item.write(new File(filename));    //写到磁盘
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		return "success";
	}
}
