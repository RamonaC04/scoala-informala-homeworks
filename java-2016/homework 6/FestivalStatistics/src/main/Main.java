package main;

import java.util.Random;

public class Main {

	public static final RandomEnum<TicketType> r = new RandomEnum<TicketType>(TicketType.class);

	public static void main(String[] args) throws InterruptedException {
		FestivalGate gate = new FestivalGate();
		Random rand = new Random();
		StatisticsThread statistics = new StatisticsThread(gate);
		statistics.start();
		while (true) {
			TicketType ticket = r.random();
			FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticket, gate);
			attendee.start();
			// TODO CODE REVIEW: sleep should be in the attendee class. This way you are just fragmenting the main thread.
			Thread.sleep(rand.nextInt(50));
		}
	}

}
