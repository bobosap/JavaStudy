package demo.downcasting;

import java.util.ArrayList;
import java.util.List;

public class ShopCar {

    private List<Electronics> mlist = new ArrayList<Electronics>();

    //add
    public void add(Electronics electronic){
        mlist.add(electronic);
    }



    //get size
    public int getSize(){
        return mlist.size();
    }

    //get item
    public Electronics getListItem(int position){
        return mlist.get(position);
    }
}
