package gjp.dao;
//实现对师数据的增删该查
//jdbcUtils工具类完成，类成员创建QueryRunner对象，指定数据源

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import gjp.tools.JDBCUtils;
import gjp.domain.ZhangWu;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
//	删除账务
	public void delete(int zwid) {
		try {
			String sql = "delete from gjp_zhangwu where zwid=?";
			int i = qr.update(sql, zwid);
		}catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("删除失败");
		}
	}
//	编辑账务到数据库
	public void editZhangWu(ZhangWu zw) {
		try {
			String sql ="update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid =?";
	//		创建对象数组，存储占位符的实际参数（传递过来的账务对象）
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			int i = qr.update(sql, params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("编辑失败");
		}
	}
//	实现添加账务方法----数据库
	public void addZhangWU(ZhangWu zw) {
		
		try {
			String sql ="select * from gjp_zhangwu (flname,money,zhanghu,createtime,description) values(?????)";
	//		创建对象数组，存储占位符的实际参数（传递过来的账务对象）
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			int i = qr.update(sql, params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("添加失败");
		}
	}
	/*定义方法，查询数据库，获取所有的账务信息
	 * 方法由service层调用
	 * 结果集，将所有的账务数据，存储到Bean对象中，存储到集合中
	 * */
	public List<ZhangWu> select(String startDate,String endDate){
		try {
			String sql = "select * from gjp_zhangwu where createtime between ? and ?";
			Object[] params = {startDate,endDate};
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
			return list;
			}catch (SQLException ex) {
				System.out.println(ex);
				throw new RuntimeException("条件查询账务失败");
			}
		
	}
	public List<ZhangWu> selectAll() {
//		查询账务数据的sql语句
//		存在异常不能随便抛，使用try catach
		try {
		String sql = "select * from gjp_zhangwu";
		List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
		return list;
		}catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("查询所有账务失败");
		}
	}
}
