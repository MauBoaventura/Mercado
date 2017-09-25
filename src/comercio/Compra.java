package comercio;

import java.util.Date;

import deposito.Produto;

public class Compra {
	private Produto produto;
	private int quantidade;
	private Cliente cliente;
	Date dataDaCompra = new Date();

	public Compra(Produto produtos,int quantidade, Cliente cliente) {
		super();
		this.produto = produtos;
		this.quantidade=quantidade;
		this.cliente = cliente;
	}

	public Produto getProdutos() {
		return produto;
	}

	public void setProdutos(Produto prod) {
		this.produto=prod;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
