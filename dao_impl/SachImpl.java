package dao_impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Sach;
import model.SACH_TAINTD;
import model.MyConnection;

public class SachImpl implements Sach{
	MyConnection myConnection = new MyConnection();
	
	@Override
	public SACH_TAINTD getObject(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		SACH_TAINTD sach = null;
		sach = new SACH_TAINTD(resultSet.getInt("id"),
				resultSet.getString("TENSACH_20180168"),
				resultSet.getString ("TACGIA_20180168"),
				resultSet.getString("NHAXB_20180168"),
				resultSet.getInt("NAMXB_20180168"),
				resultSet.getInt("DONGIA_20180168"),
				resultSet.getString("GIOITHIEU_20180168"));
		        
		return sach;
	}

	@Override
	public List<SACH_TAINTD> getList(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		List<SACH_TAINTD> list = new ArrayList<>();
        while (resultSet.next()){
            SACH_TAINTD sach = getObject(resultSet);
            if (sach != null) list.add(sach);
        }
        return list;
	
	}

	@Override
	public List<SACH_TAINTD> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from SACH_TAINTD;";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        return getList(preparedStatement.executeQuery());

	}

	@Override
	public SACH_TAINTD findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		SACH_TAINTD sach = null;
        String sql = "select * from SACH_TAINTD where id = ? ";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            sach = getObject(resultSet);
        }
        return sach;
    }

	@Override
	public SACH_TAINTD insert(SACH_TAINTD sach) throws SQLException {
		// TODO Auto-generated method stub
		 SACH_TAINTD newsach = null;
	        String sql = "insert into SACH_TAINTD (id, TENSACH_20180168, TACGIA_20180168, NHAXB_20180168,NAMXB_20180168,DONGIA_20180168,GIOITHIEU_20180168) values (?,?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
	        preparedStatement.setInt(1,sach.getIdsach());
	        preparedStatement.setString(2,sach.getTENSACH_20180168());
	        preparedStatement.setString(3,sach.getTACGIA_20180168());
	        preparedStatement.setString(4,sach.getNHAXB_20180168());
	        preparedStatement.setInt(5,sach.getNAMXB_20180168());
	        preparedStatement.setInt(6,sach.getDONGIA_20180168());
	        preparedStatement.setString(7,sach.getGIOITHIEU_20180168());
	        
	        

	        if (preparedStatement.executeUpdate() > 0){
	            ResultSet resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()){
	                newsach =findById((int) resultSet.getLong(1));
	            }
	        }
	        return newsach;
	    }

	@Override
	public boolean update(SACH_TAINTD sach) throws SQLException {
		// TODO Auto-generated method stub
		 boolean result = false;
	        String sql = "update SACH_TAINTD set TENSACH_20180168 = ?, TACGIA_20180168=?, NHAXB_20180168=?,NAMXB_20180168=?,DONGIA_20180168=?,GIOITHIEU_20180168=?  where id = ?";
	        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
	        preparedStatement.setString(1,sach.getTENSACH_20180168());
	        preparedStatement.setString(2,sach.getTACGIA_20180168());
	        preparedStatement.setString(3,sach.getNHAXB_20180168());
	        preparedStatement.setInt(4,sach.getNAMXB_20180168());
	        preparedStatement.setInt(5,sach.getDONGIA_20180168());
	        preparedStatement.setString(6,sach.getGIOITHIEU_20180168());
	        preparedStatement.setInt(7,sach.getIdsach());

	        if (preparedStatement.executeUpdate() > 0){
	            result = true;
	        }
	        return result;
	    }

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		 boolean result = false;
	        String sql = "delete from SACH_TAINTD where id = ?";
	        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);

	        if (preparedStatement.executeUpdate() > 0){
	            result = true;
	        }
	        return result;
	    }
		
	

}
