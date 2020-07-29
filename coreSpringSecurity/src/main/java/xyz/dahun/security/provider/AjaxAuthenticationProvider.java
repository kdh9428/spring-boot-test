package xyz.dahun.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.dahun.domain.Account;
import xyz.dahun.security.service.AccountContext;
import xyz.dahun.security.token.AjaxAuthenticationToken;

import javax.transaction.Transactional;
import java.util.Optional;

public class AjaxAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();


        Optional<AccountContext> optionalAccount = Optional.ofNullable((AccountContext) userDetailsService.loadUserByUsername(username));

        AccountContext accountContext = optionalAccount.orElseThrow(() -> new IllegalArgumentException("AccountContext is Null"));

        if(!passwordEncoder.matches(password, accountContext.getPassword())){
            throw new BadCredentialsException("Password 인증 실패");
        }

        return new AjaxAuthenticationToken(accountContext.getAccount(), null, accountContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(AjaxAuthenticationToken.class);
    }
}
