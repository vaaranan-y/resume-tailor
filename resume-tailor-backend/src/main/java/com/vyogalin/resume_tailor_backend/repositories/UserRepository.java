import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.vyogalin.resume_tailor_backend.models.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
}