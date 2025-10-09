package com.OOP.clases;

public class Count {
    private int allTimeCustomers;
    private int inDayCustomers;
    private int inMonthCustomers;
    private int inHalfyearCustomers;
    private int inYearCustomers;




    public void tostring(){
        System.out.printf("Статистика відвідувачів:\nЗа день: %d\nЗа місяць: %d\nЗа пів року: %d\nЗа рік: %d\nЗа весь час: %d",
                inDayCustomers, inMonthCustomers, inHalfyearCustomers, inYearCustomers, allTimeCustomers);
    }
}
