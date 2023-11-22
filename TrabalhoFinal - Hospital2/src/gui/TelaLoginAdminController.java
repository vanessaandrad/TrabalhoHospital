package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaLoginAdminController {
	
	@FXML
	private TextField textFieldUsuario;
	
	@FXML
	private TextField textFieldSenha;
	
	@FXML
	private Button botaoLoginAdmin;
	
	@FXML
	public void fazerLoginAdmin() {
		String usuario = textFieldUsuario.getText();
		String senha = textFieldSenha.getText();
		
		if(usuario.equals("admin") && senha.equals("0000")) {
			abrirMenuAdmin();
		}
		else {
			Alerts.showAlert("Login inválido", null, "Tente novamente!", AlertType.ERROR);
		}
	}
	
	private void abrirMenuAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuAdmin.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Menu do administrador");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}