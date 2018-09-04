import java.util.StringTokenizer;

public class TicketTester {
	private Play event = new Play("E1", 1.5);

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
		Ticket ticket = null;
		try {
			ticket = new Ticket(event);
			score += 1;
		} catch (Exception e) {
		}
		try {
			score = assertd(ticket.getPrice() == 10.0 * event.getPriceFactor(), score, 1);
		} catch (Exception e) {
		}
		try {
			score = assertd(ticket.getSerialNumber() == 1, score, 1);
			Ticket ticket2 = new Ticket(event);
			score = assertd(ticket.getSerialNumber() == 2, score, 1);
		} catch (Exception e) {
		}
		try {
			score = assertd(ticket.getEvent().equals(event), score, 1);
		} catch (Exception e) {
		}

		return score;
	}

	public int testToString(int score) {
		double value = 0.0;
		try {
			Ticket ticket1 = new Ticket(event);
			String string = ticket1.toString();
			System.out.println(string);
			StringTokenizer tokenizer = new StringTokenizer(string);
			String token = tokenizer.nextToken();
			if (token.equals("Ticket")) {
				value = value + 0.25;
			}
			System.out.println(token + " " + value);

			token = tokenizer.nextToken();
			if (token.equals("serialNumber")) {
				value = value + 0.25;
			}
			System.out.println(token + " " + value);
			token = tokenizer.nextToken();
			if (token.equals("3")) {
				value = value + 0.25;
			}
			System.out.println(token + " " + value);
			token = tokenizer.nextToken();
			if (token.equals("price")) {
				value = value + 0.25;
			}
			System.out.println(token + " " + value);
			token = tokenizer.nextToken();
			if (token.equals("15.0")) {
				value = value + 0.25;
			}
		} catch (Exception e) {
		}
		System.out.println("Value " + value);
		score = score + Math.round((float) value);
		return score;
	}

	public int testEquals(int score) {
		try {
			Ticket ticket1 = new Ticket(event);
			Ticket ticket2 = new Ticket(event);
			score = assertd(!ticket1.equals(ticket2), score, 1);
			score = assertd(ticket1.equals(ticket1), score, 1);
		} catch (Exception e) {
		}
		return score;
	}

	public static void main(String[] args) {
		int score = 0;
		TicketTester test = new TicketTester();
		score = test.testConstructorAndGetters(score);
		score = test.testToString(score);
		score = test.testEquals(score);
		System.out.println(score + " out of 8");
	}
}
