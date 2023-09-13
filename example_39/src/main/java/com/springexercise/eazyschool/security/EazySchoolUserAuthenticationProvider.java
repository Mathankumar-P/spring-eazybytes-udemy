package com.springexercise.eazyschool.security;

import com.springexercise.eazyschool.model.Person;
import com.springexercise.eazyschool.model.Roles;
import com.springexercise.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EazySchoolUserAuthenticationProvider  implements AuthenticationProvider {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Person person = personRepository.readByEmail(email);
        if( null!= person && person.getPerson_id()>0 &&  passwordEncoder.matches(pwd,person.getPwd())){
            return new UsernamePasswordAuthenticationToken(person.getName(), null, getGrantedAuthority(person.getRoles()));
        } else {
            throw new BadCredentialsException("Invalid Credentials");
        }
    }

    private List<? extends GrantedAuthority> getGrantedAuthority(Roles roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
