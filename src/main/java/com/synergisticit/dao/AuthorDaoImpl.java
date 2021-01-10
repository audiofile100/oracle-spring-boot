package com.synergisticit.dao;

import com.synergisticit.domain.Author;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    private JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Author> findAll() {

        String sql = "SELECT * FROM AUTHOR";

        List authorList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Author>>() {
            @Override
            public List<Author> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Author> list = new ArrayList<>();
                while (resultSet.next()) {
                    Author author = new Author();
                    author.setAuthorId(resultSet.getString(1));
                    author.setLName(resultSet.getString(2));
                    author.setFName(resultSet.getString(3));
                    list.add(author);
                }
                return list;
            }
        });

        return authorList;
    }
}
