package gjp.sevice;
/*
 * ҵ�����
 * ������һ��Co'n'troller������
 * �������㴫�ݸ�Dao�㣬�������ݿ�
 * ����Dao���е��࣬��Ա����������Dao��Ķ���
 * */

import java.util.List;
import gjp.dao.ZhangWuDao;
import gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
//	ɾ������
	public void delete(int zwid) {
		dao.delete(zwid);
	}
//	�༭�������ݿ�
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
//	��ӽ�������ݿ�
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWU(zw);
	}
	
	
/*���巽����ʵ�ֲ�ѯ��������
 * �����ɿ��Ʋ���ã���������dao��
 * ���ش洢ZhangWu�����LIST����
 * */
	public List<ZhangWu> selectAll() {
	
		return dao.selectAll();
	}
	public List<ZhangWu> select(String startDate,String endDate) {
		
		return dao.select(startDate,endDate);
	}
	
}
