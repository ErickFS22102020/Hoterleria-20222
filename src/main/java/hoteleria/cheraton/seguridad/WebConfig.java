package hoteleria.cheraton.seguridad;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registro)
	{
//		registro.addViewController("/").setViewName("moduloMenu/inicio");
//		registro.addViewController("/login").setViewName("moduloLogin/login");
		registro.addViewController("/errores/403").setViewName("moduloErrores/error403");
		
	}
}
