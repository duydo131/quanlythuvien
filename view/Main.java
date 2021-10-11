package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	 public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(Stage primaryStage) {
	        Parent root = null;
	        Scene scene = null;
			try {
				root = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
				scene = new Scene(root);
				System.out.println("hello");
			} catch (IOException e) {
				e.printStackTrace();
			}
	        primaryStage.setScene(scene);
	        primaryStage.show();

	    }
	}
