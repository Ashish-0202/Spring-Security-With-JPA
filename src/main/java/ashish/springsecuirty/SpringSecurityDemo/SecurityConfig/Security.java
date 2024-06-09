package ashish.springsecuirty.SpringSecurityDemo.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select username,password,enabled from users where username=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery( "SELECT u.username, a.authority " +
                "FROM users u " +
                "JOIN authorities a ON u.user_id = a.user_id " +
                    "WHERE u.username = ?");

        return jdbcUserDetailsManager;
    }
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails userDetails=User.withUsername("Ashish").password("{noop}Ashu@2002").roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
                customize->customize.
                        requestMatchers(HttpMethod.GET,"/api/get")
                        .hasRole("ADMI/")
                        .requestMatchers(HttpMethod.POST,"/api/post")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/getUser").hasRole("ADMIN")
        );

        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

    }
}
