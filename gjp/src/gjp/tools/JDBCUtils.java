package gjp.tools;
//��ȡ���ݿ����ӵĹ�����
//ʵ�����ӳأ�dbcp���ӳ�

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
//	����BasicDataSource����
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
		dataSource.setUsername("root");
		dataSource.setPassword("lbylby");
		dataSource.setMaxActive(10); // ��󼤻���
		dataSource.setMaxIdle(5);   // ��������
		dataSource.setMinIdle(2);
		dataSource.setInitialSize(10); //��ʼ��
	}
	public static DataSource getDataSource () {
		return dataSource;
	}
}
