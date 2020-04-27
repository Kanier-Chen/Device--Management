package dm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dm.entity.Device;

public class DeviceDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ArrayList QueryDevice1() {
		ArrayList list = new ArrayList();
		String sql = "select * from device";
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int did = rs.getInt("did");
				String dname = rs.getString("dname");
				int dstock = rs.getInt("dstock");
				Device device = new Device(did,dname,dstock);
				list.add(device);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	
	public void AddDevice(String dname,int dstock) {
		String sql="insert into device(dname,dstock) values(?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setInt(2, dstock);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(null,pstmt,null);
		}
	}
	
	public Device QueryByIdDevice(int did) {
		Device device = null;
		String sql="select * from device where did=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, did);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("did");
				String dname = rs.getString("dname");
				int dstock = rs.getInt("dstock");
				device = new Device(id,dname,dstock);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,pstmt,null);
		}
		return device;
	}
	
	public int QueryByNameDevice(String dname) {
		int id=0;
		String sql="select * from device where dname=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("did");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,pstmt,null);
		}
		return id;
	}
	
	public void AddstockDevice(int did, int dstock) {
		String sql = "update device set dstock=dstock+? where did=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, dstock);
			pstmt.setInt(2, did);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			close(null,pstmt,null);
		}
	}
	
	public void DescstockDevice(int did, int dstock) {
		String sql="update device set dstock=dstock-? where did=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, dstock);
			pstmt.setInt(2, did);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			close(null,pstmt,null);
		}
	}
	public ArrayList QueryDevice(int pageNum,int count) {
		ArrayList list = new ArrayList();
		String sql = "select * from device limit ?,?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, pageNum);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int did = rs.getInt("did");
				String dname = rs.getString("dname");
				int dstock = rs.getInt("dstock");
				Device device = new Device(did,dname,dstock);
				list.add(device);
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
