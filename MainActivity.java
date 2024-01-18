package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment() );
        binding.btmnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_home){
                    replaceFragment(new HomeFragment() );
                } else if (itemId == R.id.menu_not) {
                    replaceFragment(new NotificationFragment() );
                }else if (itemId == R.id.menu_set){
                    replaceFragment(new SettingFragment() );
                }
                return true;
            }
        });





//        binding.btmnv.setOnItemReselectedListener(item ->{
//            switch (item.getItemId()){
//                case R.id.menu_home:
//                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.menu_not:
//                    replaceFragment(new NotificationFragment());
//                    break;
//                case R.id.menu_set:
//                    replaceFragment(new NotificationFragment());
//                    break;
//            }
//            return true;
//        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmcont, fragment);
        fragmentTransaction.commit();
    }

}