package com.pratheeban.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pratheeban.commands.NotesCommand;
import com.pratheeban.domain.Notes;

public class NotesToNotesCommandTest {

	public static final Long ID_VALUE = 1L;
	public static final String RECIPE_NOTES = "Notes";

	NotesToNotesCommand converter;

	@Before
	public void setUp() throws Exception {
		converter = new NotesToNotesCommand();
	}

	@Test
	public void testNull() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new Notes()));
	}

	@Test
	public void testConvert() throws Exception {
		// given
		Notes notes = new Notes();
		notes.setId(ID_VALUE);
		notes.setRecipeNotes(RECIPE_NOTES);

		// when
		NotesCommand notesCommand = converter.convert(notes);

		// then
		assertEquals(ID_VALUE, notesCommand.getId());
		assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
	}

}
