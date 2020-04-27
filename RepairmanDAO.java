package dm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dm.entity.Customer;
import dm.entity.Repairman;


public class RepairmanDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean login(String name,String pwd,int level) {
		String sql = "select rname name,rpwd pwd from repairman where rname=? and rpwd=? and level=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1,name );
			pstmt.setString(2,pwd );
			pstmt.setInt(3,level );
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, pstmt, null);
		}
		return false;
	}
	
	public ArrayList QueryRepairman1() {
	ArrayList list = new ArrayList();
		String sql = "select * from repairman";
		try {
		pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rid = rs.getInt("rid");
				String rname = rs.getString("rname");
				String rpwd = rs.getString("rpwd");			
				String rtel = rs.getString("rtel");
				Repairman repairman = new Repairman(rid,rname,rpwd,rtel);
				list.add(repairman);
			}
		} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		close(rs,pstmt,null);
	}
	return list;
	}
	
	public void AddRepairman(String rname,String rpwd,String rtel) {
		String sql="insert into repairman(rname,rpwd,rtel,level) values(?,?,?,1)";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, rname);
			pstmt.setString(2, rpwd);
			pstmt.setString(3, rtel);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(null,pstmt,null);
		}
	}
	
	public Repairman QueryByIdRepairman(int rid) {
		Repairman repairman = null;
		String sql="select * from repairman where rid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, rid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("rid");
				String rname = rs.getString("rname");
				String rpwd = rs.getString("rpwd");
				String rtel = rs.getString("rtel");
				repairman = new Repairman(id,rname,rpwd,rtel);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return repairman;
	}
	
	public void UpdateRepairman(int rid,String rname, String rpwd, String rtel) {
		String sql = "update repairman set rname=?,rpwd=?,rtel=? where rid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, rname);
			pstmt.setString(2, rpwd);
			pstmt.setString(3, rtel);
			pstmt.setInt(4, rid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			close(null,pstmt,null);
		}
	}
	
	public void DeleteRepairman(int rid) {
		String sql="delete from repairman where rid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, rid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			close(null,pstmt,null);
		}
	}
	
	public int QueryByNameRepairman(String name) {
		int id=0;
		String sql="select * from repairman where rname=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("rid");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return id;
	}

	/**
	 * 分页查询方法
	 * @param pageNum
	 * @param count
	 * @return
	 *
	 */
	public ArrayList QueryRepairman(int pageNum,int count) {
		ArrayList list = new ArrayList();
		String sql = "select * from repairman limit ?,?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, pageNum);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rid = rs.getInt("rid");
				String rname = rs.getString("rname");
				String rpwd = rs.getString("rpwd");
				String rtel = rs.getString("rtel");
				Repairman repairman = new Repairman(rid,rname,rpwd,rtel);
				list.add(repairman);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	

}
