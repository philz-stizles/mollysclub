package com.devdezyn.mollysclub;

import com.devdezyn.mollysclub.auth.models.UserPrincipal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockCustomUserSecurityContextFactory
    implements WithSecurityContextFactory<WithMockCustomUser> {
    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        UserPrincipal principal =
                new UserPrincipal(
                        customUser.id(),
                        customUser.name(), 
                        customUser.username(), 
                        customUser.email(), 
                        customUser.password(), 
                        null
                );
        Authentication auth =
            new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities());
        context.setAuthentication(auth);
        return context;
    }
}