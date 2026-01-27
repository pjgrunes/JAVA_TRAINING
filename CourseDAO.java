package M5.act.db.act3;
import M5.act.db.act3.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public int add(int studentId, String courseName, int grade) throws Exception {
        String sql = "INSERT INTO courses(student_id, course_name, grade) VALUES(?, ?, ?) RETURNING id";
        try (Connection con = App.get();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setString(2, courseName);
            ps.setInt(3, grade);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    public List<String> listJoined() throws Exception {
        String sql = "SELECT c.id, c.course_name, c.grade, s.name AS student_name FROM courses c JOIN students s ON s.id = c.student_id ORDER BY c.id";
        List<String> rows = new ArrayList<>();
        try (Connection con = App.get();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rows.add(String.format("%d | %s | %d | %s",
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getInt("grade"),
                        rs.getString("student_name")));
            }
        }
        return rows;
    }
}

