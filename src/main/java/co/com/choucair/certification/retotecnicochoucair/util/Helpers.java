package co.com.choucair.certification.retotecnicochoucair.util;
import java.util.HashSet;
import java.util.Random;

public class Helpers {

    public static String xpath = "(//span[@class='vtex-store-components-3-x-productBrand '])[%s]";
    private static Random random;

    static  {
        random = new Random();
    }

    public static int generarNumeroRandom(int limite) {
        return (random.nextInt(limite) + 1);
    }


  /*  private Random random;
    private HashSet<Integer> generatedNumbers;
    private int limit;

    public RandomNumberGenerator(int limit) {
        this.random = new Random();
        this.generatedNumbers = new HashSet<>();
        this.limit = limit;
    }

    public int getUniqueRandom() {
        int randomNumber;
        do {
            randomNumber = random.nextInt(limit);
        } while (generatedNumbers.contains(randomNumber));
        generatedNumbers.add(randomNumber);
        return randomNumber;
    }*/




}
