package comercio;

import java.util.ArrayList;

import bancoDeDados.DAOCliente;
import deposito.Produto;

public class Iniciar {
	private static ArrayList<Produto> listaProd = new ArrayList<Produto>();
	private static ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
	private static ArrayList<Compra> listaCompras = new ArrayList<Compra>();

	public ArrayList<Produto> getListaProd() {
		return listaProd;
	}

	public void setListaProd(ArrayList<Produto> listaProd) {
		Iniciar.listaProd = listaProd;
	}

	public ArrayList<Cliente> getListaCli() {
		return listaCli;
	}

	public void setListaCli(ArrayList<Cliente> listaCli) {
		Iniciar.listaCli = listaCli;
	}

	public ArrayList<Compra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ArrayList<Compra> listaCompras) {
		Iniciar.listaCompras = listaCompras;
	}

	public void adicionarProduto(Produto produto) {
		listaProd.add(produto);
		// Banco de dados
	}

	public void adicionarCliente(Cliente cliente) {
		listaCli.add(cliente);
		// Banco de dados
		DAOCliente daoD = new DAOCliente();
		daoD.salvarCliente(cliente);
	}

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Jose", "054.667.933-10", "99783451", "SEILA");
		listaCli.add(c1);


	}
}
