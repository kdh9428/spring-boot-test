package xyz.dahun.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;
import xyz.dahun.domain.AccountDto;
import xyz.dahun.security.token.AjaxAuthenticationToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public AjaxLoginProcessingFilter() {
        super(new AntPathRequestMatcher("/api/login"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if (!ajax(request)){
            throw new IllegalStateException("Authentication is not supported");
        }

        AccountDto accountDto = objectMapper.readValue(request.getReader(), AccountDto.class);

        Optional<AccountDto> optionalAccountDto = Optional.ofNullable(accountDto);

        boolean a = accountDto.getUsername() == null;
        System.out.println(a);
//        System.out.println(optionalAccountDto.get().getUsername()+" : "+ optionalAccountDto.get().getPassword()+" : "+optionalAccountDto.get().getUsername().isBlank());

//        optionalAccountDto.orElseThrow(() -> new IllegalArgumentException("Username or Password is Blank"));

//        optionalAccountDto.filter(o -> !o.getUsername().isBlank() || !o.getPassword().isBlank()).orElseThrow(() -> new IllegalArgumentException("Username or Password is Empty"));
    optionalAccountDto.filter(o -> o.getUsername().isBlank()).orElseThrow(IllegalAccessError::new);
        if (StringUtils.isEmpty(accountDto.getUsername()) ||StringUtils.isEmpty(accountDto.getPassword())){
            throw new IllegalStateException("error!!!");
        }

        AjaxAuthenticationToken ajaxAuthenticationToken = new AjaxAuthenticationToken(optionalAccountDto.get().getUsername(), optionalAccountDto.get().getPassword());

        return getAuthenticationManager().authenticate(ajaxAuthenticationToken);
    }

    private boolean ajax(HttpServletRequest request) {
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-with"))){
            return true;
        }
        return false;
    }
}
