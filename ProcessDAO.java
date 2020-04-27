package dm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dm.entity.Device;
import dm.entity.Process;

public class ProcessDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ArrayList QueryProcess1() {
		ArrayList list = new ArrayList();
		String sql = "select * from process left outer join customer on process.cid = customer.cid left outer join repairman on process.rid = repairman.rid left outer join device on process.did = device.did";
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				int did = rs.getInt("did");
				String fdate = rs.getString("fdate");
				String pdate = rs.getString("pdate");
				int cid = rs.getInt("cid");
				String pstate = rs.getString("pstate");
				int pmoney = rs.getInt("pmoney");
				int pgrade = rs.getInt("pgrade");
				int rid = rs.getInt("rid");
				int coid = rs.getInt("coid");
				Process process = new Process(pid,did,fdate,pdate,cid,pstate,pmoney,pgrade,rid,coid);
				list.add(process);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return list;
	}
		
	public Process QueryByIdProcess(int pid) {
		Process process = null;
		String sql = "select * from process where pid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("pid");
				int did = rs.getInt("did");
				String fdate = rs.getString("fdate");
				String pdate = rs.getString("pdate");
				int cid = rs.getInt("cid");
				String pstate = rs.getString("pstate");
				int pmoney = rs.getInt("pmoney");
				int pgrade = rs.getInt("pgrade");
				int rid = rs.getInt("rid");
				int coid = rs.getInt("coid");
				process = new Process(id,did,fdate,pdate,cid,pstate,pmoney,pgrade,rid,coid);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,pstmt,null);
		}
		return process;
	}
	
	public void Add1Process(int cid, int did, String fdate) {
		String sql = "insert into process(did,fdate,pdate,cid,pstate,pmoney,pgrade,rid) values(?,?,?,?,?,0,0,null)";
		try {
			pstmt = getConn().prepareStatement(sql);	
			pstmt.setInt(1, did);
			pstmt.setString(2, fdate);
			pstmt.setString(3, "");
			pstmt.setInt(4, cid);
			pstmt.setString(5, "");
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null,pstmt,null);
		}
	}
	
	public ArrayList QueryProcess0(int cid) {
		ArrayList list1 = new ArrayList();
		String sql = "select pid,did,fdate from process where cid = ? and pmoney = 0";
		try {
			pstmt = getConn().prepareStatement(sql);	
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				int did = rs.getInt("did");
				String fdate = rs.getString("fdate");
				DeviceDAO ddao = new DeviceDAO();
				Device device = ddao.QueryByIdDevice(did);
				String dname = device.getDname();
				Process process = new Process(pid,fdate,cid,dname);
				list1.add(process);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(rs,pstmt,null);
		}
		return list1;
	}

	
	public ArrayList QueryProcess2() {
		ArrayList list = new ArrayList();
		String sql = "select pid,did,fdate,cid from process where pmoney = 0";
		try {
			pstmt = getConn().prepareStatement(sql);	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				int did = rs.getInt("did");
				String fdate = rs.getString("fdate");
				int cid = rs.getInt("cid");
				DeviceDAO ddao = new DeviceDAO();
				Device device = ddao.QueryByIdDevice(did);
				String dname = device.getDname();
				Process process = new Process(pid,fdate,cid,dname);
				list.add(process);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	
	public ArrayList QueryProcess3(String name) {
		ArrayList list = new ArrayList();
		String sql = "select pid,did,fdate from process where pmoney = 0";
		try {
			pstmt = getConn().prepareStatement(sql);	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				int did = rs.getInt("did");
				String fdate = rs.getString("fdate");
				RepairmanDAO rdao = new RepairmanDAO();
				int rid = rdao.QueryByNameRepairman(name);
				DeviceDAO ddao = new DeviceDAO();
				Device device = ddao.QueryByIdDevice(did);
				String dname = device.getDname();
				Process process = new Process(pid,did,fdate,rid,dname);
				list.add(process);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	
	public void Add2Process(int pid ,String pstate ,String pdate ,int pmoney ,int rid) {
		String sql = "update process set pstate=?,pdate=?,pmoney=?,rid=? where pid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	
			pstmt.setString(1, pstate);
			pstmt.setString(2, pdate);
			pstmt.setInt(3, pmoney);
			pstmt.setInt(4, rid);
			pstmt.setInt(5, pid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null,pstmt,null);
		}
	}
	
	public void UpdateProcess(int pid ,int did, String fdate) {
		String sql = "update process set did=?,fdate=? where pid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	
			pstmt.setInt(1, did);
			pstmt.setString(2, fdate);
			pstmt.setInt(3, pid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null,pstmt,null);
		}
	}
	
	public void DeleteProcess(int pid) {
		String sql = "delete from process where pid =?";
		try {
			pstmt = getConn().prepareStatement(sql);	
			pstmt.setInt(1, pid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null,pstmt,null);
		}
	}

	public ArrayList QueryProcess(int pageNum,int count) {
		ArrayList list = new ArrayList();
		String sql = "select * from process left outer join customer on process.cid = customer.cid left outer join repairman on process.rid = repairman.rid left outer join device on process.did = device.did limit ?,?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, pageNum);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				int did = rs.getInt("did");
				String fdate = rs.getString("fdate");
				String pdate = rs.getString("pdate");
				int cid = rs.getInt("cid");
				String pstate = rs.getString("pstate");
				int pmoney = rs.getInt("pmoney");
				int pgrade = rs.getInt("pgrade");
				int rid = rs.getInt("rid");
				String dname = rs.getString("dname");
				String cname = rs.getString("cname");
				String rname = rs.getString("rname");
				int coid = rs.getInt("coid");
				Process process = new Process(pid,did,fdate,pdate,cid,pstate,pmoney,pgrade,rid,dname,cname,rname,coid);
				list.add(process);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return list;
	}

	public ArrayList QueryProcess5(int cid) {
		ArrayList list = new ArrayList();
		String sql = "select pid,did,fdate,pdate,pstate,pmoney,rid,pgrade from process where cid=? and pmoney <> 0";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				int did = rs.getInt("did");
				String fdate = rs.getString("fdate");
				String pdate = rs.getString("pdate");
				String pstate = rs.getString("pstate");
				int pmoney = rs.getInt("pmoney");
				int rid = rs.getInt("rid");
				int pgrade = rs.getInt("pgrade");
				DeviceDAO ddao = new DeviceDAO();
				Device device = ddao.QueryByIdDevice(did);
				String dname = device.getDname();
				Process process = new Process(pid,did,fdate,pdate,cid,pstate,pmoney,pgrade,rid,dname);
				list.add(process);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	
	public void Add3Process(int pid ,int pgrade) {
		String sql = "update process set pgrade=? where pid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	
			pstmt.setInt(1, pgrade);
			pstmt.setInt(2, pid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null,pstmt,null);
		}
	}
	
	public void Add4Process(int pid ,String pstate ,String pdate ,int pmoney ,int rid, int coid) {
		String sql = "update process set pstate=?,pdate=?,pmoney=?,rid=?,coid=? where pid = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	
			pstmt.setString(1, pstate);
			pstmt.setString(2, pdate);
			pstmt.setInt(3, pmoney);
			pstmt.setInt(4, rid);
			pstmt.setInt(5, coid);
			pstmt.setInt(6, pid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null,pstmt,null);
		}
	}
}
