package examiner.services;

import examiner.domain.Examiner;
import examiner.repositories.ExaminerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExaminerService {

    private final ExaminerRepository examinerRepository;

    @Autowired
    public ExaminerService(ExaminerRepository e) {
        this.examinerRepository = e;
    }

    public List<Examiner> getExaminers() {
        return examinerRepository.findAll();
    }

    public void insertorEditExaminer(Examiner e) {
        examinerRepository.save(e);
    }

    public Examiner getExaminerById(Long id) {
        Optional<Examiner> result = examinerRepository.findById(id);

        return result.get();
    }

    public void deleteExaminer(Long id) {
        examinerRepository.deleteById(id);
    }
}
