package gjp.controller;

import java.util.List;

import gjp.domain.ZhangWu;
import gjp.sevice.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
//	ɾ������
	public void delete(int zwid) {
		service.delete(zwid);
	}
//	�༭�������ݿ�
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
//	��ӽ�������ݿ�
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}
	
	
	
/*���Ʋ㶨�巽����ʵ�ֲ�ѯ��������
 * ������view����ã���������sevice��
 * */	
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}
	public List<ZhangWu> select(String startDate,String endDate) {
		return service.select(startDate,endDate);
	}
}
