
package semester_pro;

import java.util.Random;

class Rubber_eater_fish extends Fish {                                          //this is the class for rubber eating fishes

    public Rubber_eater_fish(String name) {                                
        super(name);
        fish_count++;
    }

    public void attack(Warrior x) {                                             //thi how ruber eater fish attack wariors.after attacking the warrior is disabled
        x.disable = true;
        System.out.println(x.name + " was disabled from rub_eater fish");
        Warrior.count_warrior=Warrior.count_warrior -1;
    }
    static String[] rubeater_fish_name = new String[2];                         //here rubber fishes names are stored

    public static void rf_set(Lake x) {                                         //here fishes are randomly stablished in the lake
        Random rand = new Random();
        int i = 0;
        while (i < 2) {
            int num1 = rand.nextInt(11);
            int num2 = rand.nextInt(11);
            
            if (x.getObject(num1, num2, 0) == null & (Fish.fish_count < 7)) {

                Rubber_eater_fish y = new Rubber_eater_fish(Rubber_eater_fish.rubeater_fish_name[i]);
                x.addObject(y, num1, num2, 0);
                y.the_lake=x;
                Fish_list[i+2] = y;
                i++;
            }
        }

    }
}

