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
//		System.out.println("�������û�����");
//		//printIn���� print������
//		String username = userInput.nextLine();//nextLine �������     �ַ�����ʽ����
//		System.out.println(username);//��ӡ����
//		System.out.println("�������ֻ��ţ�");
//        //Long phone = userInput.nextLong();//������ʽ����     int����С
//		//System.out.println(phone);
//		String phone =userInput.nextLine();
//		System.out.println("���������룺");
//		String password = userInput.nextLine();
//		System.out.println(username+"---"+phone+"---"+password);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���ݿ����Ӷ��� ������ӵ����Ҷ˿ں���Ĭ�ϵ�3306 �򱾻�127.0.0.1:3306�ɲ�д
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		
			String sql = "DELETE FROM JIAJU WHERE name='liu'";
			Statement st =(Statement) con.createStatement();
			int res = 0;
			//boolean res =  st.execute();
			if(res!=0 ){
				System.out.println("�ɹ�");
			}else{
				System.out.println("ʧ��");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		
		
	}

}
