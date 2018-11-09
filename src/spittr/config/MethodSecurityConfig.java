//package spittr.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
//import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//
//import spittr.security.SpitterPermissionEvaluator;
//
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
//	@Override
//	protected MethodSecurityExpressionHandler createExpressionHandler() {
//		DefaultMethodSecurityExpressionHandler eh = new DefaultMethodSecurityExpressionHandler();
//		eh.setPermissionEvaluator(new SpitterPermissionEvaluator());
//		return eh;
//	}
//}
