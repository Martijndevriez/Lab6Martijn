import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DBmanager dBmanager = DBmanager.getInstance();
        CityDAO cityDAO = CityDAO.getInstance(dBmanager);

        // [A]
        if (args.length == 0){
            ArrayList<String> cities = cityDAO.getCityNames("En");
            for (String str : cities) {
                System.out.println(str);
            }

            System.out.println();
        }

         if (args.length == 1) {
            // [B]
            System.out.println("Entered 1 parameter.");
            ArrayList<String> citiesX = cityDAO.getCityNames(args[0]);

            for (String str : citiesX) {
                System.out.println(str);
            }
        }

        else if (args.length == 2) {
            // [C]
             System.out.println("Entered 2 parameter.\n");
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