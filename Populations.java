package com.cody.main;

/**
 * Program # 1b
 * converts arrays of city names and their populations into a formatted table, while also including the percentage of
 * people that live in the city.
 * CS108-3
 * 9/7/20
 *
 * @author Cody Chinothai
 */
public class Populations {
    //calls the methods below to create the formatted table
    public static void main(String[] args) {
        printHeader();
        System.out.println(repeat('\u2014', 54));
        printStats(getCities(), getPopulations());

    }

    //formats the city information header into columns. Adjust the values !
    public static void printHeader() {
        System.out.printf("%-15s%-14s%13s%12s%3s\n", "City", "Country", "Population", "Percent", " ");

    }

    //returns string that repeats ch and is the length of the given int
    public static String repeat(char ch, int numOfCharsInString) {

        String characters = "";
        for (int i = 0; i < numOfCharsInString; i++) {
            characters += ch;
        }
        return characters;
    }

    //loops through cities and population arrays, printing/formatting the data and creating percent values
    public static void printStats(String[] cities, double[][] population) {
        String city = "";
        String country = "";
        double percent = 0.0;
        for (int a = 0; a < population.length; a++) {
            int commafind = cities[a].indexOf(",");
            city = cities[a].substring(0, commafind);
            country = cities[a].substring(commafind + 1);

            if (population[a][0] > 10000000) {
                percent = 100 * (population[a][0] / population[a][1]);
                System.out.format("%-15s%-17s%-,10.0f%12.3f", city, country, population[a][0], percent);
                System.out.println();
            }


        }
    }

    // returns program name and author
    public static String getId() {
        return "Program 1b, Cody Chinothai";
    }

    //returns city population for each city in the form of an array
    public static double[][] getPopulations() {
        double[][] populations = {
                {24153000, 1384688986},
                {18590000, 1384688986},
                {18000000, 207862518},
                {14657000, 81257239},
                {14543000, 162951560},
                {13617000, 126168156},
                {13197596, 143964513},
                {12877000, 105920222},
                {12784000, 1384688986},
                {12400000, 1296834042},
                {12038000, 207652865},
                {11908000, 1384688986},
                {11548000, 1384688986},
                {11035000, 1296834042},
                {10608000, 1384688986},
                {10355000, 207862518},
                {10290000, 50791919},
                {10152000, 1384688986},
                {10125000, 86300000},
                {9752000, 31773839}
        };
        return populations;
    }

    //returns city names in a single array
    public static String[] getCities() {
        String[] cities = {
                "Shanghai,China",
                "BEIJING,China",
                "Karachi,Pakistan",
                "Istanbul,Turkey",
                "DHAKA,Bangladesh",
                "TOKYO,Japan",
                "MOSCOW,Russia",
                "MANILA,Philippines",
                "Tianjin,China",
                "Mumbai,India",
                "Sao Paulo,Brazil",
                "Shenzhen,China",
                "Guangzhou,China",
                "DELHI,India",
                "Wuhan,China",
                "Lahore,Pakistan",
                "Seoul,South Korea",
                "Chengdu,China",
                "KINSHASA,Congo D.R.",
                "LIMA,Peru"
        };
        return cities;
    }

}
