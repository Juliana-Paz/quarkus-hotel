package br.unitins.topicos2.ano2024.resource;

import br.unitins.topicos2.ano2024.dto.PromocaoDTO;
import br.unitins.topicos2.ano2024.dto.PromocaoResponseDTO;
import br.unitins.topicos2.ano2024.service.PromocaoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/promocoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PromocaoResource {

    @Inject
    PromocaoService promocaoService;

    @GET
    public Response getAll(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        try {
            return Response.ok().entity(promocaoService.getAll(page, pageSize)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(PromocaoDTO promocaoDTO) {
        return Response.ok().entity(promocaoService.create(promocaoDTO)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(PromocaoDTO dto, @PathParam("id") Long id) {
        PromocaoResponseDTO retorno = promocaoService.update(id, dto);
        return Response.ok(retorno).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        promocaoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(promocaoService.findById(id)).build();
    }

    @GET
    @Path("/count")
    public Response countPromocoes() {
        try {
            long count = promocaoService.count();
            return Response.ok().entity(count).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
