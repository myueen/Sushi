public class EelPortion extends Portion_Ingredient {

    private static final Eel EEL = new Eel();

    public EelPortion(double amount) {
        super(EEL, amount);
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

        return new EelPortion(this.getAmount() + other.getAmount());
    }
}
