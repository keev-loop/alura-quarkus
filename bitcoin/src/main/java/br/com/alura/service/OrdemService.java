package br.com.alura.service;

import br.com.alura.entity.Ordem;
import br.com.alura.entity.Usuario;
import br.com.alura.repository.OrdemRepository;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;


    public List<Ordem> readAll() {
        return ordemRepository.listAll();
    }

    public void inserir(SecurityContext secutiryContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();

        if(!usuario.getUsername().equals(secutiryContext.getUserPrincipal().getName())) {
            throw new RuntimeException("O usuário logado é diferente do userId");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    
}