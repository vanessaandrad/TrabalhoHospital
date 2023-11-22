package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuMedicoController {
	
	@FXML
	private Button botaoEditarMedico;
	
	@FXML
	public void cliqueBotaoEditarMedico() {
		abrirTelaEditarMedico();
	}
	
	@FXML
	private Button botaoRealizarConsulta;
	
	@FXML
	public void cliqueBotaoRealizarConsulta() {
		abrirTelaRealizarConsulta();
	}
	
	@FXML
	private Button botaoGerarRelatorio;
	
	@FXML
	public void cliqueBotaoGerarRelatorio() {
		abrirTelaGerarRelatorio();
	}
	
	private void abrirTelaEditarMedico() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarMedicos.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Edição de dados dos médicos");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void abrirTelaRealizarConsulta() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RealizarConsulta.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Edição de dados dos médicos");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void abrirTelaGerarRelatorio() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GerarRelatorio.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Edição de dados dos médicos");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}