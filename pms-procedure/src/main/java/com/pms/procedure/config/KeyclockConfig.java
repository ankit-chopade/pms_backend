package com.pms.procedure.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pms.procedure.constants.PmsProcedureConstants;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Import(KeycloakSpringBootConfigResolver.class)
@CrossOrigin(origins = PmsProcedureConstants.PMS_CROSS_ORIGIN)

public class KeyclockConfig extends KeycloakWebSecurityConfigurerAdapter {
	/**
	 * Registers the KeycloakAuthenticationProvider with the authentication manager.
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		KeycloakAuthenticationProvider authenticationProvider = new KeycloakAuthenticationProvider();
		authenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
		auth.authenticationProvider(authenticationProvider);
	}

	/**
	 * Defines the session authentication strategy.
	 */
	@Bean
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.cors().disable();
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
//		.antMatchers("/allergy/**").hasAnyRole("patient","physician","nurse","admin")
		.anyRequest().permitAll();
	}
}