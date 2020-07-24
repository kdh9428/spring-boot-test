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

//        AccountDto accountDto = objectMapper.readValue(request.getReader(), AccountDto.class);


        Optional<AccountDto> accountDto = Optional.ofNullable(objectMapper.readValue(request.getReader(), AccountDto.class));
//        Optional<AccountDto> optionalAccountDto = Optional.ofNullable(accountDto);
        String username = accountDto.map(AccountDto::getUsername).orElseThrow(() -> new IllegalArgumentException("아이디 오류"));
        String password = accountDto.map(AccountDto::getPassword).orElseThrow(() -> new IllegalArgumentException("비밀번호 오류"));


//        Optional.ofNullable(accountDto.getUsername()).orElseThrow(() -> new IllegalArgumentException("아이디 오류"));


//        System.out.println(optionalAccountDto.get().getUsername()+" : "+ optionalAccountDto.get().getPassword()+" : "+optionalAccountDto.get().getUsername().isBlank());

//        optionalAccountDto.orElseThrow(() -> new IllegalArgumentException("Username or Password is Blank"));

//        optionalAccountDto.filter(o -> !o.getUsername().isBlank() || !o.getPassword().isBlank()).orElseThrow(() -> new IllegalArgumentException("Username or Password is Empty"));
//    optionalAccountDto.filter(o -> o.getUsername().isBlank()).orElseThrow(IllegalAccessError::new);
//        if (StringUtils.isEmpty(accountDto.getUsername()) ||StringUtils.isEmpty(accountDto.getPassword())){
//            throw new IllegalStateException("error!!!");
//        }

        AjaxAuthenticationToken ajaxAuthenticationToken = new AjaxAuthenticationToken(username, password);

        return getAuthenticationManager().authenticate(ajaxAuthenticationToken);
    }

    private boolean ajax(HttpServletRequest request) {
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-with"))){
            return true;
        }
        return false;
    }
}
