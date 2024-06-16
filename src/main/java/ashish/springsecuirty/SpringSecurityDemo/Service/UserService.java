package ashish.springsecuirty.SpringSecurityDemo.Service;

import ashish.springsecuirty.SpringSecurityDemo.Entity.authorities;
import ashish.springsecuirty.SpringSecurityDemo.Entity.users;
import ashish.springsecuirty.SpringSecurityDemo.Repository.AuthorityRepository;
import ashish.springsecuirty.SpringSecurityDemo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Transactional
    public String addUser(users user){
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        users tmpuser=userRepository.save(user);
        for(authorities authority: user.getAuthorities()) {
            authority.setUsers(user);
            authorityRepository.save(authority);
        }

        return "User Created Successfully";
    }

    public List<users> getUsers(){
        return userRepository.findAll();
    }

    public Optional<users> getUserbyid(int id){
        Optional<users> user=userRepository.findById(id);

        return user;
    }
}
