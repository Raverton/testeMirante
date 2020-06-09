package br.com.raverton.crud;

import org.junit.Test;
import org.modelmapper.TypeToken;

import br.com.raverton.crud.dto.OperadorDTO;
import br.com.raverton.crud.entity.Operador;
import br.com.raverton.crud.utils.ModelMapperUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

public class ModelMapperUtilTest {

	ModelMapperUtil mapper;
	
	@Before
	public void setUp(){
		mapper = new ModelMapperUtil();
	}
	
	@Test
	public void testConverterEntidadeParaDTO(){
		
		Operador origem = new Operador();
		origem.setNome("raverton");
		
		OperadorDTO dto = (OperadorDTO) mapper.convert(origem, OperadorDTO.class);
		
		Assert.assertEquals(origem.getNome(), dto.getNome());
	}
	
	@Test
	public void testConverterDTOParaEntidade(){
		
		OperadorDTO origem = new OperadorDTO();
		origem.setNome("raverton");
		
		Operador entidade = (Operador) mapper.convert(origem, Operador.class);
		
		Assert.assertEquals(origem.getNome(), entidade.getNome());
	}
	
	@Test
	public void testConverterListaEntidadeParaListaDTO(){
		
		List<Operador> operadors = new ArrayList<>();
		
		Operador operador = new Operador();
		operador.setNome("raverton");
		
		operadors.add(operador);
		
		List<OperadorDTO> operadorsDTO = (List<OperadorDTO>) mapper.convert(operadors, new TypeToken<List<OperadorDTO>>(){}.getType());
		
		int size = operadorsDTO.size();
		
		Assert.assertTrue(size > 0);
		
		Assert.assertEquals(operador.getNome(), operadorsDTO.get(0).getNome());
		
	}
	
	@Test
	public void testConverterListaDTOParaListaEntidade(){
		
		List<OperadorDTO> dtos = new ArrayList<>();
		
		OperadorDTO dto = new OperadorDTO();
		dto.setNome("raverton");
		
		dtos.add(dto);
		
		List<Operador> operadors = (List<Operador>) mapper.convert(dtos, new TypeToken<List<Operador>>(){}.getType());
		
		int size = operadors.size();
		
		Assert.assertTrue(size > 0);
		
		Assert.assertEquals(dto.getNome(), operadors.get(0).getNome());
		
	}
}
