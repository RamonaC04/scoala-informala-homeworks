package Main;
import java.util.List;

public class CourierThread  extends Thread{

	private List<Package> toBeDelivered;

	public CourierThread(List<Package> toBeDelivered) {
		super();
		this.toBeDelivered = toBeDelivered;
	}

	@Override
	public synchronized void run() {
		try {
			Thread.sleep(toBeDelivered.get(0).getDistanceInKmToTheTarget());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double profit=0;
		double totalMerchandiseValue=0;
		PackageProfitCalculator packageProfitCalculator = new PackageProfitCalculator(10);
		
		for (Package p:toBeDelivered){
		    profit += packageProfitCalculator.calculateProfit(p);
		    totalMerchandiseValue += p.getMerchandiseValue();
		}
		System.out.println("Merchandise value:"+ totalMerchandiseValue+ " Profit:" + profit);
	}
	
}
