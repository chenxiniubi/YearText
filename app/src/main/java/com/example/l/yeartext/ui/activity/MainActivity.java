package com.example.l.yeartext.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.l.yeartext.R;
import com.example.l.yeartext.ui.fragment.FirstFragment;
import com.example.l.yeartext.ui.fragment.GroupFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private FirstFragment firstFragment;
    private GroupFragment groupFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        firstFragment = new FirstFragment();
        groupFragment = new GroupFragment();

        manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,firstFragment);
        fragmentTransaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                FragmentTransaction fragmentTransaction1 = manager.beginTransaction();
                switch (i){
                    case R.id.first_page:
                        fragmentTransaction1.replace(R.id.frame_layout,firstFragment);
                        break;
                    case R.id.order_group:
                        fragmentTransaction1.replace(R.id.frame_layout,groupFragment);
                        break;
                }
                fragmentTransaction1.commit();
            }
        });
    }
}
