package com.ns.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 *
 */
@Entity
@Table(name = "RTRN_TP_RSN_CMBN")
public class RTRN_TP_RSN implements Serializable {

	private static final long serialVersionUID = 4677612728077605784L;

	@Id
	private RtrnTpRsnPk rtrnTpRsnPk;
	
	public RTRN_TP_RSN(){}

	public RtrnTpRsnPk getRtrnTpRsnPk() {
		return rtrnTpRsnPk;
	}

	public void setRtrnTpRsnPk(RtrnTpRsnPk rtrnTpRsnPk) {
		this.rtrnTpRsnPk = rtrnTpRsnPk;
	}

	public String toString() {
		return "RtrnTpRsnPk:" + this.rtrnTpRsnPk;
	}

}
