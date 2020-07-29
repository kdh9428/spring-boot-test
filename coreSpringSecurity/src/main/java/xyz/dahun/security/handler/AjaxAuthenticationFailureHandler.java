package xyz.dahun.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        objectMapper.writeValue(response.getWriter(),errorMessageHandler(exception));

    }

    public String errorMessageHandler(AuthenticationException exception){

        String errorMessage = "Invalid Username or Password";
        if (exception instanceof BadCredentialsException){
            return "Invalid Username or Password";
        }else if (exception instanceof DisabledException){
            return "Locked";
        }else if (exception instanceof CredentialsExpiredException){
            return "Expired password";
        }else if(exception instanceof InsufficientAuthenticationException){
            return "아이디 또는 비밀번호가 Null입니다.";
        }
        return errorMessage;
    }
}
