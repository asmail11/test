package org.capiskinserver.application.hair.dto;

import java.util.List;


public class CharacteristicDto extends PersistableElementDto {
	
	private String type;

	private String nature;

	private String texture;

	private String treatment;
	
	private String visual;

	private String problem;

	private String photo;

	private List<NeedsDto> needs;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getVisual() {
		return visual;
	}

	public void setVisual(String visual) {
		this.visual = visual;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<NeedsDto> getNeeds() {
		return needs;
	}

	public void setNeeds(List<NeedsDto> needs) {
		this.needs = needs;
	}
	
	
	

}
