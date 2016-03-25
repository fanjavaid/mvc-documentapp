/**
 * 
 */
package com.fanjavaid.dao;

import java.util.List;
import com.fanjavaid.model.Document;

/**
 * @author fanjavaid
 *
 */
public interface DocumentDao {
	List<Document> fetchAll();
	Document fetchById(String id);
	void insert(Document document);
}
