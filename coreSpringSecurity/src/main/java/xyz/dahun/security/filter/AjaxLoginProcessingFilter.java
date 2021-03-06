package xyz.dahun.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import xyz.dahun.domain.dto.AccountDto;
import xyz.dahun.security.token.AjaxAuthenticationToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public AjaxLoginProcessingFilter(String ajaxURL) {
        super(new AntPathRequestMatcher(ajaxURL));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if (!ajaxVerification(request)){
            throw new IllegalStateException("Authentication method not supported:" + request.getMethod());
        }

//        Map<String,Object> map = new HashMap<>();
//        map = objectMapper.readValue(request.getReader(), new TypeReference<Map<String, Object>>() {
//        });
//        System.out.println(map.get("username"));
//
//        objectMapper.readValue(request.getReader(),AccountDto.class);

        Optional<AccountDto> accountDto = Optional.ofNullable(objectMapper.readValue(request.getReader(), AccountDto.class));
        String username = accountDto.map(AccountDto::getUsername).orElseThrow(() -> new InsufficientAuthenticationException("Username is null"));
        String password = accountDto.map(AccountDto::getPassword).orElseThrow(() -> new InsufficientAuthenticationException("Password is null"));

        AjaxAuthenticationToken ajaxAuthenticationToken = new AjaxAuthenticationToken(username, password);

        return getAuthenticationManager().authenticate(ajaxAuthenticationToken);
    }

    private boolean ajaxVerification(HttpServletRequest request) {
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            return true;
        }
        return false;
    }
}
