package test;

import java.io.IOException;
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
 * Servlet implementation class Sushi
 */
@WebServlet("/Sushi")
public class Sushi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sushi() {
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
	//押されたボタンにより動作を変える
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action.contentEquals("リセット")) {
			terminateSession(request,response);
		}else if(action.contentEquals("注文")) {
			order(request,response);
		}
	}
	//注文表(order)に個数を追加する
	void order (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		//注文を受け取る
		String num1string = request.getParameter("num1");
		String num2string = request.getParameter("num2");
		String num3string = request.getParameter("num3");
		String num4string = request.getParameter("num4");
		//文字から数字へと変換
		int num1 = Integer.parseInt(num1string);
		int num2 = Integer.parseInt(num2string);
		int num3 = Integer.parseInt(num3string);
		int num4 = Integer.parseInt(num4string);

		System.out.printf("%d %d %d %d\n", num1,num2,num3,num4);

		//セッションスコープから注文表を取り出す
		//注文表がない場合は新規作成する
		HttpSession session = request.getSession();
		Map<String,Integer> order = (Map<String,Integer>)session.getAttribute("order");
		if(order == null) {
			order = new HashMap<String,Integer>();//新規作成
			order.put("たまご",0);
			order.put("中トロ",0);
			order.put("いくら",0);
			order.put("うに",0);
			session.setAttribute("order", order);//セッションスコープに格納
		}
		//注文表に今回の注文を加算する
		int sum1 = order.get("たまご") + num1;
		int sum2 = order.get("中トロ") + num2;
		int sum3 = order.get("いくら") + num3;
		int sum4 = order.get("うに") + num4;
		order.put("たまご", sum1);
		order.put("中トロ", sum2);
		order.put("いくら", sum3);

		//合計額
		int total = sum1 * 100 + sum2 * 200 + sum3 * 300 + sum4 * 400;
		session.setAttribute("total",total);
		order.put("合計",total);

		//sushi.jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sushi.jsp");
		dispatcher.forward(request,response);
	}
	//セッションを破棄する
	void terminateSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.invalidate();

		//sushi.jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sushi.jsp");
		dispatcher.forward(request, response);
	}

}
