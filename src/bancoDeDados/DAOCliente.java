package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import comercio.Cliente;

public class DAOCliente {

	public void salvarCliente(Cliente c) {
		Connection con = Conexao.getConexao();
		Statement st;
		if (c.getData() == null) {
			GregorianCalendar data = new GregorianCalendar(1997, 03, 30);
			c.setData(data);
		}
		if (c.getEndereco() == null) {
			c.setEndereco("N�o dado");
		}
		try {
			st = con.createStatement();
			String sql = "INSERT INTO cliente (nome, cpf, telefone, endere�o, aniversario) VALUES (\'" + c.getNome()
					+ "\', \'" + c.getCpf() + "\', \'" + c.getTelefone() + "\', \'" + c.getEndereco() + "\', \'"
					+ c.getData() + "\');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel acessar a tabela cliente.");
		}
	}

	/*
	 * "INSERT INTO corredores (nome, km, numero, idade, sexo) VALUES (\'" +
	 * c.getNome() + "\'," + c.getKm6() + "," + c.getNumero() + "," +
	 * c.getIdade() + ",\'" + c.getSexo() + "\'"; sql += ")";
	 */
	public ArrayList<Cliente> recuperaCliente() {
		Connection con = Conexao.getConexao();
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			String sql = "select * from cliente";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			ArrayList<Cliente> c = new ArrayList<Cliente>();
			Cliente e = null;
			while (rs.next()) {
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String endere�o = rs.getString("endere�o");
				Date data = rs.getDate("aniversario");
				double gastos = rs.getDouble("gastos");
				double fiado = rs.getDouble("fiado");
				GregorianCalendar aniversario = new GregorianCalendar();
				aniversario.setTime(data);
				e = new Cliente(nome, cpf, telefone, endere�o, aniversario, gastos, fiado);
				c.add(e);
				// adicionaEstes();
			}
			return c;
		} catch (SQLException e) {
			System.out.println("Não foi possível acessar a tabela corredores.");
			System.exit(1);
		}
		return null;

	}

	/*
	 * public void adicionaEstes() {
	 * 
	 * String[] nomes = { "Adriana mara Ribeiro Baptista",
	 * "James Alves do nascimento", "Juliana Alves Bezerra",
	 * "Ernildo da Silva Gomes", "Maria Erisvalda de Sousa araujo",
	 * "Monica Angela Machado Araujo", "Rita de cassia Sousa",
	 * "Fabr�cio Bacelar Salles", "Elizangela Gomes Coelho",
	 * "Amarildo Gon�alves de Ara�jo", "Igor Felipe Pinto de Ara�jo",
	 * "Jeferson de SOUZA Santos", "Dem�stenes Lu�s Campelo Galv�o",
	 * "Lilian Cunha Marinho", "Luis Carlos Dourado dos Santos",
	 * "Mabenys Augusto Castelo Branco de Sousa", "GEOVAN Fernandes da silva",
	 * "COSMO Alves de LIMA", "Jos� Osmar de Moura", "Jos� Anazildo de Ara�jo",
	 * "Jos� Sotero da Silva J�nior", "M�rcio Rodrigo de Ara�jo Souza",
	 * "Fabiola Alves de Meneses", "Carlos magno furtado Sousa",
	 * "Ant�nio Luiz Gomes de Sales", "S�nia Maria de Ara�jo Cris�stomo",
	 * "Tony Cesar Magalh�es Silva", "Joao Fabiano Fernandes",
	 * "Ant�nio sampaio evangelista", "Dsordi Sousa Dantas",
	 * "francisco marcos ferreira de lima", "Ricardo Teixeira de Carvalho",
	 * "Joana de Sousa Machado", "Luciana Eug�niaMendesdosSantos",
	 * "Ana Lucia Cavalcanti", "Andr� da Silva freitas", "Carla Carvalho Couto",
	 * "MATIAS FRANCISCO GOMES SALES", "Wandson sousa nascimento" };
	 * 
	 * int[] idades = { 46, 36, 37, 51, 42, 38, 34, 36, 37, 54, 28, 41, 50, 30,
	 * 34, 43, 42, 38, 43, 50, 50, 34, 28, 40, 58, 48, 46, 21, 64, 44, 44, 56,
	 * 34, 35, 56, 18, 39, 58, 31 };
	 * 
	 * int[] kms = { 12, 6, 12, 6, 6, 12, 12, 12, 6, 12, 12, 12, 6, 6, 12, 6,
	 * 12, 6, 6, 6, 6, 12, 12, 12, 6, 6, 6, 12, 12, 12, 12, 6, 6, 6, 12, 12, 6,
	 * 6, 12 }; Corredor c = null; for (int i = 0; i < nomes.length; i++) { c =
	 * new Corredor(nomes[i], i, kms[i], idades[i], "M"); // salvar(c);
	 * 
	 * } }
	 */
	public Cliente pesquisarCliente(String cpf) {
		Connection con = Conexao.getConexao();
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			String sql = "select * from cliente where cpf = " + cpf + ";";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			Cliente c = null;
			while (rs.next()) {
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				String endere�o = rs.getString("endere�o");
				Date data = rs.getDate("aniversario");
				double gastos = rs.getDouble("gastos");
				double fiado = rs.getDouble("fiado");
				GregorianCalendar aniversario = new GregorianCalendar();
				aniversario.setTime(data);

				c = new Cliente(nome, cpf, telefone, endere�o, aniversario, gastos, fiado);
				return c;
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível acessar a tabela corredores.");
			System.exit(1);
		}
		return null;

	}


	public static void main(String[] args) {
		DAOCliente d = new DAOCliente();
		Cliente e = new Cliente("BICHO", "054.667.933-10", "(86)9 9988-8989", null, null);
		d.salvarCliente(e);
		ArrayList<Cliente> n= d.recuperaCliente();
		for (Cliente cliente : n) {
			
		}
		// = d.pesquisar("121");
		// e = d.pesquisar("121");
		// System.out.println(e.getData());
	}

}
