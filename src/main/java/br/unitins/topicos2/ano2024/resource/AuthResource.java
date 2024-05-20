package br.unitins.topicos2.ano2024.resource;

import br.unitins.topicos2.ano2024.dto.AuthUsuarioDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;
import br.unitins.topicos2.ano2024.service.HashService;
import br.unitins.topicos2.ano2024.service.HashServiceImpl;
import br.unitins.topicos2.ano2024.service.JwtService;
import br.unitins.topicos2.ano2024.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    HashService hashService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JwtService jwtService;

    @POST
    public Response login(AuthUsuarioDTO authDTO) {
        try {
            UsuarioResponseDTO user = usuarioService.findByEmailAndSenha(authDTO.email(), authDTO.senha());
            return Response.ok().header("Authorization", jwtService.generateJwt(user)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }

    public static void main(String[] args) {
        HashService h = new HashServiceImpl();
        String hash = h.getHashSenha("111");
        System.out.println(hash);
    }

}
