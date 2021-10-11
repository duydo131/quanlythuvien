package controller;


import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao_impl.SachImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.MyConnection;
import model.SACH_TAINTD;

public class ThemSachController implements Initializable   {

	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField addNamXuatBan;

	    @FXML
	    private TextField addTenSach;

	    @FXML
	    private TextField addTacGia;

	    @FXML
	    private TextField addGioiThieu;

	    @FXML
	    private TextField addDonGia;

	    @FXML
	    private TextField addMaSach;

	    @FXML
	    private TextField addNhaXuatBan;
	    
	    @FXML
	    private AnchorPane rootPane;
	    
	    MyConnection myConnection = new MyConnection();
	    SachImpl sachDao = new SachImpl();

	    @FXML
	    void addBook(ActionEvent event) throws  SQLException {
	    	myConnection.connectDB();
	    	SACH_TAINTD sach = new  SACH_TAINTD();
	    	sach.setIdsach(Integer.parseInt(addMaSach.getText()));
	    	sach.setTENSACH_20180168(addTenSach.getText());
	    	sach.setTACGIA_20180168(addTacGia.getText());
	    	sach.setNHAXB_20180168(addNhaXuatBan.getText());
	    	sach.setNAMXB_20180168(Integer.parseInt(addNamXuatBan.getText()));
	    	sach.setDONGIA_20180168(Integer.parseInt(addDonGia.getText()));
	    	sach.setGIOITHIEU_20180168(addGioiThieu.getText());
	    	
	    	SACH_TAINTD newsach = sachDao.insert(sach);
	    	if (newsach != null) {
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
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}


	
}