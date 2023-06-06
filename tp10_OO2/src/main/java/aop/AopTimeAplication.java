package main.java.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import main.java.aop.domain.LoggingUser;
import main.java.aop.infraestructure.data.AgregarUserFake;

//@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopTimeAplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(ConfigurationAspect.class);
		// SpringApplication.run(AopTimeAplication.class, args);
		LoggingUser masUsers = (LoggingUser) contexto.getBean("LogginUser", new LoggingUser(new AgregarUserFake()));
		masUsers.loginUser(10);
		masUsers.loginUser(100);
		contexto.close();
	}

}
