package br.com.alura.repository;

import br.com.alura.entity.Usuario;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
}
