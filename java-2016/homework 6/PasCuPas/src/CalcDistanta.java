import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcDistanta {

	private String str = "2.0km+300.0mm-35.0ft+0.1miles+45.2dm-100.4cm+208.4m+32.3in-26.8ft+800.9mm";

	// scoatem operatorii - si + din string
	public List<String> extragere() {
		String[] splitByPlus = str.split("\\+");// facem split dupa +
		// for (String s : splitByPlus){
		List<String> elemente = new ArrayList<String>();
		for (int i = 0; i < splitByPlus.length; i++) {// parcurgem array list
														// dupa split +
			String[] splitByMinus = splitByPlus[i].split("\\-");// facem split
																// dupa -

			for (int j = 0; j < splitByMinus.length; j++) {// parcurgem array
															// list dupa split -

				elemente.add(splitByMinus[j]); // adaugam elementele in array
												// list -ul elemente
				System.out.println(splitByMinus[j]);// facem print dupa split
			}
		}
		System.out.println(elemente);

		return elemente; // returneaza sirul de elemente pe care trebuie sa le
							// transformam in u.m data
	}
	// dupa eliminare operatori stabilim daca operanzi sunt de tip double si ne
	// returneaza numarul ce va trebui adunat pt stabilirea distantei

	public List<Double> extrageNumerele() {
		List<String> operanzi = extragere();

		List<Double> nrPtOperat = new ArrayList();// facem o noua lista unde
													// retinem nr ce trebuie
													// operate fara u.m
		for (int i = 0; i < operanzi.size(); i++) {// parcurgem lista
			// se creaza un pattern care este folosit pentru a vedea daca
			// elementul
			// din operanzi este nr sau nu.
			Pattern p = Pattern.compile("(\\d+(?:\\.\\d+))");
			// se face match intre elementul din operanzi si patternul definit
			// anterior
			Matcher m = p.matcher(operanzi.get(i));
			double d = 0.0;
			while (m.find()) {
				d = Double.parseDouble(m.group(1));
			}
			nrPtOperat.add(d);
		}
		return nrPtOperat;

	}

	public List<String> convertMeasurments() {
		List<Double> nrPtOperat = extrageNumerele();
		List<String> elemente = extragere();

		for (int i = 0; i < nrPtOperat.size(); i++) {
			String aux = elemente.get(i).replace(nrPtOperat.get(i).toString(), "");// in
																					// lista
																					// de
																					// elemente
																					// inlocuim
																					// cifrele
																					// cu
																					// spatii
																					// pt
																					// a
																					// avea
																					// doar
																					// u.m
			System.out.println(aux);
			elemente.set(i, aux);// la pozitia i din elemente se va inlocui cu
									// aux
			System.out.println(elemente);
		}
		return elemente;

	}

	// retinem operatorii intr-un array list
	public ArrayList<Character> extragereOperatori() {

		ArrayList<Character> extOp = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-') {// verificam daca
																// elementul din
																// string este
																// sau nu + sau
																// -
																// daca este il
																// adaugam in
																// array list-ul
																// extOp
				extOp.add(str.charAt(i));

			}
		}
		System.out.println(extOp);
		return extOp;
	}

	public List<Double> rezultat(String unitate) {

		List<String> elemente = convertMeasurments();//apelam elemente din metoda covertMeasur....
		List<Double> nrPtOperat = extrageNumerele();//apelam nrPtOperat din metoda extrageNr...
		
		List<Double> listaFinala = new ArrayList<Double>();//cream lista finala unde punem toate nr ce au fost convertite
		ConvertireUnitMasura converter = new ConvertireUnitMasura();
		for (int i = 0; i < elemente.size(); i++) {//parcurgem lista cu elemente 

			double rezPartial = converter.transformDistance(nrPtOperat.get(i), elemente.get(i), unitate);
			listaFinala.add(rezPartial);
		}
		return listaFinala;//lista finala cu elemente pe care aplicam suma
	}

	public double result(String unitate) { //la lista finala adaugam operatorii din extOp
		List<Double> listaFinala = rezultat(unitate);
		ArrayList<Character> extOp = extragereOperatori();
		double suma = listaFinala.get(0);//lista incepe cu un operand apoi operator
		for (int i = 0; i < extOp.size(); i++) {
			if (extOp.get(i) == '+') {
				suma = suma + listaFinala.get(i + 1);
			} else if (extOp.get(i) == '-') {
				suma = suma - listaFinala.get(i + 1);
           System.out.println(listaFinala);
			}

		}
		return suma;

	}
}
