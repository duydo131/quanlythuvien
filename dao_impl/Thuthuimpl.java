package dao_impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Thuthu;
import model.MyConnection;
import model.THUTHU_TAINTD;

public class Thuthuimpl implements Thuthu{
	MyConnection myConnection = new MyConnection();

	@Override
	public THUTHU_TAINTD getObject(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		THUTHU_TAINTD thuthu = null;
		thuthu = new THUTHU_TAINTD(resultSet.getInt("id"),
				resultSet.getString("TEN_TT_20180168"),
				resultSet.getString("GIOITINH_20180168"),
				resultSet.getDate("NGAYSINH_20180168"),
				resultSet.getString("CMND_20180168"),
				resultSet.getString("EMAIL_20180168"),
		        resultSet.getInt("DIENTHOAI_20180168"));
		        
		return thuthu;
	}

	@Override
	public List<THUTHU_TAINTD> getList(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		List<THUTHU_TAINTD> list = new ArrayList<>();
        while (resultSet.next()){
        	THUTHU_TAINTD thuthu = getObject(resultSet);
            if (thuthu != null) list.add(thuthu);
        }
        return list;
	
	}

	@Override
	public List<THUTHU_TAINTD> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from THUTHU_TAINTD;";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        return getList(preparedStatement.executeQuery());

	}

	@Override
	public THUTHU_TAINTD findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		THUTHU_TAINTD thuthu = null;
        String sql = "select * from THUTHU_TAINTD where id = ? ";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            thuthu = getObject(resultSet);
        }
        return thuthu;
    }

	@Override
	public THUTHU_TAINTD insert(THUTHU_TAINTD thuthu) throws SQLException {
		// TODO Auto-generated method stub
		THUTHU_TAINTD newthuthu = null;
        String sql = "insert into THUTHU_TAINTD (TEN_TT_20180168, GIOITINH_20180168,NGAYSINH_20180168,CMND_20180168,EMAIL_20180168, DIENTHOAI_20180168) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setString(1,thuthu.getTEN_TT_20180168());
        preparedStatement.setString(2,thuthu.getGIOITINH_20180168());
        preparedStatement.setDate(3,thuthu.getNGAYSINH_20180168());
        preparedStatement.setString(4,thuthu.getCMND_20180168());
        preparedStatement.setString(5,thuthu.getEMAIL_20180168());
        preparedStatement.setInt(6,thuthu.getDIENTHOAI_20180168());
        
        

        if (preparedStatement.executeUpdate() > 0){
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                newthuthu =findById((int) resultSet.getLong(1));
            }
        }
        return newthuthu;
    }

	@Override
	public boolean update(THUTHU_TAINTD thuthu) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "update THUTHU_TAINTD set GIOITINH_20180168=?,NGAYSINH_20180168=?,CMND_20180168=?,EMAIL_20180168=?, DIENTHOAI_20180168=?  where TEN_TT_20180168 = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);  
        preparedStatement.setString(1,thuthu.getGIOITINH_20180168());
        preparedStatement.setDate(2,thuthu.getNGAYSINH_20180168());
        preparedStatement.setString(3,thuthu.getCMND_20180168());
        preparedStatement.setString(4,thuthu.getEMAIL_20180168());
        preparedStatement.setInt(5,thuthu.getDIENTHOAI_20180168());
        preparedStatement.setString(6,thuthu.getTEN_TT_20180168());
        
        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "delete from THUTHU_TAINTD where id = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);

        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }
	

}
