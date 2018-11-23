package com.primetgi.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.primetgi.org.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private DataSource dataSource;

	public ContactDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void saveOrUpdateContact(Contact contact) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if (contact.getId() > 0) {
			// update
			String sql = "UPDATE tbl_contact SET name=?, email=?, address=?, " + "telephone=? WHERE contactId=?";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
					contact.getTelephone(), contact.getId());
		} else {
			// insert
			String sql = "INSERT INTO tbl_contact (name, email, address, telephone)" + " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
					contact.getTelephone());
		}
	}

	@Override
	public void deleteContact(int contactId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM tbl_contact WHERE contactId = ?";
		jdbcTemplate.update(sql, contactId);
	}

	@Override
	public Contact getContactDetails(int contactId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM tbl_contact WHERE contactId = " + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Contact contact = new Contact();
					contact.setId(rs.getInt("contactId"));
					contact.setName(rs.getString("name"));
					contact.setEmail(rs.getString("email"));
					contact.setAddress(rs.getString("address"));
					contact.setTelephone(rs.getString("telephone"));
					return contact;
				}
				return null;
			}

		});
	}

	@Override
	public List<Contact> listAllContacts() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM tbl_contact";

		List<Contact> listOfContacts = jdbcTemplate.query(sql, new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt("contactId"));
				contact.setName(resultSet.getString("name"));
				contact.setEmail(resultSet.getString("email"));
				contact.setAddress(resultSet.getString("address"));
				contact.setTelephone(resultSet.getString("telephone"));
				return contact;
			}

		});
		return listOfContacts;
	}

}
