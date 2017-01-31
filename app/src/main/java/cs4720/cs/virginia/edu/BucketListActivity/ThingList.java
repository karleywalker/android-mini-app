package cs4720.cs.virginia.edu.BucketListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanna on 1/30/2017.
 */

public class ThingList {


    public static String[] names = {"Streak the Lawn", "Lighting of the Lawn", "High-Five Dean Groves"};
    public static String[] descs = {"Go run around the homesr statue and come back.", "Have a great time and see some lights",
            "Just put your hand right on his hand!"};
    public static double[] lats = {38.0889, 38.0881, 38.0887};
    public static double[] longs = {-78.5596, -78.5593, -78.5591};



    public static List<BucketItem> getListData(){
        List<BucketItem> mdata = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            BucketItem item = new BucketItem();
            item.setName(names[i]);
            item.setDescription(descs[i]);
            item.setLongitude(longs[i]);
            item.setLatitude(lats[i]);
            mdata.add(item);
        }
        return mdata;
    }

}
