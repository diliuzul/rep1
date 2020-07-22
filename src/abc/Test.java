package abc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Test1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
public class Test {
	
	private static boolean res;
	private static java.sql.Statement st;
	private static String sql;

	public static void main(String[] args) throws SQLException{
		//输入的类
		Scanner userInput = new Scanner(System.in);
		Test1 test1 =new Test1();
		
		System.out.println("请输入用户名：");
		//nextLine(),将输入的用户名以字符串形式返回。
		//String USERNAME = userInput.nextLine();
		test1.setUsername(userInput.nextLine());
		//System.out.println(username);
		
		System.out.println("请输入您的手机号:");
		//nextLong(),将输入的手机号以Long型返回。
//		Long phone = userInput.nextLong();
//		System.out.println(phone);
		test1.setPhone(userInput.nextLine());
		
		
		
		System.out.println("请输入您的密码:");
		//nextLine(),将输入的密码以字符串形式返回。
//		String password = userInput.nextLine();
//		System.out.println(password);
		test1.setPassword(userInput.nextLine());
		
		
		//使用jdbc连接数据库，执行sql语句
		try{
			//导入jar包
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			//定义sql语句
			String sql ="INSERT INTO JIAJU(username,phone,password) VALUES(?,?,?)";
			System.out.println(sql);
			//获取执行sql语句的对象
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			//Statement st = (Statement) con.createStatement();
			//执行sql语句
			ps.setString(1, test1.getUsername());
			ps.setString(2,test1.getPhone());
			ps.setString(3,test1.getPassword());
			
			int res =ps.executeUpdate();
			
			//res = st.execute(sql);
			System.out.println(res);
			//查看返回结果
			if(res !=1){
				System.out.println                   ("失败");
			}else{
				System.out.println("成功");
			}
			//释放资源
			con.close();                                  
		}                             
		catch(Exception e){
			e.printStackTrace(); 
		}
	}}
			                                                                                                                         
	


                