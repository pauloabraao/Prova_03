package apresentacao;

import negocio.Participante;
import persistencia.ParticipanteDAO;

public class Main {

	public static void main(String[] args) {
	
		
		Participante p1 = new Participante();
		ParticipanteDAO dao = new ParticipanteDAO();

		p1.setNome("Paulo");
		p1.setPontuacao(12);
		
		if(dao.inserir(p1)) {
			System.out.println("Cadastro realizado");
		}else {
			System.out.println("Operação não realizada");
		}
		
	
		p1 = dao.listarPorId(1);
		
		//lista apena um participante por id
		System.out.println("id: "+ p1.getId() +
		" nome: "+ p1.getNome() +
		" pontuacao: "+ p1.getPontuacao());
		
		
		//lista todos os participantes
		for (Participante p : dao.listar()) {
			System.out.println("id: "+ p.getId() +
			" nome: "+ p.getNome() +
			" pontuacao: "+ p.getPontuacao());
		}

		//inserir um participante
		Participante p2 = new Participante();
		p2.setNome("Pedro");
		p2.setPontuacao(10);
				
		if(dao.inserir(p2)) {
			System.out.println("Cadatro realizado");
		}else {
			System.out.println("operaco nao realizada");
		}
		
		//listar todos os participantes
		for (Participante p : dao.listar()) {
			System.out.println("id: "+ p.getId() +
			" nome: "+ p.getNome() +
			" pontuacao: "+ p.getPontuacao());
		}
		
		
		//deletar um participante
	//	dao.deletar(6);
		
		System.out.println("Apos deletar");
		for (Participante p : dao.listar()) {
			System.out.println("id: "+ p.getId() +
			" nome: "+ p.getNome() +
			" pontuacao: "+ p.getPontuacao());
		}
		
		//atualizar um participante
		p2.setId(5);
		p2.setNome("Antonio");
		dao.update(p2);
	}

}
