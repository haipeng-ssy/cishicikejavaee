package com.ceshi.util;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.handson.bbs.bo.UserBO;
import com.handson.bbs.model.User;
/** *//**
 * **********************************************
 * @description 文件上传
 *                 针对本项目，上传图片在uploadFile/Image
 *                         缓存目录 c:\\tmp\\ 目录下
 *                 照片上传后，后面代码处理及时更新用户照片。
 * @author Gavin.lee
 * @date 2009-6-13 21:35:47
 * @version 1.0
 ***********************************************
 */
public class UploadPhotoServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String filepath = this.getServletContext().getRealPath("/uploadFile/Image/");    //容器相对路径
        
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
            List<FileItem> list = sfu.parseRequest(request);        //解析
            FileItem item= list.get(0);
            filename = item.getName();
            if(filename.equals("")) {
                request.getRequestDispatcher("/com/visualizePhoto.jsp").forward(request, response);
                return ;
            }            
            int pos = filename.lastIndexOf(".");                    //取图片文件格式
            if(pos > 0) {
                Date date = new Date();
                filename =filepath+'/'+ date.getTime()+filename.substring(pos);
            }
            item.write(new File(filename));    //写到磁盘
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        // 只针对文件上传的话，后面代码不用看了，后面是针对及时更新用户信息（照片）
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");        
        int pos = filename.indexOf("uploadFile");    //设置图片相对路径
        if(pos > 0) {
            filename = filename.substring(pos,pos+10)+'/'+filename.substring(pos+11);
        }
        user.setPhoto(filename);
        
        UserBO userBo = UserBO.getInstance();
        if(userBo.updateUser(user)){
            session.setAttribute("user", user);
            request.getRequestDispatcher("/com/visualizePhoto.jsp").forward(request, response);
        }
    }

}
