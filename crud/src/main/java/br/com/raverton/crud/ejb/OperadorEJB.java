package br.com.raverton.crud.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.raverton.crud.entity.Operador;

@Stateless
public class OperadorEJB {

	@PersistenceContext
	private EntityManager em;
	
	public void excluir(Long id) {
		
		em.remove(em.find(Operador.class, id));
		
	}

	public void salvar(Operador operador) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		operador.setDtCadastro(date);
		em.merge(operador);
		
	}

	public List<Operador> listar() {
		return em.createQuery("select c FROM Operador c").getResultList();
	}

	public void atualizar(Operador operador) {
		
		em.merge(operador);
		
	}

	public Operador obterPorId(Long id) {

		return em.find(Operador.class, id);
		
	}

}
