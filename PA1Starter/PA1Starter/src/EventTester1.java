import java.util.StringTokenizer;

public class EventTester1 {
	Events events = new Events();

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
		Event play1 = null;
		Event play2 = null;
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
			Event play1 = null;
			Event play2 = null;
			try {
				play1 = new Play("p1", 2.0);
				play2 = new Play("p2");
				score += 1;
			} catch (Exception e) {
			}
			String string = play1.toString();
			StringTokenizer tokenizer = new StringTokenizer(string);
			String token = tokenizer.nextToken();
			if (token.equals("Play")) {
				value = value + 0.25;
			}
			token = tokenizer.nextToken();
			if (token.equals("3")) {
				value = value + 0.25;
			}
			token = tokenizer.nextToken();
			if (token.equals("p1")) {
				value = value + 0.25;
			}
		} catch (Exception e) {
			System.out.println("string issues");
		}
		// System.out.println("Value " + value);
		score = score + Math.round((float) value);
		return score;
	}

	public int testAddTickets(int score) {
		try {
			Event play1 = new Play("p1");
			events.add(play1);
			Event play2 = new Play("p2");
			events.add(play2);
			Ticket[] tickets = new Ticket[5];
			for (int index = 0; index < tickets.length; index++) {
				tickets[index] = new Ticket(play1);
				if (index == 3) {
					score = assertd(play1.getPriceFactor() == 1.2, score, 1);
				} else if (index == 4) {
					score = assertd(play1.getPriceFactor() == 1.44, score, 1);
				}
			}
			new Ticket(play2);
			score = assertd(events.getTotalProceeds() == 6.66, score, 1);

		} catch (Exception e) {
			System.out.println("issues " + e);
		}

		return score;
	}

	public int testException(int score) {
		try {
			Event p1 = new Play("p1");
			for (int index = 0; index < 5; index++) {
				new Ticket(p1);
			}
			try {
				new Ticket(p1);
			} catch (NoSpaceException nse) {
				score++;
			}
		} catch (Exception e) {

		}
		return score;
	}

	public static void main(String[] args) {
		int score = 0;
		EventTester1 test = new EventTester1();
		score = test.testConstructorAndGetters(score);
		score = test.testToString(score);
		score = test.testAddTickets(score);
		score = test.testException(score);
		System.out.println(score + " out of 14");
	}
}
