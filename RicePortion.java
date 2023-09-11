public class RicePortion extends Portion_Ingredient {

    private static final Rice RICE = new Rice();

    public RicePortion(double amount) {
        super(RICE, amount);
        if (amount < 0) {
            throw new IllegalArgumentException("Portion amount can not be negative!");
        }
    }

    @Override
    public IngredientPortion combine(IngredientPortion other) {
        if (other == null) {
            return this;
        }
        if (!this.getName().equals(other.getName())) {
            throw new IllegalArgumentException("The ingredients have to be the same!");
        }

        return new RicePortion(this.getAmount() + other.getAmount());
    }
}
