package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import comercio.Cliente;
import deposito.Produto;

public class DAOProduto {
	public void salvarProduto(Produto c) {
		Connection con = Conexao.getConexao();
		Statement st;
		if (c.getTipo() == null) {
			c.setTipo("Sem tipo");
		}
		try {
			st = con.createStatement();
			String sql = "INSERT INTO produtos (nome_produto, codigo_produto, valor_produto, tipo_produto, quantidade_produto) VALUES (\'"
					+ c.getNome() + "\', \'" + c.getCodigo() + "\', \'" + c.getPreco() + "\', \'" + c.getTipo()
					+ "\', \'" + c.getQuantidade() + "\');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel acessar a tabela produtos.");
		}
	}

	public ArrayList<Produto> recuperaProduto() {
		Connection con = Conexao.getConexao();
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			String sql = "select * from produtos";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			ArrayList<Produto> c = new ArrayList<Produto>();
			Produto e = null;
			while (rs.next()) {
				String nome_produto = rs.getString("nome_produto");
				String codigo_produto = rs.getString("codigo_produto");
				double valor_produto = rs.getDouble("valor_produto");
				String tipo_produto = rs.getString("tipo_produto");
				int quantidade_produto = rs.getInt("quantidade_produto");

				e = new Produto(nome_produto, codigo_produto, valor_produto, tipo_produto, quantidade_produto);
				c.add(e);
			}
			return c;
		} catch (SQLException e) {
			System.out.println("Não foi possível acessar a tabela corredores.");
			System.exit(1);
		}
		return null;

	}

	public Produto pesquisarProduto(String codigo) {
		Connection con = Conexao.getConexao();
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			String sql = "select * from produtos where codigo_produto = \'" + codigo + "\';";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			Produto c = null;
			while (rs.next()) {
				String nome_produto = rs.getString("nome_produto");
				String codigo_produto = rs.getString("codigo_produto");
				double valor_produto = rs.getDouble("valor_produto");
				String tipo_produto = rs.getString("tipo_produto");
				int quantidade_produto = rs.getInt("quantidade_produto");

				c = new Produto(nome_produto, codigo_produto, valor_produto, tipo_produto, quantidade_produto);
				return c;
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível acessar a tabela corredores.");
			System.exit(1);
		}
		return null;

	}

	public static void main(String[] args) {
		DAOProduto dao = new DAOProduto();
		ArrayList<Produto> p = dao.recuperaProduto();
		for (Produto produto : p) {
			System.out.println(produto+"\n\n");
			
		}
	}
}
