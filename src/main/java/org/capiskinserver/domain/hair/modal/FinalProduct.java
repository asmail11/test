package org.capiskinserver.domain.hair.modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "finalProducts")
public class FinalProduct extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ContentMillimiter contentMillimiter;

	public FinalProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinalProduct(ContentMillimiter contentMillimiter) {
		super();
		this.contentMillimiter = contentMillimiter;
	}

	public ContentMillimiter getContentMillimiter() {
		return contentMillimiter;
	}

	public void setContentMillimiter(ContentMillimiter contentMillimiter) {
		this.contentMillimiter = contentMillimiter;
	}
	
	

}
