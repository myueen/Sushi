public class SeaweedPortion extends Portion_Ingredient {

    private static final Seaweed SEAWEED = new Seaweed();

    public SeaweedPortion(double amount) {
        super(SEAWEED, amount);
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

        return new SeaweedPortion(this.getAmount() + other.getAmount());
    }
}
