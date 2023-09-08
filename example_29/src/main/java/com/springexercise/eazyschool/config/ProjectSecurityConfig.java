package com.springexercise.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        //PermitAll
        http.csrf().disable().
                authorizeHttpRequests()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("","/","/home").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/saveMessage").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/assets/**").permitAll().
                and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();
        return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager (){
        UserDetails admin = User.withDefaultPasswordEncoder().
                username("admin").password("12345").roles("admin").build();
        UserDetails user1 = User.withDefaultPasswordEncoder().username("user1")
                .password("12345").roles("user").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("user2")
                .password("12345").roles("user").build();
        return new InMemoryUserDetailsManager(admin,user1,user2);
    }
}
