package com.github.roman1306.registry.configuration;

import com.github.roman1306.registry.dao.UserDao;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

/**
 * Настройка безопасности
 */
@SpringBootConfiguration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .and()
                .logout().logoutUrl("/logout")
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/register", "/actuator/**").permitAll()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(
                        "/resources/**",
                        "/static/**",
                        "/webjars/**",
                        "/img/**",
                        "/css/**",
                        "/js/**"
                );
    }


    private final UserDao userDao;

    public SecurityConfiguration(@NonNull UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this.userDao;
    }

    @Bean
    @Profile("!local")
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Profile("local")
    PasswordEncoder simplyPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return Objects.equals(rawPassword, encodedPassword);
            }
        };
    }
}
