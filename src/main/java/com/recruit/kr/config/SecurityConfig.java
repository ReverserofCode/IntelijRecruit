package com.recruit.kr.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Log4j2
@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("------------------------------------filterChain-----------------------------");
        http.authorizeRequests((auth)->{
           auth.antMatchers("/all").permitAll();
           auth.antMatchers("/member").hasRole("USER");
           auth.antMatchers("/admin").permitAll();
           auth.antMatchers("/login.html").permitAll();
           auth.antMatchers("/assets/**").permitAll();
           auth.antMatchers("/images/**").permitAll();
        });

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess")
                .defaultSuccessUrl("/")
        ;
        http.logout();

        http.csrf().disable();
        return http.build();
    }
}
