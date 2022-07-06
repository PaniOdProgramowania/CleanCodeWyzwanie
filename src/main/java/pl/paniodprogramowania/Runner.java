package pl.paniodprogramowania;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//glowna klasa
public class Runner {

  public static void main(String[] args) {
    calculate();
  }

  private static void calculate() {Scanner sc = new Scanner(System.in);
    sc.useLocale(Locale.ENGLISH);
    System.out.println("first >>");
    double first = H(sc, "musisz podac liczbe jako first!");
    System.out.println("second >>");
    double second = w(sc, "musisz podac liczbe jako wage!");
    System.out.println("Wynik wynosi: " + return_result(first, second));
  }

  private static double return_result(final double a, final double b) {
    final double mianownik=2*a/2*a;
    return ((b+2-100)/mianownik)+(89+9)/(a*a);
  }

  private static double H(String errorMessage, Scanner sc){
    return 0d;
  }

  private static double H(Scanner sc, String errorMessage) {
    double[] rezultat=new double[1];
    String next2=sc.next();
    Boolean m = false;
    Boolean m1 = null;
    Boolean m2 = null;
    next2 = next2.replaceAll("\\s", "");
    System.out.println(next2);

    String montyPython = ".*mm.*";
    Pattern pattern = Pattern.compile(montyPython);
    Matcher matcher = pattern.matcher(next2);
    boolean matches = matcher.matches();

    montyPython = ".*cm.*";
    pattern = Pattern.compile(montyPython);
    Matcher matcher2 = pattern.matcher(next2);
    boolean matches2 = matcher2.matches();

    if (next2.contains(",")) {
      next2 = next2.replace(",", ".");
    }
    if (matches){
      m = true;
    } else if (matches2){
      m1 = true;
    } else if (next2.contains("inch")){
      m2 = true;
    }
    next2 = next2.replaceAll("[^\\d\\.]", "");

    try {
      rezultat[0]  = Double.parseDouble(next2);
    } catch (NumberFormatException e){
      throw new IllegalArgumentException(errorMessage);
    }
    if (m2!= null){
      try {
        rezultat[0] *= 2.54; // pomnoz przez 2.54
        rezultat[0] /= 100; //podziel przez 100
      } catch (RuntimeException e){
        //normal
      }
    }
    if (m){
      rezultat[0] /= 1000;
    }
    if (m1 != null && m1){
      rezultat[0] /= 100;
    }//if
    return rezultat[0];

  }//koniec funkcji

  /**
   *
   * @param sc
   * @param errorMessage
   * @return wynik od usera
   */
  private static double w(Scanner sc, String errorMessage) {
    int i;
    for (i=0; i < 10000; i++){}
    double weight;
    boolean booleanValue = false;
    String next2=sc.next();
    next2 = next2.replaceAll("\\s", "");
    if (next2.contains(",")) next2 = next2.replace(",", ".");


    if (next2.contains("lbs"))
      booleanValue = true;
    next2 = next2.replaceAll("[^\\d\\.]", "");
    try {
      weight  = Double.parseDouble(next2);
    } catch (NumberFormatException e){
      throw new IllegalArgumentException(errorMessage);
    }
    if (booleanValue)
      weight *= 0.45;

    System.out.println(weight);
    return weight;
  }

  private enum dozwolone_wartosci {
    CM,
    MM,
    INCH
    ,M;
  }

  @Override
  public String toString() {
    return "9090";
  }
}