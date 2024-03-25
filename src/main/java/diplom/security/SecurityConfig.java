package diplom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/api/teachers/**").hasAnyAuthority("TEACHER", "ADMIN")
                        .requestMatchers("/api/students/**").hasAnyAuthority("STUDENT", "ADMIN")
                        .requestMatchers("/api/lessons/**").hasAnyAuthority("STUDENT", "TEACHER", "ADMIN")
                        .requestMatchers("/api/grades/**").hasAnyAuthority("STUDENT, TEACHER, ADMIN")
                        .requestMatchers("/api/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/users/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                )
                .build();
    }
}
