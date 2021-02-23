public class PizzaOrder {
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;
    private int numPizzas;

    public PizzaOrder(){
        this.numPizzas = 0;
        this.pizza1 = null;
        this.pizza2 = null;
        this.pizza3 = null;
    }

    public PizzaOrder(int numPizzas, Pizza pizza1, Pizza pizza2, Pizza pizza3) {
        setNumPizzas(numPizzas);
        setPizza1(pizza1);
        setPizza2(pizza2);
        setPizza3(pizza3);
    }

    public PizzaOrder(PizzaOrder anotherOrder){
        System.out.println("Copy constructor called");

        this.numPizzas = anotherOrder.numPizzas;

        if(anotherOrder.pizza1 == null){
            this.pizza1 = null;
        }
        else{
            this.pizza1 = new Pizza(anotherOrder.pizza1);
        }
        if(anotherOrder.pizza2 == null){
            this.pizza2 = null;
        }
        else{
            this.pizza2 = new Pizza(anotherOrder.pizza2);
        }
        if(anotherOrder.pizza3 == null){
            this.pizza3 = null;
        }
        else {
            this.pizza3 = new Pizza(anotherOrder.pizza3);
        }


    }

    public void setNumPizzas(int numPizzas) throws IllegalArgumentException{
        if(numPizzas < 1 || numPizzas >3){
            throw new IllegalArgumentException("the number of pizzas in this order must between 1 and 3.");
        }
        this.numPizzas = numPizzas;
    }

    public void setPizza1(Pizza pizza1) {
        this.pizza1 = pizza1;
    }

    public void setPizza2(Pizza pizza2) throws IllegalArgumentException {
        if(this.numPizzas < 2){
            throw new IllegalArgumentException("setPizza2 method will be used only if there are two or three pizzas in the order.");
        }
        this.pizza2 = pizza2;
    }

    public void setPizza3(Pizza pizza3) throws IllegalArgumentException {
        if(this.numPizzas < 3){
            throw new IllegalArgumentException("setPizza3 method will be used only if there are three pizzas in the order.");
        }
        this.pizza3 = pizza3;
    }

    public double calcTotal(){
        switch (this.numPizzas){
            case 1:
                return pizza1.calcCost();
            case 2:
                return pizza1.calcCost() + pizza2.calcCost();
            case 3:
                return pizza1.calcCost() + pizza2.calcCost() + pizza3.calcCost();
            default:
                return -9999;
        }


    }

    public int getNumPizzas(){
        return this.numPizzas;
    }

    public Pizza getPizza1() {
        return this.pizza1;
    }

    public Pizza getPizza2() {
        return this.pizza2;
    }

    public Pizza getPizza3() {
        return this.pizza3;
    }

    public static void main(String[] args) {

        Pizza pizza1 = new Pizza("large", 1, 0, 1);
        Pizza pizza2 = new Pizza("medium", 2, 2, 0);
        PizzaOrder order1 = new PizzaOrder();

        order1.setNumPizzas(2);
        order1.setPizza1(pizza1);
        order1.setPizza2(pizza2);
        double total1 = order1.calcTotal();
        System.out.println(total1);

        PizzaOrder order2 = new PizzaOrder(order1);
        order2.getPizza1().setCheeseToppings(3);
        double total2 = order2.calcTotal();
        double originalTotal = order1.calcTotal();
        System.out.println(total2);
        System.out.println(originalTotal);
    }
}
