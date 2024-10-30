import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient {
    public String getName();
    public double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public void SolidIngredient (String n, double q){
        _name = n;
        _quantity = q;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public void LiquidIngredient (String n, double q){
        _name = n;
        _quantity = q;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}
class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredientsSet;
    public void Recipe(String n, String i, ArrayList<T> is) {
        _name = n;
        _instructions = i;
        _ingredientsSet = is;
    }
    public void addIngredient(T t) {
        _ingredientsSet.add(t);
    }
    public void print() {
        System.out.println("name: " + _name);
        System.out.println("instructions: " + _instructions);
        System.out.println("list: ");
        for (int i = 0; i < _ingredientsSet.size(); i++) {
            System.out.println("name: " + _ingredientsSet.get(i).getName());
            System.out.println("quantity: " + _ingredientsSet.get(i).getQuantity());
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Recipe<Ingredient> r = new Recipe<Ingredient>("john", "blah", new ArrayList<Ingredient>());


//        Scanner scan = new Scanner(System.in);
//        System.out.println(EmployeeList.get(0).toString());
//        System.out.println("Enter 1 to print full time or 2 to print part time or 3 to print contractors or -1 to exit");
//        String input = scan.next();
//        while (!input.equals("-1")) {
//            if (input.equals("1")) {
//                for (int i = 0; i < EmployeeList.size(); i++) {
//                    if (EmployeeList.get(i) instanceof FullTimeEmp fte) {
//                        System.out.println("Id: " + fte.getId() + ", Name: " + fte.getName() + ", Salary $" + fte.getSalary() + ", Pay: $" + df.format(fte.calculatePay()));
//                    }
//                }
//            }
//            else if (input.equals("2")) {
//                for (int i = 0; i < EmployeeList.size(); i++) {
//                    if (EmployeeList.get(i) instanceof PartTimeEmp pte) {
//                        System.out.println("Id: " + pte.getId() + ", Name: " + pte.getName() + ", Hours: " + pte.getHoursWorked() + ", Hourly Pay: $" + pte.getHoursPay() + ", Pay: $" + df.format(pte.calculatePay()));
//                    }
//                }
//            }
//            else if (input.equals("3")) {
//                for (int i = 0; i < EmployeeList.size(); i++) {
//                    if (EmployeeList.get(i) instanceof Contractor con) {
//                        System.out.println("Id: " + con.getId() + ", Name: " + con.getName() + ", Projects: " + con.getProjectDone() + ", Pay Per Project: $" + con.getProjectRate() + ", Pay: $" + df.format(con.calculatePay()));
//                    }
//                }
//            }
//            else {
//                System.out.println("Error: wrong input");
//            }
//            System.out.println("Enter 1 to print full time or 2 to print part time or 3 to print contractors or -1 to exit");
//            input = scan.next();
//        }
    }
}