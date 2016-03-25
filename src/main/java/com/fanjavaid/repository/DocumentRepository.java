/**
 * 
 */
package com.fanjavaid.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.fanjavaid.dao.DocumentDao;
import com.fanjavaid.model.Document;

/**
 * @author fanjavaid
 *
 */
@Repository
public class DocumentRepository implements DocumentDao {

	private static List<Document> documents = new ArrayList<Document>();
	
	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.DocumentDao#fetchAll()
	 */
	public List<Document> fetchAll() {
		// TODO Auto-generated method stub
		return documents;
	}

	/* (non-Javadoc)
	 * @see com.fanjavaid.dao.DocumentDao#fetchById(java.lang.String)
	 */
	public Document fetchById(String id) {
		// TODO Auto-generated method stub
		Document result = null;
		for (Document document : documents) {
			if (document.getId().equals(id)) {
				result = document;
			}
		}
		
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

	public void insert(Document document) {
		// TODO Auto-generated method stub
		documents.add(document);
	}
	
}
