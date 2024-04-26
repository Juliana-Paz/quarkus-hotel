package br.unitins.topicos2.ano2024.resource;

import br.unitins.topicos2.ano2024.dto.AmenidadeDTO;
import br.unitins.topicos2.ano2024.dto.AmenidadeResponseDTO;
import br.unitins.topicos2.ano2024.service.AmenidadeService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/amenidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AmenidadeResource {

    @Inject
    AmenidadeService amenidadeService;

    @GET
    @Path("get-all-pagination")
    public Response getAll(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        try {
            return Response.ok().entity(amenidadeService.getAll(page, pageSize)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    @GET
    public Response getAll() {
        try {
            return Response.ok().entity(amenidadeService.getAll()).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response create(AmenidadeDTO amenidadeDTO) {
        return Response.ok().entity(amenidadeService.create(amenidadeDTO)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(AmenidadeDTO dto, @PathParam("id") Long id) {
        AmenidadeResponseDTO retorno = amenidadeService.update(id, dto);
        return Response.ok(retorno).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        amenidadeService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(amenidadeService.findById(id)).build();
    }

    @GET
    @Path("/count")
    public Response countAmenidades() {
        try {
            long count = amenidadeService.count();
            return Response.ok().entity(count).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
