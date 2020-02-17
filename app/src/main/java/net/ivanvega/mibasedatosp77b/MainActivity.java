package net.ivanvega.mibasedatosp77b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    DAOContacto dao;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
insert();
    }

    @Override
    protected void onResume() {
        super.onResume();
        insert();
    }

    public void insert(){
        dao =new DAOContacto(this);

        Cursor c = dao.getAllCursor();


        lv = findViewById(R.id.lv);

        SimpleCursorAdapter adp = new SimpleCursorAdapter
                (this, android.R.layout.simple_list_item_2,
                        c,
                        new String[]{"usuario", "email"},
                        new int[]{android.R.id.text1,
                                android.R.id.text2},
                        SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);

        lv.setAdapter(adp);
    }
}
