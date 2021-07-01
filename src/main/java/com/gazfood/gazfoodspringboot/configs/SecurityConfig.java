package com.gazfood.gazfoodspringboot.configs;

import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                // Кассовые узлы
                .antMatchers("/casses").hasAnyRole("ADMIN", "IT")
                .antMatchers("/addNewCassa").hasAnyRole("ADMIN", "IT")
                .antMatchers("/updateCassa").hasAnyRole("ADMIN", "IT")
                .antMatchers("/saveCassa").hasAnyRole("ADMIN", "IT")
                .antMatchers("/deleteCassa").hasAnyRole("ADMIN", "IT")
                .antMatchers("/detailsCassa").hasAnyRole("ADMIN", "IT")
                .antMatchers("/casses/export/excel").hasAnyRole("ADMIN", "IT")

                .and()
                    .formLogin()
                .and()
                    .logout().logoutSuccessUrl("/");
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }


}
