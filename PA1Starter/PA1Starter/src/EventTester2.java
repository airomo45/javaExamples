import java.util.StringTokenizer;

public class EventTester2 {
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
		Event concert1 = null;
		Event concert2 = null;
		try {
			concert1 = new Concert("c1", 2.0);
			concert2 = new Concert("c2");
			score += 2;
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(concert1.getDescription().equals("c1"), score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(concert1.getEventId() == 1, score, 1);
			score = assertd(concert2.getEventId() == 2, score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(concert1.getPriceFactor() == 2.0, score, 1);
			concert2.setPriceFactor(3.0);
			concert2.setDescription("concert2");
			score = assertd(concert2.getPriceFactor() == 3.0, score, 1);
			score = assertd(concert2.getDescription().equals("concert2"), score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		return score;
	}

	public int testToString(int score) {
		double value = 0.0;
		try {
			Event concert1 = null;
			Event concert2 = null;
			try {
				concert1 = new Concert("c1", 2.0);
				concert2 = new Concert("c2");
				score += 1;
			} catch (Exception e) {
			}
			String string = concert1.toString();
			StringTokenizer tokenizer = new StringTokenizer(string);
			String token = tokenizer.nextToken();
			if (token.equals("Concert")) {
				value = value + 0.25;
			}
			token = tokenizer.nextToken();
			if (token.equals("3")) {
				value = value + 0.25;
			}
			token = tokenizer.nextToken();
			if (token.equals("c1")) {
				value = value + 0.25;
			}

		} catch (Exception e) {
			System.out.println("string issues");
		}
		// System.out.println("Value " + value);
		score = score + Math.round((float) value);
		return score;
	}

	public static void main(String[] args) {
		int score = 0;
		EventTester2 test = new EventTester2();
		score = test.testConstructorAndGetters(score);
		score = test.testToString(score);
		System.out.println(score + " out of 10");
	}
}
