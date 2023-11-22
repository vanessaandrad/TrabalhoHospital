package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.MedicoLogado;

public class TelaLoginMedicoController {

	@FXML
	private TextField textFieldUsuario;

	@FXML
	private TextField textFieldSenha;

	@FXML
	private Button botaoLogin;
	
	public static String crmLogado;

	public void fazerLogin() {
		String caminhoArquivo = "C:\\Users\\vanes\\git\\Trabalho-Final-Hospital\\TrabalhoFinal - Hospital\\arquivos\\listaDeMedicos.txt";
		File file = new File(caminhoArquivo);

		String usuario = textFieldUsuario.getText();
		String senha = textFieldSenha.getText();

		try {
			FileReader reader = new FileReader(file);
			BufferedReader buffReader = new BufferedReader(reader);

			String linha;
			while ((linha = buffReader.readLine()) != null) {
				if (linha.contains(usuario)) {
					if (linha.contains(senha)) {
						crmLogado = usuario;
						abrirMenuMedico();
						reader.close();
						buffReader.close();
						return;
					}
				}
			}
			reader.close();
			buffReader.close();
			Alerts.showAlert("Login inválida!", null, null, AlertType.WARNING);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void abrirMenuMedico() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuMedico.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Tela de Operações");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getcrmLogado() {
		return crmLogado;
	}
}