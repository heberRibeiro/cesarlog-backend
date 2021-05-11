package com.unit.cesarlog.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer repositoryId;
	private Integer statusId;
	private String code;
	private String tipping;
	private Integer projectId;
	private String specification;
	private Integer employeeId;
	private Double latitude;
	private Double longitude;
	private Date coordinateUpdate;
	private Date stausUpdate;
	private String detail;
	private String serie;
	
	public Equipment() {

	}

	

	public Equipment(Integer repositoryId, Integer statusId, String code, String tipping, Integer projectId,
			String specification, Integer employeeId, Double latitude, Double longitude, Date coordinateUpdate,
			Date stausUpdate, String detail, String serie) {
		super();
		this.repositoryId = repositoryId;
		this.statusId = statusId;
		this.code = code;
		this.tipping = tipping;
		this.projectId = projectId;
		this.specification = specification;
		this.employeeId = employeeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.coordinateUpdate = coordinateUpdate;
		this.stausUpdate = stausUpdate;
		this.detail = detail;
		this.serie = serie;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Integer repositoryId) {
		this.repositoryId = repositoryId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTipping() {
		return tipping;
	}

	public void setTipping(String tipping) {
		this.tipping = tipping;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getCoordinateUpdate() {
		return coordinateUpdate;
	}

	public void setCoordinateUpdate(Date coordinateUpdate) {
		this.coordinateUpdate = coordinateUpdate;
	}

	public Date getStausUpdate() {
		return stausUpdate;
	}

	public void setStausUpdate(Date stausUpdate) {
		this.stausUpdate = stausUpdate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
