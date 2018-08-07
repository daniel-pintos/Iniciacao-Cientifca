package br.ufpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpr.config.BDConfig;
import br.ufpr.entidade.Nota;

public class NotaDAO {
	
	public class GerenicObject{
		private String nomeCliente;
		private int nota;
		private String nomeProduto;
		public String getNomeCliente() {
			return nomeCliente;
		}
		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}
		public int getNota() {
			return nota;
		}
		public void setNota(int nota) {
			this.nota = nota;
		}
		public String getNomeProduto() {
			return nomeProduto;
		}
		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}

	}
	
	public List<Nota> listarNotas() throws Exception {
		List<Nota> lista = new ArrayList<>();

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM nota";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Nota nota = new Nota();
			nota.setIdNota(rs.getInt(1));
			nota.setIdCliente(rs.getInt(2));
			nota.setIdProduto(rs.getInt(3));
			nota.setNota(rs.getInt(4));
			
			lista.add(nota);
		}

		return lista;
	}
	
	public List<GerenicObject> buscarNotaPorIdCliente(int idCliente) throws Exception {
		List<GerenicObject> listResultado = new ArrayList<>();

		Connection conexao = BDConfig.getConnection();

		String sql = "select cl.nomeCliente, n.notaProduto, p.nomeProduto from cliente cl, nota n, produto p where n.idProduto = p.idProduto and cl.idCliente = n.idCliente and cl.idCliente = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			GerenicObject resultado = new GerenicObject();
			resultado.setNomeCliente(rs.getString(1));
			resultado.setNota(rs.getInt(2));
			resultado.setNomeProduto(rs.getString(3));
			/* Adicionando na lista de Notas */
			listResultado.add(resultado);
		}

		return listResultado;
	}

	public int addNota(Nota nota) throws Exception {
		int idGerado = 0;
		Connection conexao = BDConfig.getConnection();

		String sql = "insert into nota(idNota, idCliente, idProduto, notaProduto) values (?, ?)";

		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, nota.getIdNota());
		statement.setInt(2, nota.getIdCliente());
		statement.setInt(3, nota.getIdProduto());
		statement.setInt(4, nota.getNota());
		statement.execute();
		
		ResultSet rs = statement.getGeneratedKeys();
		/*se foi gerado um id de respost de cadastro*/
		if (rs.next()) {
			idGerado = rs.getInt(1);
		}
		
		return idGerado;
	}
	
	public void editarNota(Nota nota, int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "UPDATE nota SET idNota = ?, idCliente = ? , idProduto = ? , notaProduto = ? WHERE idNota = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, nota.getIdNota());
		statement.setInt(2, nota.getIdCliente());
		statement.setInt(3, nota.getIdProduto());
		statement.setInt(4, nota.getNota());
		statement.setInt(5, idNota);
		statement.execute();
	}
	
	public void removerNota(int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "delete from nota where idNota = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idNota);
		statement.execute();
	}
	
}
