package dm.entity;

public class Repairman {
	private int rid;
	private String rname;
	private String rpwd;
	private String rtel;
	public Repairman() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Repairman(int rid, String rname, String rpwd, String rtel) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rpwd = rpwd;
		this.rtel = rtel;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRpwd() {
		return rpwd;
	}
	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}
	public String getRtel() {
		return rtel;
	}
	public void setRtel(String rtel) {
		this.rtel = rtel;
	}
	
}
