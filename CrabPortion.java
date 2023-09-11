public class CrabPortion extends Portion_Ingredient {

    private static final Crab CRAB = new Crab();

    public CrabPortion(double amount) {
        super(CRAB, amount);
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

        return new CrabPortion(this.getAmount() + other.getAmount());
    }
}
