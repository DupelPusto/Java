package project.common;

public class Count {
    private int allTimeCustomers = 0;
    private int inDayCustomers = 0;
    private int inMonthCustomers = 0;
    private int inHalfyearCustomers = 0;
    private int inYearCustomers = 0;

    public void add(int i){
        this.allTimeCustomers += i;
        this.inDayCustomers += i;
        this.inMonthCustomers += i;
        this.inHalfyearCustomers += i;
        this.inYearCustomers += i;
    }

    public void showStatistic(){
        System.out.printf("\nСтатистика відвідувачів:\nЗа день: %d\nЗа місяць: %d\nЗа пів року: %d\nЗа рік: %d\nЗа весь час: %d",
                inDayCustomers, inMonthCustomers, inHalfyearCustomers, inYearCustomers, allTimeCustomers);
    }

}
