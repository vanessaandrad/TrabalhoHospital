package model.entities;

public class MedicoLogado {
	protected String nomeLogado;
	protected String especialidadeLogado;
	protected String planoAtendidoLogado;
	protected String senhaLogado;
	protected String crmLogado;

	public MedicoLogado(String nomeLogado, String especialidadeLogado, String planoAtendidoLogado, String senhaLogado,
			String crmLogado) {
		this.nomeLogado = nomeLogado;
		this.especialidadeLogado = especialidadeLogado;
		this.planoAtendidoLogado = planoAtendidoLogado;
		this.senhaLogado = senhaLogado;
		this.crmLogado = crmLogado;
	}

	public String getNomeLogado() {
		return nomeLogado;
	}

	public void setNomeLogado(String nomeLogado) {
		this.nomeLogado = nomeLogado;
	}

	public String getEspecialidadeLogado() {
		return especialidadeLogado;
	}

	public void setEspecialidadeLogado(String especialidadeLogado) {
		this.especialidadeLogado = especialidadeLogado;
	}

	public String getPlanoAtendidoLogado() {
		return planoAtendidoLogado;
	}

	public void setPlanoAtendidoLogado(String planoAtendidoLogado) {
		this.planoAtendidoLogado = planoAtendidoLogado;
	}

	public String getSenhaLogado() {
		return senhaLogado;
	}

	public void setSenhaLogado(String senhaLogado) {
		this.senhaLogado = senhaLogado;
	}

	public String getCrmLogado() {
		return crmLogado;
	}

	public void setCrmLogado(String crmLogado) {
		this.crmLogado = crmLogado;
	}
}