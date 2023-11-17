package com.joaoeffs.portalalunojava.infra.security;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.core.annotation.CurrentSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@CurrentSecurityContext(expression = "authentication.principal.id")
public @interface CurrentUser {
}
