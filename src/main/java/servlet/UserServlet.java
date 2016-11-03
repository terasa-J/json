package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import entity.User;


public class UserServlet extends HttpServlet {
	private List<User> listUser;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//初始化数据，从后台读取
		prepareData();
		//封装成json
		JSONArray array=new JSONArray();
		for(User u:listUser){
			JSONObject obj=new JSONObject();
			obj.put("id",u.getId());
			obj.put("name",u.getName());
			array.put(obj);
		}
		out.println(array.toString());
		
		
		
		
	}
	protected void prepareData(){
	    listUser=new ArrayList<User>();
		User u1=new User();
		u1.setId(1);
		u1.setName("eva");
		listUser.add(u1);
		
		User u2=new User();
		u2.setId(3);
		u2.setName("jiang");
		listUser.add(u2);	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
