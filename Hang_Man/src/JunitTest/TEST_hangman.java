package JunitTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import HangMan.hangmanMethods;

class TEST_hangman {

	hangmanMethods ex1;

	@Test
	public void testStoreChar() {                  // Testing if storeChar method stores characters successfully
		
		hangmanMethods.word = "hi";               // The method in the main code stores a string in a character array , in main code the 
		                                         //method storeChar creates a new character array and add all characters from the string to an array

		ArrayList<Character> arr1 = new ArrayList<Character>();   // Creating a new a array and add the same elements to check if they are corresponding
		arr1.add('h');
		arr1.add('i');
		assertEquals(arr1, hangmanMethods.moveCharacterToArray());

	}

	@Test
	public void testGaps() {                    // Testing if gaps method represents gaps instead of characters
		hangmanMethods.arr.clear();             
		hangmanMethods.arr.add('h');            // adding characters 
		hangmanMethods.arr.add('h');
		hangmanMethods.arr.add('h');
		ArrayList<Character> actual = hangmanMethods.Gaps();
		ArrayList<Character> expected = new ArrayList<Character>();  // creating a new array and add the expected number of gaps
		expected.add('-');
		expected.add('-');
		expected.add('-');

		assertEquals(actual, expected);

	}

	@Test
	public void bugTest() {                              // bug method move you to the next level in the game
		hangmanMethods.arr.clear();               
		hangmanMethods.word = hangmanMethods.next(); 
		String a = hangmanMethods.word;
		String b = hangmanMethods.bug();

		assertEquals(b, a);                           // check if the word in the current level equals the word in the next level 

	}

}