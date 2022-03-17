package com.olix.order_system.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exit_table")
public class Exit implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private OffsetDateTime exitDateTime;
	@OneToMany(mappedBy = "exit", fetch = FetchType.EAGER)
	private List<ExitItem> exitItems = new ArrayList<ExitItem>();

	public Exit() {

	}

	public Exit(Long id, OffsetDateTime exitDateTime) {
		super();
		this.id = id;
		this.exitDateTime = exitDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getExitDateTime() {
		return exitDateTime;
	}

	public void setExitDateTime(OffsetDateTime exitDateTime) {
		this.exitDateTime = exitDateTime;
	}

	public List<ExitItem> getExitItems() {
		return exitItems;
	}

	public void setExitItems(List<ExitItem> exitItems) {
		this.exitItems = exitItems;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exit other = (Exit) obj;
		return Objects.equals(id, other.id);
	}

}
