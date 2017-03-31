package com.example.helloworld;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HelloWorld {

    public static void main(String[] param) {

        hello();
        System.exit(0);
    }

    private static void hello()
    {
        String born_date = JOptionPane.showInputDialog ("Please enter the date you were born in");
        String born_month = JOptionPane.showInputDialog ("Please enter the month you were born in");
        String born_year = JOptionPane.showInputDialog ("Please enter the year you were born in");

        int current_year = Calendar.getInstance().get(Calendar.YEAR);
     //   int current_month = (Calendar.getInstance().get(Calendar.MONTH))-1; // index jan starts from 0
     //   int current_date = Calendar.getInstance().get(Calendar.DATE);

         // virtual methods of objects is accessed by the dot
        // new Date, new to view object
        // read on virtual method objects - object oriented concept
        // objects read about
        // google

        // next task upload on github - connect it with intellij, trello
        // share on point - is version control system

        // in github - start project from zero, download all software
        
        // get answers in days, or try leap

        // note:  input has ranges - no decimals, invaild dates e.g: 31st feb or sybmols

        int date = Integer.parseInt(born_date);  //converting the string into integer
        int month = Integer.parseInt(born_month);
        int year = Integer.parseInt(born_year);

        int age = current_year - year;

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        Date dateobj = new Date();
        Date dates = new GregorianCalendar(current_year, month-1, date).getTime();  //return the millisecond since birth date

        System.out.println(df.format(dateobj));
        System.out.println(df.format(dates));

        long diff = (dates.getTime() - dateobj.getTime()) / (1000 * 60 * 60 * 24);   // long type

        if (diff <0)
    {

        int current_year_next = current_year + 1;  // 2017+1 = 2018
        dates = new GregorianCalendar(current_year_next, month-1, date).getTime();
        diff = (dates.getTime() - dateobj.getTime()) / (1000 * 60 * 60 * 24);
        age = current_year_next - year;
    }


        //diff returns time in millisecond
        // so have to convert millisecond into days
            // 1 second = 1000 millisecond
            // 1 minute = 60 seconds
            // 1 hour = 60 minute
            // 1 day = 24 hour

       // System.out.println(dateobj.getTime());   //return the millisecond since current date
       // System.out.println(dates.getTime());
       // System.out.println(df.format(diff));
        System.out.println(diff);
        JOptionPane.showMessageDialog(null,"There are " + diff +" days left until your " + age + " birthday");
       // return;
    }

}

