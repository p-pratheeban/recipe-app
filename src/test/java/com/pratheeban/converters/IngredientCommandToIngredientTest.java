package com.pratheeban.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.pratheeban.commands.IngredientCommand;
import com.pratheeban.commands.UnitOfMeasureCommand;
import com.pratheeban.domain.Ingredient;
import com.pratheeban.domain.Recipe;


public class IngredientCommandToIngredientTest {

	public static final Recipe RECIPE = new Recipe();
	public static final BigDecimal AMOUNT = new BigDecimal("1");
	public static final String DESCRIPTION = "Cheeseburger";
	public static final Long ID_VALUE = 1L;
	public static final Long UOM_ID = 2L;

	IngredientCommandToIngredient converter;

	@Before
	public void setUp() throws Exception {
		converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new IngredientCommand()));
	}

	@Test
	public void testConvert() throws Exception {
		// given
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);
		UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
		unitOfMeasureCommand.setId(UOM_ID);
		command.setUom(unitOfMeasureCommand);

		// when
		Ingredient ingredient = converter.convert(command);

		// then
		assertNotNull(ingredient);
		assertNotNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
		assertEquals(UOM_ID, ingredient.getUom().getId());
	}

	@Test
	public void convertWithNullUOM() throws Exception {
		// given
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);

		// when
		Ingredient ingredient = converter.convert(command);

		// then
		assertNotNull(ingredient);
		assertNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
	}

}
