package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
	private CheckBox cBox;
	@FXML
	private Label lbl;

	@FXML
	public void onButtonClicked(ActionEvent ae) {
		System.out.println(inputField.getText());
		if(bOne.equals(ae.getSource()))
			System.out.println("Me");
		else if(bTwo.equals(ae.getSource()))
			System.out.println("Me Too");
		
		Runnable runner = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							lbl.setText("Thread Complete");
							
						}
					});
				} catch(InterruptedException ie) {
					ie.printStackTrace();
				}
				
			}
		};
		
		new Thread(runner).start();
		
		if(cBox.isSelected()) {
			inputField.clear();
			bOne.setDisable(true);
			bTwo.setDisable(true);
		}
	}
	
	@FXML
	public void onKeyReleased(KeyEvent ke) {
		String input = inputField.getText();
		boolean disableButton = input.isEmpty() || input.trim().isEmpty();
		bOne.setDisable(disableButton);
		bTwo.setDisable(disableButton);
		
	}
	
	@FXML
	public void handleChange() {
		System.out.println("The checkbox is selected: " + cBox.isSelected());
	}
}
