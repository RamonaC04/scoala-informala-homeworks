package main;

public class FestivalAttendeeThread extends Thread {

	private TicketType ticket;
	private FestivalGate gate;

	public FestivalAttendeeThread(TicketType ticket, FestivalGate gate) {
		// TODO CODE REVIEW: gate should be synchronized.
		this.ticket = ticket;
		this.gate = gate;
	}

	@Override
	public void run() {
		gate.attendeePass(ticket);
	}

}
