/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semester_pro;

public class Semester_pro {
    
    public static void main(String[] args) {
        
        Lake nozama = new Lake("nozama",11,11);                                 // nozama is the name of the lake which we have to make the game

        Super_warrior.super_warrior_names[0] = ("Toby");                        //These are warriors' names.
        Super_warrior.super_warrior_names[1] = ("Happy");                       //"super_warrior_names" means super warrior's names
        Normal_warrior.normal_warrior_names[0] = ("Silvester");                 //"normal_warrior_names" means normal warrior's names
        Normal_warrior.normal_warrior_names[1] = ("Paige");

        Normal_warrior.set_normal_warrior(nozama);                              //this is to set normal warrior's objects in the lake nozama
        Super_warrior.set_super_warrior(nozama);                                //this is to set super warrior's objects in the lake nozama


        for (int x = 0; x < 5; x++) {
            Lotus.loname[x] = ("f" + new Integer(1 + x).toString());            //f1,f2,f3,f4,f5 are the names of lotus flowers
        }
        for (int x = 0; x < 2; x++) {
            Killer_fish.killer_fish_name[x] = ("kf" + new Integer(1 + x).toString());          //kf1,kf2 are names of killer fishes
        }
        for (int x = 0; x < 2; x++) {
            Rubber_eater_fish.rubeater_fish_name[x] = ("rf" + new Integer(1 + x).toString());      //rf1,rf2 are names of rubber eating fishes
        }
        for (int x = 0; x < 2; x++) {
            Innocent_fish.innocent_fish_name[x] = ("if" + new Integer(1 + x).toString());      //if1,if2 are names of innocent fishes
        }
        
        TreasureChest.setChest(nozama);                                         //this set treasurer chest in the lake nozama
        Killer_fish.kf_set(nozama);                                             //this row set killer fishes in the lake nozama
        Lotus.lotus_set(nozama);                                                //this row set lotuses in the lake nozama
        Rubber_eater_fish.rf_set(nozama);                                       //this row set rubber eater fishes in the lake nozma
        Innocent_fish.if_set(nozama);                                           //this row set innocent fishes in the lake nozama
                                                                                //this po boolean variable helps us to make super warrior to pick petals of lotus 
        
       Thread Toby = new Thread(Warrior.warriorList[2],"Toby");                         //this how warrior threads are made
       Thread Happy = new Thread(Warrior.warriorList[3],"Happy");
       Thread Sly = new Thread(Warrior.warriorList[0],"Silvester");
       Thread Paige = new Thread(Warrior.warriorList[1],"paige");
       
       Thread F0 = new Thread(Fish.Fish_list[0],Innocent_fish.innocent_fish_name[0]);//this how fish threads are made
       Thread F1 = new Thread(Fish.Fish_list[1],Innocent_fish.innocent_fish_name[1]);
       Thread F2 = new Thread(Fish.Fish_list[2],Rubber_eater_fish.rubeater_fish_name[0]);
       Thread F3 = new Thread(Fish.Fish_list[3],Rubber_eater_fish.rubeater_fish_name[1]);
       Thread F4 = new Thread(Fish.Fish_list[4],Killer_fish.killer_fish_name[0]);
       Thread F5 = new Thread(Fish.Fish_list[5],Killer_fish.killer_fish_name[1]);
       
       F0.start();                                                              //all fish threads are started
       F1.start();
       F2.start();
       F3.start();
       F4.start();
       F5.start();
       
       while (true){
        if (Fish.all_ok_mark>3){
                Toby.start();                                                   //here,all warrior threads are started after all fish threadas are started
                Happy.start();
                Sly.start();
                Paige.start();
                break;
        }
       }
       
       nozama.checking_disables();                                              //here when a warrior get disable, that warrior remove from grid and warrior list                                          
       
     }   
}