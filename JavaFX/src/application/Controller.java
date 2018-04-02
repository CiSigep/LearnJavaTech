package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
	
	@FXML
	private TextField inputField;
	@FXML
	private Button bOne;
	@FXML
	private Button bTwo;

	@FXML
	public void onButtonClicked(ActionEvent ae) {
		System.out.println(inputField.getText());
		if(bOne.equals(ae.getSource()))
			System.out.println("Me");
		else if(bTwo.equals(ae.getSource()))
			System.out.println("Me Too");
	}
	
	@FXML
	public void onKeyReleased(KeyEvent ke) {
		String input = inputField.getText();
		boolean disableButton = input.isEmpty() || input.trim().isEmpty();
		bOne.setDisable(disableButton);
		bTwo.setDisable(disableButton);
		
	}
}
