public class AvocadoPortion extends Portion_Ingredient {

    private static final Avocado AVOCADO = new Avocado();

    public AvocadoPortion(double amount) {
        super(AVOCADO, amount);
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

        return new AvocadoPortion(this.getAmount() + other.getAmount());
    }
}
