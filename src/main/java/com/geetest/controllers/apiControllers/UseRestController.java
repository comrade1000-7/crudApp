package com.geetest.controllers.apiControllers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UseRestController implements RowMapper<UseRestController.User> {
    private final NamedParameterJdbcOperations jdbcOperations;

    public UseRestController(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("c_username"));
    }

    record User(int id, String name) {}

    @GetMapping
    public List<User> findAllUsers() {
        return jdbcOperations.query("select * from t_users", this);
    }


}
