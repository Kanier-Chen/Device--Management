package dm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dm.entity.Customer;
import dm.entity.Repairman;


public class CustomerDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean login(String name,String pwd,int level) {
		String sql = "select cname name,cpwd pwd from customer where cname=? and cpwd=? and level=?";
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
	
	public void register(String name,String pwd,String tel,String address) {
		int level0=0;
		String sql = "insert into customer(cname,cpwd,ctel,caddress,level) values(?,?,?,?,?)";
		
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1,name );
			pstmt.setString(2,pwd );
			pstmt.setString(3,tel);
			pstmt.setString(4, address);
			pstmt.setInt(5, level0);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
	public ArrayList QueryCustomer() {
		ArrayList list=new ArrayList();
		String sql="select * from customer";
		try {
			pstmt = getConn().prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int cid=rs.getInt("cid");
				String cname=rs.getString("cname");
				String cpwd=rs.getString("cpwd");
				String ctel=rs.getString("ctel");
				String caddress=rs.getString("caddress");
				int level = rs.getInt("level");
				Customer customer=new Customer(cid,cname,cpwd,ctel,caddress,level);
				list.add(customer);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	
	public Customer QueryByIdCustomer(int cid) {
		Customer customer=null;
		String sql="select * from customer where cid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("cid");
				String cname = rs.getString("cname");
				String cpwd = rs.getString("cpwd");
				String ctel=rs.getString("ctel");
				String caddress = rs.getString("caddress");
				customer = new Customer(id,cname,cpwd,ctel,caddress,0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,pstmt,null);
		}
		return customer;
	}
	
	public int QueryByNameCustomer(String cname) {
		int id=0;
		String sql="select * from customer where cname=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getInt("cid");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs,pstmt,null);
		}
		return id;
	}
	
	public void updateCustomer(int cid,String cname,String cpwd,String ctel,String caddress) {
		String sql="update customer set cname=?,cpwd=?,ctel=?,caddress=?,level=0 where cid=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.setString(2, cpwd);
			pstmt.setString(3, ctel);
			pstmt.setString(4, caddress);
			pstmt.setInt(5, cid);
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
	}
	
	public void deleteCustomer(int cid) {
		String sql="delete from customer where cid=?";
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(null,pstmt,null);
		}
	}
	/**
	 * 分页查询方法
	 * @param pageNum
	 * @param count
	 * @return
	 */
	public ArrayList QueryCustomer(int pageNum,int count) {
		ArrayList list=new ArrayList();
		String sql="select * from customer limit ?,?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, pageNum);
			pstmt.setInt(2, count);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int cid=rs.getInt("cid");
				String cname=rs.getString("cname");
				String cpwd=rs.getString("cpwd");
				String ctel=rs.getString("ctel");
				String caddress=rs.getString("caddress");
				int level = rs.getInt("level");
				Customer customer=new Customer(cid,cname,cpwd,ctel,caddress,level);
				list.add(customer);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return list;
	}
	 

}
