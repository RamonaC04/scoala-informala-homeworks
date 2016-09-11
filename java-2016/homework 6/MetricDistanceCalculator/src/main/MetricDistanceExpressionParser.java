package main;

public class MetricDistanceExpressionParser {

	private static final String MINUS = "-";
	private static final String PLUS = "\\+";

	public Distance[] parse(String expression) throws UnknownDistanceFormatException {
		// count the operands
		int operandCount = countSubStringOccurrences(expression, PLUS) + countSubStringOccurrences(expression, MINUS)
				+ 1;
		if (expression.startsWith("-")) {
			operandCount--;
		}
		Distance distanta[] = new Distance[operandCount];
		int index = 0;
		expression = expression.trim().replaceAll(" ", "").replaceAll("\t", ""); // loose
																					// the
																					// whitespaces
		while (expression.length() > 0) {
			int sign = 1;
			if (expression.startsWith(MINUS)) {
				expression = expression.replaceFirst(MINUS, "");
				sign = -1;
			} else if (expression.startsWith("+")) {
				expression = expression.replaceFirst(PLUS, "");
			}
			int nextOpPos = nextOperand(expression);
			String operator = null;
			if (nextOpPos == -1) {// last operand
				operator = expression;
			} else {
				operator = expression.substring(0, nextOpPos);
			}
			expression = expression.replaceFirst(operator, "");
			distanta[index++] = convertToDistance(operator, sign);
		}
		return distanta;
	}

	public int nextOperand(String expression) {
		int plusPos = expression.indexOf("+");
		int minusPos = expression.indexOf("-");
		if (plusPos == -1) {
			return minusPos;
		}
		if (minusPos == -1) {
			return plusPos;
		}
		return plusPos < minusPos ? plusPos : minusPos;
	}

	private Distance convertToDistance(String e, int sign) throws UnknownDistanceFormatException {
		if (e.endsWith(Distance.KILO_METERS)) {
			return convertToDistance(e, sign, Distance.KILO_METERS);
		} else if (e.endsWith(Distance.MILES)) {
			return convertToDistance(e, sign, Distance.MILES);
		} else if (e.endsWith(Distance.CENTI_METERS)) {
			return convertToDistance(e, sign, Distance.CENTI_METERS);
		} else if (e.endsWith(Distance.MILI_METERS)) {
			return convertToDistance(e, sign, Distance.MILI_METERS);
		} else if (e.endsWith(Distance.DECI_METERS)) {
			return convertToDistance(e, sign, Distance.DECI_METERS);
		} else if (e.endsWith(Distance.INCH)) {
			return convertToDistance(e, sign, Distance.INCH);
		} else if (e.endsWith(Distance.FOOT)) {
			return convertToDistance(e, sign, Distance.FOOT);
		} else if(e.endsWith(Distance.METERS)) {
			return convertToDistance(e, sign, Distance.METERS);
		} else 
			throw new UnknownDistanceFormatException(e);
	}

	private Distance convertToDistance(String e, int sign, String distanceFormat) {
		return new Distance(distanceFormat, sign * Double.parseDouble(e.replace(distanceFormat, "")));
	}

	private int countSubStringOccurrences(String s, String sub) {
		return s.length() - s.replaceAll(sub, "").length();
	}

}
