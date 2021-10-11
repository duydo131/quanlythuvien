package controller;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao_impl.Docgiaimpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DOCGIA_TAINTD;
import model.MyConnection;

public class ThemDocGiaController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addCMND;

    @FXML
    private TextField addGioiTinh;

    @FXML
    private DatePicker addNgaySinh;

    @FXML
    private TextField addSdt;

    @FXML
    private TextField addtendg;

    @FXML
    private TextField addDiachi;

    @FXML
    private TextField addMaDG;

    @FXML
    private TextField addEmail;
    
    @FXML
    private AnchorPane rootPane;
    
    MyConnection myConnection = new MyConnection();
    Docgiaimpl docgiaDao = new Docgiaimpl();
    DOCGIA_TAINTD docgia = MainController.selectedDocGia;

    @FXML
    void addDG(ActionEvent event) throws ClassCastException, SQLException {
    	myConnection.connectDB();
    	DOCGIA_TAINTD docgia = new DOCGIA_TAINTD();
    	docgia.setId_dg(Integer.parseInt(addMaDG.getText()));
    	docgia.setGIOITINH_20180168(addGioiTinh.getText());
    	docgia.setEMAIL_20180168(addEmail.getText());
    	docgia.setNGAYSINH_20180168(Date.valueOf(addNgaySinh.getValue()));
    	docgia.setCMND_20180168(addCMND.getText());
    	docgia.setDIENTHOAI_20180168(Integer.parseInt(addSdt.getText()));
    	docgia.setDIACHI_20180168(addDiachi.getText());
    	docgia.setTEN_DG_20180168(addtendg.getText());
    	
    	DOCGIA_TAINTD newdg = docgiaDao.insert(docgia);
    	if (newdg != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("thanh cong");
            alert.showAndWait();
            return;
        }
    	
    	

    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();

    }

   

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
		
	}
}
