package examiner.services;

import examiner.domain.Student;
import examiner.repositories.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository s;

    /**
     * using Autowired to automatically instantiate an implementation of
     * StudentRepository *
     */
    @Autowired
    public StudentService(StudentRepository s) {
        this.s = s;
    }

    public void registerStudent(Student student) {
        s.save(student);
    }

    public List<Student> getStudents() {
        return s.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> result = s.findById(id);

        return result.get();
    }

    public void deleteStudent(Long id) {
        s.deleteById(id);
    }
}
