
package semester_pro;

class Grid_location{                                                            //here every grid loacation can be considered as a object
    Object[] layer;                                                             //warriors and other creatures are seperated by layers.
    private int[] location_x_y;
    
    public Grid_location(int[] cordinates){                                     //here there are two layers
        this.location_x_y = cordinates;
        this.layer = new Object[2];
    }
    public void delete_object(int layer){                                       //here we can delete any object by inputing the layer of the grid location
        this.layer[layer] = null;
    }
    public void add_object(int layer , Object x){
        this.layer[layer] = x;
    }
    public Object take_object(int layer){
        return this.layer[layer];
    }
}


