package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroMedicoController {
	
	@FXML
	private TextField textFieldNome;
	
	@FXML
	private TextField textFieldEspecialidade;
	
	@FXML
	private TextField textFieldPlanoAtendido;
	
	@FXML
	private TextField textFieldSenha;
	
	@FXML
	private TextField textFieldCRM;
	
	@FXML
	private Button botaoRealizarCadastro;
	
	@FXML
	private Label labelMensagem;
	
	@FXML
    public void realizarCadastro() {
        String nome = textFieldNome.getText();
        String especialidade = textFieldEspecialidade.getText();
        String planoAtendido = textFieldPlanoAtendido.getText();
        String senha = textFieldSenha.getText();
        String CRM = textFieldCRM.getText();
        int crm = Integer.parseInt(CRM);

       
        String url = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "demilovato1";

        String insertQuery = "INSERT INTO medicoscadastrados (nome, especialidade, plano_atendido, senha, crm)"
                + " VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, especialidade);
            preparedStatement.setString(3, planoAtendido);
            preparedStatement.setString(4, senha);
            preparedStatement.setInt(5, crm);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                labelMensagem.setText("Cadastro realizado com sucesso!");
                clearFields();
            } else {
                labelMensagem.setText("Falha ao cadastrar.");
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            labelMensagem.setText("Erro ao realizar o cadastro.");
        }
    }

    private void clearFields() {
        textFieldNome.clear();
        textFieldEspecialidade.clear();
        textFieldPlanoAtendido.clear();
        textFieldSenha.clear();
        textFieldCRM.clear();
    }
}