package ua.nure.filonitch.Practice9;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/voting")
public class Voting extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();

	public Voting() {
		map.put("Football", 0);
		map.put("Biathlon", 0);
		map.put("Basketball", 0);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sport = request.getParameter("sport");
		int counter = map.get(sport);
		map.put(sport, ++counter);

		request.setAttribute("counter", map.get("Football"));
		request.setAttribute("counter2", map.get("Biathlon"));
		request.setAttribute("counter3", map.get("Basketball"));
		request.getRequestDispatcher("part2_1.jsp").forward(request, response);
	}
}
