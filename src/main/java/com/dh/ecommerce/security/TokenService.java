package com.dh.ecommerce.security;

import com.dh.ecommerce.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {


    //Aqui usamos @Value para buscar as variaveis que estão no nosso application.properties
    @Value("${ecommerce.jwt.expiration}")
    private String expiracao;
    @Value("${ecommerce.jwt.secret}")
    private String secret;
    public String gerarToken(Authentication authentication) {
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        Date dataHoje = new Date();
        Date dataExpiracao = new Date(dataHoje.getTime() + Long.parseLong( this.expiracao));
        String token = Jwts.builder()
                //Setamos a origem do token
                .setIssuer("Api DH Ecommerce")
                //Setamos um valor unico para o token que no caso é nosso username
                .setSubject(usuarioLogado.getUsername())
                //Setamos a data de criação do token
                .setIssuedAt(dataHoje)
                //Setamos a data de expiração do token
                .setExpiration(dataExpiracao)
                //Setamos o metodo de criptografia e a secret que ira gerar o token
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
        return token;
    }

    public boolean vefiricaToken(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getUsernameUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        String username =  claims.getSubject();
        return username;
    }
}
