package pe.edu.upc.StartUp.Elec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean
	PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
	
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEnconder());		
		
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// Aqui realiza la configuración de los permisos
				.antMatchers("/*.js", "/*.css").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/receipts/**").access("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_CUSTOMER')")
				.antMatchers("/customers/**").access("hasRole('ROLE_ADMINISTRATOR')")
				.antMatchers("/benefits/**").access("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_CUSTOMER')")
				.antMatchers("/homes/**").access("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_CUSTOMER')")

				.antMatchers("/publications/**").access("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_EMPLOYEE')")
				.antMatchers("/employees/**").access("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_EMPLOYEE')")

			.and()
				.formLogin();
	}
	
	
}
