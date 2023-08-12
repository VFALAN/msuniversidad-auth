package com.vf.dev.msuniversidadauth.conf.security;

import com.vf.dev.msuniversidadauth.conf.filters.JwtFilter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
@Slf4j
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Value("${msunivesidad.version}")
    private String VERSION;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //"/msuniversidad-auth/api/authentification"

        http.csrf().disable();
        http.addFilterAfter(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().antMatchers("/api/authentification/*", "/api/menu/*")
                .permitAll().anyRequest().authenticated().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //   http.cors().configurationSource(corsConfigurationSource());
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedOrigin("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        log.info("INICANDO MSUNIVESRSIDAD-AUTH VERSION: " + this.VERSION);

        return new BCryptPasswordEncoder();
    }

    @Bean
    public Filter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
