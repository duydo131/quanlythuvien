package view;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ThuVienSach extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = null;
		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getResource("/view/thuVienSach.fxml"));
			scene = new Scene(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}