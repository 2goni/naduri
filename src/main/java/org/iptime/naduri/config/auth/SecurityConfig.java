package org.iptime.naduri.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//스프링 시큐리티 설정
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                        // anyMatchers() 안의 경로는 permiAll()로 누구든 호출가능
                        .authorizeRequests().antMatchers("/**", "/images/**", "/js/**").permitAll()
                        // 그외의 경로(anyRequest) 는 authenticated()로 로그인된 사람만 호출가능
                        .anyRequest().authenticated()
                .and()
                        // 로그아웃 성공시 logoutSuccessUrl 경로 호출
                        .logout().logoutSuccessUrl("/")
                .and()
                        // 로그인 성공시 customOAuth2UserService 제공
                        .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
