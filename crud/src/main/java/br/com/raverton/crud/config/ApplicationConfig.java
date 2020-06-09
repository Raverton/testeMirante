package br.com.raverton.crud.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.raverton.crud.resources.OperadorResource;
import br.com.raverton.crud.resources.PessoaResource;

@ApplicationPath("servicos")
public class ApplicationConfig extends Application
{
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new HashSet<>();
		addRestResouceClasses(resources);
		return resources;
	}

	private void addRestResouceClasses(Set<Class<?>> resources) {
		resources.add(OperadorResource.class);
		resources.add(PessoaResource.class);
	}
	

	
}
