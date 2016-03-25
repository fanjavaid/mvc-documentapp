/**
 * 
 */
package com.fanjavaid.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * @author fanjavaid
 *
 */
public class Document {
	@NotNull
	@Length(min=5, max=20, message="{id.length}")
	private String id;
	
	@NotNull
	@Size(min=5, max=200, message="{name.size}")
	private String name;
	
	private Date createdAt;
	
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(String id, String name, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", createdAt="
				+ createdAt + "]";
	}
	
}
