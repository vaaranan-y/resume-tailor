import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.vyogalin.resume_tailor_backend.models.AppUser;
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
        AppUser userEntity = userRepository.findByUsername(username);
        
        if (userEntity == null) {
            throw new UsernameNotFoundException("Unable to find user: " + username);
        }

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                null
        );
    }

    // public Optional<AppUser> getUserByUsername(String username) {
    //     return userRepository.findByUsername(username);
    // }

    // public List<AppUser> getAllUsers(String email) {
    //     return userRepository.findAll();
    // }

    // // public AppUser registerUser(AppUser user) {
    // //     // Save user with hashed password
    // //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    // //     return userRepository.save(user);
    // // }

    // public AppUser registerUserRaw(String username, String email, String password) {
    //     userRepository.findByUsername(username).ifPresent(user -> {
    //         throw new RuntimeException("User already exists!");
    //     });

    //     AppUser user = new AppUser(username, email, password);

    //     // Save user with hashed password
    //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     return userRepository.save(user);
    // }
}