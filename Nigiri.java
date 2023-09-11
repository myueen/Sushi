import static java.lang.Math.round;

public class Nigiri implements Sushi {

    private static Rice RICE = new Rice();
    private static RicePortion RICE_PORTION = new RicePortion(0.5);
    private static double RICE_COST = RICE_PORTION.getCost();
    private static double RICE_CALORIES = RICE_PORTION.getCalories();
    private NigiriType type_;
    private Ingredient ingredient;
    private IngredientPortion ingredientPortion_;

    public enum NigiriType {
        TUNA,
        YELLOWTAIL,
        EEL,
        CRAB,
        SHRIMP
    }

    public Nigiri(NigiriType type) {
        this.type_ = type;
        this.ingredient = getIngredient(type);
        this.ingredientPortion_ = getIngredientPortion(type);
    }

    private Ingredient getIngredient(NigiriType type) {
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

    private IngredientPortion getIngredientPortion(NigiriType type) {
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
        return this.ingredient.getName() + " nigiri";
    }

    @Override
    public IngredientPortion[] getIngredients() {
        IngredientPortion[] all_ingredient = new IngredientPortion[2];
        all_ingredient[0] = RICE_PORTION;
        all_ingredient[1] = this.ingredientPortion_;
        return all_ingredient;
    }

    @Override
    public int getCalories() {
        return (int) round(this.ingredientPortion_.getCalories() + RICE_CALORIES);
    }

    @Override
    public double getCost() {
        return this.ingredientPortion_.getCost() + RICE_COST;
    }

    @Override
    public boolean getHasRice() {
        return true;
    }

    @Override
    public boolean getHasShellfish() {
        return this.ingredientPortion_.getIsShellfish() || RICE.getIsShellfish();
    }

    @Override
    public boolean getIsVegetarian() {
        return this.ingredientPortion_.getIsVegetarian() && RICE.getIsVegetarian();
    }
}
