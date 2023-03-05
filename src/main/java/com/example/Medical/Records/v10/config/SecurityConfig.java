package com.example.Medical.Records.v10.config;

import com.example.Medical.Records.v10.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/appointments").hasAnyAuthority("ROLE_ADMIN" , "ROLE_GENERAL_PRACTITIONER", "ROLE_PHYSICIAN", "ROLE_PATIENT")
                .antMatchers("/patients").hasAnyAuthority("ROLE_ADMIN" , "ROLE_GENERAL_PRACTITIONER", "ROLE_PHYSICIAN")
                .antMatchers("/physicians").hasAnyAuthority("ROLE_ADMIN" , "ROLE_GENERAL_PRACTITIONER", "ROLE_PHYSICIAN")
                .antMatchers("/diagnosis").hasAnyAuthority("ROLE_ADMIN" , "ROLE_GENERAL_PRACTITIONER", "ROLE_PHYSICIAN")
                .antMatchers("/sick-leaves").hasAnyAuthority("ROLE_ADMIN" , "ROLE_GENERAL_PRACTITIONER", "ROLE_PHYSICIAN")
                .antMatchers("/treatments").hasAnyAuthority("ROLE_ADMIN" , "ROLE_GENERAL_PRACTITIONER", "ROLE_PHYSICIAN")
                .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
                .antMatchers("/register", "/login").anonymous().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/unauthorized")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();
        return http.build();
    }
}
