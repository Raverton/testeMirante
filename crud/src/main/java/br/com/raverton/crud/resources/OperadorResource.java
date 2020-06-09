package br.com.raverton.crud.resources;

import java.util.Arrays;
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

import br.com.raverton.crud.dto.OperadorDTO;
import br.com.raverton.crud.ejb.OperadorEJB;
import br.com.raverton.crud.entity.Operador;
import br.com.raverton.crud.entity.Perfil;
import br.com.raverton.crud.utils.ModelMapperUtil;

@Path("operador")
public class OperadorResource {
	
	private static ModelMapperUtil mapper = new ModelMapperUtil();
	
	@Inject
	OperadorEJB service;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<OperadorDTO> listar(){
		
		List<Operador> operadores = service.listar();
	
		return (List<OperadorDTO>) mapper.convert(operadores, new TypeToken<List<OperadorDTO>>(){}.getType());
		
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void salvar(OperadorDTO dto){
		
		service.salvar((Operador)mapper.convert(dto, Operador.class));
	}
	
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public OperadorDTO obterPorId(@PathParam("id") Long id){
		
		return (OperadorDTO)mapper.convert(service.obterPorId(id), OperadorDTO.class);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(OperadorDTO dto){
		
		service.atualizar((Operador)mapper.convert(dto, Operador.class));
		
	}
	
	@Path("/{id}")
	@DELETE
	public void excluirPorId(@PathParam("id") Long id){
		
		service.excluir(id);
	}
	

}


