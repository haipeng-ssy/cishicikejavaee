package com.ceshi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackForPhone {

	@RequestMapping("/getResult")
	public void getResultForPhone(HttpServletRequest request,HttpServletResponse response){
		String strRequest = request.getParameter("myphone");
		if (strRequest.equals("huawei")) {
			try {
			
				response.getOutputStream().println("nihao huawei");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
