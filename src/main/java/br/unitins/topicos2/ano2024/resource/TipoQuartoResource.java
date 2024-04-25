package br.unitins.topicos2.ano2024.resource;

import br.unitins.topicos2.ano2024.dto.TipoQuartoDTO;
import br.unitins.topicos2.ano2024.dto.TipoQuartoResponseDTO;
import br.unitins.topicos2.ano2024.service.TipoQuartoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/tipoquartos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoQuartoResource {

    @Inject
    TipoQuartoService tipoQuartoService;

    @GET
    public Response getAll(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        try {
            return Response.ok().entity(tipoQuartoService.getAll(page, pageSize)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(TipoQuartoDTO tipoQuartoDTO) {
        return Response.ok().entity(tipoQuartoService.create(tipoQuartoDTO)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(TipoQuartoDTO dto, @PathParam("id") Long id) {
        TipoQuartoResponseDTO retorno = tipoQuartoService.update(id, dto);
        return Response.ok(retorno).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        tipoQuartoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(tipoQuartoService.findById(id)).build();
    }

    @GET
    @Path("/count")
    public Response countTipoQuartos() {
        try {
            long count = tipoQuartoService.count();
            return Response.ok().entity(count).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
