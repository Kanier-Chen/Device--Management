package dm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dm.entity.Component;

public class ComponentDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ArrayList QueryComponent1() {
		ArrayList list = new ArrayList();
		String sql = "select * from component";
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int coid = rs.getInt("coid");
				String coname = rs.getString("coname");
				int costock = rs.getInt("costock");
				Component component = new Component(coid,coname,costock);
				list.add(component);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	
	public void AddComponent(String coname,int costock) {
		String sql="insert into component(coname,costock) values(?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, coname);
			pstmt.setInt(2, costock);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(null,pstmt,null);
		}
	}
	
	public Component QueryByIdComponent(int coid) {
		Component component = null;
		String sql="select * from component where coid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, coid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("coid");
				String coname = rs.getString("coname");
				int costock = rs.getInt("costock");
				component = new Component(id,coname,costock);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,pstmt,null);
		}
		return component;
	}
	
	public int QueryByNameComponent(String coname) {
		int coid = 0;
		String sql="select * from component where coname=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, coname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				coid = rs.getInt("coid");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,pstmt,null);
		}
		return coid;
	}
	
	public void AddstockComponent(int coid, int stock) {
		String sql = "update component set costock=costock+? where coid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, stock);
			pstmt.setInt(2, coid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			close(null,pstmt,null);
		}
	}
	
	public void DescstockComponent(int coid, int stock) {
		String sql="update component set costock=costock-? where coid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, stock);
			pstmt.setInt(2, coid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			close(null,pstmt,null);
		}
	}
	public ArrayList QueryComponent(int pageNum,int count) {
		ArrayList list = new ArrayList();
		String sql = "select * from component limit ?,?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, pageNum);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int coid = rs.getInt("coid");
				String coname = rs.getString("coname");
				int costock = rs.getInt("costock");
				Component component = new Component(coid,coname,costock);
				list.add(component);
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
