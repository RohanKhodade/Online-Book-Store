package com.example.Online.Book.Store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled=true)
public class SecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails= User.withUsername("rohan")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER").build();
//        UserDetails userDetailsTwo=User.withUsername("ronnie")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER").build();
//        UserDetails userDetailsThree=User.withUsername("Admin")
//                .password(passwordEncoder().encode("adminOne"))
//                .roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(userDetails,userDetailsTwo,userDetailsThree);
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.csrf(csrfCustomizer->csrfCustomizer.disable());
        httpSecurity.authorizeHttpRequests(requests->
                requests.requestMatchers("/welcome","/userInfo/createUser").permitAll()
                        .anyRequest().authenticated());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(session->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }
}
