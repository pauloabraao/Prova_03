package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import negocio.Participante;
import persistencia.Conexao;

public class ParticipanteDAO {

	public Participante listarPorId(int id) {

		Participante participante = new Participante();

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement sql = conexao.prepareStatement("select * from participantes where id=?");

			sql.setInt(1, id);

			ResultSet result = sql.executeQuery();

			while (result.next()) {
				participante.setNome(result.getString("nome"));
				participante.setPontuacao(result.getInt("pontuacao"));
			}

			conexao.close();

		} catch (Exception e) {
		}
		return participante;
	}

	public ArrayList<Participante> listar() {

		ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();

		try {
			Connection conexao = new Conexao().getConexao();

			ResultSet result = conexao
					.prepareStatement("SELECT * FROM participantes order by dataCadastroParticipante DESC")
					.executeQuery();

			Participante participante;

			while (result.next()) {
				participante = new Participante();

				participante.setNome(result.getString("nome"));
				participante.setPontuacao(result.getInt("pontuacao"));

				listaParticipantes.add(participante);
			}
			conexao.close();
		} catch (SQLException e) {
		} finally {
		}
		return listaParticipantes;
	}

	public boolean inserir(Participante a) {
		int valor = 0;
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao
					.prepareStatement("INSERT INTO participantes (id, nome, pontuacao) VALUES (?, ?, ?);");

			result.setInt(1, a.getId());
			result.setString(2, a.getNome());
			result.setInt(3, a.getPontuacao());
			valor = result.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (valor == 1)
			return true;
		else
			return false;

	}

	public void deletar(int id) {
		try {

			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao.prepareStatement("DELETE FROM participantes WHERE id = ?;");

			result.setInt(1, id);

			result.executeUpdate();

			conexao.close();
		} catch (Exception e) {

		}
	}

	public boolean update(Participante a) {
		int valor = 0;
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement result = conexao
					.prepareStatement("UPDATE participantes SET nome = ?, pontuacao =? WHERE id = ?");

			result.setString(1, a.getNome());
			result.setInt(2, a.getPontuacao());
			result.setInt(3, a.getId());

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
