package com.example.pokestar.electricflute;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.pokestar.electricflute.base.BaseActivity;
import com.example.pokestar.electricflute.ui.DiscoverFragment;
import com.example.pokestar.electricflute.ui.FunsFragment;
import com.example.pokestar.electricflute.ui.MessageFragment;
import com.example.pokestar.electricflute.ui.MineFragment;
import com.example.pokestar.electricflute.ui.SingFragment;
import com.example.pokestar.electricflute.utils.ToastUtil;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends BaseActivity {

    BottomNavigationViewEx bnve;
    FloatingActionButton fab;


    @Override
    protected Fragment createFragment() {
        return FunsFragment.newInstance();
    }

    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    public int getContainerId() {
        return R.id.fragment_container;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnve = (BottomNavigationViewEx) findViewById(R.id.bnve);
        fab = (FloatingActionButton) findViewById(R.id.main_fab);
        initBNView();
        initEvent();
    }



    private void initBNView() {
        bnve.enableItemShiftingMode(false);
        bnve.enableShiftingMode(false);
        bnve.enableAnimation(false);

    }

    private void initEvent() {

        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.i_fun:
                        replaceFragment(FunsFragment.newInstance());
                        return true;
                    case R.id.i_discover:
                        replaceFragment(DiscoverFragment.newInstance());
                        return true;
                    case R.id.i_empty:
                        ToastUtil.showShort(getApplicationContext(),"center");
                        return true;
                    case R.id.i_message:
                        replaceFragment(MessageFragment.newInstance());
                        return true;
                    case R.id.i_mine:
                        replaceFragment(MineFragment.newInstance());
                        return true;
                }
                return false;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bnve.setCurrentItem(2);
                replaceFragment(SingFragment.newInstance());

            }
        });
    }
}
