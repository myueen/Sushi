public class Sushi_Ingredient implements Ingredient {

    private String name;
    private int calories_per_ounce;
    private double price_per_ounce;
    private boolean is_vegetarian;
    private boolean is_rice;
    private boolean is_shellfish;

    public Sushi_Ingredient(
            String nm,
            double pricePerOunce,
            int caloriesPerOunce,
            boolean isVegetarian,
            boolean isRice,
            boolean isShellfish) {
        this.name = nm;
        this.calories_per_ounce = caloriesPerOunce;
        this.price_per_ounce = pricePerOunce;
        this.is_vegetarian = isVegetarian;
        this.is_rice = isRice;
        this.is_shellfish = isShellfish;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCaloriesPerDollar() {
        return this.calories_per_ounce / this.price_per_ounce;
    }

    @Override
    public int getCaloriesPerOunce() {
        return calories_per_ounce;
    }

    @Override
    public double getPricePerOunce() {
        return price_per_ounce;
    }

    @Override
    public boolean getIsVegetarian() {
        return is_vegetarian;
    }

    @Override
    public boolean getIsRice() {
        return is_rice;
    }

    @Override
    public boolean getIsShellfish() {
        return is_shellfish;
    }

    @Override
    public boolean equals(Ingredient other) {
        if (other == null) {
            return false;
        }

        if (this.name.equals(other.getName())
                && this.price_per_ounce == other.getPricePerOunce()
                && this.calories_per_ounce == other.getCaloriesPerOunce()
                && this.is_vegetarian == other.getIsVegetarian()
                && this.is_rice == other.getIsRice()
                && this.is_shellfish == other.getIsShellfish()) {
            return true;
        } else {
            return false;
        }
    }
}
