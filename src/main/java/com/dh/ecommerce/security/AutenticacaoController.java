package com.dh.ecommerce.security;

import com.dh.ecommerce.entity.dto.TokenDTO;
import com.dh.ecommerce.entity.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        try {
            UsernamePasswordAuthenticationToken loginUsuario = usuarioDTO.converter();
            Authentication authentication =  authManager.authenticate(loginUsuario);

            String token = tokenService.gerarToken(authentication);
            TokenDTO tokenDTO = new TokenDTO();
            tokenDTO.setToken(token);
            tokenDTO.setTipo("Bearer");

            return new ResponseEntity(tokenDTO, HttpStatus.OK);
        }catch (AuthenticationException e){
            return new ResponseEntity("Erro ao autenticar", HttpStatus.BAD_REQUEST);
        }
    }
}
