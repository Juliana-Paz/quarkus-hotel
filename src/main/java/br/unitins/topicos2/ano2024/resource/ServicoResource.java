package br.unitins.topicos2.ano2024.resource;

import br.unitins.topicos2.ano2024.dto.ServicoDTO;
import br.unitins.topicos2.ano2024.dto.ServicoResponseDTO;
import br.unitins.topicos2.ano2024.service.ServicoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/servicos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicoResource {

    @Inject
    ServicoService servicoService;

    @GET
    public Response getAll(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        try {
            return Response.ok().entity(servicoService.getAll(page, pageSize)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(ServicoDTO servicoDTO) {
        return Response.ok().entity(servicoService.create(servicoDTO)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(ServicoDTO dto, @PathParam("id") Long id) {
        ServicoResponseDTO retorno = servicoService.update(id, dto);
        return Response.ok(retorno).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        servicoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(servicoService.findById(id)).build();
    }

    @GET
    @Path("/count")
    public Response countServicos() {
        try {
            long count = servicoService.count();
            return Response.ok().entity(count).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
