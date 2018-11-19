package gjp.dao;
//ʵ�ֶ�ʦ���ݵ���ɾ�ò�
//jdbcUtils��������ɣ����Ա����QueryRunner����ָ������Դ

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import gjp.tools.JDBCUtils;
import gjp.domain.ZhangWu;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
//	ɾ������
	public void delete(int zwid) {
		try {
			String sql = "delete from gjp_zhangwu where zwid=?";
			int i = qr.update(sql, zwid);
		}catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("ɾ��ʧ��");
		}
	}
//	�༭�������ݿ�
	public void editZhangWu(ZhangWu zw) {
		try {
			String sql ="update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid =?";
	//		�����������飬�洢ռλ����ʵ�ʲ��������ݹ������������
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			int i = qr.update(sql, params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("�༭ʧ��");
		}
	}
//	ʵ��������񷽷�----���ݿ�
	public void addZhangWU(ZhangWu zw) {
		
		try {
			String sql ="select * from gjp_zhangwu (flname,money,zhanghu,createtime,description) values(?????)";
	//		�����������飬�洢ռλ����ʵ�ʲ��������ݹ������������
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			int i = qr.update(sql, params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("���ʧ��");
		}
	}
	/*���巽������ѯ���ݿ⣬��ȡ���е�������Ϣ
	 * ������service�����
	 * ������������е��������ݣ��洢��Bean�����У��洢��������
	 * */
	public List<ZhangWu> select(String startDate,String endDate){
		try {
			String sql = "select * from gjp_zhangwu where createtime between ? and ?";
			Object[] params = {startDate,endDate};
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
			return list;
			}catch (SQLException ex) {
				System.out.println(ex);
				throw new RuntimeException("������ѯ����ʧ��");
			}
		
	}
	public List<ZhangWu> selectAll() {
//		��ѯ�������ݵ�sql���
//		�����쳣��������ף�ʹ��try catach
		try {
		String sql = "select * from gjp_zhangwu";
		List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
		return list;
		}catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("��ѯ��������ʧ��");
		}
	}
}
