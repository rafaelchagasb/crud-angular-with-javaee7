package br.com.rafaelchagasb.crud.resources;

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

import br.com.rafaelchagasb.crud.dto.ClienteDTO;
import br.com.rafaelchagasb.crud.ejb.ClienteEJB;
import br.com.rafaelchagasb.crud.entity.Cliente;
import br.com.rafaelchagasb.crud.utils.ModelMapperUtil;

@Path("cliente")
public class ClienteResource {
	
	private static ModelMapperUtil mapper = new ModelMapperUtil();
	
	@Inject
	ClienteEJB service;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<ClienteDTO> listar(){
		
		List<Cliente> clientes = service.listar();
		
		return (List<ClienteDTO>) mapper.convert(clientes, new TypeToken<List<ClienteDTO>>(){}.getType());
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void salvar(ClienteDTO dto){
		
		service.salvar((Cliente)mapper.convert(dto, Cliente.class));
	}
	
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ClienteDTO obterPorId(@PathParam("id") Long id){
		
		return (ClienteDTO)mapper.convert(service.obterPorId(id), ClienteDTO.class);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(ClienteDTO dto){
		
		service.atualizar((Cliente)mapper.convert(dto, Cliente.class));
		
	}
	
	@Path("/{id}")
	@DELETE
	public void excluirPorId(@PathParam("id") Long id){
		
		service.excluir(id);
	}
	
}
