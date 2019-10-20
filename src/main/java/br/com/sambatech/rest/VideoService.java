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
import javax.ws.rs.core.Response.Status;

import br.com.sambatech.model.Estatistica;
import br.com.sambatech.model.Video;

@Path("")
public class VideoService {

	private static List<Video> videos = new ArrayList<Video>();

	@POST
	@Path("/videos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Video video) {
		String msg = "";
		Status status = null;
		long time_now = System.currentTimeMillis();
		
		if (time_now - video.getTimestamp() > 6000) {
			status = Response.Status.NO_CONTENT;
		}else {
			msg = "Criado com sucesso" + time_now;
			status = Response.Status.CREATED;
			videos.add(video);
		}
			
		return Response.status(status).entity(msg).build();
	}

	@GET
	@Path("/videos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Video> listarVideo() {

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
	
	@GET
	@Path("/statistics")
	@Produces(MediaType.APPLICATION_JSON)
	public Estatistica statistics(){
		
		Estatistica estatistica = new Estatistica();
		if (videos.size() == 0) {
			return null;
		}
		estatistica.calculaEstatistica(videos);
		
		return estatistica;
	}

}
