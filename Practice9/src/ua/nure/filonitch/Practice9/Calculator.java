package ua.nure.filonitch.Practice9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WebServlet")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		String operation = req.getParameter("op");

		int result = 0;
		if ("minus".equals(operation))
			result = x - y;
		else if ("plus".equals(operation))
			result = x + y;

		req.setAttribute("result", result);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}
