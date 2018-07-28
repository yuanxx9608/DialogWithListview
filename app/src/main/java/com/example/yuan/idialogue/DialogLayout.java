package com.example.yuan.idialogue;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialogLayout {

    String[] mlistText = {"P1   ", "P2  H", "P3   ", "P4   ", "P5   ", "P6   " ,"P7   ", "P8   " };
    ArrayList<Map<String, Object>> mData = new ArrayList<>();
    private Context mContext;

    public DialogLayout(Context context){
        this.mContext=context;
    }

    public void dilogLayoutF(){
        final int length = mlistText.length;
        for (int i = 0; i < length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("text", mlistText[i]);
            mData.add(item);
        }

        final AlertDialog.Builder dialog_builder = new AlertDialog.Builder(mContext);
        View views = LayoutInflater.from(mContext).inflate(R.layout.dialog_layout, null);

        final ListView listview = (ListView) views.findViewById(R.id.dialog_list);
        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        SimpleAdapter dialogAdapter = new SetSimpleAdapter(mContext, mData, R.layout.dialog_list_item, new String[] { "text" },
                new int[] { R.id.dialog_item_text });
        listview.setAdapter(dialogAdapter);
        dialog_builder.setView(views);
        final AlertDialog dialog = dialog_builder.show();

        dialog.findViewById(R.id.dialog_btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listview.getCheckedItemCount()!=0){
                    Toast.makeText(mContext,mlistText[listview.getCheckedItemPosition()],Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(mContext,"请选择其中一项",Toast.LENGTH_SHORT).show();
                }

            }
        });

        WindowManager.LayoutParams dialog_lp = dialog.getWindow().getAttributes();
        dialog_lp.width = mContext.getResources().getDimensionPixelSize(R.dimen.dialog_width);
        dialog_lp.height = mContext.getResources().getDimensionPixelSize(R.dimen.dialog_height);
        dialog.getWindow().setAttributes(dialog_lp);

    }

    class SetSimpleAdapter extends SimpleAdapter {

        public SetSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,
                                int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LinearLayout.inflate(mContext, R.layout.dialog_list_item, null);
            }
            return super.getView(position, convertView, parent);
        }
    }
}
