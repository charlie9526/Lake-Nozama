
package semester_pro;

import java.util.Random;

class Killer_fish extends Fish {                                                //thos is the class for killer fishes

    public Killer_fish(String name) {
        super(name);
        fish_count++;
    }

    public void kill(Warrior x) {                                               //in this method killer fish kill warrir and then warrior will become an disabled object in the lake. 
        if (x.immortal!=true) {
            x.disable = true;
            System.out.println(x.name + " was dead from kilelr fish");
            Warrior.count_warrior=Warrior.count_warrior -1;
        } else {
            x.disable=false;
        }
    }
    static String[] killer_fish_name = new String[2];                           //killer fishe'names are contained here

    public static void kf_set(Lake x) {                                         //this is the method which help us to contain killer fish objects in the lake randomly
        Random rand = new Random();
        int i = 0;
        while (i < 2) {
            int num1 = rand.nextInt(11);
            int num2 = rand.nextInt(11);

            if ((x.getObject(num1, num2, 0) == null & (Fish.fish_count < 7))) {

                Killer_fish y = new Killer_fish(Killer_fish.killer_fish_name[i]);
                x.addObject(y, num1, num2, 0);
                y.the_lake=x;
                Fish_list[i+4] = y;
                i++;
            }
        }
    }
}
