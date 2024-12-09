import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import com.vyogalin.resume_tailor_backend.models.AppUser;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Optional<AppUser> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<AppUser> getAllUsers(String email) {
        return userRepository.findAll();
    }

    // public AppUser registerUser(AppUser user) {
    //     // Save user with hashed password
    //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     return userRepository.save(user);
    // }

    public AppUser registerUserRaw(String username, String email, String password) {
        userRepository.findByUsername(username).ifPresent(user -> {
            throw new RuntimeException("User already exists!");
        });

        AppUser user = new AppUser(username, email, password);

        // Save user with hashed password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}