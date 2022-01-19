package br.com.alura.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import lombok.*;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@UserDefinition
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;


    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public static void adicionar(Usuario usuario) {
        usuario.password = BcryptUtil.bcryptHash(usuario.password);
        usuario.role = validarUsername(usuario.username);
        persist(usuario);
    }

    public static String validarUsername(String username) {
        if(username.equals("alura")) {
            return "admin";
        } else {
            return "user";
        }
    }

}
