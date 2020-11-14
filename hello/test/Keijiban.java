package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Keijiban
 */
@WebServlet("/Keijiban")
public class Keijiban extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> list = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Keijiban() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("not used");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("送信")) {
			order(request,response);
		}else if (action.contentEquals("リセット")) {
			terminateSession(request,response);
		}
	}
	//呟きをオーダーに入れる
	void order (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//呟きを受け取る
		String String = request.getParameter("murmur");
		list.add(String);
		System.out.println(list);

		HttpSession session = request.getSession();
		Map<String,String> order = (Map<String,String>)session.getAttribute("order");
		Map<String,Integer> count = (Map<String,Integer>)session.getAttribute("count");
		if(order == null) {
			order = new HashMap<String,String>();//新規作成
			count = new HashMap<String,Integer>();
			order.put("投稿",":");
			count.put("大きさ",0);
			session.setAttribute("order", order);//セッションスコープに格納
			session.setAttribute("count", count);//セッションスコープに格納
		}
		count.put("大きさ",list.size());
		for( int i=0;i<list.size();i++) {
		order.put("投稿"+i,list.get(i));
		}

		//keijiban.jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/keijiban.jsp");
		dispatcher.forward(request,response);
	}
		//全削除する
		void terminateSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			HttpSession session = request.getSession();
			session.invalidate();
			list.clear();

			//keijiban.jspにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/keijiban.jsp");
			dispatcher.forward(request, response);
		}
}