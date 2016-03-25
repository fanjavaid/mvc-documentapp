/**
 * 
 */
package com.fanjavaid.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fanjavaid.dao.DocumentDao;
import com.fanjavaid.model.Document;

/**
 * @author fanjavaid
 *
 */
@Repository
public class DocumentRepository implements DocumentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	private static List<Document> documents = new ArrayList<Document>();
	
	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.DocumentDao#fetchAll()
	 */
	public List<Document> fetchAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM document";
		List<Document> documents = jdbcTemplate.query(sql, new RowMapper<Document>() {

			public Document mapRow(ResultSet rs, int rownum)
					throws SQLException {
				// TODO Auto-generated method stub
				Document document = new Document();
				document.setId(rs.getString("id"));
				document.setName(rs.getString("name"));
				document.setCreatedAt(rs.getTimestamp("created_at"));
				
				return document;
			}
			
		});
		
		return documents;
	}

	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.DocumentDao#fetchById(java.lang.String)
	 */
	public Document fetchById(final String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM document WHERE id = ?";
		Document result = jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, id);
				ps.executeQuery();
			}
		}, new ResultSetExtractor<Document>() {

			public Document extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				Document document = null;
				if (rs.next()) {
					document = new Document();
					document.setId(rs.getString("id"));
					document.setName(rs.getString("name"));
					document.setCreatedAt(rs.getTimestamp("created_at"));
				}
				
				return document;
			}
			
		});
		
		return result;
	}

	/*
	private List<Document> storages() {
		Document d1 = new Document("1101", "Spring MVC Cookbook", new Date());
		Document d2 = new Document("1102", "JSTL in Action 4", new Date());
		Document d3 = new Document("1103", "Java 8.0 Recipes", new Date());
		Document d4 = new Document("1104", "Laravel 5.2", new Date());
		Document d5 = new Document("1105", "Kamasutra", new Date());
		
		documents.add(d1);
		documents.add(d2);
		documents.add(d3);
		documents.add(d4);
		documents.add(d5);
		
		return documents;
	}*/

	public void insert(final Document document) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO document VALUES (?, ?, now())";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Object>() {
			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, document.getId());
				ps.setString(2, document.getName());
				
				return ps.executeUpdate();
			}
		});
	}
	
}
