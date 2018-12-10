package lt.bta.java2.config;

import lt.bta.java2.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    // ******************************************************************************************************
    // kuo skiriasi roles nuo authorities: https://www.baeldung.com/spring-security-granted-authority-vs-role
    // ******************************************************************************************************

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        // ***********************************************************************************************
        // autorizacijos testavimui labai geras variantas yra tik atmintyje laikomi useriai (nereikia DB):
        // ***********************************************************************************************
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                    .password("$2a$12$TKuxelQEwWxmMGNBeSHwze4SvAKAMeWhIdDtlL88kZMb2olM6.0n2")
//                    //.authorities("ROLE_USER");
//                    .roles("USER");

        // **********************************************
        // realaus autentifikavimo pavyzdys naudojant JPA
        // **********************************************
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers( "/secure").access("hasRole('USER') or hasRole('ADMIN')")
                    .antMatchers("/admin").access("hasAnyAuthority('ROLE_ADMIN')")
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .permitAll();


        // ********************************************************************
        // galima naudoti ne tik Spring sugeneruota "login" langa, bet ir savo:
        // ********************************************************************
//                    .loginPage("/login")
//                    .usernameParameter("username").passwordParameter("password")
//                    .and()
//                .logout().logoutSuccessUrl("/login?logout");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}