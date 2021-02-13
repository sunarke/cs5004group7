package hw4;

public class Pizza {
    private String size;
    private int cheeseToppings;
    private int pepperoniToppings;
    private int hamToppings;

    public Pizza(){
        this.size = "";
        this.cheeseToppings = 0;
        this.pepperoniToppings = 0;
        this.hamToppings = 0;
    }

    public Pizza(String size, int cheeseToppings, int pepperoniToppings, int hamToppings){
        setSize(size);
        setCheeseToppings(cheeseToppings);
        setPepperoniToppings(pepperoniToppings);
        setHamToppings(hamToppings);
    }

    public Pizza(Pizza p) {
        if (p == null){
            return;
        }
        this.size = p.size;
        this.cheeseToppings = p.cheeseToppings;
        this.pepperoniToppings = p.pepperoniToppings;
        this.hamToppings = p.hamToppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) throws IllegalArgumentException {
        if(!size.equals("small")  && !size.equals("medium") && !size.equals("large")){
            throw new IllegalArgumentException("Size of pizza can only be either small, medium, or large");
        }
        this.size = size;
    }

    public int getCheeseToppings() {
        return cheeseToppings;
    }

    public void setCheeseToppings(int cheeseToppings) throws IllegalArgumentException{
        if (cheeseToppings < 0){
            throw new IllegalArgumentException("topping cannot be zero");
        }
        this.cheeseToppings = cheeseToppings;
    }

    public int getPepperoniToppings() {
        return pepperoniToppings;
    }

    public void setPepperoniToppings(int pepperoniToppings) throws IllegalArgumentException{
        if (pepperoniToppings < 0){
            throw new IllegalArgumentException("topping cannot be zero");
        }
        this.pepperoniToppings = pepperoniToppings;
    }

    public int getHamToppings() {
        return hamToppings;
    }

    public void setHamToppings(int hamToppings) throws IllegalArgumentException{
        if (hamToppings < 0){
            throw new IllegalArgumentException("topping cannot be zero");
        }
        this.hamToppings = hamToppings;
    }

    //
    public double calcCost(){
        if(getSize().equals("small")){
           return 10 + 2 * (getCheeseToppings()+getHamToppings()+getPepperoniToppings());
        }
        else if(getSize().equals("medium")){
            return 12 + 2 * (getCheeseToppings()+getHamToppings()+getPepperoniToppings());
        }
        else {
            return 14 + 2 * (getCheeseToppings()+getHamToppings()+getPepperoniToppings());
        }

    }

    public String getDescription(){
        return String.format("pizza size: %s \n" +
                "the number of cheese toppings: %d \n" +
                "the number of pepperoni toppings: %d \n" +
                "the number of ham toppings: %d \n" +
                "the pizza cost: %.2f",
                getSize(), getCheeseToppings(), getPepperoniToppings(), getHamToppings(), calcCost());
    }

}
