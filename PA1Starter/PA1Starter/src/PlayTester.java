import java.util.StringTokenizer;

public class PlayTester {
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
		Play play1 = null;
		Play play2 = null;
		try {
			play1 = new Play("p1", 2.0);
			play2 = new Play("p2");
			score += 2;
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(play1.getDescription().equals("p1"), score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(play1.getEventId() == 1, score, 1);
			score = assertd(play2.getEventId() == 2, score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		try {
			score = assertd(play1.getPriceFactor() == 2.0, score, 1);
			play2.setPriceFactor(3.0);
			play2.setDescription("play2");
			score = assertd(play2.getPriceFactor() == 3.0, score, 1);
			score = assertd(play2.getDescription().equals("play2"), score, 1);
		} catch (Exception e) {
			System.out.println("constructor...issues");
		}

		return score;
	}

	public int testToString(int score) {
		double value = 0.0;
		try {
			Play play1 = null;
			Play play2 = null;
			try {
				play1 = new Play("p1", 2.0);
				play2 = new Play("p2");
				score += 1;
			} catch (Exception e) {
			}
			String string = play1.toString();
			System.out.println(string);
			StringTokenizer tokenizer = new StringTokenizer(string);
			String token = tokenizer.nextToken();
			if (token.equals("Event")) {
				value = value + 0.25;
			}
			System.out.println(token + " " + value);

			token = tokenizer.nextToken();
			if (token.equals("3")) {
				value = value + 0.25;
			}
			System.out.println(token + " " + value);
			token = tokenizer.nextToken();
			if (token.equals("p1")) {
				value = value + 0.25;
			}
			System.out.println(token + " " + value);

		} catch (Exception e) {
			System.out.println("string issues");
		}
		// System.out.println("Value " + value);
		score = score + Math.round((float) value);
		return score;
	}

	public int testEquals(int score) {
		try {
			Play play1 = new Play("p1");
			Play play2 = new Play("p2");
			score = assertd(!play1.equals(play2), score, 1);
			score = assertd(play1.equals(play1), score, 1);
		} catch (Exception e) {
		}
		return score;
	}

	public int testAddTickets(int score) {
		try {
			Play play1 = new Play("p1");
			Ticket[] tickets = new Ticket[5];
			for (int index = 0; index < tickets.length; index++) {
				tickets[index] = new Ticket(play1);
			}
			score = score + 3;
			Ticket[] retrievedTickets = play1.getTickets();
			for (int index = 0; index < retrievedTickets.length; index++) {
				assert (retrievedTickets[index].equals(tickets[index]));
			}
			try {
				Ticket tExtra = new Ticket(play1);
				retrievedTickets = play1.getTickets();
				for (int index = 0; index < retrievedTickets.length; index++) {
					assert (!retrievedTickets[index].equals(tExtra));
				}
				score += 2;
			} catch (Exception e) {

			}
		} catch (Exception e) {
			System.out.println("issues " + e);
		}

		return score;
	}

	public static void main(String[] args) {
		int score = 0;
		PlayTester test = new PlayTester();
		score = test.testConstructorAndGetters(score);
		score = test.testToString(score);
		score = test.testEquals(score);
		score = test.testAddTickets(score);
		System.out.println(score + " out of 17");
	}
}
