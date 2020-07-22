package abc;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	private static Scanner userInput;

	public static void main(String[] args) throws SQLException{
		userInput = new Scanner(System.in);
//		System.out.println("请输入用户名：");
//		//printIn换行 print不换行
//		String username = userInput.nextLine();//nextLine 检测输入     字符串形式返回
//		System.out.println(username);//打印输入
//		System.out.println("请输入手机号：");
//        //Long phone = userInput.nextLong();//数字形式返回     int长度小
//		//System.out.println(phone);
//		String phone =userInput.nextLine();
//		System.out.println("请输入密码：");
//		String password = userInput.nextLine();
//		System.out.println(username+"---"+phone+"---"+password);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接对象 如果链接的是且端口号是默认的3306 则本机127.0.0.1:3306可不写
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
			String sql = "DELETE FROM JIAJU WHERE name='liu'";
			Statement st =(Statement) con.createStatement();
			int res = 0;
			//boolean res =  st.execute();
			if(res!=0 ){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		
		
	}

}
