package com.ceyentra.spring.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.ceyentra.spring.security.security.ApplicationUSerPermission.COURSE_WRITE;
import static com.ceyentra.spring.security.security.ApplictaionUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE ,"/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.POST ,"/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.PUT ,"/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.GET ,"/management/api/**").hasAnyRole(ADMIN.name() , ADMINTRANEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails achira = User.builder()
                .username("achira")
                .password(encoder.encode("bablu"))
                .password("bablu")
                .roles(STUDENT.name())
                .build();

        UserDetails AdminUser = User.builder()
                .username("ekc")
                .password(encoder.encode("bablu"))
                .roles(ADMIN.name())
                .build();

        UserDetails AdminTraneeUser = User.builder()
                .username("sumi")
                .password(encoder.encode("bablu"))
                .roles(ADMINTRANEE.name())
                .build();


        return new InMemoryUserDetailsManager(
                achira,
                AdminUser,
                AdminTraneeUser
        );
    }
}
