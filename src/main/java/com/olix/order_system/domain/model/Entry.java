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

@Entity
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private OffsetDateTime entryDateTime;
	@OneToMany(mappedBy = "entry", fetch = FetchType.EAGER)
	private List<EntryItem> entryItems = new ArrayList<EntryItem>();

	public Entry() {
	}

	public Entry(Long id, OffsetDateTime entryDateTime) {
		super();
		this.id = id;
		this.entryDateTime = entryDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getEntryDateTime() {
		return entryDateTime;
	}

	public void setEntryDateTime(OffsetDateTime entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	public List<EntryItem> getEntryItems() {
		return entryItems;
	}

	public void setEntryItems(List<EntryItem> entryItems) {
		this.entryItems = entryItems;
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
		Entry other = (Entry) obj;
		return Objects.equals(id, other.id);
	}

}
