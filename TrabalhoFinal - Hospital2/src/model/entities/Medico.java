package model.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Medico {
	private String nome;
	private int crm;
	private String especialidade;
	private String planoAtendido;
	private String senha;

	public Medico(String nome, String especialidade, String planoAtendido, String senha, int crm) {
		this.nome = nome;
		this.especialidade = especialidade;
		this.planoAtendido = planoAtendido;
		this.senha = senha;
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getPlanoAtendido() {
		return planoAtendido;
	}

	public void setPlanoAtendido(String planoAtendido) {
		this.planoAtendido = planoAtendido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public static void cadastrarMedico(String nome, String especialidade, String planoAtendido, String senha, int crm) {
		Medico medico = new Medico(nome, especialidade, planoAtendido, senha, crm);
		String caminhoArquivo = "C:\\Users\\vanes\\git\\Trabalho-Final-Hospital\\TrabalhoFinal - Hospital\\arquivos\\listaDeMedicos.txt";

		try {
			boolean arquivoExiste = new File(caminhoArquivo).exists();

			if (!arquivoExiste) {
				new File(caminhoArquivo).createNewFile();
			}

			try (FileWriter writer = new FileWriter(caminhoArquivo, true);
					BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

				bufferedWriter.write(medico.toString());
				bufferedWriter.newLine();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return nome + " " + especialidade + " " + planoAtendido + " " + senha + " " + crm;
	}
}