package com.wxy.micro.config;

import com.wxy.micro.handler.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity /*内部含有@Configuration*/
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/user/**").hasAnyRole("USER","ADMIN","SYSTEMADMIN")
                .antMatchers("/admin/**").hasAnyRole("ADMIN","SYSTEMADMIN")
                .antMatchers("/system/**").hasRole("SYSTEMADMIN");

        http.formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http.csrf().disable();
    }
    //密码加密方式
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //自定义用户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("wang").password(new MyPasswordEncoder().encode("123456")).roles("SYSTEMADMIN");
        auth.inMemoryAuthentication().withUser("zhangsan").password(new MyPasswordEncoder().encode("123456")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("lisi").password(new MyPasswordEncoder().encode("123456")).roles("USER");


    }

}
