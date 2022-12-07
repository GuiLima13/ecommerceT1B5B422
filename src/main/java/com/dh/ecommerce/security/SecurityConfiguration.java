package com.dh.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    AutenticacaoViaTokenFilter autenticacaoViaTokenFilter;
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //Aqui cuidamos da parte de permissão de acesso
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                //Permitindo acesso apenas ao get de /produto
                .antMatchers(HttpMethod.GET,"/produto").permitAll()
                //Permitindo autenticação para todos
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                //.antMatchers(HttpMethod.GET, "/pedido").permitAll()
                //Bloqueando acesso a qualquer rota que não tenha sido mapeado acima
                .anyRequest().authenticated()
                //Abre um formulario de login
                //.and().formLogin();
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(autenticacaoViaTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    //Aqui cuidamos da parte de autenticação do acesso
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(autenticacaoService)
                    .passwordEncoder(new BCryptPasswordEncoder());
    }
}
