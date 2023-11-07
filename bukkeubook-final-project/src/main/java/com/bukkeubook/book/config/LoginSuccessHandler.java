package com.bukkeubook.book.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.bukkeubook.book.member.model.dto.UserImpl;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UserImpl user = (UserImpl) authentication.getPrincipal();
		String url = "";
		if(user.getEmpEndYn().equals("Y")) {
			url="/common/leaveMember";
			request.getSession().setAttribute("message", "퇴사한 사원입니다.");
			HttpSession session = request.getSession();
			session.removeAttribute("login");
			session.invalidate();
			
			
			Cookie cookie = new Cookie("JSESSIONID", null);
		    cookie.setMaxAge(0);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		} else {
			url="/main";
		}
		response.sendRedirect(url);
	}

}
