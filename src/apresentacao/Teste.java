package apresentacao;

import negocio.Participante;
import persistencia.ParticipanteDAO;

public class Teste {
	
	public static void main(String[] args) {
		ParticipanteDAO dao = new ParticipanteDAO();
		System.out.println(dao.listarPorId(12).getNome());
		Participante pedro = new Participante();
		pedro.setNome("Pedro");
		pedro.setPontuacao(1337);
		pedro.setId(87);
		dao.inserir(pedro);
		System.out.println(dao.listarPorId(87).getNome());
		
	}
}
