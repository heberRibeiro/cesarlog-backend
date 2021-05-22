package com.unit.cesarlog.domain;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer branchId;
	private Integer projectId;
	private Integer equipmentStatusId;
	private Integer equipmentTypeId;
	private String tipping;
	private String specification;
	private String serie;
	private String detail;
	private Double latitude;
	private Double longitude;
	private Date coordinateUpdate;
	private Date statusUpdate;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	public Equipment() {

	}

	public Equipment(Integer branchId, Integer projectId, Integer equipmentStatusId,
			Integer equipmentTypeId, String tipping, String specification, String serie, String detail, Double latitude,
			Double longitude, Date coordinateUpdate, Date statusUpdate) {
		this.branchId = branchId;
		this.projectId = projectId;
		this.equipmentStatusId = equipmentStatusId;
		this.equipmentTypeId = equipmentTypeId;
		this.tipping = tipping;
		this.specification = specification;
		this.serie = serie;
		this.detail = detail;
		this.latitude = latitude;
		this.longitude = longitude;
		this.coordinateUpdate = coordinateUpdate;
		this.statusUpdate = statusUpdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getEquipmentStatusId() {
		return equipmentStatusId;
	}

	public void setEquipmentStatusId(Integer equipmentStatusId) {
		this.equipmentStatusId = equipmentStatusId;
	}

	public Integer getEquipmentTypeId() {
		return equipmentTypeId;
	}

	public void setEquipmentTypeId(Integer equipmentTypeId) {
		this.equipmentTypeId = equipmentTypeId;
	}

	public String getTipping() {
		return tipping;
	}

	public void setTipping(String tipping) {
		this.tipping = tipping;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
	
	public Date getStatusUpdate() {
		return statusUpdate;
	}

	public void setStatusUpdate(Date statusUpdate) {
		this.statusUpdate = statusUpdate;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Dados do Equipamento\n");
		builder.append("Especificação: ");
		builder.append(specification);
		builder.append(", serie: ");
		builder.append(serie);
		builder.append(", detalhe: ");
		builder.append(detail);
		builder.append("\n");
		builder.append("data da última atualização de status: ");
		builder.append(sdf.format(statusUpdate));
		return builder.toString();
	}
	
}
