package id.co.team8.librarymanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import id.co.team8.librarymanagement.service.UsersDetailService;

@Configuration
public class BasicSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UsersDetailService();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .csrf().disable()
            .httpBasic()
            .and()
            .authorizeRequests()
            .mvcMatchers(HttpMethod.GET, "/**").permitAll()
            .mvcMatchers(HttpMethod.POST, "/**").hasAuthority("admin")
            .mvcMatchers(HttpMethod.PUT, "/**").hasAuthority("admin")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();

            return http.build();
    }
}
