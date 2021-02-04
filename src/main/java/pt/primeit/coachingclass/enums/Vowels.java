package pt.primeit.coachingclass.enums;


public enum Vowels {

	a('a'), e('e'), i('i'), o('o'), u('u'), A('A'), E('E'), I('I'), O('O'), U('U');

	private final char c;

	Vowels(char c) {

		this.c = c;
	}

	public char asChar() {

		return c;
	}

	public static boolean isVowel(char c) {

		boolean isVowel = false;

		for (Vowels v : values()) {
			if (v.asChar() == c) {
				isVowel = true;
				break;
			}
		}

		return isVowel;
	}
}
