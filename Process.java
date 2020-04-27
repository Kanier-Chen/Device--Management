package dm.entity;

public class Process {
	private int pid;
	private int did;
	private String fdate;
	private String pdate;
	private int cid;
	private String pstate;
	private int pmoney;
	private int pgrade;
	private int rid;
	private String dname;
	private String cname;
	private String rname;
	private int coid;
	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Process(int pid, String fdate, int cid, String dname) {
		super();
		this.pid = pid;
		this.fdate = fdate;
		this.cid = cid;
		this.dname = dname;
	}
	


	public Process(int pid, int did, String fdate, int rid, String dname) {
		super();
		this.pid = pid;
		this.did = did;
		this.fdate = fdate;
		this.rid = rid;
		this.dname = dname;
	}
	


	public Process(int pid, int did, String fdate, String pdate, int cid, String pstate, int pmoney, int pgrade,
			int rid, String dname) {
		super();
		this.pid = pid;
		this.did = did;
		this.fdate = fdate;
		this.pdate = pdate;
		this.cid = cid;
		this.pstate = pstate;
		this.pmoney = pmoney;
		this.pgrade = pgrade;
		this.rid = rid;
		this.dname = dname;
	}


	public Process(int pid, int did, String fdate, String pdate, int cid, String pstate, int pmoney, int pgrade,
			int rid, int coid) {
		super();
		this.pid = pid;
		this.did = did;
		this.fdate = fdate;
		this.pdate = pdate;
		this.cid = cid;
		this.pstate = pstate;
		this.pmoney = pmoney;
		this.pgrade = pgrade;
		this.rid = rid;
		this.coid = coid;
	}


	public Process(int pid, int did, String fdate, String pdate, int cid, String pstate, int pmoney, int pgrade,
			int rid, String dname, String cname, String rname, int coid) {
		super();
		this.pid = pid;
		this.did = did;
		this.fdate = fdate;
		this.pdate = pdate;
		this.cid = cid;
		this.pstate = pstate;
		this.pmoney = pmoney;
		this.pgrade = pgrade;
		this.rid = rid;
		this.dname = dname;
		this.cname = cname;
		this.rname = rname;
		this.coid = coid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getFdate() {
		return fdate;
	}


	public void setFdate(String fdate) {
		this.fdate = fdate;
	}


	public String getPdate() {
		return pdate;
	}


	public void setPdate(String pdate) {
		this.pdate = pdate;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getPstate() {
		return pstate;
	}


	public void setPstate(String pstate) {
		this.pstate = pstate;
	}


	public int getPmoney() {
		return pmoney;
	}


	public void setPmoney(int pmoney) {
		this.pmoney = pmoney;
	}


	public int getPgrade() {
		return pgrade;
	}


	public void setPgrade(int pgrade) {
		this.pgrade = pgrade;
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public int getCoid() {
		return coid;
	}


	public void setCoid(int coid) {
		this.coid = coid;
	}

	
}
