package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginMedicoController {

	@FXML
	private TextField textFieldUsuario;

	@FXML
	private TextField textFieldSenha;

	@FXML
	private Button botaoLogin;
	
	@FXML
	private Label labelMensagem;
	
	public static String crmLogado;

	public boolean fazerLogin() {
		String url = "jdbc:mysql://localhost:3306/bancodetestes";
        String username = "developer";
        String password = "86779791";
        
        String crm = textFieldUsuario.getText();
        String senha = textFieldSenha.getText();

        String selectQuery = "SELECT * FROM medicoscadastrados WHERE crm = ? AND senha = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

        	preparedStatement.setString(1, crm);
            preparedStatement.setString(2, senha);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	crmLogado = crm;
            	abrirMenuMedico();
                return resultSet.next(); // If there is a matching user, authentication is successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
            labelMensagem.setText("Erro ao realizar o cadastro.");
        }
		return false;
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