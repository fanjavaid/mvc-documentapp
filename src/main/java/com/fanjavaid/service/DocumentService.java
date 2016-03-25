/**
 * 
 */
package com.fanjavaid.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanjavaid.dao.DocumentDao;
import com.fanjavaid.model.Document;

/**
 * @author fanjavaid
 *
 */
@Service
public class DocumentService {
	@Autowired
	private DocumentDao dao;

	public DocumentService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentService(DocumentDao dao) {
		super();
		this.dao = dao;
	}

	public DocumentDao getDao() {
		return dao;
	}

	public void setDao(DocumentDao dao) {
		this.dao = dao;
	}
	
	// Services
	public List<Document> getAllDocuments() {
		List<Document> documents = dao.fetchAll();
		
		return documents;
	}
	
	public Document getDocumentById(String id) {
		Document document = dao.fetchById(id);
		
		return document;
	}
	
	public void addNewDocument(Document document) {
		document.setCreatedAt(new Date());
		dao.insert(document);
	}
	
}
