package dm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dm.entity.Process;
import dm.entity.Register;

public class LoginDAO extends FactoryDataBase{
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boolean login(String name,String pwd,int level) {
		String sql = "select name,pwd from register where name = ? and pwd = ? and level = ?";
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
	
	public Register QueryByIdLogin(int id) {
		Register register = null;
		String sql = "select * from register where id=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				int level = rs.getInt("level");
				register = new Register(id1,name,pwd,level);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return register;
	}
	
	public int QueryByNameLogin(String name) {
		int id1=0;
		String sql = "select * from register where name=?";
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id1 = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs,pstmt,null);
		}
		return id1;
	}
}
