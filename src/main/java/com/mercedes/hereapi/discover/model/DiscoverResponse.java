package com.mercedes.hereapi.discover.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscoverResponse implements Comparable<DiscoverResponse>{

	private String title;
	private String id;
	private String resultType;
	private String localityType;
	private Position position;
	private Double distance;
	private List<Categ> categories;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public String getLocalityType() {
		return localityType;
	}
	public void setLocalityType(String localityType) {
		this.localityType = localityType;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public List<Categ> getCategories() {
		return categories;
	}
	public void setCategories(List<Categ> categories) {
		this.categories = categories;
	}
	@Override
	public int compareTo(DiscoverResponse discoverResponse) {

		if(distance==discoverResponse.distance)  
			return 0;  
		else if(distance>discoverResponse.distance)  
			return 1;  
		else  
			return -1;  
	}
}
