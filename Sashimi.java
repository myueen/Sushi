import static java.lang.Math.round;

public class Sashimi implements Sushi {

    private SashimiType type_;
    private Ingredient ingredient;
    private IngredientPortion ingredientPortion_;

    public enum SashimiType {
        TUNA,
        YELLOWTAIL,
        EEL,
        CRAB,
        SHRIMP
    }

    public Sashimi(SashimiType type) {
        this.type_ = type;
        this.ingredient = getIngredient(type);
        this.ingredientPortion_ = getIngredientPortion(type);
    }

    private Ingredient getIngredient(SashimiType type) {
        switch (type) {
            case TUNA:
                return new Tuna();
            case YELLOWTAIL:
                return new Yellowtail();
            case EEL:
                return new Eel();
            case CRAB:
                return new Crab();
            case SHRIMP:
                return new Shrimp();
            default:
                return null;
        }
    }

    private IngredientPortion getIngredientPortion(SashimiType type) {
        switch (type) {
            case TUNA:
                return new TunaPortion(0.75);
            case YELLOWTAIL:
                return new YellowtailPortion(0.75);
            case EEL:
                return new EelPortion(0.75);
            case CRAB:
                return new CrabPortion(0.75);
            case SHRIMP:
                return new ShrimpPortion(0.75);
            default:
                return null;
        }
    }

    @Override
    public String getName() {
        return this.ingredient.getName() + " sashimi";
    }

    @Override
    public IngredientPortion[] getIngredients() {
        IngredientPortion[] all_ingredient = new IngredientPortion[1];
        all_ingredient[0] = this.ingredientPortion_;
        return all_ingredient;
    }

    @Override
    public int getCalories() {

        return (int) round(this.ingredientPortion_.getCalories());
    }

    @Override
    public double getCost() {

        return this.ingredientPortion_.getCost();
    }

    @Override
    public boolean getHasRice() {

        return this.ingredientPortion_.getIsRice();
    }

    @Override
    public boolean getHasShellfish() {

        return this.ingredientPortion_.getIsShellfish();
    }

    @Override
    public boolean getIsVegetarian() {

        return this.ingredientPortion_.getIsVegetarian();
    }
}
