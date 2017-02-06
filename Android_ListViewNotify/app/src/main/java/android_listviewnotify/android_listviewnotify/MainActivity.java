package android_listviewnotify.android_listviewnotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;

    private List<Integer> datas;
    private CommonAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = ((ListView) findViewById(R.id.list_view));
        datas = new ArrayList<>();


        for (int i = 0; i < 20; i++) {

            datas.add(i);
        }


        mListView.setAdapter(adapter = new CommonAdapter<Integer>(this, datas, R.layout.item) {

            @Override
            protected void convertView(View item, Integer integer) {

                TextView textView = (TextView) item.findViewById(R.id.num);

                textView.setText(String.format("%d", integer));
            }
        });

        mListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        CommonAdapter<Integer> adapter = (CommonAdapter) parent.getAdapter();

        Integer item = adapter.getItem(position);


        datas.set(position, item + 1);
        /**
         * 刷新局部数据
         */
        adapter.notifyDataSetChanged(mListView, position);


    }
}
