package cs4720.cs.virginia.edu.BucketListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * The model representing a single bucket list item
 */

public class BucketItem {

    private String name;
    private String description;
    private String latitude;
    private String longitude;
    private int day;
    private int month;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {

        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {

        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    private static String[] names = {"Streak the Lawn", "Lighting of the Lawn", "High-Five Dean Groves", "Eat at Bodos Bagels"};
    private static String[] descs = {"Go run around the homer statue and come back.", "Have a great time and see some lights",
            "Just put your hand right on his hand!", "They're great bagels"};
    private static String[] lats = {"38.0889", "38.0881", "38.0887", "38.0992"};
    private static String[] longs = {"-78.5596", "-78.5593", "-78.5591", "-78.6650"};
    private static int[] days = {22, 20, 5, 4};
    private static int[] months = {5, 9, 5, 9};
    private static int[] years = {2018, 2018, 2017, 2017};

    private boolean isSelected;


    public static List<BucketItem> getMdata() {
        return mdata;
    }

    public static void setMdata(List<BucketItem> mdata) {
        BucketItem.mdata = mdata;
    }

    private static List<BucketItem> mdata = createInitialBucketList();

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public static List<BucketItem> createInitialBucketList() {
        List<BucketItem> mdata = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            BucketItem item = new BucketItem();
            item.setName(names[i]);
            item.setDescription(descs[i]);
            item.setLongitude(longs[i]);
            item.setLatitude(lats[i]);
            item.setDay(days[i]);
            item.setMonth(months[i]);
            item.setYear(years[i]);
            mdata.add(item);
        }
        return mdata;
    }


}
