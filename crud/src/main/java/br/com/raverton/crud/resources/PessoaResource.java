package br.com.raverton.crud.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.modelmapper.TypeToken;

import br.com.raverton.crud.dto.PessoaDTO;
import br.com.raverton.crud.ejb.PessoaEJB;
import br.com.raverton.crud.entity.Pessoa;
import br.com.raverton.crud.utils.ModelMapperUtil;

@Path("pessoa")
public class PessoaResource {
private static ModelMapperUtil mapper = new ModelMapperUtil();
	
	@Inject
	PessoaEJB service;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<PessoaDTO> listar(){
		
		List<Pessoa> pessoas = service.listar();
	
		return (List<PessoaDTO>) mapper.convert(pessoas, new TypeToken<List<PessoaDTO>>(){}.getType());
		
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void salvar(PessoaDTO dto){
		
		service.salvar((Pessoa)mapper.convert(dto, Pessoa.class));
	}
	
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public PessoaDTO obterPorId(@PathParam("id") Long id){
		
		return (PessoaDTO)mapper.convert(service.obterPorId(id), PessoaDTO.class);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(PessoaDTO dto){
		
		service.atualizar((Pessoa)mapper.convert(dto, Pessoa.class));
		
	}
	
	@Path("/{id}")
	@DELETE
	public void excluirPorId(@PathParam("id") Long id){
		
		service.excluir(id);
	}
	

}
