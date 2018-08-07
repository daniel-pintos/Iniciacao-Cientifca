package br.ufpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpr.config.BDConfig;
import br.ufpr.entidade.Cliente;

public class ClienteDAO {

	public List<Cliente> listarClientes() throws Exception {
		List<Cliente> lista = new ArrayList<>();

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM cliente";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(rs.getInt(1));
			cliente.setNomeCliente(rs.getString(2));
			
			lista.add(cliente);
		}

		return lista;
	}
	
	public int addCliente(Cliente cliente) throws Exception {
		int idGerado = 0;
		Connection conexao = BDConfig.getConnection();

		String sql = "insert into cliente(nomeCliente) values (?)";

		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, cliente.getNomeCliente());
		statement.execute();
		
		ResultSet rs = statement.getGeneratedKeys();
		/*se foi gerado um id de respost de cadastro*/
		if (rs.next()) {
			idGerado = rs.getInt(1);
		}
		
		return idGerado;
	}
	
	public void editarCliente(Cliente cliente, int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "update cliente set idCliente = ?, nomeCliente = ? where idCliente = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, cliente.getIdCliente());
		statement.setString(2, cliente.getNomeCliente());
		statement.setInt(5,idNota);
		statement.execute();
	}
	
	public void removerCliente(int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "delete from cliente where idCliente=?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idNota);
		statement.execute();
	}
	

}
