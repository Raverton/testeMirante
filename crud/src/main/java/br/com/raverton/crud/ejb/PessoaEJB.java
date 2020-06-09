package br.com.raverton.crud.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.raverton.crud.entity.Pessoa;
@Stateless
public class PessoaEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void excluir(Long id) {
		
		em.remove(em.find(Pessoa.class, id));
		
	}

	public void salvar(Pessoa pessoa) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println(formatter.format(pessoa.getDtNacimento()));
		//Pessoa.setDtCadastro(date);
		em.merge(pessoa);
		
	}

	public List<Pessoa> listar() {
		return em.createQuery("select c FROM Pessoa c").getResultList();
	}

	public void atualizar(Pessoa Pessoa) {
		
		em.merge(Pessoa);
		
	}

	public Pessoa obterPorId(Long id) {

		return em.find(Pessoa.class, id);
		
	}
}
