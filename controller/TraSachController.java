package controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import dao_impl.Chitietmuontraimpl;
import dao_impl.Muontraimpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CHITIET_MUONTRA_TAINTD;
import model.MUONTRA_TAINTD;
import model.MyConnection;

public class TraSachController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker ngaytra;

    @FXML
    private TextField masach1;

    @FXML
    private TextField ghichu;

    @FXML
    private TextField trangthaisach;

    @FXML
    private TextField madg1;

    @FXML
    private TextField mamt1;
    
    @FXML
    private AnchorPane rootPane;
    
    MyConnection myConnection = new MyConnection();
    Muontraimpl muontraDao = new Muontraimpl();
    Chitietmuontraimpl ccmtDao = new Chitietmuontraimpl();
    
    

    @FXML
    void update(ActionEvent event) throws Exception {
    	myConnection.connectDB();
    	MUONTRA_TAINTD muontra = new MUONTRA_TAINTD();
    	CHITIET_MUONTRA_TAINTD ctmt = new CHITIET_MUONTRA_TAINTD();
    	ctmt.setMAMT_20180168(Integer.parseInt(mamt1.getText()));
    	ctmt.setMASACH_20180168(Integer.parseInt(masach1.getText()));
    	ctmt.setNGAY_TRA_20180168(Date.valueOf(ngaytra.getValue()));
    	ctmt.setTRANG_THAI_SACH_20180168(true);
    	ctmt.setGHI_CHU_20180168(ghichu.getText());
    	
    	CHITIET_MUONTRA_TAINTD newctmt = ccmtDao.insert(ctmt);
    	if (newctmt != null) {
    		muontra.setMA_DG_20180168(Integer.parseInt(madg1.getText()));
    		MUONTRA_TAINTD newmuontra = muontraDao.insert(muontra);
    		if (newmuontra != null) {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("thanh cong");
                alert.showAndWait();
                return;
    		}
    	}
    	

    }

    @FXML
    void quaylai(ActionEvent event) {
    	Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();

    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
