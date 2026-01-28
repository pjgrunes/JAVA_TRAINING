package M6_Act3;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", columnDefinition = "VARCHAR(50)", length = 50)
    private String courseName;

    @Column(name = "grade", columnDefinition = "VARCHAR(2)", length = 2)
    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // --- getters/setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
