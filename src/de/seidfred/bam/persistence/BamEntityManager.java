package de.seidfred.bam.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BamEntityManager {

	private static final String PERSISTENCE_UNIT = "BAM";

	public final static BamEntityManager INSTANCE = new BamEntityManager();

	private EntityManager em;

	private BamEntityManager() {
		// Exists only to defeat instantiation.
	}

	public EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT)
					.createEntityManager();
		}
		return em;
	}
}
