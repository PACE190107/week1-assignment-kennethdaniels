package com.revature.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletExample extends HttpServlet {
//intended endpoint url kennethdanielsdb.cxpt4bk9ingo.us-east-1.rds.amazonaws.com
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Steve Likes Shapes!");
	}
}
