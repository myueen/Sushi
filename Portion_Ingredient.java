public class Portion_Ingredient implements IngredientPortion {

    private Ingredient ingredient_;
    private double amount_;

    public Portion_Ingredient(Ingredient ingredient, double amount) {
        this.ingredient_ = ingredient;
        this.amount_ = amount;
    }

    @Override
    public Ingredient getIngredient() {

        return ingredient_;
    }

    @Override
    public double getAmount() {

        return amount_;
    }

    @Override
    public String getName() {

        return ingredient_.getName();
    }

    @Override
    public boolean getIsVegetarian() {

        return ingredient_.getIsVegetarian();
    }

    @Override
    public boolean getIsRice() {

        return ingredient_.getIsRice();
    }

    @Override
    public boolean getIsShellfish() {

        return ingredient_.getIsShellfish();
    }

    @Override
    public double getCalories() {

        return amount_ * ingredient_.getCaloriesPerOunce();
    }

    @Override
    public double getCost() {

        return amount_ * ingredient_.getPricePerOunce();
    }

    @Override
    public IngredientPortion combine(IngredientPortion other) {
        return null;
    }
}
