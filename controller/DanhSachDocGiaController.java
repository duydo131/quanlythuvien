package controller;


import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao_impl.Docgiaimpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DOCGIA_TAINTD;
import model.MyConnection;


public class DanhSachDocGiaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<DOCGIA_TAINTD, String> diaChi;

    @FXML
    private TableColumn<DOCGIA_TAINTD, String> tenDG;

    @FXML
    private TableColumn<DOCGIA_TAINTD, Number> dienThoai;

    @FXML
    private TableColumn<DOCGIA_TAINTD, Date> ngaySinh;

    @FXML
    private TableColumn<DOCGIA_TAINTD, Number> id;

    @FXML
    private TableColumn<DOCGIA_TAINTD, String> gioiTinh;

    @FXML
    private TableColumn<DOCGIA_TAINTD, String> cmnd;

    @FXML
    private TableColumn<DOCGIA_TAINTD, String> email;
    
    @FXML
    private TableView<DOCGIA_TAINTD> docGiaTable;
    @FXML
    private AnchorPane rootPane;
    
    List<DOCGIA_TAINTD> docgiaList = null;
    private  ObservableList<DOCGIA_TAINTD> docgiaObservableList;

    
    MyConnection myConnection = new MyConnection();
    Docgiaimpl docgiaDao = new Docgiaimpl();

    @FXML
    void quayLai(ActionEvent event) {
    	Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();

    }

    @FXML
     public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
            myConnection.connectDB();
            docgiaList = docgiaDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	docgiaObservableList = FXCollections.observableArrayList(docgiaList);
    	
		id.setCellValueFactory(new PropertyValueFactory<>("id_dg"));
		diaChi.setCellValueFactory(new PropertyValueFactory<>("DIACHI_20180168"));
		tenDG.setCellValueFactory(new PropertyValueFactory<>("TEN_DG_20180168"));
		dienThoai.setCellValueFactory(new PropertyValueFactory<>("DIENTHOAI_20180168"));
		ngaySinh.setCellValueFactory(new PropertyValueFactory<>("NGAYSINH_20180168"));
		gioiTinh.setCellValueFactory(new PropertyValueFactory<>("GIOITINH_20180168"));
		cmnd.setCellValueFactory(new PropertyValueFactory<>("cmnd"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		docGiaTable.getItems().setAll(docgiaObservableList);
   

    }
}

