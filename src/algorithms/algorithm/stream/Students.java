package algorithms.algorithm.stream;

import java.util.List;
import java.util.Optional;

public class Students {

    private final List<Student> students;

    public Students(List<Student> students) {
        this.students = students;
    }

    public Optional<Student> findStudentById(Long identity) {
        return students.stream()
                .filter(s -> s.isSameIdentity(identity))
                .findFirst();
    }
}