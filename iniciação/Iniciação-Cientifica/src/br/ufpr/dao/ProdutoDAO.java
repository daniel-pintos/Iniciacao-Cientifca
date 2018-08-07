package br.ufpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpr.config.BDConfig;
import br.ufpr.entidade.Produto;

public class ProdutoDAO {

	public List<Produto> listarProdutos() throws Exception {
		List<Produto> lista = new ArrayList<>();

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM produto";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Produto produto = new Produto();
			produto.setIdProduto(rs.getInt(1));
			produto.setNomeProduto(rs.getString(2));
			
			lista.add(produto);
		}

		return lista;
	}
	
	public int addProduto(Produto produto) throws Exception {
		int idGerado = 0;
		Connection conexao = BDConfig.getConnection();

		String sql = "insert into produto(nomeProduto) values (?)";

		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, produto.getNomeProduto());
		statement.execute();
		
		ResultSet rs = statement.getGeneratedKeys();
		/*se foi gerado um id de respost de cadastro*/
		if (rs.next()) {
			idGerado = rs.getInt(1);
		}
		
		return idGerado;
	}
	
	public void editarProduto(Produto produto, int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "update produto set idProduto = ?, nomeProduto = ? where idProduto = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, produto.getIdProduto());
		statement.setString(2, produto.getNomeProduto());
		statement.setInt(5,idNota);
		statement.execute();
	}
	
	public void removerProduto(int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "delete from produto where idProduto=?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idNota);
		statement.execute();
	}
	

}
