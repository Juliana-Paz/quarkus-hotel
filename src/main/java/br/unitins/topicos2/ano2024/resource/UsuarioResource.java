package br.unitins.topicos2.ano2024.resource;

import br.unitins.topicos2.ano2024.dto.UsuarioDTO;
import br.unitins.topicos2.ano2024.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    UsuarioService usuarioService;

    @POST
    public Response criarNovoUsuario(UsuarioDTO usuarioDTO) {

        return Response.ok().entity(usuarioService.create(usuarioDTO)).build();
    }
    

}
