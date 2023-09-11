public class ShrimpPortion extends Portion_Ingredient {

    private static final Shrimp SHRIMP = new Shrimp();

    public ShrimpPortion(double amount) {
        super(SHRIMP, amount);
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

        return new ShrimpPortion(this.getAmount() + other.getAmount());
    }
}
