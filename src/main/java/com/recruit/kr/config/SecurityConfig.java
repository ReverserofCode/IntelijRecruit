package com.recruit.kr.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Log4j2
@Configuration
@EnableWebSecurity
public class SecurityConfig  {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("------------------------------------filterChain-----------------------------");
        http.authorizeRequests((auth) -> {
//           모두 공개
            auth.antMatchers("/all").permitAll();
            auth.antMatchers("/login.html").permitAll();
            auth.antMatchers("/assets/**").permitAll();
            auth.antMatchers("/images/**").permitAll();
//           회원 공개
            auth.antMatchers("/member").hasRole("USER");
            auth.antMatchers("/ProjectInsert").hasRole("USER");

//           관리자 공개
            auth.antMatchers("/admin").hasRole("ADMIN");
        });

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess")
                .defaultSuccessUrl("/")
        ;
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index.html")
                .deleteCookies("JSESSIONID", "remember-me")
        ;
        //위에 deleteCookies는 주석 처리해도 돌아가지만 기왕이면 있는게 나을거 같아서 남겨 놓음

        http.csrf().disable();
//        http.exceptionHandling()
//                .accessDeniedHandler();

        return http.build();
    }

}
