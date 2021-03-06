package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServ
 */
@WebServlet("/EmpServ")
public class EmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmpServ() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		//out.println("<table border=1><tr></tr><table>");
		out.println("{\"data\":[");
		int cnt = 0;
		for(Employee emp: list) {
			//System.out.println(emp.getFirstName()+","+emp.getLastName());
			out.println("{\"fistName\":\""+emp.getFirstName()+"\",\"lastName\":\""+emp.getLastName()+"\","
					+ "\"email\":\""+emp.getEmail()+"\"}");
			cnt++;
			if(list.size() !=cnt) {
				out.println(",");
				
			}

		}
		out.println("]}");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.getWriter().append("---post---");
	}

}
