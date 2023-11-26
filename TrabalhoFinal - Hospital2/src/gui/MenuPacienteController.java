package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuPacienteController {
	
	@FXML
	private Button botaoEditarDados;
	
	@FXML
	private Button botaoAgendarConsulta;

	@FXML
	private Button botaoCancelarConsulta;

	public void cliqueBotaoAgendarConsulta() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AgendarConsulta.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Agendar consulta");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cliqueBotaoCancelarConsulta() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CancelarConsulta.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Cancelar consulta");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cliqueBotaoEditarDados() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarPaciente.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Agendar consulta");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}