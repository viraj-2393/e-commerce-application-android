package com.starfleck.shoosy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class ProfilePage extends AppCompatActivity {
    ImageButton shp_cart, home , hamberger2 , explore_from_profile_page;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.profile_page);
        addListenerOnButton();
    }
    public void addListenerOnButton(){
        //navigate to users cart
        shp_cart = (ImageButton)findViewById(R.id.cart_icon_white);
        shp_cart.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               Intent intent = new Intent(getApplicationContext(),CartSection.class);
               startActivity(intent);
           }
        });
        //--------------

        //navigate to the home
        home = (ImageButton)findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(getApplicationContext(),HomeScreen.class);
                startActivity(intent);
            }
        });
        //-----------

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = (DrawerLayout)findViewById(R.id.my_drawer_layout);
        hamberger2 = (ImageButton)findViewById(R.id.menu_icon_white);
        hamberger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        //-------------

        explore_from_profile_page = (ImageButton)findViewById(R.id.explore_button);
        explore_from_profile_page.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),Explore.class);
                startActivity(intent);
            }
        });

    }
}