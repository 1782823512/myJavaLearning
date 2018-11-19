package gjp.tools;
//获取数据库连接的工具类
//实现连接池，dbcp连接池

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
//	创建BasicDataSource对象
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
		dataSource.setUsername("root");
		dataSource.setPassword("lbylby");
		dataSource.setMaxActive(10); // 最大激活数
		dataSource.setMaxIdle(5);   // 最大空闲数
		dataSource.setMinIdle(2);
		dataSource.setInitialSize(10); //初始化
	}
	public static DataSource getDataSource () {
		return dataSource;
	}
}
