import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Roll implements Sushi {

    private String name_;
    private IngredientPortion[] roll_ingredients_;

    public Roll(String name, IngredientPortion[] roll_ingredients) {
        if (roll_ingredients == null) {
            throw new IllegalArgumentException("The array is empty!");
        }
        for (IngredientPortion ingredient : roll_ingredients) {
            if (ingredient == null) {
                throw new IllegalArgumentException("One or more of the ingredients portion is empty.");
            }
        }

        List<IngredientPortion> d = new ArrayList<>();
        List<IngredientPortion> no_d = new ArrayList<>();

        for (IngredientPortion ip : roll_ingredients) {
            d.add(ip);
        }

        int i = 0;
        while (i < d.size()) {
            for (int j = i + 1; j < d.size(); j++) {
                if (d.get(i).getName().equals(d.get(j).getName())) {
                    no_d.add(d.get(i).combine(d.get(j)));
                    d.remove(d.get(j));
                    i++;
                }
            }
            no_d.add(d.get(i));
            i++;
        }

        boolean check_seaweed = false;
        for (int j = 0; j < no_d.size(); j++) {
            if (no_d.get(j).getName().equals("seaweed")) {
                check_seaweed = true;
                if (no_d.get(j).getAmount() < 0.1) {
                    no_d.set(j, new SeaweedPortion(0.1));
                }
            }
        }

        if (!check_seaweed) {
            no_d.add(new SeaweedPortion(0.1));
        }

        this.name_ = name;
        this.roll_ingredients_ = no_d.toArray(new IngredientPortion[0]);
    }

    @Override
    public String getName() {
        return this.name_;
    }

    @Override
    public IngredientPortion[] getIngredients() {
        return this.roll_ingredients_.clone();
    }

    @Override
    public int getCalories() {
        double total_calories = 0;
        for (IngredientPortion ingredient : this.roll_ingredients_) {
            total_calories += ingredient.getCalories();
        }
        return (int) Math.round(total_calories);
    }

    @Override
    public double getCost() {
        double total_cost = 0.0;
        for (IngredientPortion ingredient : this.roll_ingredients_) {
            total_cost += ingredient.getCost();
        }
        return round((total_cost) * 100) / 100.0;
    }

    @Override
    public boolean getHasRice() {
        for (IngredientPortion ingredient : this.roll_ingredients_) {
            if (ingredient.getIsRice()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getHasShellfish() {
        for (IngredientPortion ingredient : this.roll_ingredients_) {
            if (ingredient.getIsShellfish()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getIsVegetarian() {
        for (IngredientPortion ingredient : this.roll_ingredients_) {
            if (!ingredient.getIsVegetarian()) {
                return false;
            }
        }
        return true;
    }
}
