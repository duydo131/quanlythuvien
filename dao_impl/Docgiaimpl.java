package dao_impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Docgia;
import model.DOCGIA_TAINTD;
import model.MyConnection;



public class Docgiaimpl implements Docgia{
	MyConnection myConnection = new MyConnection();
	@Override
	public DOCGIA_TAINTD getObject(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		DOCGIA_TAINTD docgia = null;
		docgia = new DOCGIA_TAINTD(resultSet.getInt("id"),
				resultSet.getString("TEN_DG_20180168"),
				resultSet.getString("GIOITINH_20180168"),
				resultSet.getString ("DIACHI_20180168"),
				resultSet.getDate("NGAYSINH_20180168"),
				resultSet.getString("CMND_20180168"),
				resultSet.getString("EMAIL_20180168"),
		        resultSet.getInt("DIENTHOAI_20180168"));
		        
		return docgia;
	}

	@Override
	public List<DOCGIA_TAINTD> getList(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		List<DOCGIA_TAINTD> list = new ArrayList<>();
        while (resultSet.next()){
        	DOCGIA_TAINTD docgia = getObject(resultSet);
            if (docgia != null) list.add(docgia);
        }
        return list;
	
	}

	@Override
	public List<DOCGIA_TAINTD> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from DOCGIA_TAINTD;";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        return getList(preparedStatement.executeQuery());

	}

	@Override
	public DOCGIA_TAINTD findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		DOCGIA_TAINTD docgia = null;
        String sql = "select * from DOCGIA_TAINTD where id = ? ";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            docgia = getObject(resultSet);
        }
        return docgia;
    }

	@Override
	public DOCGIA_TAINTD insert(DOCGIA_TAINTD docgia) throws SQLException {
		// TODO Auto-generated method stub
		 DOCGIA_TAINTD newdocgia = null;
	        String sql = "insert into DOCGIA_TAINTD (TEN_DG_20180168, GIOITINH_20180168, DIACHI_20180168,NGAYSINH_20180168,CMND_20180168,EMAIL_20180168, DIENTHOAI_20180168) values (?,?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
	        preparedStatement.setString(1,docgia.getTEN_DG_20180168());
	        preparedStatement.setString(2,docgia.getGIOITINH_20180168());
	        preparedStatement.setString(3,docgia.getDIACHI_20180168());
	        preparedStatement.setDate(4,docgia.getNGAYSINH_20180168());
	        preparedStatement.setString(5,docgia.getCMND_20180168());
	        preparedStatement.setString(6,docgia.getEMAIL_20180168());
	        preparedStatement.setInt(7,docgia.getDIENTHOAI_20180168());
	        
	        

	        if (preparedStatement.executeUpdate() > 0){
	            ResultSet resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()){
	                newdocgia =findById((int) resultSet.getLong(1));
	            }
	        }
	        return newdocgia;
	    }

	@Override
	public boolean update(DOCGIA_TAINTD docgia) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "update DOCGIA_TAINTD set GIOITINH_20180168=?, DIACHI_20180168=?,NGAYSINH_20180168=?,CMND_20180168=?,EMAIL_20180168=?, DIENTHOAI_20180168=?  where TEN_DG_20180168 = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);  
        preparedStatement.setString(1,docgia.getGIOITINH_20180168());
        preparedStatement.setString(2,docgia.getDIACHI_20180168());
        preparedStatement.setDate(3,docgia.getNGAYSINH_20180168());
        preparedStatement.setString(4,docgia.getCMND_20180168());
        preparedStatement.setString(5,docgia.getEMAIL_20180168());
        preparedStatement.setInt(6,docgia.getDIENTHOAI_20180168());
        preparedStatement.setString(7,docgia.getTEN_DG_20180168());

        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }


	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "delete from DOCGIA_TAINTD where id = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);

        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }
	

}
