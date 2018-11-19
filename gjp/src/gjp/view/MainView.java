package gjp.view;
//视图层

import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import gjp.controller.ZhangWuController;
import gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	/* Run 方法
	 * 1 完成功能界面的显示
	 * 2 接受键盘的输入
	 * 3 根据选项值，调用对应的方法
	 *  
	 * */
	public void run() {
//		创建Scanner类对象，反复键盘输入
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------------------管家婆家庭记账软件------------------------");
			System.out.println("1.添加账务 2.编辑账务  3.删除账务  4.查询账务  5.推出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
//			接受用户的菜单选择
			int choose = sc.nextInt();
//			对选择的功能判断
			switch(choose) {
				case 1:
					addZhangWu();
//					调用添加账务的方法
					break;
				case 2:
					editZhangWU();
//					调用编辑账务的方法
					break;
				case 3:
					delete();
//					调用删除账务的方法
					break;
				case 4:
					selectZhangWu();
//					调用查询方法
					break;
				case 5:
					System.exit(0);
					break;
			}
			
		}
		
	}
//	定义删除账务方法
	public void delete() {
		selectAll();
		System.out.println("输入删除账务的ID");
		int zwid = new Scanner(System.in).nextInt();
//		调用控制层方法，传递主键id
		controller.delete(zwid);
		System.out.println("删除成功");
	}
	/*编辑账务
	 * 接收用户输入，将数据信息封装成ZhangWu对象
	 * 调用控制层方法，传递ZhangWu对象，实现编辑
	 * */
	public void editZhangWU() {
		selectAll();
		System.out.println("编辑账务，请输入要编辑的账务编号：");
		Scanner sc = new Scanner(System.in);
		System.out.print("编辑的账务ID：");
		int zwid = sc.nextInt();
		System.out.print("输入分类名称");
		String flname =sc.next();
		System.out.print("金额");
		double money =sc.nextDouble();
		System.out.print("交易账户");
		String zhanghu =sc.next();
		System.out.print("交易创建时间,格式XXXX-XX-XX");
		String createtime =sc.next();
		System.out.print("描述");
		String description =sc.next();
//		调用控制层方法，实现数据添加
		ZhangWu zw = new ZhangWu(zwid, flname, money, createtime, description, zhanghu);
		controller.editZhangWu(zw);
		System.out.println("编辑成功");
	}
/* 查询方法selectZhangwu（）
 * 1.显示查询方式   全部查询   条件查询
 * 2 接受用户选择
 * 
 * */
	public void selectZhangWu() {
		System.out.println("1.查询所有  2.条件查询");
		Scanner sc = new Scanner(System.in);
		int selectChoose = sc.nextInt();
//		根据用户选择判断，调用不同的方法
		switch(selectChoose) {
			case 1:
//				查询所有
				selectAll();
				break;
			case 2:
//				条件查询
				select();
				break;
		}
				
	}
/*   定义添加方法
 *    接收用户5项输入，调用控制层的方法
 * 
 * */	
	public void addZhangWu() {
		System.out.println("选择添加账务，请输入以下内容：");
		Scanner sc = new Scanner(System.in);
		System.out.print("输入分类名称");
		String flname =sc.next();
		System.out.print("金额");
		double money =sc.nextDouble();
		System.out.print("交易账户");
		String zhanghu =sc.next();
		System.out.print("交易创建时间,格式XXXX-XX-XX");
		String createtime =sc.next();
		System.out.print("描述");
		String description =sc.next();
//		调用控制层方法，实现数据添加
		ZhangWu zw = new ZhangWu(0, flname, money, createtime, description, zhanghu);
		controller.addZhangWu(zw);
		System.out.println("恭喜添加成功");
	}

	//	定义方法查询所欲账务
	public void selectAll() {
//		调用控制层层方法查看所有的账务数据
		List<ZhangWu> list = controller.selectAll();
//		遍历list
		if (list.size()!=0)
			print(list);
		else 
			System.out.println("没有查到数据");
	}

	//	打印方法，输入list打印list集合数据
	private void print(List<ZhangWu> list) {
	System.out.println("ID\t类别\t账户\t金额\t时间\t描述");
	for(ZhangWu zw:list) {
		System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t"+zw.getMoney()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
	}
}

	//	条件查询方法
	public void select() {
		System.out.println("选择条件查询，输入日期格式XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要查询的初始日期：");
		String startDate = sc.nextLine();
		System.out.println("请输入要查询的终止日期：");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate,endDate);
		if (list.size()!=0)
			print(list);
		else 
			System.out.println("没有查到数据");
	}
}
