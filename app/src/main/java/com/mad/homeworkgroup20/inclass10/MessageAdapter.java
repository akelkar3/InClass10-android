package com.mad.homeworkgroup20.inclass10;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aliandro on 2/26/2018.
 */

public class MessageAdapter extends ArrayAdapter<Thread> {
    String currentUserId;
    public MessageAdapter(Context context, int resource, ArrayList<Thread> objects, String UserID) {
        super(context, resource, objects);
        Log.d("test", "MessageAdapter: "+ UserID);
        this.currentUserId=UserID;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Thread threadItem = getItem(position);
        if(convertView==null)
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view, parent, false);

        TextView title = (TextView)convertView.findViewById(R.id.threadTitle);
        ImageButton delete = convertView.findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Log.d("test", "onClick: deleteClicked");
               // apiCalls caller = new apiCalls();
                ((ListView) parent).performItemClick(view, position, 0); // Let the event be handled in onItemClick()
           //     caller.deleteMessage(threadItem.id);

            }
        });
     //   ImageView image = (ImageView)convertView.findViewById(R.id.newsImage);
       title.setText(threadItem.message);
      //set delete visibility
        //set the data from the news object
        delete.setVisibility(View.INVISIBLE);
        Log.d("test", "getView: after adding  "+ currentUserId);
        if (currentUserId.equalsIgnoreCase(threadItem.user_id))
            delete.setVisibility(View.VISIBLE) ;

        return convertView;
    }


}
