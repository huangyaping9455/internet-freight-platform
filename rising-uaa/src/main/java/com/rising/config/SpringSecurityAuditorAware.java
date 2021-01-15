package com.rising.config;

import com.rising.rbac.domain.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@Slf4j
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof AnonymousAuthenticationToken) {
                return Optional.of("HSystem");
            } else {
                if (authentication == null) {
                    return Optional.of("HSystem");
                }
                Admin user = (Admin) authentication.getPrincipal();
                return Optional.of(user.getUsername());
            }
        } catch (Exception ex) {
            log.error("get user Authentication failed: " + ex.getMessage(), ex);
            return Optional.of("HSystem");
        }
    }
}