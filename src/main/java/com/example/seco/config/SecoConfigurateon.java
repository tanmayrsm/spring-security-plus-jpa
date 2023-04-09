package com.example.seco.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.seco.service.UserService;

@Configuration
@EnableWebSecurity
public class SecoConfigurateon {
	
	@Autowired
	private UserService userService;
	
	@Bean
	public static BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(bCryptPasswordEncoder());
		return auth;
	}

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> {
				try {
					authz
						.requestMatchers("/registration**","/js/**","/css/**", "/img/**")
						.permitAll()
					    .anyRequest().authenticated()
					    // Specifically, the "/registration**","/js/**","/css/**", "/img/**" paths are configured to not require any authentication. All other paths must be authenticated.
					    .and().formLogin()
					    .loginPage("/login").permitAll()
					    // login page can be viewed by anyone
					    .and().logout()
					    .invalidateHttpSession(true).clearAuthentication(true)
					    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					    // "/logout" will logout user, and redirect him to "/login?logout"
					    .logoutSuccessUrl("/login?logout").permitAll();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
            )
            .httpBasic();
        
        http.authenticationProvider(authenticationProvider());
        
        return http.build();
    }

}
