public class YellowtailPortion extends Portion_Ingredient {

    private static final Yellowtail YELLOWTAIL = new Yellowtail();

    public YellowtailPortion(double amount) {
        super(YELLOWTAIL, amount);
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

        return new YellowtailPortion(this.getAmount() + other.getAmount());
    }
}
