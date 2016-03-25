/**
 * 
 */
package com.fanjavaid.web;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fanjavaid.model.Document;
import com.fanjavaid.service.DocumentService;

/**
 * @author fanjavaid
 *
 */
@Controller
@RequestMapping ( "/document" )
public class DocumentWebController {

	private final Log log = LogFactory.getLog(DocumentWebController.class.getName());
	
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping ( method = RequestMethod.GET )
	public String index() {
		return "index";
	}
	
	@RequestMapping ( value = "/list", method = RequestMethod.GET )
	public String list(ModelMap model) {
		List<Document> documents = documentService.getAllDocuments();
		model.addAttribute("documents", documents);
		
		return "list";
	}
	
	@RequestMapping ( value = "/{id}/show", method = RequestMethod.GET )
	public String show(@PathVariable ("id") String id, ModelMap model) {
		Document document  = documentService.getDocumentById(id);
		model.addAttribute("document", document);
		
		log.info("Get " + document);
		
		return "show";
	}
	
	@RequestMapping ( value = "/create", method = RequestMethod.GET )
	public String create(ModelMap model) {
		model.addAttribute("document", new Document());
		
		return "create";
	}
	
	@RequestMapping ( value = "/create", method = RequestMethod.POST )
	public String store(@Valid Document document, Errors errors) {
		if (errors.hasErrors()) {
			return "create";
		}
		
		documentService.addNewDocument(document);
		return "redirect:/document/list";
	}
}
