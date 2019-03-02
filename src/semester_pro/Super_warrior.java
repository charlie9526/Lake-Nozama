
package semester_pro;

import java.util.Random;

class Super_warrior extends Warrior { 
    
    public void run(){
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
    

    public Super_warrior(String name, int locationx, int locationy) {
        super(name, locationx, locationy);
        count_warrior++;
    }

    static String[] super_warrior_names = new String[2];                        //here super warriors names are stored in this array

    public static void set_super_warrior(Lake x) {                              //in this method we can put super warrior objects in the lake
        Random rand = new Random();
        int i = 0;
        while (i < 2) {
            int num1, num2;
            while (true) {
                num1 = rand.nextInt(11);
                num2 = rand.nextInt(11);

                if (num1 * num2 == 0) {
                    break;
                }
            }
            if ((x.getObject(num1, num2, 1) == null) & (Warrior.count_warrior < 5)) {

                Super_warrior y = new Super_warrior(Super_warrior.super_warrior_names[i], num1, num2);
                x.addObject(y, num1, num2, 1);
                y.disable=false;
                y.locationx = num1;
                y.locationy = num2;
                y.the_lake = x;
                warriorList[i + 2] = y;
                i++;
            }
        }
    }
    
    public void jump(Lake x) {                                                  //in this method super warrior can check lotus flowers and pick them
        isMoved=true;                                                           //this jump method is more differtent than jump method of the normal warriors.
        if (!disable){
            if ((immortal == false) && (locationx + 1 < 11) 
                    && !(x.grid[locationx + 1][locationy].take_object(0) == null)){
                synchronized(this.the_lake.grid[locationx+1][locationy]){
                    if((x.grid[locationx + 1][locationy].take_object(1) == null) 
                        && (x.grid[locationx + 1][locationy].take_object(0)).getClass() == Lotus.class) {
                        x.move_warrior_Object(locationx, locationy, locationx + 1, locationy, 1);
                        locationx++;
                        immortal = true;
                        isMoved=false;
                        System.out.println(name + " picked petl and  immortal by now");
                    }
                }
            } else if ((immortal==false) && (locationx - 1 >= 0) 
                    && !(x.grid[locationx -1][locationy].take_object(0) == null)){
                synchronized(this.the_lake.grid[locationx-1][locationy]){
                    if((x.grid[locationx - 1][locationy].take_object(1) == null) 
                        && (x.grid[locationx - 1][locationy].take_object(0)).getClass() == Lotus.class) {
                        x.move_warrior_Object(locationx, locationy, locationx - 1, locationy, 1);
                        immortal = true;
                        locationx-=1;
                        isMoved=false;
                        System.out.println(name + " picked petal and immortal by now");
                    }
                }
            } else if ((immortal==false)&&(locationy + 1 < 11)&& 
                    !(x.grid[locationx][locationy+1].take_object(0) == null)){ 
                    synchronized(this.the_lake.grid[locationx][locationy+1]){
                        if((x.grid[locationx][locationy + 1].take_object(1) == null) && (x.grid[locationx][locationy + 1].take_object(0)).getClass() == Lotus.class) {
                            x.move_warrior_Object(locationx, locationy, locationx, locationy + 1, 1);
                            immortal = true;
                            isMoved=false;
                            locationy++;
                            System.out.println(name + " picked petal and immortal by now");
                        }
                    }
            } else if ((immortal==false)&&(locationy - 1 >= 0)&& !(x.grid[locationx ][locationy-1].take_object(0) == null)){
                    synchronized(this.the_lake.grid[locationx][locationy-1]){
                        if((x.grid[locationx][locationy - 1].take_object(1) == null) && (x.grid[locationx][locationy - 1].take_object(0)).getClass() == Lotus.class) {
                            x.move_warrior_Object(locationx, locationy, locationx , locationy - 1, 1);
                            immortal = true;
                            isMoved=false;
                            locationy-=1;
                            System.out.println(name + "picked petal and immortal by now");
                        }
                    }
            } if (isMoved){
            
                while (isMoved) {                                               //there are four directions and random numbers are 0,1,2,3 for those directions
                    Random randi = new Random();
                    int num = randi.nextInt(4);
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
                            locationx=locationx-1;
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
}