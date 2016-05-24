package de.seidfred.bam.dao;

import javax.persistence.EntityManager;

import de.seidfred.bam.persistence.BamEntityManager;

public class BamDAO {

	protected EntityManager em = BamEntityManager.INSTANCE.getEntityManager();

}
