package M5.act.db.act3;
import M5.act.db.act3.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public int add(String name, int age, String email) throws Exception {
        String sql = "INSERT INTO students(name, age, email) VALUES(?, ?, ?) RETURNING id";
        try (Connection con = App.get();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    public List<String> list() throws Exception {
        String sql = "SELECT id, name, age, email FROM students ORDER BY id";
        List<String> rows = new ArrayList<>();
        try (Connection con = App.get();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rows.add(String.format("%d | %s | %d | %s",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")));
            }
        }
        return rows;
    }
}


