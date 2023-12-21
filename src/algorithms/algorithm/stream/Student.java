package algorithms.algorithm.stream;

public class Student {

    private final Long identity;
    private final String name;
    private final Major major;
    private final int grade;

    public Student(Long identity,
                   String name,
                   Major major,
                   int grade) {
        this.identity = identity;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public boolean isSameIdentity(Long identity) {
        return this.identity.equals(identity);
    }

    public boolean isSameMajor(Major major) {
        return this.major.equals(major);
    }

    public int getGrade() {
        return this.grade;
    }
}