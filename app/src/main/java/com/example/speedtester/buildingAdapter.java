package com.example.speedtester;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class buildingAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] buildingName;
    int[] buildingLevel;
    int[] buildingAP;

    //to do: warning and critical

    public buildingAdapter(Context c, String[] n, int[] l, int[] a){
        buildingName = n;
        buildingLevel = l;
        buildingAP = a;

        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return buildingName.length;
    }

    @Override
    public Object getItem(int position) {
        return buildingName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.building_listview_detail, parent,false);

        TextView towerNameTextView = (TextView) v.findViewById(R.id.towerNameTextView);
        TextView numberLevelsTextView = (TextView) v.findViewById(R.id.totalLevelsTextView);
        TextView numberSsidTextView = (TextView) v.findViewById(R.id.totalAPTextView);
        TextView warningNumberTextView = (TextView) v.findViewById(R.id.warningNumTextView);
        TextView criticalNumberTextView = (TextView) v.findViewById(R.id.criticalNumTextView);

        String Name = buildingName[position];
        int Level = buildingLevel[position];
        int NumAp;
        if(buildingAP != null){
            NumAp = buildingAP[position];}
        else{
            NumAp=0;
        }


        Log.d("adapter", "view");
        Log.d("adapter", String.valueOf(buildingAP));



        towerNameTextView.setText(Name);
        numberLevelsTextView.setText("levels: "+Level);
        if(buildingAP != null)
        numberSsidTextView.setText("AP: "+NumAp);
        else
        numberSsidTextView.setText("AP: loading");
        return v;
    }
}