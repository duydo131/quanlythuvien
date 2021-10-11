package controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao_impl.Thuthuimpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.MyConnection;
import model.THUTHU_TAINTD;


public class QuanLyThuThuController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tenThuThuSearch;

    @FXML
    private TableColumn<THUTHU_TAINTD, Number> dienThoai;

    @FXML
    private TableColumn<THUTHU_TAINTD, Date> ngaySinh;

    @FXML
    private TableColumn<THUTHU_TAINTD, Number> id;

    @FXML
    private TableColumn<THUTHU_TAINTD, String> gioiTinh;

    @FXML
    private TableView<THUTHU_TAINTD> thuthuTable;

    @FXML
    private TableColumn<THUTHU_TAINTD, String> cmnd;

    @FXML
    private TableColumn<THUTHU_TAINTD, String> email;

    @FXML
    private TableColumn<THUTHU_TAINTD, String> tenTT;
    
    @FXML
    private AnchorPane rootPane;
    
    List<THUTHU_TAINTD> thuthuList = null;
    private  ObservableList<THUTHU_TAINTD> thuthuObservableList;
    
    MyConnection myConnection = new MyConnection();
    Thuthuimpl thuthuDao = new Thuthuimpl();
    
    public static THUTHU_TAINTD selectedThuthu;

    @FXML
    void timKiemThuThu(ActionEvent event) throws SQLException {
    	selectedThuthu = thuthuDao.findById(Integer.parseInt(tenThuThuSearch.getText()));
    	thuthuList.clear();
    	thuthuList.add(selectedThuthu);
    	initialize(location, resources);

    }

    @FXML
    void xoaThuThu(ActionEvent event) throws SQLException {
    	selectedThuthu = thuthuTable.getSelectionModel().getSelectedItem();
    	thuthuObservableList.remove(selectedThuthu);
    	thuthuDao.delete(selectedThuthu.getId());


    }

    @FXML
    void quayLai(ActionEvent event) throws SQLException {
    	Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();


    }

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1){
    	try {
            myConnection.connectDB();
            thuthuList = thuthuDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	thuthuObservableList = FXCollections.observableArrayList(thuthuList);
    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	dienThoai.setCellValueFactory(new PropertyValueFactory<>("DIENTHOAI_20180168"));
    	ngaySinh.setCellValueFactory(new PropertyValueFactory<>("NGAYSINH_20180168"));
    	gioiTinh.setCellValueFactory(new PropertyValueFactory<>("GIOITINH_20180168"));
    	email.setCellValueFactory(new PropertyValueFactory<>("EMAIL_20180168"));
    	cmnd.setCellValueFactory(new PropertyValueFactory<>("CMND_20180168"));
    	tenTT.setCellValueFactory(new PropertyValueFactory<>("TEN_TT_20180168"));
    	
    	thuthuTable.getItems().setAll(thuthuObservableList);
    	
    	
    	
        

    }
}
