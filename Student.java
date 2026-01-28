package M6_Act3;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "age", columnDefinition = "INT")
    private Integer age;

    @Column(name = "email", unique = true, length = 100, columnDefinition = "VARCHAR(100)")
    private String email;

    @OneToMany(mappedBy = "student")
    private List<Course> courses = new ArrayList<>();

    // --- getters/setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    public void addCourse(Course c) {
        courses.add(c);
        c.setStudent(this);
    }

    public void removeCourse(Course c) {
        courses.remove(c);
        c.setStudent(null);
    }
}
