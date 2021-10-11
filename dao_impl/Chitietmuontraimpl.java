package dao_impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Chitietmuontra;
import model.CHITIET_MUONTRA_TAINTD;
import model.MyConnection;

public class Chitietmuontraimpl implements Chitietmuontra{
	MyConnection myConnection = new MyConnection();

	@Override
	public CHITIET_MUONTRA_TAINTD getObject(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		CHITIET_MUONTRA_TAINTD chitietmuontra = null;
		chitietmuontra = new CHITIET_MUONTRA_TAINTD(resultSet.getInt("id"),
				resultSet.getInt("MA_MT_20180168"),
				resultSet.getInt("MASACH_20180168"),
				resultSet.getDate("NGAY_TRA_20180168"),
		        resultSet.getBoolean("TRANG_THAI_SACH_20180168"),
		        resultSet.getInt("TIEN_PHAT_20180168"),
		        resultSet.getString("GHI_CHU_20180168"));
        
		return chitietmuontra;
	}

	@Override
	public List<CHITIET_MUONTRA_TAINTD> getList(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		List<CHITIET_MUONTRA_TAINTD> list = new ArrayList<>();
        while (resultSet.next()){
        	CHITIET_MUONTRA_TAINTD chitietmuontra = getObject(resultSet);
            if (chitietmuontra != null) list.add(chitietmuontra);
        }
        return list;
	
	}

	@Override
	public List<CHITIET_MUONTRA_TAINTD> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from CHITIET_MUONTRA_TAINTD;";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        return getList(preparedStatement.executeQuery());

	}

	@Override
	public CHITIET_MUONTRA_TAINTD findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		CHITIET_MUONTRA_TAINTD chitietmuontra = null;
        String sql = "select * from CHITIET_MUONTRA_TAINTD where id = ? ";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            chitietmuontra = getObject(resultSet);
        }
        return chitietmuontra;
    }

	@Override
	public CHITIET_MUONTRA_TAINTD insert(CHITIET_MUONTRA_TAINTD chitietmuontra) throws SQLException {
		// TODO Auto-generated method stub
		CHITIET_MUONTRA_TAINTD newchitietmuontra = null;
        String sql = "insert into CHITIET_MUONTRA_TAINTD (MAMT_20180168,MASACH_20180168, NGAY_TRA_20180168,TRANG_THAI_SACH_20180168,TIEN_PHAT_20180168,GHI_CHU_20180168) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setInt(1,chitietmuontra.getMAMT_20180168());
        preparedStatement.setInt(2,chitietmuontra.getMASACH_20180168());
        preparedStatement.setDate(3,chitietmuontra.getNGAY_TRA_20180168());
        preparedStatement.setBoolean(4,chitietmuontra.isTRANG_THAI_SACH_20180168());
        preparedStatement.setInt(5,chitietmuontra.getTIEN_PHAT_20180168());
        preparedStatement.setString(6,chitietmuontra.getGHI_CHU_20180168());

        
        

        if (preparedStatement.executeUpdate() > 0){
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
            	newchitietmuontra =findById((int) resultSet.getLong(1));
            }
        }
        return newchitietmuontra;
    }

	@Override
	public boolean update(CHITIET_MUONTRA_TAINTD chitietmuontra) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "update CHITIET_MUONTRA_TAINTD set MASACH_20180168=?, NGAY_TRA_20180168=?,TRANG_THAI_SACH_20180168=?,TIEN_PHAT_20180168=?,GHI_CHU_20180168 where MAMT_20180168 = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);  
        preparedStatement.setInt(1,chitietmuontra.getMASACH_20180168());
        preparedStatement.setDate(2,chitietmuontra.getNGAY_TRA_20180168());
        preparedStatement.setBoolean(3,chitietmuontra.isTRANG_THAI_SACH_20180168());
        preparedStatement.setInt(4,chitietmuontra.getTIEN_PHAT_20180168());
        preparedStatement.setString(5,chitietmuontra.getGHI_CHU_20180168());
        preparedStatement.setInt(6,chitietmuontra.getMAMT_20180168());



        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "delete from CHITIET_MUONTRA_TAINTD where id = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);

        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }
	

}
