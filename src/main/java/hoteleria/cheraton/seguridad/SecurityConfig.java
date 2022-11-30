package hoteleria.cheraton.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	protected void configure (HttpSecurity http) throws Exception
	{
		//http.csrf().disable();    
		
		http.authorizeHttpRequests()
			.antMatchers("/menu/inicio","/menu/galerias","/menu/nosotros","/menu/contactos","/menu/reservaciones").permitAll()
			.antMatchers("/menu/reservaciones/reservar/**")
				.hasAnyRole("CLIENTE")
			.antMatchers("/menu/mantenimiento/habitaciones/**","/menu/mantenimiento/tipoHabitaciones/**","/menu/mantenimiento/paises/**")
				.hasAnyRole("EMPLEADO")
			.antMatchers("/menu/mantenimiento/usuarios/**","/menu/mantenimiento/roles/**")
				.hasAnyRole("ADMINISTRADOR")
			
			.and()
				.formLogin()
				.loginPage("/login")
			.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/errores/403")
			;
		
		// muy importante para dar acceso a todas las paginas cuando no hemos iniciado sesion y aparte tenemos permiso
		http.sessionManagement()
        	.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
	}
}
