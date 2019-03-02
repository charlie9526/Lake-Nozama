
package semester_pro;

import java.util.Random;

abstract class Fish extends Thread{                                             //fish is an abstract class.

    private String specy;
    Lake the_lake;
    boolean isMoved; 
    static int all_ok_mark;
    static boolean stop_mark;                                                   //stop mark helps to stop all threads when we wanna stop threads suddenly
    String name;
    int locationx;
    int locationy;
    static Fish[] Fish_list = new Fish[6];                                      //this is an array which storage fish objects only
    static int fish_count;                                                      //fish count is in fish_count atribute.its static because it is common thing for all fish objects

    public void run(){                                                          //run method of al fish threads
        while(true){
            swim(the_lake);
            all_ok_mark++;
            if (stop_mark || Warrior.count_warrior==0){
                Thread.currentThread().stop();
            }
        }
    }
    
     public void swim(Lake x){
        isMoved=true;
        while (isMoved ) {                                                      //there are four directions and random numbers are 0,1,2,3 for those directions
            Random randi = new Random();
            int num = randi.nextInt(4);
            if ((num == 0) & (locationx + 1 < 11)) {
                synchronized (this.the_lake.grid[locationx+1][locationy].layer){//here the grid location of fish objects are syncronized because at one time only one fish is able to live in a location
                    if (x.getObject(locationx+1,locationy,0)== null & (isMoved == true)) {
                        x.move_fish_Object(locationx, locationy, locationx + 1, locationy, 0);
                        locationx ++;
                        isMoved = false;
                    }
                    else{
                    continue;
                    }

                }
            }
            else if ((num == 1) & !((locationx - 1) < 0)) {
                synchronized(this.the_lake.grid[locationx-1][locationy].layer){
                    if (x.getObject(locationx-1,locationy,0) == null & (isMoved == true)) {
                        x.move_fish_Object(locationx, locationy, locationx - 1, locationy, 0);
                        locationx-=1;
                        isMoved = false;
                    }
                    else{
                        continue;
                    }
                }
            }
            else if ((num == 2) & (locationy + 1 < 11)) {
                synchronized(this.the_lake.grid[locationx][locationy+1].layer){
                    if (x.getObject(locationx,locationy+1,0) == null & (isMoved == true)) {
                            x.move_fish_Object(locationx, locationy, locationx , locationy+1, 0);
                            locationy ++;
                            isMoved = false;
                    }
                    else{
                       continue;
                    }
                }
            }
            else if ((num == 3) & !((locationy - 1) < 0)) {
                synchronized(this.the_lake.grid[locationx][locationy-1].layer){
                    if (x.getObject(locationx,locationy-1,0) == null & (isMoved == true)) {
                        x.move_fish_Object(locationx, locationy, locationx , locationy-1, 0);
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
     public Fish(String name) {                                                 //this is the constructor of fish
        this.name = name;
    }
}