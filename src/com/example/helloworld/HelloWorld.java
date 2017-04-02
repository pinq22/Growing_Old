package com.example.helloworld;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import sun.util.resources.cldr.ebu.CalendarData_ebu_KE;
 */

// TODO sanitize inputs, note:  input has ranges - no decimals, invaild dates e.g: 31st feb or sybmols

// TODO learn clean code, Architecture, Model View Controller (implication of multiple files), create object - encapsulation

/*
 virtual methods of objects is accessed by the dot
 new Date, new to view object
read on virtual method objects - object oriented concept
 objects read about
 google
*/

// TODO create Trello account, share on point is version control system

// get answers in days, or try leap
public class HelloWorld {

    public static void main(String[] param) {
        hello();
        System.exit(0);
    }
    private static void hello()
    {
        String born_month = JOptionPane.showInputDialog ("Please enter the month you were born in");
        String born_date = JOptionPane.showInputDialog ("Please enter the date you were born in");
        String born_year = JOptionPane.showInputDialog ("Please enter the year you were born in");

        int current_year = Calendar.getInstance().get(Calendar.YEAR);

     //   int current_month = (Calendar.getInstance().get(Calendar.MONTH))-1; // index jan starts from 0
     //   int current_date = Calendar.getInstance().get(Calendar.DATE);

        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        // check if it is a leap year
        boolean isLeapYear = cal.isLeapYear(cal.get(GregorianCalendar.YEAR));

        int month = Integer.parseInt(born_month)-1;
        int date = Integer.parseInt(born_date);  //converting the string into integer
        int year = Integer.parseInt(born_year);
        int age = current_year - year;

        long diff;
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        Date dates = new GregorianCalendar(current_year, month, date).getTime();  //return the millisecond since birth date
        diff = (dates.getTime() - dateobj.getTime()) / (1000 * 60 * 60 * 24);   // long type
       /*
       diff returns time in millisecond
       so have to convert millisecond into days
       1 second = 1000 millisecond
       1 minute = 60 seconds
       1 hour = 60 minute
       1 day = 24 hour
        */
        if (diff <0)
        {
            int current_year_next = current_year + 1;  // 2017+1 = 2018
            dates = new GregorianCalendar(current_year_next, month, date).getTime();
            diff = (dates.getTime() - dateobj.getTime()) / (1000 * 60 * 60 * 24);
            age = current_year_next - year;
        }

        String [] month_name = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};

        if(year >=0 && year <= current_year ) {
            for (int i = 0; i < 12; i++) //L3
            {
                if (i == month) {
                    if (i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 || i == 11) {
                        for (int x = 1; x <= 31; x++) {
                            if (x == date) {
                                JOptionPane.showMessageDialog(null, "There are " + diff + " days left until your " + age + " birthday");
                            }
                        }
                    } else if (i == 1) // Feb = 29
                    {
                        if (isLeapYear) {
                            for (int z = 1; z <= 29; z++) {
                                if (z == date) {
                                    JOptionPane.showMessageDialog(null, "There are " + diff + " days left until your " + age + " birthday");
                                }
                            }
                        } else {
                            for (int z = 1; z <= 28; z++) {
                                if (z == date) {
                                    JOptionPane.showMessageDialog(null, "There are " + diff + " days left until your " + age + " birthday");
                                }
                            }
                        }
                    } else {
                        for (int z = 1; z <= 30; z++) {
                            if (z == date) {
                                JOptionPane.showMessageDialog(null, "There are " + diff + " days left until your " + age + " birthday");
                            }
                        }
                    }
                    System.out.println(month_name[i]);
                }
            }
        }
       // System.out.println(dateobj.getTime());   //return the millisecond since current date
       // System.out.println(dates.getTime());
       // System.out.println(df.format(diff));
       // return;
    }
}

