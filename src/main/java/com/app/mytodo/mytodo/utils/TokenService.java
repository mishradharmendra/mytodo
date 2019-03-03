package com.app.mytodo.mytodo.utils;

import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenService {

    public TokenService() {
        this.authTokenCache = new ConcurrentMapCache("authTokenCache");
    }

    private Cache authTokenCache;

    public String generateNewToken() {
        return UUID.randomUUID().toString();
    }

    public void store(String token, Authentication authentication) {
        authTokenCache.put(token, authentication);
    }

    public void clear(String token) {
        authTokenCache.evict(token);
    }

    public boolean contains(String token) {
        return authTokenCache.get(token) != null;
    }

    public Authentication retrieve(String token) {
        return (Authentication) authTokenCache.get(token).get();
    }
}
