package cstk.chisato.config;

import cstk.chisato.security.JdbcTemplateUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate){
        return new JdbcTemplateUserDetailService(jdbcTemplate);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity
                .authorizeHttpRequests(reg -> {
                    //注册页和接口放行
                    reg.requestMatchers( "/register").permitAll();
                    reg.requestMatchers(HttpMethod.GET, "/page/login").permitAll();
                    reg.anyRequest().authenticated();
                })
                .formLogin()
                .loginPage("/page/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/page/index", true)
                .failureUrl("/page/login?error=true")
                .and()
                .build();
    }

}
