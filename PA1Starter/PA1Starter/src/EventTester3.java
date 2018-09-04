import java.util.StringTokenizer;

public class EventTester3 {
	public int assertd(boolean condition, int score, int increment) {
		int value = 0;
		try {
			assert (condition);
			value = increment;
		} catch (Error error) {

		}
		return score + value;

	}

	public int testConstructorAndGetters(int score) {
		Event meeting1 = null;
		try {
			meeting1 = new Meeting("m1", 50.0);
			score += 1;
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(meeting1.getDescription().equals("m1"), score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(meeting1.getEventId() == 1, score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(((Meeting) meeting1).getFee() == 50.0, score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		return score;
	}

	public int testToString(int score) {
		double value = 0.0;
		try {
			Event meeting1 = null;
			try {
				meeting1 = new Meeting("m1", 2.0);
			} catch (Exception e) {
			}
			String string = meeting1.toString();
			StringTokenizer tokenizer = new StringTokenizer(string);
			String token = tokenizer.nextToken();
			if (token.equals("Meeting")) {
				value = value + 0.25;
			}
			token = tokenizer.nextToken();
			if (token.equals("2")) {
				value = value + 0.25;
			}
			token = tokenizer.nextToken();
			if (token.equals("m1")) {
				value = value + 0.25;
			}

		} catch (Exception e) {
			System.out.println("string issues");
		}
		// System.out.println("Value " + value);
		score = score + Math.round((float) value);
		return score;
	}

	public int testAddUnsupportedStuff(int score) {
		try {
			Event meeting1 = new Meeting("m1", 50.0);

			try {
				meeting1.getTickets();
			} catch (UnsupportedOperationException uoe) {
				score++;
			}
			try {
				meeting1.setPriceFactor(2.0);
			} catch (UnsupportedOperationException uoe) {
				score++;
			}
			try {
				meeting1.getPriceFactor();
			} catch (UnsupportedOperationException uoe) {
				score++;
			}
		} catch (Exception e) {
			System.out.println("issues " + e);
		}

		return score;
	}

	public static void main(String[] args) {
		int score = 0;
		EventTester3 test = new EventTester3();
		score = test.testConstructorAndGetters(score);
		score = test.testToString(score);
		score = test.testAddUnsupportedStuff(score);
		System.out.println(score + " out of 8");
	}
}
