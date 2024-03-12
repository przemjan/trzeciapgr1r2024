import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class uczen {





          public static void main(String[] args) {
               Scanner scanner = new Scanner(System.in);

               System.out.println("Wybierz opcje:");
               System.out.println("1. Zamien liczbe arabska na rzymska");
               System.out.println("2. Zamien liczbe rzymska na arabska");
               int option = scanner.nextInt();

               switch (option) {
                    case 1:
                         System.out.print("Podaj liczbe arabska: ");
                         int arabicNumber = scanner.nextInt();
                         if (arabicNumber < 1 || arabicNumber > 3999) {
                              System.out.println("Blad: Liczba arabska musi byc z zakresu od 1 do 3999.");
                         } else {
                              String romanEquivalent = convertToRoman(arabicNumber);
                              System.out.println("Liczba rzymska: " + romanEquivalent);
                         }
                         break;
                    case 2:
                         System.out.print("Podaj liczbe rzymska: ");
                         scanner.nextLine();
                         String romanNumber = scanner.nextLine();
                         int arabicEquivalent = convertToArabic(romanNumber);
                         if (arabicEquivalent == -1) {
                              System.out.println("Blad: Niepoprawny format liczby rzymskiej.");
                         } else {
                              System.out.println("Liczba arabska: " + arabicEquivalent);
                         }
                         break;
                    default:
                         System.out.println("Blad: Wybrano niepoprawna opcje.");
               }
          }

          public static String convertToRoman(int num) {
               int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
               String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

               StringBuilder roman = new StringBuilder();

               for (int i = 0; i < arabicValues.length; i++) {
                    while (num >= arabicValues[i]) {
                         roman.append(romanSymbols[i]);
                         num -= arabicValues[i];
                    }
               }

               return roman.toString();
          }

          public static int convertToArabic(String roman) {
               Map<Character, Integer> romanValues = new HashMap<>();
               romanValues.put('I', 1);
               romanValues.put('V', 5);
               romanValues.put('X', 10);
               romanValues.put('L', 50);
               romanValues.put('C', 100);
               romanValues.put('D', 500);
               romanValues.put('M', 1000);

               int arabic = 0;
               int prevValue = 0;

               for (int i = roman.length() - 1; i >= 0; i--) {
                    int value = romanValues.getOrDefault(roman.charAt(i), -1);
                    if (value == -1) {
                         return -1;
                    }
                    if (value < prevValue) {
                         arabic -= value;
                    } else {
                         arabic += value;
                    }
                    prevValue = value;
               }

               return arabic;
          }
     }


