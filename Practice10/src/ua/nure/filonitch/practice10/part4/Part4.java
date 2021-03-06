package ua.nure.filonitch.practice10.part4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Part4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/practice10?user=root&password=1333";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("login") != null)
			resp.sendRedirect("/part3.jsp");
		else
			resp.sendRedirect("part4.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("password");

		System.out.printf("Get login: %s, password: %s%n", login, pass);

		if (login == null || pass == null || !isUserExists(login, pass)) {
			System.out.println("redirect to part4.jsp");
			resp.sendRedirect("part4.jsp");
		} else {
			req.getSession().setAttribute("login", login);
			System.out.println("redirect to part3");
			resp.sendRedirect("/part3.jsp");
		}

	}

	private boolean isUserExists(String login, String pass) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(CONNECTION_URL);
			System.out.println(con);
			statement = con.prepareStatement("SELECT COUNT(*) FROM users WHERE login=? AND password=?");
			statement.setString(1, login);
			statement.setString(2, pass);

			rs = statement.executeQuery();

			if (rs.next() && "1".equals(rs.getString("COUNT(*)")))
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();

				if (statement != null)
					statement.close();

				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}