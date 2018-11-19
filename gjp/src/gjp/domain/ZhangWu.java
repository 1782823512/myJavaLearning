package gjp.domain;

public class ZhangWu {
	private int zwid;
	private String flname;
	private double money;
	private String createtime;
	private String description;
	private String zhanghu;
	public int getZwid() {
		return zwid;
	}
	public void setZwid(int zwid) {
		this.zwid = zwid;
	}
	public ZhangWu() {
		
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getZhanghu() {
		return zhanghu;
	}
	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public ZhangWu(int zwid, String flname, double money, String createtime, String description, String zhanghu) {
		super();
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.createtime = createtime;
		this.description = description;
		this.zhanghu = zhanghu;
	}
	@Override
	public String toString() {
		return "ZhangWu [zwid=" + zwid + ", flname=" + flname + ", money=" + money + ", createtime=" + createtime + ", description="
				+ description + ", zhanghu=" + zhanghu + "]";
	}
	
	
}
