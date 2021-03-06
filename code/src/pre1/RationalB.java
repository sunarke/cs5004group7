package pre1;

/**
 * This class represent a rational number for Part Two B.
 * It has two parts: numerator and denominator.
 */
public class RationalB {
    private int numerator;
    private int denominator;

    /**
     * Construct a rational number without the provided value,
     * and initialize this object to zero.
     */
    public RationalB(){
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * Construct a rational number with the provided integer.
     *
     * @param wholeNumber
     */
    public RationalB(int wholeNumber){
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * Construct a rational number with the provided numerator and denominator.
     *
     * @param numerator the numerator value of this rational number.
     * @param denominator the denominator value of this rational number.
     */
    public RationalB(int numerator, int denominator){
        setNumerator(numerator);
        setDenominator(denominator);
    }

    /**
     * Return a rational number as the result of adding the two provided rational numbers.
     *
     * @param r1 a rational number r1 to be added to another rational number.
     * @param r2 a rational number r2 to be added to another rational number
     * @return the result of adding the two rational numbers.
     */
    public static RationalB addition(RationalB r1, RationalB r2){
        int newNumerator = r1.numerator * r2.denominator + r2.numerator * r1.denominator;
        int newDenominator = r1.denominator * r2.denominator;
        return new RationalB(newNumerator, newDenominator);
    }

    /**
     * Change this rational number as the result of adding the provided rational number.
     * @param x a rational number x to be added to this rational number.
     */
    public void addition(RationalB x){
        setNumerator(this.numerator * x.denominator + x.numerator * this.denominator);
        setDenominator(this.denominator * x.denominator);
    }

    /**
     * Return a rational number as the result of subtracting the two provided rational numbers.
     *
     * @param r1 a rational number to be subtracted by the other rational number.
     * @param r2 a rational number going to subtract the other rational number.
     * @return a rational number as the result of subtracting the two provided rational numbers.
     */
    public static RationalB subtraction(RationalB r1, RationalB r2){
        int newNumerator = r1.numerator * r2.denominator - r2.numerator * r1.denominator;
        int newDenominator = r1.denominator * r2.denominator;
        return new RationalB(newNumerator, newDenominator);
    }

    /**
     * Change this rational number as the result of subtracting the provided rational number from this rational number.
     *
     * @param x a rational number that is going to subtract the this rational number.
     */
    public void subtraction(RationalB x){
        setNumerator(this.numerator * x.denominator - x.numerator * this.denominator);
        setDenominator(this.denominator * x.denominator);
    }

    /**
     * Return a rational number as the result of multiplying the two provided rational numbers.
     *
     * @param r1 a rational r1 to be multiplied to another rational number.
     * @param r2 a rational r2 to be multiplied to another rational number.
     * @return a rational number as the result of multiplying the two provided rational numbers.
     */
    public static RationalB multiplication(RationalB r1, RationalB r2){
        int newNumerator = r1.numerator * r2.numerator;
        int newDenominator = r1.denominator * r2.denominator;
        return new RationalB(newNumerator, newDenominator);
    }

    /**
     * Change this rational number as the result of multiplying the provided rational number to this rational number.
     *
     * @param x a rational x to be multiplied to this rational number.
     */
    public void multiplication(RationalB x){
        setNumerator(this.numerator * x.numerator);
        setDenominator(this.denominator * x.denominator);
    }

    /**
     * Return a rational number as the result of the division operation of the two provided rational numbers.
     *
     * @param r1 a rational number to be divided by the other rational number.
     * @param r2 a rational number that are going to divide the other rational number.
     * @return a rational number as the result of the division operation of the two provided rational numbers.
     */
    public static RationalB division(RationalB r1, RationalB r2){
        int newNumerator = r1.numerator * r2.denominator;
        int newDenominator = r1.denominator * r2.numerator;
        return new RationalB(newNumerator, newDenominator);
    }

    /**
     * Change this rational number as the result of this rational number divide the provided rational number.
     *
     * @param x a rational number that are going to divide this rational number.
     */
    public void division(RationalB x){
        setNumerator(this.numerator * x.denominator);
        setDenominator(this.denominator * x.numerator);
    }

    /**
     * Return the value of this numerator.
     *
     * @return the value of this numerator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Set the value of this numerator.
     *
     * @param numerator the provided integer that are going to be this numerator.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Return the value of this denominator.
     *
     * @return the value of this denominator.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Set the value of this denominator.
     *
     * @param denominator the provided integer that are going to be this denominator.
     * @throws IllegalArgumentException if the provided integer is zero.
     */
    public void setDenominator(int denominator) throws IllegalArgumentException{
        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
        normalization();
    }

    /**
     * Return whether this rational number and the other rational number are equal.
     *
     * @param r1 the rational number that are going to compare with this rational number.
     * @return whether this rational number and the other rational number are equal.
     */
    public boolean equals(RationalB r1){
        if(this == r1){
            return true;
        }
        else if(this.getDenominator() * r1.getNumerator()
                == this.getNumerator() * r1.getDenominator()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Return a String representation of this rational number with this numerator and this denominator.
     * @return a String representation of this rational number with this numerator and this denominator.
     */
    @Override
    public String toString() {
        return this.getNumerator() + "/" + getDenominator();
    }

    /**
     * Set this rational number to a normalized form which the sign of this rational number only show up on numerator.
     */
    public void normalization(){
        if(this.denominator < 0){
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }
}