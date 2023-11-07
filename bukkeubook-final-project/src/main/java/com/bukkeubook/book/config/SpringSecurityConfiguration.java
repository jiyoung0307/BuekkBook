package com.bukkeubook.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bukkeubook.book.member.model.service.MemberService;


@EnableWebSecurity	//권한 설정 -> 설정파일이면서 시큐리티 설정(권한 및 경로 포함)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
//	WebSecurityConfigurerAdapter< Adapter는 인터페이스의 강제성 추상메소드를 오버라이드만 해놓은 아이.
//	내가 원하는 메소드만 재정의하여 사용가능
	
	private MemberService memberService;
	private AuthFailureHandler authFailureHandler;
	private LoginSuccessHandler loginSuccessHandler;
	@Autowired
	public SpringSecurityConfiguration(LoginSuccessHandler loginSuccessHandler, AuthFailureHandler authFailureHandler, MemberService memberService) {
		this.memberService = memberService;
		this.authFailureHandler = authFailureHandler;
		this.loginSuccessHandler = loginSuccessHandler;
	}
	
	
//	/* 1. 암호화 처리를 위한 PasswordEncoder를 Bean으로 설정 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	//빈등록만 해주면 알아서 비번 확인을 할 수 있다.
	}
	
	/* 2. 시큐리티 설정을 무시할 정적 리소스 등록 
	 *    resources안의 static 폴더 내부의 정적 리소스 요청 무시*/
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**","/js/**","/images/**","/lib/**");
	}
	
	/* 3. HTTP요청에 대한 권한 설정 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 
		http.csrf().disable()		
		    .authorizeRequests()	
//		        .antMatchers("/book/**").authenticated()							
		    	.antMatchers("/").permitAll()
		        .antMatchers("/book/**", "/order/**").hasAnyRole("BOOK", "MASTER")	
		        .antMatchers("/dept/**", "/manage/**").hasAnyRole("MANAGE", "MASTER")
		        .antMatchers("/main", "/mypage/**", "/attend/**", "/document/**", "/secretary/**", "/deptCommon/**").hasAnyRole("MANAGE", "FINANCE", "SECRETARY", "BOOK", "MASTER")
		        .anyRequest().permitAll()											
		    .and()	
		    	.formLogin()														
		    	.loginPage("/member/login")
		    	.successHandler(new LoginSuccessHandler())
		    	.failureHandler(authFailureHandler)
//		    	.successForwardUrl("/main")										
		    .and()	//로그아웃 페이지
		    	.logout()															
		    	.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))	
		    	.deleteCookies("JSESSIONID")										
		    	.invalidateHttpSession(true)										
		    	.logoutSuccessUrl("/")
		    	.clearAuthentication(true)
		    .and()	//에러 페이지
		    	.exceptionHandling()												
		    	.accessDeniedPage("/common/denied");								
				
	}
	
//	/* 4. 권한을 등록할 때 인증할 비즈니스 로직이 어떤것인지 등록(MemberService 계층에서 할 예정) */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
		
	}
	
}
