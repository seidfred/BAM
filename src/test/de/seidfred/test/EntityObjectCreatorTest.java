package de.seidfred.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EntityObjectCreatorTest {

	@Test
	public void testSimpleEntity() {
		EntityObjectCreator<SimpleTestEntity> temp = new EntityObjectCreator<SimpleTestEntity>(
				new BasicDatataypeAttributeValues());
		SimpleTestEntity tempSimpleObject = temp.createObjectFor(SimpleTestEntity.class);
		assertNotNull(tempSimpleObject);
		assertTrue(tempSimpleObject instanceof SimpleTestEntity);
	}
}
