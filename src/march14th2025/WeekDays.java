package march14th2025;

public enum WeekDays {
    //public WeekDays extends Enum --> This is how it is being processed inside the compiler

    //Enum is a special type of class that represents a group of constants (unchangeable variables, like final variables).
//Enum is nothing but a collection of constant Values


    //public static final WeekDays MONDAY = new WeekDays();
    MONDAY, //Each Constant Represents an Object

    //public static final WeekDays TUESDAY = new WeekDays();
    TUESDAY,

    //public static final WeekDays WEDNESDAY = new WeekDays();
    WEDNESDAY,

    //public static final WeekDays THURSDAY = new WeekDays();
    THURSDAY,

    //public static final WeekDays FRIDAY = new WeekDays();
    FRIDAY,

    //public static final WeekDays SATURDAY = new WeekDays();
    SATURDAY,

    //public static final WeekDays SUNDAY = new WeekDays();
    SUNDAY;

    WeekDays() {
        System.out.println("Weekdays Enum is called");
    }

    private String weekday;

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }


    //Similar to a class we can have constructors, methods, getters and setters in Enum
    //We Cannot create an object of Enum
}

