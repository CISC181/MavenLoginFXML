package pkgMain;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import pkgController.GameBoardController;
import pkgController.LoginController;

public class Main extends Application {

	private Stage primaryStage;
	private Parent root;
	private LoginController LoginController = null;
	private GameBoardController GameBoardController = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		FadeInFadeOut("OUT");
		this.primaryStage = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/pkgMain/Login.fxml"));
			root = loader.load();

			LoginController = loader.getController();
			LoginController.setMainApp(this);

			Scene scene = new Scene(root, 300, 275);			
			scene.getStylesheets().add("include/css/application.css");
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();
			FadeInFadeOut("IN");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void OpenGameBoard() {
		Parent root = null;
		FadeInFadeOut("OUT");
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/pkgMain/GameBoard.fxml"));
			root = loader.load();

			GameBoardController = loader.getController();
			GameBoardController.setMainApp(this);

			Scene scene = new Scene(root, 300, 275);
			primaryStage.setTitle("GameBoard");
			primaryStage.setScene(scene);
			primaryStage.show();
			FadeInFadeOut("IN");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void FadeInFadeOut(String strDirection) {

		try {
			if (strDirection == "OUT") {
				FadeTransition ft = new FadeTransition(Duration.millis(1000), root);
				ft.setFromValue(1.0);
				ft.setToValue(0.0);
				ft.play();
			} else {
				FadeTransition ft = new FadeTransition(Duration.millis(1000), root);
				ft.setFromValue(0.0);
				ft.setToValue(1.0);
				ft.play();
			}
		} catch (Exception e) {

		}

	}
}