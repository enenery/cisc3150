import java.util.Scanner;

/**
 * cisc3150
 * hw2-q2
 * direction: Write a program that displays a calendar on the screen. It asks the user
 * the year, what day the first of January fell on, then displays every month
 * from January to December. Make sure to get the leap years right.
 * @author erii sugimoto
 * @since  9/9/2017.
 */
public class CalendarPrintf {

    public static void main(String args[]){
        System.out.print("Enter year: ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.print("Enter what day the first of January fell on for that year: ");
        String day = scanner.next();
        printCalendar(year, day);
    }

    public static void printCalendar(int year, String day){
        String month = "";
        String daysForDisplay = " Su Mo Tu We Th Fr Sa";
        int days = 0;
        int startDay = 0;

        day = day.toLowerCase();
        if(day.contains("su"))
            startDay = 0;
        else if (day.contains("mo"))
            startDay = 1;
        else if (day.contains("tu"))
            startDay = 2;
        else if (day.contains("we"))
            startDay = 3;
        else if (day.contains("th"))
            startDay = 4;
        else if (day.contains("fr"))
            startDay = 5;
        else if (day.contains("sa"))
            startDay = 6;


        for(int i = 0; i < 12; i++){
            switch (i) {
                case 0:
                   month = "January";
                   days = 31;
                   break;
                case 1:
                    month = "February";
                    if(year % 4 == 0)
                        days = 29;
                    else
                        days = 28;
                    break;
                case 2:
                    month = "March";
                    days = 31;
                    break;
                case 3:
                    month = "April";
                    days = 30;
                    break;
                case 4:
                    month = "May";
                    days = 31;
                    break;
                case 5:
                    month = "June";
                    days = 30;
                    break;
                case 6:
                    month = "July";
                    days = 31;
                    break;
                case 7:
                    month = "August";
                    days = 31;
                    break;
                case 8:
                    month = "September";
                    days = 30;
                    break;
                case 9:
                    month = "October";
                    days = 31;
                    break;
                case 10:
                    month = "November";
                    days = 30;
                    break;
                case 11:
                    month = "December";
                    days = 31;
                    break;
            }

            System.out.printf("\n\n%12s%1c%-10d\n", month, ' ', year);
            System.out.printf("%s\n", daysForDisplay);

            for(int j = 0; j < startDay; j++){
                System.out.printf("%3c", ' ');
            }

            for(int k = 1; k <= days; k++){
                if((startDay + k) % 7 == 0)
                    System.out.printf("%3d\n", k);
                else
                    System.out.printf("%3d", k);
            }

            startDay = (startDay + days) % 7;

        }
    }
}
