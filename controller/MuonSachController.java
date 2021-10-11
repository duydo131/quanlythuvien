package controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import dao_impl.Docgiaimpl;
import dao_impl.Muontraimpl;
import dao_impl.SachImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DOCGIA_TAINTD;
import model.MUONTRA_TAINTD;
import model.MyConnection;
import model.SACH_TAINTD;

public class MuonSachController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tensach;

    @FXML
    private TextField tendg;

    @FXML
    private TextField madg;

    @FXML
    private DatePicker ngayhentra;

    @FXML
    private TextField mamt;

    @FXML
    private DatePicker ngaymuon;
    
    @FXML
    private AnchorPane rootPane;
    
    MyConnection myConnection = new MyConnection();
    Muontraimpl muontraDao = new Muontraimpl();
    SachImpl sachDao1 = new SachImpl();
    Docgiaimpl docgiaDao1 = new Docgiaimpl();

    @FXML
    void addMuonSach(ActionEvent event) throws Exception{
    	myConnection.connectDB();
    	MUONTRA_TAINTD muontra = new MUONTRA_TAINTD();
    	SACH_TAINTD sach1 = new SACH_TAINTD();
    	DOCGIA_TAINTD docgia1 = new DOCGIA_TAINTD();
    	
    	muontra.setMAMT_20180168(Integer.parseInt(mamt.getText()));
    	muontra.setMA_DG_20180168(Integer.parseInt(madg.getText()));
    	muontra.setNGAY_MUON_20180168(Date.valueOf(ngaymuon.getValue()));
    	muontra.setNGAY_HENTRA_20180168(Date.valueOf(ngayhentra.getValue()));
    	
    	MUONTRA_TAINTD newmuontra = muontraDao.insert(muontra);
    	
    	if (newmuontra != null) {
    		sach1.setTENSACH_20180168(tensach.getText());
    		SACH_TAINTD newsach1 = sachDao1.insert(sach1);
    		if (newsach1 != null) {
    			docgia1.setTEN_DG_20180168(tendg.getText());
    			DOCGIA_TAINTD newdocgia1 = docgiaDao1.insert(docgia1);
    			if (newdocgia1 != null) {
    				Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("thanh cong");
                    alert.showAndWait();
                    return;
    			}
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
