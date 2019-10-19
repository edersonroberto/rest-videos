package br.com.sambatech.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.sambatech.modelo.Video;

@Path("")
public class VideoService {

	private static List<Video> videos = new ArrayList<Video>();

	@POST
	@Path("/videos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Video video) {
		String msg = "Criado com sucesso";
		videos.add(video);
		return Response.status(Response.Status.CREATED).entity(msg).build();
	}

	@GET
	@Path("/videos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Video> listarNota() {

		return videos;
	}

	@DELETE
	@Path("/videos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete() {
		String msg = "Todos os videos removidos com sucesso";
		videos = new ArrayList<Video>();
		return Response.status(Response.Status.NO_CONTENT).entity(msg).build();
	}

}
