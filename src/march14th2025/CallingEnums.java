package march14th2025;

public class CallingEnums {
    public static void main(String[] args) {

        WeekDays w1 = WeekDays.MONDAY;

        System.out.println(w1);

        //Prints the index position of the enum
        System.out.println(w1.ordinal());

        System.out.println("******************************************************************************************");

        //Get all the values that is present in the ENUM in the form of an array:
        WeekDays[] w2 = WeekDays.values();

        for (WeekDays w : w2) {
            System.out.println(w);
        }

        System.out.println("******************************************************************************************");

        WeekDays.MONDAY.setWeekday("WeekDay");
        WeekDays.TUESDAY.setWeekday("WeekDay");
        WeekDays.WEDNESDAY.setWeekday("WeekDay");
        WeekDays.THURSDAY.setWeekday("WeekDay");
        WeekDays.FRIDAY.setWeekday("WeekDay");
        WeekDays.SATURDAY.setWeekday("Weekend");
        WeekDays.SUNDAY.setWeekday("WeekEnd");

        for (WeekDays w : w2) {
            System.out.println(w + " is a " + w.getWeekday());
        }

        System.out.println("******************************************************************************************");

        MonthsEnum m1 = MonthsEnum.APRIL;

        System.out.println(m1.getMonthName());
        System.out.println(m1.getMonthNumber());
    }
}