package pkgController;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import pkgMain.Main;
 
public class LoginController {
	
	private Main Main;
	
    @FXML private Text actiontarget;
    @FXML private Text UserName;
    @FXML private PasswordField passwordField;
    
	public void setMainApp(Main main) {
		this.Main = main;
	}
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed " + passwordField.getText().toString());
        
        
        Main.OpenGameBoard();
    }

}