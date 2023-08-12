package com.vf.dev.msuniversidadauth.util;

import com.google.gson.JsonObject;
import com.vf.dev.msuniversidadauth.model.entity.UsuarioEntity;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class jwtUtil {
    private static final String BEARER = "Bearer";
    @Value("${jwt.token.key}")
    private String SECRET;


    public String generarToken(String username, List<GrantedAuthority> authorityList) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(username).signWith(SignatureAlgorithm.HS256, SECRET);

        jwtBuilder.claim("authorities", authorityList.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return jwtBuilder.compact();
    }

    public String addAuthentification(UsuarioEntity usuario) {


        return Jwts.builder()
                .setSubject(usuario.getCorreo())
                .claim("idUsuario", usuario.getIdUsuario())
                .claim("estatus", usuario.getEstatus().getIdEstatus())
                .claim("perfil", usuario.getPerfil().getIdPerfil()).signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }

    public boolean validToken(String token) throws MsUniversidadException {
        boolean isValido = false;
        try {
            String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJwt(token.replace(BEARER, "")).getBody().getSubject();
            if (user != null) {
                isValido = true;
            }
            return isValido;
        } catch (ExpiredJwtException e) {
            throw new MsUniversidadException("Token expirado", "20001");
        }
    }


    public Claims getAuthentication(HttpServletRequest request, HttpServletResponse response) {

        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(BEARER, ""))
                    .getBody().getSubject();
            return user != null ? Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(BEARER, "").trim()).getBody() : null;
        }
        return null;
    }
}
