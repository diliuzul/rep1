package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class asd {
	public static void main(String[] args) throws Exception {
		// ��������
		try{
				Class.forName("com.mysql.jdbc.Driver");
				// ��ȡ���ݿ����Ӷ��� ������ӵ����Ҷ˿ں���Ĭ�ϵ�3306 �򱾻�127.0.0.1:3306�ɲ�д
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/user", "root", "root");
				
			
				
				// ��ȡSQL����ִ���߶���
//				String sql = "INSERT INTO JIAJU(username,phone) VALUE('liumingye ','15045029000')";
				String sql = "DELETE FROM JIAJU WHERE username='liumingye';)";
				
				
//				PreparedStatement pstmt = conn
//						.prepareStatement(sql);
//				
				
				// ִ��SQl���
				System.out.println(sql);
				
				Statement st = (Statement) conn.createStatement();
				boolean res = st.execute(sql);
				System.out.println(res);
				if(res){
					System.out.println("�ɹ�");
					
				}else{
					System.out.println("ʧ��");
				}
				/*
				ResultSet resultSet = pstmt.executeQuery();
				// �������
				while(resultSet.next()){
					String name = resultSet.getString("username");
					String phone = resultSet.getString("phone");
				
					System.out.println("�û���:"+name+"\t�ֻ���: "+phone+ "");
				}
				*/
//				res.next;
//				System.out.println(res.getInt(1));

				// 6. �ر����ͷ���Դ
				conn.close();
//				pstmt.close();
//				resultSet.close();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
