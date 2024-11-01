import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient {
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _qtyInGm; // in grams
    public SolidIngredient (String n, double q){
        _name = n;
        _qtyInGm = q;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _qtyInGm;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _qtyInMl; // in millileters
    public LiquidIngredient (String n, double q){
        _name = n;
        _qtyInMl = q;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _qtyInMl;
    }
}
// constraint for the type var - have to use extends
class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    public Recipe(String n, String i) {
        _name = n;
        _instructions = i;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T t) {
        _ingredients.add(t);
    }
    public void print() {
        System.out.println("Recipe: " + _name);
        System.out.println("instructions: " + _instructions);
        System.out.println("Ingredients: ");
        for (int i = 0; i < _ingredients.size(); i++) {
            System.out.println("- " + _ingredients.get(i).getName() + ": " + _ingredients.get(i).getQuantity());
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Recipe<Ingredient> r = new Recipe<Ingredient>("john", "blah");
//        r.addIngredient(new SolidIngredient("Carrot", 2));
//        r.addIngredient(new LiquidIngredient("broth", 1));
//        r.addIngredient(new SolidIngredient("meat", 2));
//        r.print();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1 to add ingredient or 2 to list ingredient or -1 to exit");
        String input = scan.next();
        while (!input.equals("-1")) {
            if (input.equals("1")) {
                System.out.println("Enter 1 for Solid and 2 for Liquid ingredient");
                input = scan.next();
                if (input.equals("1")) {
                    System.out.println("Enter name: ");
                    String n = scan.next();
                    System.out.println("Enter quantity");
                    double q = scan.nextDouble();
                    r.addIngredient(new SolidIngredient(n, q));
                }
                else {
                    System.out.println("Enter name: ");
                    String n = scan.next();
                    System.out.println("Enter quantity");
                    double q = scan.nextDouble();
                    r.addIngredient(new LiquidIngredient(n, q));
                }
            }
            else if (input.equals("2")) {
                r.print();
            }
            else {
                System.out.println("Error: wrong input");
            }
            System.out.println("Enter 1 to add ingredient or 2 to list ingredient or -1 to exit");
            input = scan.next();
        }
    }
}