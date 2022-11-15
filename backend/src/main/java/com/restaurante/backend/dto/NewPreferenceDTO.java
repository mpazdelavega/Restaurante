package com.restaurante.backend.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class NewPreferenceDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accessToken;
    private List<PreferenceItem> items;
    
	public NewPreferenceDTO(String accessToken, List<PreferenceItem> items) {
		super();
		this.accessToken = accessToken;
		this.items = items;
	}
	public NewPreferenceDTO() {

	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public List<PreferenceItem> getItems() {
		return items;
	}
	public void setItems(List<PreferenceItem> items) {
		this.items = items;
	}
    
    

}
