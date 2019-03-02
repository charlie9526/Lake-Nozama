
package semester_pro;


class Lake{

    Grid_location grid[][];                                                     
    int width;
    int height;
    String name;
    int numb = 0;
    
    public  void checking_disables(){
        while (!(Warrior.stop_mark==false || Warrior.count_warrior==0 )){
            for (Warrior x : Warrior.warriorList){
                if (x.disable){
                    remove_Object(x.locationx, x.locationy, 1);
                    x=null;
                }
            }
        }
      
    }
    

    public void addObject(Object obj, int x, int y, int layer) {                //from this method we can contain any kind of object in the lake
        grid[x][y].add_object(layer, obj);
        
        numb++;
        if (numb>16){
            System.out.println(Thread.currentThread().getName()+" moved to "+ x+" , "+ y);
        }
    }

    public void remove_Object(int x, int y, int layer) {                         //from this method we can remove any kind of object in the lake
        grid[x][y].delete_object(layer);
    }

    public Object getObject(int x, int y, int layer) {                          //from this method we can get any kind of object from the lake
        return grid[x][y].take_object(layer);
    }

    public void move_warrior_Object(int early_x, int early_y, int new_x, int new_y, int layr) {//from this method we can move warrior objects in the lake
            Object obj = getObject(early_x, early_y, layr);
            ((Warrior) obj).isMoved = true;
            remove_Object(early_x, early_y, layr);       
            addObject(obj, new_x, new_y, layr);
            checkStatus(new_x, new_y);        
    }
     public void move_fish_Object(int early_x, int early_y, int new_x, int new_y, int layr) {//from this method we can move any kind of fish object in the lake
            Object obj = getObject(early_x, early_y, layr);
            remove_Object(early_x, early_y, layr);       
            addObject(obj, new_x, new_y, layr);       
    }
 
     public Lake(String name , int width , int height) {
        
        this.name = name;
        this.height = height;
        this.width = width;
        this.grid = new Grid_location[width][height];
     
        for (int x=0 ; x<width ; x++){
            for (int y=0 ; y<height ; y++){
                this.grid[x][y] = new Grid_location(new int[] {x,y});
            }
        }
    }

    public void checkStatus(int x, int y) {                                     //after moving warrior we should check whether is there any fish or flower.then warrior should face to them
        Object obj = getObject(x, y, 0);
        if(obj != null){
            if (!(obj instanceof Innocent_fish)) {
                if (obj instanceof Killer_fish) {
                    ((Killer_fish) obj).kill((Warrior) getObject(x, y, 1));
                    
                     if( ((Warrior) getObject(x,y,1)).disable==true){
                        ((Warrior) getObject(x, y, 1)).self_stop=true;
                        
                    }       
                } else if (obj instanceof Rubber_eater_fish) {
                    ((Rubber_eater_fish) obj).attack((Warrior) getObject(x, y, 1));
                    ((Warrior) getObject(x, y, 1)).self_stop=true;
                    
                } else if (obj instanceof Lotus) {
                    Object obj3 = getObject(x, y, 1);
                    ((Warrior) obj3).pickpetal((Lotus) obj);
                } else {
                    ((TreasureChest) obj).setIsTaken(true);
                    ((TreasureChest) obj).setWinner((Warrior) getObject(x, y, 1));
                    Warrior.stop_mark=true;
                    Fish.stop_mark = true;
                }
            }
        }
    }
}
