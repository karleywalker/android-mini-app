package cs4720.cs.virginia.edu.BucketListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanna on 1/30/2017.
 */

public class ThingList {


    private static String[] names = {"Streak the Lawn", "Lighting of the Lawn", "High-Five Dean Groves", "Eat at Bodos Bagels"};
    private static String[] descs = {"Go run around the homer statue and come back.", "Have a great time and see some lights",
            "Just put your hand right on his hand!", "They're great bagels"};
    private static String[] lats = {"38.0889", "38.0881", "38.0887", "38.0992"};
    private static String[] longs = {"-78.5596", "-78.5593", "-78.5591", "-78.6650"};

    public static List<BucketItem> getMdata() {
        return mdata;
    }

    public static void setMdata(List<BucketItem> mdata) {
        ThingList.mdata = mdata;
    }

    private static List<BucketItem> mdata = makeListData();



    public static List<BucketItem> makeListData(){
        List<BucketItem> mdata = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
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
