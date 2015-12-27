package com.l2j.myepldatabase;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daruken on 15. 12. 27..
 */
public class MultiAdapter extends BaseAdapter {
    ArrayList<StructEplClub> item;
    private int layout;
    LayoutInflater inflater;

    public MultiAdapter(Context context, int layout, ArrayList<StructEplClub> item){
        this.item = item;
        this.layout = layout;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return item.size();
    }

    @Override
    public Object getItem(int position){
        return item.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }

        int[] drawablesLiverpool = new int[]{R.drawable.liverpool_1, R.drawable.liverpool_2, R.drawable.liverpool_3,
                R.drawable.liverpool_4, R.drawable.liverpool_5, R.drawable.liverpool_6,
                R.drawable.liverpool_7, R.drawable.liverpool_8, R.drawable.liverpool_9,
                R.drawable.liverpool_10, R.drawable.liverpool_11, R.drawable.liverpool_12,
                R.drawable.liverpool_13, R.drawable.liverpool_14, R.drawable.liverpool_15,
                R.drawable.liverpool_16, R.drawable.liverpool_17, R.drawable.liverpool_18,
                R.drawable.liverpool_19, R.drawable.liverpool_20, R.drawable.liverpool_21,
                R.drawable.liverpool_22, R.drawable.liverpool_23 };

        int[] drawablesArsenal = new int[]{R.drawable.arsenal_1, R.drawable.arsenal_2, R.drawable.arsenal_3,
                R.drawable.arsenal_4, R.drawable.arsenal_5, R.drawable.arsenal_6,
                R.drawable.arsenal_7, R.drawable.arsenal_8, R.drawable.arsenal_9,
                R.drawable.arsenal_10, R.drawable.arsenal_11, R.drawable.arsenal_12,
                R.drawable.arsenal_13, R.drawable.arsenal_14, R.drawable.arsenal_15,
                R.drawable.arsenal_16, R.drawable.arsenal_17, R.drawable.arsenal_18,
                R.drawable.arsenal_19, R.drawable.arsenal_20, R.drawable.arsenal_21,
                R.drawable.arsenal_22, R.drawable.arsenal_23 };

        int[] drawablesManUtd = new int[]{R.drawable.manutd_1, R.drawable.manutd_2, R.drawable.manutd_3,
                R.drawable.manutd_4, R.drawable.manutd_5, R.drawable.manutd_6,
                R.drawable.manutd_7, R.drawable.manutd_8, R.drawable.manutd_9,
                R.drawable.manutd_10, R.drawable.manutd_11, R.drawable.manutd_12,
                R.drawable.manutd_13, R.drawable.manutd_14, R.drawable.manutd_15,
                R.drawable.manutd_16, R.drawable.manutd_17, R.drawable.manutd_18,
                R.drawable.manutd_19, R.drawable.manutd_20, R.drawable.manutd_21,
                R.drawable.manutd_22, R.drawable.manutd_23 };

        MainActivity mainActivity = new MainActivity();
        if(mainActivity.mClub.equals("liverpool")) {
            ImageView imageViewProfile = (ImageView) convertView.findViewById(R.id.imageViewProfile);
            imageViewProfile.setImageResource(drawablesLiverpool[position]);
        }else if(mainActivity.mClub.equals("arsenal")){
            ImageView imageViewProfile = (ImageView) convertView.findViewById(R.id.imageViewProfile);
            imageViewProfile.setImageResource(drawablesArsenal[position]);
        }else if(mainActivity.mClub.equals("manutd")){
            ImageView imageViewProfile = (ImageView) convertView.findViewById(R.id.imageViewProfile);
            imageViewProfile.setImageResource(drawablesManUtd[position]);
        }else{

        }

        TextView textViewName = (TextView)convertView.findViewById(R.id.textViewName);
        String playerName = "Name : " + item.get(position).mPlayerName;
        textViewName.setText(playerName);

        TextView textViewPosition = (TextView)convertView.findViewById(R.id.textViewPosition);
        String playerPosition = "Position : " + item.get(position).mPosition;
        textViewPosition.setText(playerPosition);

        TextView textViewNumber = (TextView)convertView.findViewById(R.id.textViewNumber);
        String playerNumber = "Number : " + String.valueOf(item.get(position).mNumber);
        textViewNumber.setText(playerNumber);

        return convertView;
    }
}
