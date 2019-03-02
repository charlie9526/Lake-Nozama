
package semester_pro;

import java.util.Random;

class Innocent_fish extends Fish {                                              //innocent fish class.

    public Innocent_fish(String name) {
        super(name);
        fish_count++;
    }
    
    static String[] innocent_fish_name = new String[2];                         //innocent fishes' names are contained in this array

    public static void if_set(Lake x) {                                         //this is the method which help us to contain innocent fish objects in the lake randomly
        Random rand = new Random();
        int i = 0;
        
        while (i < 2) {

            int num1 = rand.nextInt(11);
            int num2 = rand.nextInt(11);

            if (x.getObject(num1, num2, 0) == null & (Fish.fish_count < 7)) {   //if there isnt any object where we are to put inncnt fish object and fish count is lower than seven we can put fish object there.
                Innocent_fish y = new Innocent_fish(Innocent_fish.innocent_fish_name[i]);
                x.addObject(y, num1, num2, 0);
                y.the_lake=x;
                Fish_list[i] = y;
                i++;
            }
        }

    }
}
