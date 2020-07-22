package project;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import model.Test1;

public class Add {
	
		private static Scanner userInput;
		private static Scanner sc;
		private static Scanner sc2;
		private static Scanner sc3;
		private static Scanner sc4;
		private static void  add(){
			userInput = new Scanner(System.in);
			Test1 test1 =new Test1();
			
			System.out.println("请输入家具名称：");
			//nextLine(),将输入的用户名以字符串形式返回。
			//String USERNAME = userInput.nextLine();
			test1.setUsername(userInput.nextLine());
			//System.out.println(username);
			
			System.out.println("请输入家具数量:");
			//nextLong(),将输入的手机号以Long型返回。
//			Long phone = userInput.nextLong();
//			System.out.println(phone);
			test1.setPhone(userInput.nextLine());
			
			System.out.println("请输入家具价格:");
			//nextLine(),将输入的密码以字符串形式返回。
//			String password = userInput.nextLine();
//			System.out.println(password);
			test1.setPassword(userInput.nextLine());
			
			
			//使用jdbc连接数据库，执行sql语句
			try{
				//导入jar包
				//注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				//获取数据库
				Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				//定义sql语句
				String sql ="INSERT INTO FUR(name,num,money) VALUES(?,?,?)";
				//System.out.println(sql);
				//获取执行sql语句的对象
				PreparedStatement ps = con.prepareStatement(sql);
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
					System.out.println ("失败");
				}else{
					System.out.println("成功");
				}
				//释放资源
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		private static void  change(){
			sc3 = new Scanner(System.in);
			try{
				//导入jar包
				//注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				//获取数据库
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement stmt = con.createStatement();
				//定义sql语句
				System.out.println("请输入家具编号");
				int id = sc3.nextInt();
				System.out.println("输入修改后商品名称");
				String name = sc3.next();
				System.out.println("输入修改后商品数量");
				String num = sc3.next();
				System.out.println("输入修改后商品价格");
				String money = sc3.next();
				String sql1 = "update fur set name='"+name+"'where id = "+id;
				int i = stmt.executeUpdate(sql1);
				String sql2 = "update fur set num='"+num+"'where id = "+id;
				int x = stmt.executeUpdate(sql2);
				String sql3 = "update fur set money='"+money+"'where id = "+id;
				int y =stmt.executeUpdate(sql3);
				System.out.println(i+" "+x+" "+y);
				
				//释放资源
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		private static void  delete(){
			sc4 = new Scanner(System.in);
			try{
				//导入jar包
				//注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				//获取数据库
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement stmt = con.createStatement();
				//定义sql语句
				System.out.println("请输入家具编号");
				int id = sc4.nextInt();
				String sql = "delete from fur where id="+id;
				int i = stmt.executeUpdate(sql);
				System.out.println(i);
				
				//释放资源
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
			
		}
		private static void  find (){
			try{
				//导入jar包
				//注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				//获取数据库
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				//定义sql语句
				String sql = "select * from fur ";
				
				PreparedStatement ps =con.prepareStatement(sql);
				//Statement st = (Statement) con.createStatement();
				
				ResultSet result = ps.executeQuery();
				while(result.next()){
					String name = result.getString("name");
					String num = result.getString("num");
					String money = result.getString("money");
					System.out.println("家具名称:"+name+" \t\t 家具数量 :"+num+"  \t\t家具单价:"+money);
				}
				
				//释放资源
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		
		private static void  seek(){
			sc2 = new Scanner(System.in);
			try{
				//导入jar包
				//注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				//获取数据库
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement stmt = con.createStatement();
				//定义sql语句
				System.out.println("请输入会员编号");
				int id = sc2.nextInt();
				System.out.println("请输入积分");
				int seek = sc2.nextInt();
				String sql = "update jiaju set seek='"+seek+"'where id = "+id;
				int i =  stmt.executeUpdate(sql);
				System.out.println(i);
				
				//释放资源
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		
		
		
		private static void Menu() {
			System.out.println("1:添加家具信息");
			System.out.println("2:更改家居信息");
			System.out.println("3:删除家具信息");
			System.out.println("4:查询家具信息");
			System.out.println("5:更改积分");
			System.out.println("0:退出");
		}
		public static void main(String[] args) throws SQLException{
			sc = new Scanner(System.in);
			Menu();
			int choose = 10;
			while(true){
				System.out.println("请输入您所需功能:");
				choose = sc.nextInt();
				switch (choose) {
				case 1:
					add();
					break;
				case 2:
					change();
					break;
				case 3:
					delete();
					break;
				case 4:
					find();
					break;
				case 5:
					seek();
					break;
				case 0:
					System.exit(0);
					break;
				}
			}
		}

		}		                                           
