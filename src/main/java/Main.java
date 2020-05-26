/*
Made by Martijn de Vries
 */

import java.util.ArrayList;

public class Main {

    //main for dbmanager and citydao
    public static void main(String[] args) {

        DBmanager dBmanager = DBmanager.getInstance();
        CityDAO cityDAO = CityDAO.getInstance(dBmanager);

        // Assignment A let citydao find all cities starting with the name 'En'.
        if (args.length == 0){
            ArrayList<String> cities = cityDAO.getCityNames("En");
            for (String str : cities) {
                System.out.println(str);
            }

            System.out.println();
        }

        // Assignment B same as above only you can fill in city string in command line parameter.
         if (args.length == 1) {
            // [B]
            System.out.println("Entered one parameter.");
            ArrayList<String> citiesX = cityDAO.getCityNames(args[0]);

            for (String str : citiesX) {
                System.out.println(str);
            }
        }

         // Assignment C same as B only now it has 2 command line parameters.
        else if (args.length == 2) {
            // [C]
             System.out.println("Entered two parameter.\n");
             ArrayList<String> cities1 = cityDAO.getCityNames(args[0]);
             ArrayList<String> cities2 = cityDAO.getCityNames(args[1]);

             for (String str : cities1) {
                 System.out.println(str);
             }
             System.out.println("\n");
             for (String str : cities2) {
                 System.out.println(str);
             }
        }
    }
}
