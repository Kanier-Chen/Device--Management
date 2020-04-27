package dm.entity;

public class Device {
	private int did;
	private String dname;
	private int dstock;
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Device(int did, String dname, int dstock) {
		super();
		this.did = did;
		this.dname = dname;
		this.dstock = dstock;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDstock() {
		return dstock;
	}
	public void setDstock(int dstock) {
		this.dstock = dstock;
	}
	
}
