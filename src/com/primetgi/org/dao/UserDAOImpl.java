package com.primetgi.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.primetgi.org.model.User;

public class UserDAOImpl implements UserDAO {

	
	private DataSource dataSource;

	public UserDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> list() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * FROM tblPerson";

		List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
				User users = new User();
				users.setId(rs.getInt("ID"));
				users.setName(rs.getString("Name"));
				users.setEmailId(rs.getString("EmailId"));
				return users;
			}

		});
		return listUser;
	}

}
