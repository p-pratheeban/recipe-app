package com.pratheeban.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pratheeban.commands.UnitOfMeasureCommand;
import com.pratheeban.domain.UnitOfMeasure;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";

	UnitOfMeasureCommandToUnitOfMeasure converter;

	@Before
	public void setUp() throws Exception {
		converter = new UnitOfMeasureCommandToUnitOfMeasure();
	}

	@Test
	public void testNullParamter() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasureCommand()));
	}

	@Test
	public void testConvert() throws Exception {
		// given
		UnitOfMeasureCommand command = new UnitOfMeasureCommand();
		command.setId(ID_VALUE);
		command.setDescription(DESCRIPTION);

		// when
		UnitOfMeasure uom = converter.convert(command);

		// then
		assertNotNull(uom);
		assertEquals(ID_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());
	}

}
