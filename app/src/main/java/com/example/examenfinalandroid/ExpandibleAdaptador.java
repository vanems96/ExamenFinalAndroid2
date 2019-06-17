package com.example.examenfinalandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpandibleAdaptador  extends BaseExpandableListAdapter {

    private ArrayList<String> listMedidas;
    private Map<String, ArrayList<String>> mapChild;
    private Context context;

    public ExpandibleAdaptador(ArrayList<String> listMedidas, Map<String, ArrayList<String>> mapChild, Context context) {
        this.listMedidas = listMedidas;
        this.mapChild = mapChild;
        this.context = context;
    }

    public ExpandibleAdaptador(List<Fecha> fechas) {
    }

    @Override

    public int getGroupCount() {

        return listMedidas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapChild.get(listMedidas.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listMedidas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(listMedidas.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String fechaMedidas = (String) getGroup(groupPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.expandible_group,null);
        TextView tvGroup = convertView.findViewById(R.id.ExpandibleGroup);
       // TextView tvChild = convertView.findViewById(R.id.ExpandibleChild);
        tvGroup.setText(fechaMedidas);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String itemMedidas = (String) getChild(groupPosition,childPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.expandible_child,null);
        TextView tvChild = convertView.findViewById(R.id.ExpandibleChild);
        tvChild.setText(itemMedidas);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
