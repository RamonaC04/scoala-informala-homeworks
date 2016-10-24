package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class FestivalGate {
	private LinkedBlockingQueue<TicketType> queue;

	public FestivalGate() {
		queue = new LinkedBlockingQueue<>();
	}

	public void attendeePass(TicketType e) {
		queue.add(e);
	}

	public List<TicketType> getAllValidations() throws InterruptedException {
		ArrayList<TicketType> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			res.add(queue.take());
		}
		return res;
	}
}
