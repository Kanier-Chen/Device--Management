package dm.entity;

public class Register {
	private int id;
	private String name;
	private String pwd;
	private int level;
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(int id, String name, String pwd, int level) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
