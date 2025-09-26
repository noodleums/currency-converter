import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args) {
	    List<String> currencies = new ArrayList<>();
	    currencies.add("eur");currencies.add("gbp");currencies.add("irr");currencies.add("jpy");currencies.add("aud");
	    currencies.add("chf");currencies.add("inr");currencies.add("myr");currencies.add("cny");currencies.add("ils");
	    
	    String[] currencyValues = {".84", ".74","42075","149.75","1.53",".8","88.71","4.22","7.13","3.35"};
	    
        Scanner scanner = new Scanner(System.in);
        System.out.println("List of available currencies:\nEUR\nGBP\nIRR\nJPY\nAUD\nCHF\nINR\nMYR\nCNY\nILS");
        System.out.println("Enter USD amount");
        String baseAmountStr = scanner.next();
        BigDecimal baseAmount = new BigDecimal(baseAmountStr);
        while (baseAmount.compareTo(new BigDecimal(0)) == -1) {
            System.out.println("Currency can't be less than 0");
            baseAmountStr = scanner.next();
            baseAmount = new BigDecimal(baseAmountStr);
            if (baseAmount.compareTo(new BigDecimal(0)) != -1) {
                break;
            }
        }
        System.out.println("Enter conversion currency");
        String conversionCurrency = scanner.next();
        while (currencies.indexOf(conversionCurrency.toLowerCase()) == -1) {
            System.out.println("Invalid currency");
            conversionCurrency = scanner.next();
            if (currencies.indexOf(conversionCurrency.toLowerCase()) != -1){
                break;
            }
        }
        int conversionIndex = currencies.indexOf(conversionCurrency.toLowerCase());
        BigDecimal conversion = new BigDecimal(currencyValues[conversionIndex]);
        BigDecimal conversionAmount = baseAmount.multiply(conversion);
        System.out.println(baseAmountStr + " USD -> " + conversionAmount + " " + conversionCurrency.toUpperCase());
	}
}
