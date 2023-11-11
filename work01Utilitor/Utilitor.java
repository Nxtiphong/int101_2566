package int101s2023h02.src.work01Utilitor;

public final class Utilitor {
    public String testString(String value){
        if (value == null) throw new NullPointerException("This value is null");
        if (value.isBlank()) throw new IllegalArgumentException("This value is blank String");
        return value;
    }
    public static double testPositive(double value){
        if (value < 0) throw new IllegalArgumentException("This value is less then 0");
        return value;
    }
    public static long computeIsbn10(long isbn10){
        if (String.valueOf(isbn10).length() != 9) {
            throw new IllegalArgumentException("ISBN-10 have to have a 10-digit");
        }
        String isbnString = String.valueOf(isbn10);
        int chack = 0;

        for (int i = 0; i<9; i++){
            int digit = Character.getNumericValue(isbnString.charAt(i));
            chack += (i + 1) * digit;
        }

        int remain = chack % 11;
        return (remain == 0) ? 0 : 11 - remain;
    }
}
