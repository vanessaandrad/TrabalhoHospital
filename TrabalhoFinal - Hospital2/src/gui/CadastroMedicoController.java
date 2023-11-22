package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Medico;

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
		
		Medico.cadastrarMedico(nome, especialidade, planoAtendido, senha, crm);
		
		labelMensagem.setText("Cadastro realizado com sucesso!");
		
		textFieldNome.clear();
        textFieldEspecialidade.clear();
        textFieldPlanoAtendido.clear();
        textFieldSenha.clear();
        textFieldCRM.clear();
	}
}