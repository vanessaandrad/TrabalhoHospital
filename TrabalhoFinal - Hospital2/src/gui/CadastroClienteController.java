package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Cliente;

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
		String senha = textFieldSenha.getText();
		//String CPF = textFieldCPF.getText();
		//int cpf = Integer.parseInt(CPF);
		
		Cliente.cadastrarCliente(nome, idade, plano, senha);
		
		labelMensagem.setText("Cadastro realizado com sucesso!");
		
		textFieldNome.clear();
        textFieldIdade.clear();
        textFieldPlano.clear();
        textFieldSenha.clear();
        textFieldCPF.clear();
	}
}
