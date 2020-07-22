package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class asd {
	public static void main(String[] args) throws Exception {
		// 加载驱动
		try{
				Class.forName("com.mysql.jdbc.Driver");
				// 获取数据库连接对象 如果链接的是且端口号是默认的3306 则本机127.0.0.1:3306可不写
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/user", "root", "root");
				
			
				
				// 获取SQL语句的执行者对象
//				String sql = "INSERT INTO JIAJU(username,phone) VALUE('liumingye ','15045029000')";
				String sql = "DELETE FROM JIAJU WHERE username='liumingye';)";
				
				
//				PreparedStatement pstmt = conn
//						.prepareStatement(sql);
//				
				
				// 执行SQl语句
				System.out.println(sql);
				
				Statement st = (Statement) conn.createStatement();
				boolean res = st.execute(sql);
				System.out.println(res);
				if(res){
					System.out.println("成功");
					
				}else{
					System.out.println("失败");
				}
				/*
				ResultSet resultSet = pstmt.executeQuery();
				// 遍历结果
				while(resultSet.next()){
					String name = resultSet.getString("username");
					String phone = resultSet.getString("phone");
				
					System.out.println("用户名:"+name+"\t手机号: "+phone+ "");
				}
				*/
//				res.next;
//				System.out.println(res.getInt(1));

				// 6. 关闭流释放资源
				conn.close();
//				pstmt.close();
//				resultSet.close();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
