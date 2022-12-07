package com.dh.ecommerce;

import com.dh.ecommerce.entity.Usuario;
import com.dh.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Configuration
public class CreateUserRun implements ApplicationRunner {

    @Autowired
    UsuarioRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder brCrypt = new BCryptPasswordEncoder();

        //Criando usuario
        Usuario usuario = new Usuario();
        usuario.setPassword(brCrypt.encode("123456"));
        usuario.setUsername("Guilherme");

        repository.save(usuario);

    }
}
