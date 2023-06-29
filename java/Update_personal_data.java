

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.Jdbc;


@WebServlet("/Update_personal_data")
public class Update_personal_data extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Update_personal_data() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String learn = request.getParameter("learn");
		int id = Integer.parseInt(request.getParameter("user_id"));
		
		String sql = "update JavaBean.user_data set user_name= ? , user_phone= ? , user_gender= ? , user_learn= ? where user_id= ?";
		Jdbc jd = null;
		try {
			jd = new Jdbc();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			 conn = jd.get_Connection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.setString(1, user_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.setString(2, phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.setString(3, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.setString(4, learn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.setInt(5, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.addBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String responseData = "http://localhost:8080/JavaBean/MemberCenter.jsp?id="+id;
	    
	    // 閮剔蔭����摰寥���
		response.setContentType("text/plain");
	    
	    // 撠��神�����
	    PrintWriter out = response.getWriter();
	    out.print(responseData);
	    out.flush();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
