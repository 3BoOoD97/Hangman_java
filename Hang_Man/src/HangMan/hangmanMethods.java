package HangMan;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class hangmanMethods {

	public static ArrayList<Character> arr = new ArrayList<Character>();

	public static ArrayList<Character> Spaces = new ArrayList<Character>();
	public static int setlevel = 0;

	public static String word;
	public static int level = 0;
	public static boolean runoff = false;
	static Scanner scan = new Scanner(System.in);

	public static void menu() {
		System.out.println("Press 1 :  Start a new game");
		System.out.println("Press 2 :  Change the level");
		System.out.println("Press 0 :  Exit the game ");

		int s = scan.nextInt();

		if (s > 2 && s < 0) {
			System.out.println("Enter a right value");

			menu();
		} else if (s == 1) {
			level = -1;
			next();
			check();
		}

		else if (s == 2) {
			for (int i = 0; i > -1; i++) {
				System.out.println("Choose a level between 0-5");
				char lvl = scan.next().charAt(0);

				if (lvl >= '0' && lvl <= '5') {
					int input = lvl - '0';
					;
					level = input - 1;
					System.out.println(level);
					next();
					check();
					break;
				}
				else
					System.out.println("Pls enter a right value");
			}
		}
		else if (s == 0) {
			trunOff();
		} else
			System.err.println("Enter a right value from the menu");
		menu();

	}

	public static void trunOff() {
		runoff = true;
		if (runoff == true)
			System.out.println("Bye Bye ... ^_^");
		System.exit(0);
	}

	public static String next() {
		level++;
		switch (level) {
		case 0:
			word = "airplane";
			break;
		case 1:
			word = "triangle";

			break;
		case 2:
			word = "scissors";

			break;
		case 3:
			word = "spaceship";
			break;
		case 4:
			word = "president";
			break;
		case 5:
			word = "discovery";
			break;
		}

		return word;
	}

	public static ArrayList<Character> moveCharacterToArray() {
		for (int i = 0; i < word.length(); i++) {
			arr.add(word.charAt(i));

		}
		return arr;
	}

	public static ArrayList<Character> Gaps() {
		char s = '-';
		for (int i = 0; i < arr.size(); i++) {
			Spaces.add(i, s);
		}
		return Spaces;
	}

	public static void AllChar() {
		for (int i = 0; i < 26; i++) {
			if (i % 9 == 0)
				System.out.println();
			char c = (char) ('a' + i);
			System.out.print(c + "  ");
		}
	}
	public static void check() {
		ArrayList<Character> taken = new ArrayList<Character>();
		final int attempts = 10;
		if (level > 5) {
			System.err.println("End  of the game");
			menu();
		}
		arr.clear();
		Spaces.clear();
		AllChar();
		moveCharacterToArray();
		Gaps();
		for (int i = attempts; i >= 0; i--) {
			if (i == 0) {
				System.err.println("Sorry you dindt make it after 10 attempts the word is :  " + word);
				agineOrExit();
			}
			if (Spaces.equals(arr)) {
				System.out.println("You make it the word is :  " + word);
				agineOrExit();
			}
			System.out.println();
			System.out.println("Characters which are alredy used   " + taken);
			System.out.println();
			System.out.println(Spaces);
			System.out.println("Choose a char from the list to enter");
			System.out.println("You have  " + i + "   attempts");
			char b = 0;
			for (int s = 0; s > -1; s++) {
				String character = scan.next();
				char c = character.charAt(0);

				if (c == '0') {
					pause();
					break;
				}

				else if (Character.isDigit(c)) {
					System.out.println("a wrong value , Choose a char from the list to enter");
					AllChar();
					continue;
				}

				else if (Character.isLetter(c)) {
					b = c;
					taken.add(b);
					break;
				}
			}

			for (int j = 0; j < word.length(); j++) {

				if (b == arr.get(j)) {
					Spaces.set(j, b);
				}
			}
		}
	}

	public static void agineOrExit() {
		System.out.println("press 1 to continue");
		System.out.println("press 0 to exit");
		int continueOrExit = scan.nextInt();
		if (continueOrExit == 1) {
			next();
			check();
		} else if (continueOrExit == 0) {
			trunOff();

		}

		else
			System.out.println("Enter a valid number");

	}

	public static void pause() {
		int input;

		for (int i = 0; i > -1; i++) {
			System.out.println("press 1 to Exit the game and back to menu");
			System.out.println("press 0 to exit the application ");
			input = scan.nextInt();

			if (input == 1) {
				menu();
				break;
			} else if (input == 0) {
				trunOff();
				break;
			} else
				System.out.println("Enter a right value");
			continue;
		}

	}
	public static String bug() {
		
	
		
		hangmanMethods.word=next();

		return word;
		
		
	}
}
