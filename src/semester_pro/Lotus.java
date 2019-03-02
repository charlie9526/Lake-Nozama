
package semester_pro;

import java.util.Random;

class Lotus {

    private String colour;                                                     
    int petals = 100;                                                           //one flower has 100 petals
    String name;
    static int count_lotus;                                                     //static count_lotus helps us to keep the count of flowes

    public Lotus(String name) {
        this.name = name;
        count_lotus++;
    }
    
    static String[] loname = new String[5];

    public static void lotus_set(Lake x) {                                      //from this method ,we can set flower objects in the lke
        Random rand = new Random();
        int i = 0;
        while (i < 5) {                                                         //there should be only five lotus flowrs
            int num1 = rand.nextInt(11);
            int num2 = rand.nextInt(11);
       
            if (x.getObject(num1, num2, 0) == null & (Lotus.count_lotus < 5)) {
                Lotus y = new Lotus(Lotus.loname[i]);
                x.addObject(y, num1, num2, 0);
                i++;
            }
        }
    }
}