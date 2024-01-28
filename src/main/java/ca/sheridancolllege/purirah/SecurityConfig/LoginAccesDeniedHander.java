package ca.sheridancolllege.purirah.SecurityConfig;

import java.io.IOException;



import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginAccesDeniedHander implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         
         if(auth != null) {
        	 System.out.println(auth.getName()+
        			 " was trying to access resource: " +
        			 request.getRequestURL()
        			 );
         }
         response .sendRedirect(request.getContextPath() + "/denied");
	}

}
