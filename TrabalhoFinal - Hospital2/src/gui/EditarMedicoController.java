package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.entities.MedicoLogado;

public class EditarMedicoController {

	@FXML
	private RadioButton radioButtonNome;

	@FXML
	private RadioButton radioButtonEspecialidade;

	@FXML
	private RadioButton radioButtonCRM;

	@FXML
	private RadioButton radioButtonPlano;

	@FXML
	private RadioButton radioButtonSenha;

	@FXML
	private TextField textFieldEditar;

	@FXML
	private Button botaoEditar;

	public void editarDado() {
		String caminhoArquivo = "C:\\Users\\ianjo\\OneDrive\\Área de Trabalho\\POO\\arquivosTrabalhoFinal\\Lista de Médicos\\listaMedicos.txt";
		File file = new File(caminhoArquivo);

		List<String> linhas = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linha;

			while ((linha = br.readLine()) != null) {
				linhas.add(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String dadoNovo = textFieldEditar.getText();

		if (radioButtonNome.isSelected()) {
			for (int i = 0; i < linhas.size(); i++) {
				String linha = linhas.get(i);
				String[] campos = linha.split(" ");

				if (campos.length >= 4 && campos[4].equals(TelaLoginMedicoController.getcrmLogado())) {
					campos[0] = dadoNovo;
					linhas.set(i, String.join(" ", campos));
					break;
				}
			}
			salvarArquivosMedicos(linhas);
			return;
		}
		if (radioButtonEspecialidade.isSelected()) {
			for (int i = 0; i < linhas.size(); i++) {
				String linha = linhas.get(i);
				String[] campos = linha.split(" ");

				if (campos.length >= 4 && campos[4].equals(TelaLoginMedicoController.getcrmLogado())) {
					campos[1] = dadoNovo;
					linhas.set(i, String.join(" ", campos));
					break;
				}
			}
			salvarArquivosMedicos(linhas);
			return;
		}
		if (radioButtonPlano.isSelected()) {
			for (int i = 0; i < linhas.size(); i++) {
				String linha = linhas.get(i);
				String[] campos = linha.split(" ");

				if (campos.length >= 4 && campos[4].equals(TelaLoginMedicoController.getcrmLogado())) {
					campos[2] = dadoNovo;
					linhas.set(i, String.join(" ", campos));
					break;
				}
			}
			salvarArquivosMedicos(linhas);
			return;
		}
		if (radioButtonSenha.isSelected()) {
			for (int i = 0; i < linhas.size(); i++) {
				String linha = linhas.get(i);
				String[] campos = linha.split(" ");

				if (campos.length >= 4 && campos[4].equals(TelaLoginMedicoController.getcrmLogado())) {
					campos[3] = dadoNovo;
					linhas.set(i, String.join(" ", campos));
					break;
				}
			}
			salvarArquivosMedicos(linhas);
			return;
		}
		if (radioButtonCRM.isSelected()) {
			for (int i = 0; i < linhas.size(); i++) {
				String linha = linhas.get(i);
				String[] campos = linha.split(" ");

				if (campos.length >= 4 && campos[4].equals(TelaLoginMedicoController.getcrmLogado())) {
					campos[4] = dadoNovo;
					linhas.set(i, String.join(" ", campos));
					break;
				}
			}
			salvarArquivosMedicos(linhas);
			return;
		}
	}

	public void salvarArquivosMedicos(List<String> linhas) {
		String caminhoArquivo = "C:\\Users\\vanes\\git\\Trabalho-Final-Hospital\\TrabalhoFinal - Hospital\\arquivos\\listaDeMedicos.txt";
		File file = new File(caminhoArquivo);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (String linha : linhas) {
				writer.write(linha);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}