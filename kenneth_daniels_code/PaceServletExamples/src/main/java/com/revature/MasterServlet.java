package com.revature;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//responsible for marshalling/unmarshalling POJOS to JSON
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
		resp.setContentType("application/json");
		resp.getWriter().append(mapper.writeValueAsString(MasterDispatcher.process(req, resp)));
}
