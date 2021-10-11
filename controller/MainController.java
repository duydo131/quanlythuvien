package controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao_impl.Chitietmuontraimpl;
import dao_impl.Docgiaimpl;
import dao_impl.Muontraimpl;
import dao_impl.SachImpl;
import dao_impl.Thuthuimpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.CHITIET_MUONTRA_TAINTD;
import model.DOCGIA_TAINTD;
import model.MUONTRA_TAINTD;
import model.MyConnection;
import model.SACH_TAINTD;
import model.THUTHU_TAINTD;



public class MainController implements Initializable {
	
	MyConnection myConnection = new MyConnection();
	

    List<THUTHU_TAINTD> thuthuList ;
    ObservableList<THUTHU_TAINTD> thuthuObservableList;
    Thuthuimpl thuthuDao = new Thuthuimpl();
    
    List<SACH_TAINTD> sachList ;
    ObservableList<SACH_TAINTD> sachObservableList;
    SachImpl sachDao = new SachImpl();
    
    List<DOCGIA_TAINTD> docgiaList;
    ObservableList<DOCGIA_TAINTD> docgiaObservableList;
    Docgiaimpl docgiaDao = new Docgiaimpl();
    
    List<MUONTRA_TAINTD> muontraList ;
    ObservableList<MUONTRA_TAINTD> muontraObservableList;
    Muontraimpl muontraDao = new Muontraimpl();
    
    List<CHITIET_MUONTRA_TAINTD> chitietmuontraList ;
    ObservableList<CHITIET_MUONTRA_TAINTD> chitietmuontraObservableList;
    Chitietmuontraimpl ctmtDao = new Chitietmuontraimpl();
    
