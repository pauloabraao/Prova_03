package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.Categorias;
import negocio.Participante;
import persistencia.Conexao;

public class CategoriasDAO {
	
	public Categorias listarPorId(int id) {

		Categorias categorias = new Categorias();

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement sql = conexao.prepareStatement("select * from categorias where id=?");

			sql.setInt(1, id);

			ResultSet result = sql.executeQuery();

			while (result.next()) {
				categorias.setPessoa(result.getString("pessoa"));
				categorias.setCarro(result.getString("carro"));
				categorias.setCidadeEstadoPais(result.getString("cidadeEstadoPais"));
				categorias.setFruta(result.getString("fruta"));
				categorias.setObjeto(result.getString("objeto"));
				categorias.setAnimal(result.getString("animal"));
			}

			conexao.close();

		} catch (Exception e) {
		}
		return categorias;
	}

	public ArrayList<Categorias> listar() {

		ArrayList<Categorias> listaCategorias = new ArrayList<Categorias>();

		try {
			Connection conexao = new Conexao().getConexao();

			ResultSet result = conexao
					.prepareStatement("SELECT * FROM categorias order by dataCadastroCategorias DESC")
					.executeQuery();

			Categorias categorias;

			while (result.next()) {
				categorias = new Categorias();

				categorias.setPessoa(result.getString("pessoa"));
				categorias.setCarro(result.getString("carro"));
				categorias.setCidadeEstadoPais(result.getString("cidadeEstadoPais"));
				categorias.setFruta(result.getString("fruta"));
				categorias.setObjeto(result.getString("objeto"));
				categorias.setAnimal(result.getString("animal"));

				listaCategorias.add(categorias);
			}
			conexao.close();
		} catch (SQLException e) {
		} finally {
		}
		return listaCategorias;
	}

	public boolean inserir(Categorias a) {
		int valor = 0;
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao
					.prepareStatement("INSERT INTO categorias (pessoa, carro, cidadeEstadoPais, fruta, objeto, animal) VALUES (?, ?);");

			result.setString(1, a.getPessoa());
			result.setString(2, a.getCarro());
			result.setString(3, a.getCidadeEstadoPais());
			result.setString(4, a.getFruta());
			result.setString(5, a.getObjeto());
			result.setString(6, a.getAnimal());

			valor = result.executeUpdate();
			conexao.close();
		} catch (Exception e) {

		}

		if (valor == 1)
			return true;
		else
			return false;

	}

	public void deletar(int id) {
		try {

			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao.prepareStatement("DELETE FROM categorias WHERE id = ?;");

			result.setInt(1, id);

			result.executeUpdate();

			conexao.close();
		} catch (Exception e) {

		}
	}

	public boolean update(Categorias a) {
		int valor = 0;
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao
					.prepareStatement("UPDATE categorias SET pessoa = ?, carro =?, carro =cidadeEstadoPais, fruta =?, objeto =?, animal =? WHERE id = ?");

			result.setString(1, a.getPessoa());
			result.setString(2, a.getCarro());
			result.setString(3, a.getCidadeEstadoPais());
			result.setString(4, a.getFruta());
			result.setString(5, a.getObjeto());
			result.setString(6, a.getAnimal());

			valor = result.executeUpdate();
			conexao.close();
		} catch (Exception e) {

		}

		if (valor == 1)
			return true;
		else
			return false;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
