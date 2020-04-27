package dm.entity;

public class Component {
	private int coid;
	private String coname;
	private int costock;
	
	public Component() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Component(int coid, String coname, int costock) {
		super();
		this.coid = coid;
		this.coname = coname;
		this.costock = costock;
	}

	public int getCoid() {
		return coid;
	}

	public void setCoid(int coid) {
		this.coid = coid;
	}

	public String getConame() {
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public int getCostock() {
		return costock;
	}

	public void setCostock(int costock) {
		this.costock = costock;
	}
	
}
