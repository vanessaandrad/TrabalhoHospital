package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroClienteController {
	
	@FXML
	private TextField textFieldNome;
	
	@FXML
	private TextField textFieldIdade;
	
	@FXML
	private TextField textFieldPlano;
	
	@FXML
	private TextField textFieldSenha;
	
	@FXML
	private TextField textFieldCPF;
	
	@FXML
	private Button botaoRealizarCadastroC;
	
	@FXML
	private Label labelMensagem;
	
	 @FXML
	    public void realizarCadastroP() {
	        String nome = textFieldNome.getText();
	        String idade = textFieldIdade.getText();
	        String plano = textFieldPlano.getText();
	        String cpf = textFieldCPF.getText();
	        String senha = textFieldSenha.getText();

	        String url = "jdbc:mysql://localhost:3306/bancodetestes";
	        String username = "developer";
	        String password = "86779791";

	        String insertQuery = "INSERT INTO pacientes (nome, idade, plano, senha, cpf) VALUES (?, ?, ?, ?, ?)";

	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

	            preparedStatement.setString(1, nome);
	            preparedStatement.setString(2, idade);
	            preparedStatement.setString(3, plano);
	            preparedStatement.setString(4, senha);
	            preparedStatement.setString(5, cpf);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                labelMensagem.setText("Cadastro realizado com sucesso!");
	                clearFields();
	            } else {
	                labelMensagem.setText("Falha ao cadastrar.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            labelMensagem.setText("Erro ao realizar o cadastro.");
	        }
	    }

	    private void clearFields() {
	        textFieldNome.clear();
	        textFieldIdade.clear();
	        textFieldPlano.clear();
	        textFieldSenha.clear();
	        textFieldCPF.clear();
	    }
	}