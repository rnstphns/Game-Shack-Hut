package edu.miu.cs.cs425.eregistrarwebapi.security;

import edu.miu.cs.cs425.eregistrarwebapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsService")
@Transactional
public class AuthUserDetailService implements UserDetailsService {
    private final UserRepository userRepo;

    public AuthUserDetailService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(username);
        var userDetails = new AuthUserDetail(user);
        return userDetails;
    }
}