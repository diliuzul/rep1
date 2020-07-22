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
			
			System.out.println("������Ҿ����ƣ�");
			//nextLine(),��������û������ַ�����ʽ���ء�
			//String USERNAME = userInput.nextLine();
			test1.setUsername(userInput.nextLine());
			//System.out.println(username);
			
			System.out.println("������Ҿ�����:");
			//nextLong(),��������ֻ�����Long�ͷ��ء�
//			Long phone = userInput.nextLong();
//			System.out.println(phone);
			test1.setPhone(userInput.nextLine());
			
			System.out.println("������Ҿ߼۸�:");
			//nextLine(),��������������ַ�����ʽ���ء�
//			String password = userInput.nextLine();
//			System.out.println(password);
			test1.setPassword(userInput.nextLine());
			
			
			//ʹ��jdbc�������ݿ⣬ִ��sql���
			try{
				//����jar��
				//ע������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ���ݿ�
				Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				//����sql���
				String sql ="INSERT INTO FUR(name,num,money) VALUES(?,?,?)";
				//System.out.println(sql);
				//��ȡִ��sql���Ķ���
				PreparedStatement ps = con.prepareStatement(sql);
				//Statement st = (Statement) con.createStatement();
				//ִ��sql���
				ps.setString(1, test1.getUsername());
				ps.setString(2,test1.getPhone());
				ps.setString(3,test1.getPassword());
				
				int res =ps.executeUpdate();
				
				//res = st.execute(sql);
				System.out.println(res);
				//�鿴���ؽ��
				if(res !=1){
					System.out.println ("ʧ��");
				}else{
					System.out.println("�ɹ�");
				}
				//�ͷ���Դ
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		private static void  change(){
			sc3 = new Scanner(System.in);
			try{
				//����jar��
				//ע������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ���ݿ�
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement stmt = con.createStatement();
				//����sql���
				System.out.println("������Ҿ߱��");
				int id = sc3.nextInt();
				System.out.println("�����޸ĺ���Ʒ����");
				String name = sc3.next();
				System.out.println("�����޸ĺ���Ʒ����");
				String num = sc3.next();
				System.out.println("�����޸ĺ���Ʒ�۸�");
				String money = sc3.next();
				String sql1 = "update fur set name='"+name+"'where id = "+id;
				int i = stmt.executeUpdate(sql1);
				String sql2 = "update fur set num='"+num+"'where id = "+id;
				int x = stmt.executeUpdate(sql2);
				String sql3 = "update fur set money='"+money+"'where id = "+id;
				int y =stmt.executeUpdate(sql3);
				System.out.println(i+" "+x+" "+y);
				
				//�ͷ���Դ
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		private static void  delete(){
			sc4 = new Scanner(System.in);
			try{
				//����jar��
				//ע������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ���ݿ�
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement stmt = con.createStatement();
				//����sql���
				System.out.println("������Ҿ߱��");
				int id = sc4.nextInt();
				String sql = "delete from fur where id="+id;
				int i = stmt.executeUpdate(sql);
				System.out.println(i);
				
				//�ͷ���Դ
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
			
		}
		private static void  find (){
			try{
				//����jar��
				//ע������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ���ݿ�
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				//����sql���
				String sql = "select * from fur ";
				
				PreparedStatement ps =con.prepareStatement(sql);
				//Statement st = (Statement) con.createStatement();
				
				ResultSet result = ps.executeQuery();
				while(result.next()){
					String name = result.getString("name");
					String num = result.getString("num");
					String money = result.getString("money");
					System.out.println("�Ҿ�����:"+name+" \t\t �Ҿ����� :"+num+"  \t\t�Ҿߵ���:"+money);
				}
				
				//�ͷ���Դ
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		
		private static void  seek(){
			sc2 = new Scanner(System.in);
			try{
				//����jar��
				//ע������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ���ݿ�
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement stmt = con.createStatement();
				//����sql���
				System.out.println("�������Ա���");
				int id = sc2.nextInt();
				System.out.println("���������");
				int seek = sc2.nextInt();
				String sql = "update jiaju set seek='"+seek+"'where id = "+id;
				int i =  stmt.executeUpdate(sql);
				System.out.println(i);
				
				//�ͷ���Դ
				con.close();                                  
			}                             
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		
		
		
		private static void Menu() {
			System.out.println("1:��ӼҾ���Ϣ");
			System.out.println("2:���ļҾ���Ϣ");
			System.out.println("3:ɾ���Ҿ���Ϣ");
			System.out.println("4:��ѯ�Ҿ���Ϣ");
			System.out.println("5:���Ļ���");
			System.out.println("0:�˳�");
		}
		public static void main(String[] args) throws SQLException{
			sc = new Scanner(System.in);
			Menu();
			int choose = 10;
			while(true){
				System.out.println("�����������蹦��:");
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
