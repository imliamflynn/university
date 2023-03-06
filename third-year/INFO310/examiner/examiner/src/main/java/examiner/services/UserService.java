package examiner.services;

import examiner.domain.Committee;
import examiner.domain.Student;
import examiner.domain.User;
import examiner.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository u) {
        this.userRepository = u;
    }

    public User registerUser(String username, String password) {
        if (username == null || password == null) {
            return null;
        } else {
            if (userRepository.findFirstByUsername(username).isPresent()) {
                System.out.println("Duplicate username");

                return null;
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            return userRepository.save(user);
        }
    }

    public void registerStudentUser(User user, Student student, Committee committee) {

        user.setStudent(student);
        student.setCommittee(committee);

        userRepository.save(user);
    }

    public User authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

    public User getUserById(Long id) {
        Optional<User> result = userRepository.findById(id);

        return result.get();
    }

}
