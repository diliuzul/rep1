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
		//�������
		Scanner userInput = new Scanner(System.in);
		Test1 test1 =new Test1();
		
		System.out.println("�������û�����");
		//nextLine(),��������û������ַ�����ʽ���ء�
		//String USERNAME = userInput.nextLine();
		test1.setUsername(userInput.nextLine());
		//System.out.println(username);
		
		System.out.println("�����������ֻ���:");
		//nextLong(),��������ֻ�����Long�ͷ��ء�
//		Long phone = userInput.nextLong();
//		System.out.println(phone);
		test1.setPhone(userInput.nextLine());
		
		
		
		System.out.println("��������������:");
		//nextLine(),��������������ַ�����ʽ���ء�
//		String password = userInput.nextLine();
//		System.out.println(password);
		test1.setPassword(userInput.nextLine());
		
		
		//ʹ��jdbc�������ݿ⣬ִ��sql���
		try{
			//����jar��
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���ݿ�
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			//����sql���
			String sql ="INSERT INTO JIAJU(username,phone,password) VALUES(?,?,?)";
			System.out.println(sql);
			//��ȡִ��sql���Ķ���
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
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
				System.out.println                   ("ʧ��");
			}else{
				System.out.println("�ɹ�");
			}
			//�ͷ���Դ
			con.close();                                  
		}                             
		catch(Exception e){
			e.printStackTrace(); 
		}
	}}
			                                                                                                                         
	


                