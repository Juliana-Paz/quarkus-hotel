package br.unitins.topicos2.ano2024.resource;

import br.unitins.topicos2.ano2024.dto.QuartoDTO;
import br.unitins.topicos2.ano2024.service.QuartoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/quartos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuartoResource {

    @Inject
    QuartoService quartoService;

    @GET
    public Response getAll(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        return Response.ok().entity(quartoService.getAll(page, pageSize)).build();
    }

    @POST
    public Response create(QuartoDTO quartoDTO) {
        try {
            return Response.ok().entity(quartoService.create(quartoDTO)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, QuartoDTO quartoDTO) {
        return Response.ok().entity(quartoService.update(id, quartoDTO)).build();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        quartoService.delete(id);
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(quartoService.findById(id)).build();
    }

    @GET
    @Path("/count")
    public Response countUsers() {
        try {
            long count = quartoService.count();
            return Response.ok().entity(count).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}