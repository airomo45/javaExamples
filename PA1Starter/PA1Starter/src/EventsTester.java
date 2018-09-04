public class EventsTester {
	public int assertd(boolean condition, int score, int increment) {
		int value = 0;
		try {
			assert (condition);
			value = increment;
		} catch (Error error) {

		}
		return score + value;

	}

	public int testEverything(int score) {
		try {
			Event play1 = new Play("p1");
			Event concert1 = new Concert("c1");
			Event meeting1 = new Meeting("m1", 100);
			for (int index = 0; index < 5; index++) {
				new Ticket(play1);
			}
			try {
				for (int index = 0; index < 5; index++) {
					new Ticket(concert1);
				}
			} catch (NoSpaceException nse) {
				score++;
			}
			Events events = new Events();
			events.add(meeting1);
			events.add(concert1);
			events.add(play1);
			score = score + 2;
			score = assertd(events.getEvents().length == 3, score, 1);
			score = assertd(events.getEvents()[0].equals(meeting1), score, 1);
			score = assertd(events.getEvents()[1].equals(concert1), score, 1);
			score = assertd(events.getEvents()[2].equals(play1), score, 1);
			score = assertd(events.getTotalProceeds() == 110.64, score, 2);
		} catch (Exception e) {

		}
		return score;
	}

	public static void main(String[] args) {
		int score = 0;
		EventsTester test = new EventsTester();
		score = test.testEverything(score);
		System.out.println(score + " out of 8");
	}
}
