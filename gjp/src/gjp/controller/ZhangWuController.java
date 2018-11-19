package gjp.controller;

import java.util.List;

import gjp.domain.ZhangWu;
import gjp.sevice.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
//	删除账务
	public void delete(int zwid) {
		service.delete(zwid);
	}
//	编辑账务到数据库
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
//	添加结果到数据库
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}
	
	
	
/*控制层定义方法，实现查询所有账务
 * 方法由view层调用，方法调用sevice层
 * */	
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}
	public List<ZhangWu> select(String startDate,String endDate) {
		return service.select(startDate,endDate);
	}
}
