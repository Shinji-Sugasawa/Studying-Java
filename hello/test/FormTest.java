package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormTest
 */
@WebServlet("/FormTest")
public class FormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); //フォームの文字コード
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int year = Integer.parseInt(request.getParameter("year"));
		int gender = Integer.parseInt(request.getParameter("gender"));
		String blood = request.getParameter("blood");

		response.setCharacterEncoding("UTF-8");//レスポンスの文字コード
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset=\"UTF-8\"><title>formtest</title></head>");
		out.println("<body>");

		out.println("<div>氏名:"+name+"</div>");

		out.println("<div>年齢:"+age+"</div>");

		out.println("<div>学年:"+year+"</div>");

		if(gender==0) out.println("<div>性別:男</div>");
		else out.println("<div>性別:女</div>");

		out.println("<div>血液型:"+blood+"</div>");

		out.println("</body>");
		out.println("</html>");
	}

}
