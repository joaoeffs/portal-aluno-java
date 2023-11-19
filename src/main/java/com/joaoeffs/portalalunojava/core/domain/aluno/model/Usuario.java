package com.joaoeffs.portalalunojava.core.domain.aluno.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.joaoeffs.portalalunojava.infra.role.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "uuid"))
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "matricula")
    private String matricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    Usuario(UsuarioBuilder builder) {
        this.id = requireNonNull(builder.id);
        this.nome = builder.nome;
        this.sobrenome = builder.sobrenome;
        this.dataNascimento = builder.dataNascimento;
        this.email = requireNonNull(builder.email);
        this.senha = requireNonNull(builder.senha);
        this.matricula = builder.matricula;
        this.role = builder.role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_PROFESSOR"));

        if (this.role == Role.PROFESSOR)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_PROFESSOR"));

        return List.of(new SimpleGrantedAuthority("ROLE_ALUNO"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