    {
        try {
            myConnection.connectDB();
            sachList = sachDao.findAll();
            docgiaList = docgiaDao.findAll();
            chitietmuontraList = ctmtDao.findAll();
            muontraList = muontraDao.findAll();
            thuthuList = thuthuDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    public static SACH_TAINTD selectedSach;
    public static DOCGIA_TAINTD selectedDocGia;
    public static MUONTRA_TAINTD selectedMuonTra;
    
    void loadWindow(String location, String title)  {
        try {
        	
            Parent parent = FXMLLoader.load(getClass().getResource(location));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableColumn<DOCGIA_TAINTD, Number> sdt;

        @FXML
        private TableView<DOCGIA_TAINTD> qldgTable;

        @FXML
        private TableColumn<DOCGIA_TAINTD, Number> maDG;

        @FXML
        private TextField mamtSearch;

        @FXML
        private TextField tenDocGiaSearch;

        @FXML
        private TableColumn<MUONTRA_TAINTD, Number> maMt;

        @FXML
        private TextField tenSachSearch;

        @FXML
        private TableColumn<DOCGIA_TAINTD, String> gioiTinh;

        @FXML
        private TableView<SACH_TAINTD> qlsachTable;
        
        @FXML
        private TableColumn<MUONTRA_TAINTD, Number> maDGMT;

        @FXML
        private TableColumn<MUONTRA_TAINTD, Number> maSachMT;
        
        @FXML
        private TableColumn<DOCGIA_TAINTD, String> tenDGMT;
        
        @FXML
        private TableColumn<SACH_TAINTD, String> tenSachMT;

        @FXML
        private TableColumn<DOCGIA_TAINTD, String> cmnd;

        @FXML
        private TableColumn<SACH_TAINTD, String> nhaXB;

        @FXML
        private TableColumn<SACH_TAINTD, Number> donGia;

        @FXML
        private TableColumn<MUONTRA_TAINTD, String> ngayMuon;

        @FXML
        private TableColumn<SACH_TAINTD, String> tenSach;

        @FXML
        private TableColumn<DOCGIA_TAINTD, String> diaChi;

        @FXML
        private TableColumn<DOCGIA_TAINTD, String> tenDG;

        @FXML
        private TableColumn<CHITIET_MUONTRA_TAINTD, String> trangThai;

        @FXML
        private TableView<MUONTRA_TAINTD> qlmtTable;

        @FXML
        private TableColumn<DOCGIA_TAINTD, Date> ngaySinh;

        @FXML
        private TableColumn<SACH_TAINTD, Number> maSach;

        @FXML
        private TableColumn<SACH_TAINTD, String> gioiThieu;

        @FXML
        private TableColumn<SACH_TAINTD, String> tacGia;

        @FXML
        private TableColumn<DOCGIA_TAINTD, String> email;

        @FXML
        private TableColumn<SACH_TAINTD, Number> namXB;
        
        @FXML
        private AnchorPane rootPane;

        @FXML
        void timKiemSach(ActionEvent event) throws SQLException  {
        	selectedSach = sachDao.findById(Integer.parseInt(tenSachSearch.getText()));
        	sachList.clear();
        	sachList.add(selectedSach);
            setTableSach();

        }

        @FXML
        void xoaSach(ActionEvent event) throws SQLException {
        	selectedSach = qlsachTable.getSelectionModel().getSelectedItem();
        	sachObservableList.remove(selectedSach);
        	sachDao.delete(selectedSach.getIdsach());

        }
         
        public void setTableSach() throws SQLException {
        	sachList = sachDao.findAll();
        	sachObservableList = FXCollections.observableArrayList(sachList);
        	maSach.setCellValueFactory(new PropertyValueFactory<>("idsach"));
        	tenSach.setCellValueFactory(new PropertyValueFactory<>("TENSACH_20180168"));
        	gioiThieu.setCellValueFactory(new PropertyValueFactory<>("GIOITHIEU_20180168"));
        	tacGia.setCellValueFactory(new PropertyValueFactory<>("TACGIA_20180168"));
        	nhaXB.setCellValueFactory(new PropertyValueFactory<>("NHAXB_20180168"));
        	namXB.setCellValueFactory(new PropertyValueFactory<>("NAMXB_20180168"));
        	donGia.setCellValueFactory(new PropertyValueFactory<>("DONGIA_20180168"));
        	
        	qlsachTable.getItems().setAll(sachObservableList);
        	
        	
        }

        @FXML
        void timKiemDocGia(ActionEvent event) throws SQLException {
        	selectedDocGia = docgiaDao.findById(Integer.parseInt(tenDocGiaSearch.getText()));
        	docgiaList.clear();
        	docgiaList.add(selectedDocGia);
            setTableDocGia();

        }

        @FXML
        void xoaDocGia(ActionEvent event) throws SQLException {
        	selectedDocGia = qldgTable.getSelectionModel().getSelectedItem();
        	docgiaObservableList.remove(selectedDocGia);
        	docgiaDao.delete(selectedDocGia.getId_dg());


        }
        public void setTableDocGia() {
        	docgiaObservableList = FXCollections.observableArrayList(docgiaList);
        	maDG.setCellValueFactory(new PropertyValueFactory<>("id_dg"));
        	tenDG.setCellValueFactory(new PropertyValueFactory<>("TEN_DG_20180168"));
        	gioiTinh.setCellValueFactory(new PropertyValueFactory<>("GIOITINH_20180168"));
        	diaChi.setCellValueFactory(new PropertyValueFactory<>("DIACHI_20180168"));
        	ngaySinh.setCellValueFactory(new PropertyValueFactory<>("NGAYSINH_20180168"));
        	cmnd.setCellValueFactory(new PropertyValueFactory<>("CMND_20180168"));
        	email.setCellValueFactory(new PropertyValueFactory<>("EMAIL_20180168"));
        	sdt.setCellValueFactory(new PropertyValueFactory<>("DIENTHOAI_20180168"));
        	
        	qldgTable.getItems().setAll(docgiaObservableList);
        	
        	
        }
        

        @FXML
        void timkiemMamt(ActionEvent event) throws SQLException {
        	selectedMuonTra = muontraDao.findById(Integer.parseInt(mamtSearch.getText()));
        	muontraList.clear();
        	muontraList.add(selectedMuonTra);
            setTableMuonTra();

        }

        @FXML
        void xoaMamt(ActionEvent event) throws SQLException {
        	selectedMuonTra = qlmtTable.getSelectionModel().getSelectedItem();
        	muontraObservableList.remove(selectedMuonTra);
        	muontraDao.delete(selectedMuonTra.getMAMT_20180168());


        }
        
        public void setTableMuonTra() {
        	muontraObservableList = FXCollections.observableArrayList(muontraList);
        	sachObservableList = FXCollections.observableArrayList(sachList);
        	docgiaObservableList = FXCollections.observableArrayList(docgiaList);
        	maMt.setCellValueFactory(new PropertyValueFactory<>("MAMT_20180168"));
        	maSachMT.setCellValueFactory(new PropertyValueFactory<>("idsach"));
        	tenSachMT.setCellValueFactory(new PropertyValueFactory<>("TENSACH_20180168"));
        	maDGMT.setCellValueFactory(new PropertyValueFactory<>("id_dg"));
        	tenDGMT.setCellValueFactory(new PropertyValueFactory<>("TEN_DG_20180168"));
        	ngayMuon.setCellValueFactory(new PropertyValueFactory<>("NGAY_MUON_20180168"));
        	trangThai.setCellValueFactory(new PropertyValueFactory<>("TRANG_THAI_SACH_20180168"));
        	
        	
        	
        	qlmtTable.setItems(muontraObservableList);

        	
        	
        }

        @FXML
        void themDocGia(ActionEvent event) {
        	loadWindow("/view/themDocGia.fxml", "Thêm Độc Giả");

        }

        @FXML
        void themSach(ActionEvent event) {
        	loadWindow("/view/themSach.fxml", "Thêm Sách");

        }

        @FXML
        void danhSachDocGia(ActionEvent event) {
        	loadWindow("/view/danhSachDocGia.fxml", "Danh Sách Độc Giả");

        }

        @FXML
        void thuVienSach(ActionEvent event) {
        	loadWindow("/view/thuVienSach.fxml", "Thư Viện Sách");

        }

        @FXML
        void quanLyThuThu(ActionEvent event) {
        	loadWindow("/view/quanLyThuThu.fxml", "Quản Lý Thủ Thư");

        }

        @FXML
        void muonSach(ActionEvent event) {
        	loadWindow("/view/muonSach.fxml", "Mượn Sách");

        }

        @FXML
        void TraSach(ActionEvent event) {
        	loadWindow("/view/traSach.fxml", "Trả Sách");

        }
        
        

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub

//			setTableMuonTra();
		setTableDocGia();
//			 try {
//				setTableSach() ;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
	
		}
    }


