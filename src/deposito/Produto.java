package deposito;

public class Produto {

	private String nome;
	private String codigo;
	private double preco;
	private String tipo;
	private double quantidade;

	public Produto(String nome, String codigo, double preco, int quantidade) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Produto(String nome, String codigo, double preco, String tipo, int quantidade) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nCodigo: " + this.getCodigo() + "\nPreço: " + this.getPreco() + "\nTipo: "
				+ this.getTipo() + "\nQuantidade: " + this.getQuantidade();
	}
}
