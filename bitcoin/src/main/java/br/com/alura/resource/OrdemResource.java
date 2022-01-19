package br.com.alura.resource;

import br.com.alura.entity.Ordem;
import br.com.alura.repository.OrdemRepository;
import br.com.alura.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@Path("/ordens")
public class OrdemResource {


    @Inject
    OrdemService ordemService;


    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> readAll() {
        return ordemService.readAll();
    }


    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext secutiryContext, Ordem ordem) {
        ordemService.inserir(secutiryContext, ordem);
    }


}
