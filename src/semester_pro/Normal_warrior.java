
package semester_pro;

import java.util.Random;

class Normal_warrior extends Warrior{
      
    public void run(){                                                          //this is the run method of normal warioprs
       while (true){
          jump(the_lake);
          if (stop_mark==true){
              Thread.currentThread().stop();
          }
          else if(self_stop==true){
              break;
          }
         
       }
    }
    
     public Normal_warrior(String name, int locationx, int locationy) {
        super(name, locationx, locationy);
        count_warrior++;
    }
    static String[] normal_warrior_names = new String[2];                       //this array store normal warriors' names

    public static void set_normal_warrior(Lake x) {                             //this method helps to contain objects in the lake randomly.
        Random rand = new Random();
        int i = 0;
        while (i < 2) {
            int num1;
            int num2;

            while (true) {                                                      //this loop is for finding an edge point to situate a warrior
                num1 = rand.nextInt(11);
                num2 = rand.nextInt(11);
                if (num1 * num2 == 0) {

                    break;
                }
            }

            if (x.getObject(num1, num2, 1) == null && (Warrior.count_warrior < 5)) {

                Normal_warrior y = new Normal_warrior(Normal_warrior.normal_warrior_names[i], num1, num2);
                y.disable=false;
                y.locationx = num1;
                y.locationy = num2;
                y.the_lake = x;
                x.addObject(y, num1, num2, 1);
                warriorList[i] = y;
                i++;
            }
        }
    }
    
    public void jump(Lake x){
        isMoved=true;
        if (!disable){
            while (isMoved && !(disable)) {                                         
                Random randi = new Random();                                 
                int num = randi.nextInt(4);                                     //there are four directions and random numbers are 0,1,2,3 for those directions
                if ((num == 0) & (locationx + 1 < 11)) {
                    synchronized (this.the_lake.grid[locationx+1][locationy]){
                        if (x.getObject(locationx+1,locationy,1) == null & (isMoved == true)) {
                            x.move_warrior_Object(locationx, locationy, locationx + 1, locationy, 1);
                            locationx ++;
                            isMoved = false;
                    
                        }
                        else{
                            continue;
                        }
                    }
                } else if ((num == 1) & !((locationx - 1) < 0)) {
                    synchronized(this.the_lake.grid[locationx-1][locationy]){
                        if (x.getObject(locationx-1,locationy,1) == null & (isMoved == true)) {
                        x.move_warrior_Object(locationx, locationy, locationx - 1, locationy, 1);
                        locationx-=1;
                        isMoved = false;
                        }
                        else{
                            continue;
                        }
                    }
                } else if ((num == 2) & (locationy + 1 < 11)) {
                    synchronized(this.the_lake.grid[locationx][locationy+1]){
                        if (x.getObject(locationx,locationy+1,1) == null & (isMoved == true)) {
                            x.move_warrior_Object(locationx, locationy, locationx , locationy+1, 1);
                            locationy ++;
                            isMoved = false;
                        }
                        else{
                            continue;
                        }
                    }
                } else if ((num == 3) & !((locationy - 1) < 0)) {
                    synchronized(this.the_lake.grid[locationx][locationy-1]){
                        if (x.getObject(locationx,locationy-1,1) == null & (isMoved == true)) {
                            x.move_warrior_Object(locationx, locationy, locationx , locationy-1, 1);
                            locationy -=1;
                            isMoved = false;
                        }
                        else{
                            continue;
                        }
                    }
                }
            }
        }
    }
}