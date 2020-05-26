package ua.nure.filonitch.practice10.part3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        @SuppressWarnings("unchecked")
			ArrayList<String> names = (ArrayList<String>) req.getSession().getAttribute("names");
	        String rem = req.getParameter("remove");
	        if(rem != null && "true".equals(rem))
	            names.clear();

	        resp.sendRedirect("part3.jsp");
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        @SuppressWarnings("unchecked")
			ArrayList<String> names = (ArrayList<String>) req.getSession().getAttribute("names");
	        if (names == null){
	            names = new ArrayList<>();
	            req.getSession().setAttribute("names",names);
	        }
	        String myname = req.getParameter("myname");
	        if (myname != null)
	            names.add(myname);

	        resp.sendRedirect("part3.jsp");
	    }

}
