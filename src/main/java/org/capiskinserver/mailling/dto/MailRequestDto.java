package org.capiskinserver.mailling.dto;


import lombok.Data;

@Data
public class MailRequestDto {
	
	private String name;
	private String to;
	public String from;
	public String subject;
	  
}