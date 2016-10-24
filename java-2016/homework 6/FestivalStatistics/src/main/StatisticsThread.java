package main;

import java.util.List;

public class StatisticsThread extends Thread {

	private FestivalGate gate;

	public StatisticsThread(FestivalGate gate) {
		super();
		this.gate = gate;
	}

	@Override
	public void run() {
		while (true) {
			try {
				List<TicketType> validations = gate.getAllValidations();
				int noOfFullTypeTicket = 0;
				for (TicketType t : validations) {
					if (t == TicketType.FULL)
						noOfFullTypeTicket++;
				}
				int noOfFullVipTypeTicket = 0;
				for (TicketType t : validations) {
					if (t == TicketType.FULL_VIP)
						noOfFullVipTypeTicket++;
				}
				int noOfFreePassTypeTicket = 0;
				for (TicketType t : validations) {
					if (t == TicketType.FREE_PASS)
						noOfFreePassTypeTicket++;
				}
				int noOfFreeOneDayTicket = 0;
				for (TicketType t : validations) {
					if (t == TicketType.ONE_DAY)
						noOfFreeOneDayTicket++;
				}
				int noOfFreeOneDayVipTicket = 0;
				for (TicketType t : validations) {
					if (t == TicketType.ONE_DAY_VIP)
						noOfFreeOneDayVipTicket++;
				}
				System.out.println(validations.size() + " people entered ");
				System.out.println(noOfFullTypeTicket + "people have full pass ticket");
				System.out.println(noOfFullVipTypeTicket + "people have full vip pass ticket");
				System.out.println(noOfFreePassTypeTicket + "people have free pass pass ticket");
				System.out.println(noOfFreeOneDayTicket + "people have one day pass ticket");
				System.out.println(noOfFreeOneDayVipTicket + "people have one day vip pass ticket");
				StatisticsThread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
