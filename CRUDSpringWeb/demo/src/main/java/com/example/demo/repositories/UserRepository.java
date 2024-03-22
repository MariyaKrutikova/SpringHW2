package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

import static javax.swing.UIManager.getInt;
import static javax.swing.UIManager.getString;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    /** удаление пользователя по ID */
    public void deleteById(int id) {
        String sqlDelete = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sqlDelete, id);
    }

//    public void update (User user) {
//        String sqlUpdate = "UPDATE userTable SET firstName = ? lastName =? WHERE id = ?";
//        jdbc.update(sqlUpdate, user.getFirstName(), user.getLastName(), user.getId());
//    }

}
