package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns={"/hello"}, loadOnStartup=1)
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {  
		// ���� �ʱ�ȭ - ������ ���� �Ǵ� ���ε� ��, �� �ѹ��� �����.
		System.out.println("[HelloSerlvet] init()");
	}
	   
	@Override // ȣ��� ������ �ݺ������� �����.
	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 1. �Է�
		// 2. ó�� 
		// 3. ���
		System.out.println("[HelloSerlvet] service()");
	}

	@Override   
	public void destroy() {   
		// ������ �۾� - ������ ����(unload)�� ��, �� �ѹ��� �����.
		System.out.println("[HelloSerlvet] destroy()");  
	}
}