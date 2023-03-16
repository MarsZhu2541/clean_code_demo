package main.errorHandling;

public class Demo7_6 {

    public static int getMealPerDiem(){
        return 15;
    }
    public static class MealExpenses {
        private int total;

        public int getTotal() {
            return total;
        }

        public MealExpenses(int total) {
            this.total = total;
        }
    }

    public static class ExpenseReportDAO {
//        public MealExpenses getMeals(int emplyeeId) throws MealExpensesNotFound {
//            if (emplyeeId == 1) {
//                return new MealExpenses(20);
//            } else{
//                throw new MealExpensesNotFound();
//            }
//        }

        public MealExpenses getMeals(int emplyeeId) {
            if (emplyeeId == 1) {
                return new MealExpenses(20);
            }else {
                return new PerDiemMealExpense(0);
            }

        }
    }

    private static class MealExpensesNotFound extends Exception {
    }

    public static class PerDiemMealExpense extends MealExpenses{

        private int total;

        public PerDiemMealExpense(int total) {
            super(total);
            this.total=total;
        }

        public int getTotal() {
            return 15;
        }

    }

    public static void main(String[] args) {
        int m_total=0;
        ExpenseReportDAO expenseReportDAO = new ExpenseReportDAO();

//        try {
//            MealExpenses expenses = expenseReportDAO.getMeals(1);
//            m_total+=expenses.getTotal();
//        }catch (MealExpensesNotFound e){
//            m_total+=getMealPerDiem();
//        }

        MealExpenses expenses = expenseReportDAO.getMeals(1);
        m_total+=expenses.getTotal();

        System.out.println("m_total: "+m_total);
    }
}
