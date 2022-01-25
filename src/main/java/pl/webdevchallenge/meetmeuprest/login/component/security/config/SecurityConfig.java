package pl.webdevchallenge.meetmeuprest.login.component.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.webdevchallenge.meetmeuprest.eventApp.component.MD5Encoder;
import pl.webdevchallenge.meetmeuprest.login.component.security.CustomAuthEntryPoint;
import pl.webdevchallenge.meetmeuprest.login.component.security.CustomAuthFailureHandler;
import pl.webdevchallenge.meetmeuprest.login.component.security.CustomAuthSuccessHandler;
import pl.webdevchallenge.meetmeuprest.login.component.security.CustomLogoutSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomAuthSuccessHandler customAuthSuccessHandler;
    private CustomAuthFailureHandler customAuthFailureHandler;
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;
    private CustomAuthEntryPoint customAuthEntryPoint;
    private DataSource dataSource;
    private MD5Encoder md5Encoder;

    @Autowired
    public SecurityConfig(CustomAuthSuccessHandler customAuthSuccessHandler, CustomAuthFailureHandler customAuthFailureHandler,
                          CustomLogoutSuccessHandler customLogoutSuccessHandler, CustomAuthEntryPoint customAuthEntryPoint,
                          DataSource dataSource, MD5Encoder md5Encoder) {
        super();
        this.customAuthSuccessHandler = customAuthSuccessHandler;
        this.customAuthFailureHandler = customAuthFailureHandler;
        this.customLogoutSuccessHandler = customLogoutSuccessHandler;
        this.customAuthEntryPoint = customAuthEntryPoint;
        this.dataSource = dataSource;
        this.md5Encoder = md5Encoder;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().headers().frameOptions().sameOrigin().and().authorizeRequests().antMatchers("/api/eventadmin/users/new").permitAll()
                .antMatchers("/api/**").authenticated().and().formLogin()
                .successHandler(customAuthSuccessHandler).failureHandler(customAuthFailureHandler)
                .usernameParameter("email").passwordParameter("password").permitAll().and().exceptionHandling()
                .authenticationEntryPoint(customAuthEntryPoint).and().logout().invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").logoutSuccessHandler(customLogoutSuccessHandler);
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select email, password, active from users where email=?")
                .authoritiesByUsernameQuery(
                        "select users.email from users .... "); //query to build
    }

    private PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return null;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return false;
            }
        };
    }
}
