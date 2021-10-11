package dao_impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Muontra;
import model.MUONTRA_TAINTD;
import model.MyConnection;

public class Muontraimpl implements Muontra{
	MyConnection myConnection = new MyConnection();

	@Override
	public MUONTRA_TAINTD getObject(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		MUONTRA_TAINTD muontra = null;
		muontra = new MUONTRA_TAINTD(
				resultSet.getInt("MA_MT_20180168"),
				resultSet.getInt("MA_DG_20180168"),
				resultSet.getInt("MA_TT_20180168"),
				resultSet.getDate("NGAY_MUON_20180168"),
				resultSet.getDate("NGAY_HENTRA_20180168"));
        
		return muontra;
	}

	@Override
	public List<MUONTRA_TAINTD> getList(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		List<MUONTRA_TAINTD> list = new ArrayList<>();
        while (resultSet.next()){
        	MUONTRA_TAINTD muontra = getObject(resultSet);
            if (muontra != null) list.add(muontra);
        }
        return list;
	
	}

	@Override
	public List<MUONTRA_TAINTD> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from MUONTRA_TAINTD;";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        return getList(preparedStatement.executeQuery());

	}

	@Override
	public MUONTRA_TAINTD findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		MUONTRA_TAINTD muontra = null;
        String sql = "select * from MUONTRA_TAINTD where MA_MT_20180168 = ? ";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            muontra = getObject(resultSet);
        }
        return muontra;
    }

	@Override
	public MUONTRA_TAINTD insert(MUONTRA_TAINTD muontra) throws SQLException {
		// TODO Auto-generated method stub
		MUONTRA_TAINTD newmuontra = null;
        String sql = "insert into MUONTRA_TAINTD (MAMT_20180168,MA_DG_20180168, MA_TT_20180168,NGAY_MUON_20180168,NGAY_HENTRA_20180168) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setInt(1,muontra.getMAMT_20180168());
        preparedStatement.setInt(2,muontra.getMA_DG_20180168());
        preparedStatement.setInt(3,muontra.getMA_TT_20180168());
        preparedStatement.setDate(4,muontra.getNGAY_MUON_20180168());
        preparedStatement.setDate(5,muontra.getNGAY_HENTRA_20180168());

        
        

        if (preparedStatement.executeUpdate() > 0){
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                newmuontra =findById((int) resultSet.getLong(1));
            }
        }
        return newmuontra;
    }

	@Override
	public boolean update(MUONTRA_TAINTD muontra) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "update MUONTRA_TAINTD set MA_DG_20180168=?, MA_TT_20180168=?,NGAY_MUON_20180168=?,NGAY_HENTRA_20180168=? where MAMT_20180168 = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);  
        preparedStatement.setInt(1,muontra.getMA_DG_20180168());
        preparedStatement.setInt(2,muontra.getMA_TT_20180168());
        preparedStatement.setDate(3,muontra.getNGAY_MUON_20180168());
        preparedStatement.setDate(4,muontra.getNGAY_HENTRA_20180168());
        preparedStatement.setInt(5,muontra.getMAMT_20180168());



        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        String sql = "delete from MUONTRA_TAINTD where id = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);

        if (preparedStatement.executeUpdate() > 0){
            result = true;
        }
        return result;
    }
	

}
