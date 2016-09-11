import java.util.ArrayList;
import java.util.List;

// Se da un string:"2.0km+300.0mm-35.0ft+0.1miles+45.2dm-100.4cm+208.4m+32.3in-26.8ft+800.9mm"
//
//import java.util.Enumeration;
//import java.util.Hashtable;
public class Afisare {

	public static void main(String[] args) {
		String str = "2.0km+300.0mm-35.0ft+0.1miles+45.2dm-100.4cm+208.4m+32.3in-26.8ft+800.9mm";
		System.out.println(str);

		CalcDistanta calc = new CalcDistanta();//cream un ob de tip calcDistanta

		List<Double> lst = calc.extrageNumerele();
		System.out.println(lst);
		calc.convertMeasurments();//apelam convertMeasurments
		String unitateDeMasura = "m";//stabilim unit de masura pt rezultat
		double rez = calc.result(unitateDeMasura);
		System.out.println("Rezultatul este:" + rez + unitateDeMasura);
	}

}
