package gjp.sevice;
/*
 * 业务层类
 * 接受上一层Co'n'troller的数据
 * 经过计算传递给Dao层，操作数据库
 * 调用Dao层中的类，成员变量，创建Dao类的对象
 * */

import java.util.List;
import gjp.dao.ZhangWuDao;
import gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
//	删除账务
	public void delete(int zwid) {
		dao.delete(zwid);
	}
//	编辑账务到数据库
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
//	添加结果到数据库
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWU(zw);
	}
	
	
/*定义方法，实现查询所有账务
 * 方法由控制层调用，方法调用dao层
 * 返回存储ZhangWu对象的LIST集合
 * */
	public List<ZhangWu> selectAll() {
	
		return dao.selectAll();
	}
	public List<ZhangWu> select(String startDate,String endDate) {
		
		return dao.select(startDate,endDate);
	}
	
}
