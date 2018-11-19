package gjp.view;
//��ͼ��

import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import gjp.controller.ZhangWuController;
import gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	/* Run ����
	 * 1 ��ɹ��ܽ������ʾ
	 * 2 ���ܼ��̵�����
	 * 3 ����ѡ��ֵ�����ö�Ӧ�ķ���
	 *  
	 * */
	public void run() {
//		����Scanner����󣬷�����������
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------------------�ܼ��ż�ͥ�������------------------------");
			System.out.println("1.������� 2.�༭����  3.ɾ������  4.��ѯ����  5.�Ƴ�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
//			�����û��Ĳ˵�ѡ��
			int choose = sc.nextInt();
//			��ѡ��Ĺ����ж�
			switch(choose) {
				case 1:
					addZhangWu();
//					�����������ķ���
					break;
				case 2:
					editZhangWU();
//					���ñ༭����ķ���
					break;
				case 3:
					delete();
//					����ɾ������ķ���
					break;
				case 4:
					selectZhangWu();
//					���ò�ѯ����
					break;
				case 5:
					System.exit(0);
					break;
			}
			
		}
		
	}
//	����ɾ�����񷽷�
	public void delete() {
		selectAll();
		System.out.println("����ɾ�������ID");
		int zwid = new Scanner(System.in).nextInt();
//		���ÿ��Ʋ㷽������������id
		controller.delete(zwid);
		System.out.println("ɾ���ɹ�");
	}
	/*�༭����
	 * �����û����룬��������Ϣ��װ��ZhangWu����
	 * ���ÿ��Ʋ㷽��������ZhangWu����ʵ�ֱ༭
	 * */
	public void editZhangWU() {
		selectAll();
		System.out.println("�༭����������Ҫ�༭�������ţ�");
		Scanner sc = new Scanner(System.in);
		System.out.print("�༭������ID��");
		int zwid = sc.nextInt();
		System.out.print("�����������");
		String flname =sc.next();
		System.out.print("���");
		double money =sc.nextDouble();
		System.out.print("�����˻�");
		String zhanghu =sc.next();
		System.out.print("���״���ʱ��,��ʽXXXX-XX-XX");
		String createtime =sc.next();
		System.out.print("����");
		String description =sc.next();
//		���ÿ��Ʋ㷽����ʵ���������
		ZhangWu zw = new ZhangWu(zwid, flname, money, createtime, description, zhanghu);
		controller.editZhangWu(zw);
		System.out.println("�༭�ɹ�");
	}
/* ��ѯ����selectZhangwu����
 * 1.��ʾ��ѯ��ʽ   ȫ����ѯ   ������ѯ
 * 2 �����û�ѡ��
 * 
 * */
	public void selectZhangWu() {
		System.out.println("1.��ѯ����  2.������ѯ");
		Scanner sc = new Scanner(System.in);
		int selectChoose = sc.nextInt();
//		�����û�ѡ���жϣ����ò�ͬ�ķ���
		switch(selectChoose) {
			case 1:
//				��ѯ����
				selectAll();
				break;
			case 2:
//				������ѯ
				select();
				break;
		}
				
	}
/*   ������ӷ���
 *    �����û�5�����룬���ÿ��Ʋ�ķ���
 * 
 * */	
	public void addZhangWu() {
		System.out.println("ѡ����������������������ݣ�");
		Scanner sc = new Scanner(System.in);
		System.out.print("�����������");
		String flname =sc.next();
		System.out.print("���");
		double money =sc.nextDouble();
		System.out.print("�����˻�");
		String zhanghu =sc.next();
		System.out.print("���״���ʱ��,��ʽXXXX-XX-XX");
		String createtime =sc.next();
		System.out.print("����");
		String description =sc.next();
//		���ÿ��Ʋ㷽����ʵ���������
		ZhangWu zw = new ZhangWu(0, flname, money, createtime, description, zhanghu);
		controller.addZhangWu(zw);
		System.out.println("��ϲ��ӳɹ�");
	}

	//	���巽����ѯ��������
	public void selectAll() {
//		���ÿ��Ʋ�㷽���鿴���е���������
		List<ZhangWu> list = controller.selectAll();
//		����list
		if (list.size()!=0)
			print(list);
		else 
			System.out.println("û�в鵽����");
	}

	//	��ӡ����������list��ӡlist��������
	private void print(List<ZhangWu> list) {
	System.out.println("ID\t���\t�˻�\t���\tʱ��\t����");
	for(ZhangWu zw:list) {
		System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t"+zw.getMoney()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
	}
}

	//	������ѯ����
	public void select() {
		System.out.println("ѡ��������ѯ���������ڸ�ʽXXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ�ĳ�ʼ���ڣ�");
		String startDate = sc.nextLine();
		System.out.println("������Ҫ��ѯ����ֹ���ڣ�");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate,endDate);
		if (list.size()!=0)
			print(list);
		else 
			System.out.println("û�в鵽����");
	}
}
