package com.devdezyn.mollysclub;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.test.context.support.WithSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface WithMockCustomUser {

    long id() default 1L;

    String name() default "mockName";

    String username() default "mockUsername";

    String email() default "mockuser@email.test";

    String password() default "mockPassword";
}
