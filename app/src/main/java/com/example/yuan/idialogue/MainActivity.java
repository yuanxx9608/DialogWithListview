package com.example.yuan.idialogue;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    String[] mDialoglistText = {"P1   ", "P2  H", "P3   ", "P4   ", "P5   ", "P6   ", "P7   ", "P8   "};
    ArrayList<Map<String, Object>> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int mDialogLength = mDialoglistText.length;
        for (int i = 0; i < mDialogLength; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("text", mDialoglistText[i]);
            mData.add(item);
        }

        Button dialog_btn_test = (Button) findViewById(R.id.dialog_btn_test);
        dialog_btn_test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                final AlertDialog.Builder dialog_builder = new AlertDialog.Builder(MainActivity.this);
//                View views = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_layout, null);
//
//                final ListView listview = (ListView) views.findViewById(R.id.dialog_list);
//                listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//                SimpleAdapter dialogAdapter = new SetSimpleAdapter(MainActivity.this, mData, R.layout.dialog_list_item, new String[]{"text"},
//                        new int[]{R.id.dialog_item_text});
//                listview.setAdapter(dialogAdapter);
//                dialog_builder.setView(views);
//                final AlertDialog dialog = dialog_builder.show();
//
//                dialog.findViewById(R.id.dialog_btn_ok).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, mDialoglistText[listview.getCheckedItemPosition()], Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//                WindowManager.LayoutParams dialog_lp = dialog.getWindow().getAttributes();
//                dialog_lp.width = MainActivity.this.getResources().getDimensionPixelSize(R.dimen.dialog_width);
//                dialog_lp.height = MainActivity.this.getResources().getDimensionPixelSize(R.dimen.dialog_height);
//                dialog.getWindow().setAttributes(dialog_lp);
                DialogLayout dialogLayout=new DialogLayout(MainActivity.this);
                dialogLayout.dilogLayoutF();
            }
        });

    }

    class SetSimpleAdapter extends SimpleAdapter {

        public SetSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from,
                                int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LinearLayout.inflate(getBaseContext(), R.layout.dialog_list_item, null);
            }
            return super.getView(position, convertView, parent);
        }
    }
}
