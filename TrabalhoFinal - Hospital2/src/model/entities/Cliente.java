package model.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente {
	protected String nome;
	protected String idade;
	protected String plano;
	
	protected String senha;
	
	public Cliente(String nome, String idade, String plano, String senha) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.plano = plano;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public static void cadastrarCliente(String nome, String idade, String plano, String senha) {
			Cliente cliente = new Cliente(nome, idade, plano, senha);
			String caminhoArquivo = "C:\\Users\\vanes\\git\\Trabalho-Final-Hospital\\TrabalhoFinal - Hospital\\arquivos\\listaDeClientes.txt";

			try {
				boolean arquivoExiste = new File(caminhoArquivo).exists();

				if (!arquivoExiste) {
					new File(caminhoArquivo).createNewFile();
				}

				try (FileWriter writer = new FileWriter(caminhoArquivo, true);
						BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

					bufferedWriter.write(cliente.toString());
					bufferedWriter.newLine();

				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public String toString() {
		return nome + " " + idade + " " + plano + " " + senha;
	}	
	

}
