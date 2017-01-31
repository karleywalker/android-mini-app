package cs4720.cs.virginia.edu.BucketListActivity;

/**
 * The adapter class that handles how a BucketItem appears in the RecyclerView
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public abstract class BucketListAdapter extends
        RecyclerView.Adapter<BucketListAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.bucket_item);

        }
    }

    // Store a member variable for the bucket items
    private List<BucketItem> mBucketItem;
    // Store the context for easy access
    private Context mContext;

    // Pass in the bucket item array into the constructor
    public BucketListAdapter(Context context, List<BucketItem> items) {
        mBucketItem = items;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public BucketListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View bIView = inflater.inflate(R.layout.bucket_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(bIView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(BucketListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        BucketItem item = mBucketItem.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
      /**  textView.setText(item.getName());
        if(!item.isOnline()) {
            textView.setClickable(false);
            textView.setActivated(false);
            textView.setEnabled(false);

        } **/

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mBucketItem.size();
    }
}