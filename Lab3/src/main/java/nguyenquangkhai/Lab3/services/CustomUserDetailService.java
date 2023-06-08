package nguyenquangkhai.Lab3.services;

import nguyenquangkhai.Lab3.entity.CustomUserDetail;
import nguyenquangkhai.Lab3.entity.User;
import nguyenquangkhai.Lab3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (username == null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user, userRepository);
    }
}
