package com.example.interviewskeleton.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String customToken = (String) authentication.getPrincipal();
        // Custom logic to validate the token
        return getValidationToken(customToken);
    }

    private Authentication getValidationToken(String customToken) {
        if (!customToken.equals("such-secure-much-wow"))
            throw new AuthenticationServiceException("Invalid authetication token");

        return new PreAuthenticatedAuthenticationToken(customToken, null, new ArrayList<>());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationToken.class.equals(authentication);
    }

}
