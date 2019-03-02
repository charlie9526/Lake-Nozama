
package semester_pro;


abstract class Warrior extends Thread  {

    static int count_warrior;                                                   //static count_warrior helps us to keep the count of warriors
    boolean liveliness;
    boolean immortal;
    boolean disable;
    String name;
    boolean win;
    int locationx;
    int locationy;
    boolean isMoved;     
    Lake the_lake;
    static boolean stop_mark;                                                   //stop mark helps to stop all threads when we wanna stop threads suddenly
    boolean self_stop;                                                          //self stop is to stop warrior object thread when attacked by some fish and get disable.
    static Warrior[] warriorList = new Warrior[4];                              //this is an array which storage wrrior objects only
    
    public Warrior(String name, int locationx, int locationy) {
    
        this.name = name;
        this.locationx = locationx;
        this.locationy = locationy;
        
    }
    
    public void pickpetal(Lotus y) {                                            //picking petal if warrior meet a flower is impossible..thats why pick petal method is here.
        if (y.petals > 0 & immortal!=true & !(this.getClass()==Super_warrior.class) ) {
            immortal = true;
            y.petals -= 1;
            System.out.println(name+" pickd petal and immortal by now");
        }
    }                                                                           
}