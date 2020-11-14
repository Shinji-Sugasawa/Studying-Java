package pokemon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class T2
 */
@WebServlet("/T2")
public class T2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public T2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		T2DAO t2dao = new T2DAO();
		session.setAttribute("all",t2dao.findAll());	//DAO呼び出し
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/t2.jsp");
		dispatcher.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if(action.contentEquals("create")) {
			String number = request.getParameter("number");
			String name = request.getParameter("name");
			String attack = request.getParameter("attack");
			String defence = request.getParameter("defence");
			String physical = request.getParameter("physical");
			System.out.printf("%s %s %s %s %s \n", number, name, attack,defence,physical);
			T2DAO t2dao = new T2DAO();
			boolean success = t2dao.create(Integer.parseInt(number), name,Integer.parseInt(attack),Integer.parseInt(defence),Integer.parseInt(physical));
			if(success) {
				session.setAttribute("message","create成功");
			} else {
				session.setAttribute("message","create失敗");
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/t2result.jsp");
			 dispatcher.forward(request, response);

		} else if (action.contentEquals("delete")){
			String number = request.getParameter("killnum");
			System.out.printf("%s\n", number);
			T2DAO t2dao = new T2DAO();
			boolean success = t2dao.delete(Integer.parseInt(number));
			if(success) {
				session.setAttribute("message","delete成功");
			} else {
				session.setAttribute("message","delete失敗");
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/t2result.jsp");
			 dispatcher.forward(request, response);

		} else if (action.contentEquals("update")) {
			String number = request.getParameter("upnum");
			String name = request.getParameter("upname");
			String attack = request.getParameter("upattack");
			String defence = request.getParameter("updefence");
			String physical = request.getParameter("upphysical");

			if(name == "") name = "null";
			if(attack == "") attack = "null";
			if(defence == "") defence = "null";
			if(physical == "") physical = "null";

			T2DAO t2dao = new T2DAO();
			boolean success = t2dao.update(Integer.parseInt(number), name,attack,defence,physical);
			if(success) {
				session.setAttribute("message","update成功");
			} else {
				session.setAttribute("message","update失敗");
			}
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/t2result.jsp");
			 dispatcher.forward(request, response);
		}
	}
}
