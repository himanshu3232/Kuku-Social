package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@EnableWebSecurity // Enable Spring Security
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for API security (optional, consider if needed)
                .cors().configurationSource(corsConfigurationSource()) // CORS configuration (optional)
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/api/**").authenticated() // Require authentication for /api/** endpoints
                        .anyRequest().permitAll() // Allow all other requests
                )
                .exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint(unauthorizedHandler()) // Custom unauthorized handler (optional)
                )
                .securityContext(securityContext -> securityContext
                        .securityContextRepository(securityContextRepository()) // Custom security context repository (optional)
                )
                // Add authentication providers (e.g., in-memory, database, JWT)
                .and()
                .httpBasic(); // Enable HTTP Basic authentication

        // Consider form login if needed (optional):
        // http.formLogin();

        return http.build();
    }

    // Implement custom beans for unauthorizedHandler, securityContextRepository, and authentication providers

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // Configure CORS settings here
        return new UrlBasedCorsConfigurationSource(RequestMatcher.anyRequest());
    }
}
