package comercio;

import java.util.GregorianCalendar;

public class Cliente {
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private GregorianCalendar data;
	private double gastos;
	private double fiado;

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String telefone, String endereco, GregorianCalendar data, double gastos,
			double fiado) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.data = data;
		this.gastos = gastos;
		this.fiado = fiado;
		
	}

	public Cliente(String nome, String cpf, String telefone, String endereco, GregorianCalendar data) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.data = data;

	}

	public Cliente(String nome, String cpf, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getData() {
		if (data==null) {
			return null;
		}
		String anoMesDia=data.get(GregorianCalendar.YEAR)+"/"+data.get(GregorianCalendar.MONTH)+"/"+data.get(GregorianCalendar.DAY_OF_MONTH);
		return anoMesDia;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

	public double getFiado() {
		return fiado;
	}

	public void setFiado(double fiado) {
		this.fiado = fiado;
	}

}
