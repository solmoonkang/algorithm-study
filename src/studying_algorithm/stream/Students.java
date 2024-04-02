package studying_algorithm.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Student> findStudentsByName(String name) {
        return students.stream()
                .filter(s -> s.isSameName(name))
                .collect(Collectors.toList());
    }

    public List<Student> findStudentsByMajor(String majorName) {
        Major major = Major.findByMajorName(majorName);

        return students.stream()
                .filter(s -> s.isSameMajor(major))
                .collect(Collectors.toList());
    }

    public Map<Integer, Long> countStudentsByGrade() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
    }
}