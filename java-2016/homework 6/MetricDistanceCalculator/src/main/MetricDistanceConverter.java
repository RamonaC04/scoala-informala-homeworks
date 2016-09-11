package main;
//mm, cm, dm, m, km, inch, foot, miles
public class MetricDistanceConverter {
	
 private static final Convertion [] CONVERTIONS = new Convertion[]{
		 
 		new Convertion(Distance.KILO_METERS, Distance.METERS, 1000),
 		new Convertion(Distance.METERS, Distance.KILO_METERS, 0.001),
 		new Convertion(Distance.KILO_METERS, Distance.MILES,0.6214),
 		new Convertion(Distance.MILES, Distance.KILO_METERS, 1.6093),
 		new Convertion(Distance.KILO_METERS, Distance.CENTI_METERS, 100000),
		new Convertion(Distance.METERS, Distance.MILES, 0.00062),
 		new Convertion(Distance.MILES, Distance.METERS, 1609.344),
 		new Convertion(Distance.METERS, Distance.CENTI_METERS, 100),
 		new Convertion(Distance.CENTI_METERS, Distance.METERS, 0.01),
 		new Convertion(Distance.MILES, Distance.CENTI_METERS, 160934.4),
 		new Convertion(Distance.CENTI_METERS, Distance.MILES, 6.2137119e-06),
 		new Convertion(Distance.KILO_METERS, Distance.INCH,39370.0787 ),
 		new Convertion(Distance.KILO_METERS, Distance.FOOT,3280.8399),
 		new Convertion(Distance.KILO_METERS, Distance.DECI_METERS, 10000),
 		new Convertion(Distance.METERS, Distance.MILI_METERS, 1000),
 		new Convertion(Distance.METERS, Distance.DECI_METERS,10),
 		new Convertion(Distance.METERS, Distance.FOOT,3.2808),
 		new Convertion(Distance.CENTI_METERS, Distance.INCH,0.3937),
 		new Convertion(Distance.CENTI_METERS, Distance.FOOT,0.0328),
 		new Convertion(Distance.CENTI_METERS, Distance.DECI_METERS,0.1),
 		new Convertion(Distance.CENTI_METERS, Distance.MILI_METERS,10),
 		new Convertion(Distance.MILES, Distance.INCH,63360),
 		new Convertion(Distance.MILES, Distance.FOOT,5280),
 		new Convertion(Distance.MILES, Distance.MILI_METERS,1609344 ),
 		new Convertion(Distance.MILES, Distance.DECI_METERS,16093.44 ),
 		new Convertion(Distance.FOOT, Distance.METERS,0.3048 ),
 		new Convertion(Distance.FOOT, Distance.MILES,0.0002 ),
 		new Convertion(Distance.FOOT, Distance.CENTI_METERS,30.48),
 		new Convertion(Distance.FOOT, Distance.DECI_METERS,3.0480 ),
 		new Convertion(Distance.FOOT, Distance.INCH,12 ),
 		new Convertion(Distance.FOOT, Distance.KILO_METERS,0.0003 ),
 		new Convertion(Distance.FOOT, Distance.MILI_METERS, 304.8),
 		new Convertion(Distance.INCH, Distance.FOOT,0.8333 ),
 		new Convertion(Distance.INCH, Distance.METERS,0.0254 ),
 		new Convertion(Distance.INCH, Distance.CENTI_METERS,2.54 ),
 		new Convertion(Distance.INCH, Distance.DECI_METERS,0.254 ),
 		new Convertion(Distance.INCH, Distance.MILI_METERS,25.4 ),
 		new Convertion(Distance.INCH, Distance.KILO_METERS, 0),
 		new Convertion(Distance.INCH, Distance.MILES, 1.57828281218333e-05),
 		new Convertion(Distance.DECI_METERS, Distance.MILI_METERS,100 ),
 		new Convertion(Distance.DECI_METERS, Distance.MILES,0),
 		new Convertion(Distance.DECI_METERS, Distance.CENTI_METERS,10 ),
 		new Convertion(Distance.DECI_METERS, Distance.FOOT,3.0480 ),
 		new Convertion(Distance.DECI_METERS, Distance.METERS,0.1 ),
 		new Convertion(Distance.DECI_METERS, Distance.INCH, 3.9370),
 		new Convertion(Distance.MILI_METERS, Distance.METERS,0.001 ),
 		new Convertion(Distance.MILI_METERS, Distance.DECI_METERS,0.01 ),
 		new Convertion(Distance.MILI_METERS, Distance.CENTI_METERS,0.1 ),
 		new Convertion(Distance.MILI_METERS, Distance.INCH,0.03939 ),
 		new Convertion(Distance.MILI_METERS, Distance.FOOT,0.0033 ),
 		new Convertion(Distance.MILI_METERS, Distance.MILES, 0),
 		
 		
 		
 		
 		
 };
 	
 	public Distance convert(Distance distance, String toFormat) throws UnknownDistanceFormatException{
 		if(distance.getFormatName().equals(toFormat)){
 			return distance;
 		}
 		Convertion convertion = null;
 		for(Convertion c : CONVERTIONS){
 			if(c.fromFormat.equals(distance.getFormatName()) && c.toFormat.equals(toFormat)){
 				convertion = c;
 				break;
 			}
 		}
 		if(convertion==null){
 			throw new UnknownDistanceFormatException("No rate found for "+distance.getFormatName()+" - "+toFormat);
 		}
 		return new Distance (toFormat, distance.getValue()*convertion.rate);
 	}
 	
 	private static class Convertion {
 		double rate;
 		String fromFormat;
 		String toFormat;
 		
 		public Convertion(String fromFormat, String toFormat, double rate) {
 			super();
 			this.rate = rate;
 			this.fromFormat = fromFormat;
 			this.toFormat = toFormat;
 		}
 		
 		
 	
 	}
 
 }

