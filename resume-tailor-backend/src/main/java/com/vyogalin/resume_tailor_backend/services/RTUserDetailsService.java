import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.vyogalin.resume_tailor_backend.models.RTUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.vyogalin.resume_tailor_backend.repositories.RTUserRepository;

@Service
public class RTUserDetailsService {
    @Autowired
    private RTUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public RTUserDetailsService(RTUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RTUser userEntity = userRepository.findByUsername(username);
        
        if (userEntity == null) {
            throw new UsernameNotFoundException("Unable to find user: " + username);
        }

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                null
        );
    }

    // public Optional<RTUser> getUserByUsername(String username) {
    //     return userRepository.findByUsername(username);
    // }

    // public List<RTUser> getAllUsers(String email) {
    //     return userRepository.findAll();
    // }

    // // public RTUser registerUser(RTUser user) {
    // //     // Save user with hashed password
    // //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    // //     return userRepository.save(user);
    // // }

    // public RTUser registerUserRaw(String username, String email, String password) {
    //     userRepository.findByUsername(username).ifPresent(user -> {
    //         throw new RuntimeException("User already exists!");
    //     });

    //     RTUser user = new RTUser(username, email, password);

    //     // Save user with hashed password
    //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     return userRepository.save(user);
    // }
}