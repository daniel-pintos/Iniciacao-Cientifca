package br.ufpr.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufpr.dao.NotaDAO;
import br.ufpr.dao.NotaDAO.GerenicObject;
import br.ufpr.entidade.Nota;

@Path("/notas")
public class NotasService {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";

	private NotaDAO notaDAO;
	
	@PostConstruct
	private void init() {
		notaDAO = new NotaDAO();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Nota> listarNotas() {
		List<Nota> lista = null;
		try {
			lista = notaDAO.listarNotas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	@GET
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<GerenicObject> buscarNotaCliente(@PathParam("id") int idCliente){
		List<GerenicObject> lista = null;
		try {
			lista = notaDAO.buscarNotaPorIdCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNota(Nota nota) {
		String msg = "";

		System.out.println(nota.getIdNota());

		try {
			int idGerado = notaDAO.addNota(nota);
			msg = String.valueOf(idGerado);
		} catch (Exception e) {
			msg = "Erro ao add a nota!";
			e.printStackTrace();
		}

		return msg;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarNota(Nota nota, @PathParam("id") int idNota) {
		String msg = "";
		
		System.out.println(nota.getIdNota());
		
		try {
			notaDAO.editarNota(nota, idNota);
			msg = "Nota editada com sucesso!";
		} catch (Exception e) {
			msg = "Erro ao editar a nota!";
			e.printStackTrace();
		}
		
		return msg;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerNota(@PathParam("id") int idNota) {
		String msg = "";
		
		try {
			notaDAO.removerNota(idNota);
			
			msg = "Nota removida com sucesso!";
		} catch (Exception e) {
			msg = "Erro ao remover a nota!";
			e.printStackTrace();
		}
		
		return msg;
	}
	
}
