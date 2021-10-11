package controller;


import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao_impl.SachImpl;
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
import model.MyConnection;
import model.SACH_TAINTD;

public class ThuVienSachController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<SACH_TAINTD, String> tenSach;

    @FXML
    private TableColumn<SACH_TAINTD, Number> id;

    @FXML
    private TableColumn<SACH_TAINTD, String> gioiThieu;

    @FXML
    private TableColumn<SACH_TAINTD, String> tacGia;

    @FXML
    private TableColumn<SACH_TAINTD, String> nhaXB;

    @FXML
    private TableColumn<SACH_TAINTD, Number> namXB;

    @FXML
    private TableColumn<SACH_TAINTD, Number> donGia;
    
    @FXML
    private TableView<SACH_TAINTD> sachTable;
    
    @FXML
    private AnchorPane rootPane;
    
    List<SACH_TAINTD> sachList = null;
    private  ObservableList<SACH_TAINTD> sachObservableList;
    
    MyConnection myConnection = new MyConnection();
    SachImpl sachDao = new SachImpl();

    @FXML
    void quayLai(ActionEvent event) {
    	Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();

    	
    }

    @FXML
     public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
            myConnection.connectDB();
            sachList = sachDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	sachObservableList = FXCollections.observableArrayList(sachList);
    	id.setCellValueFactory(new PropertyValueFactory<>("idsach"));
    	tenSach.setCellValueFactory(new PropertyValueFactory<>("TENSACH_20180168"));
    	gioiThieu.setCellValueFactory(new PropertyValueFactory<>("GIOITHIEU_20180168"));
    	tacGia.setCellValueFactory(new PropertyValueFactory<>("TACGIA_20180168"));
    	nhaXB.setCellValueFactory(new PropertyValueFactory<>("NHAXB_20180168"));
    	namXB.setCellValueFactory(new PropertyValueFactory<>("NAMXB_20180168"));
    	donGia.setCellValueFactory(new PropertyValueFactory<>("DONGIA_20180168"));
    	
    	sachTable.getItems().setAll(sachObservableList);
    	
      

    }
}
