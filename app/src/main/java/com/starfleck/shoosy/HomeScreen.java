package com.starfleck.shoosy;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import static android.view.Gravity.*;

public class HomeScreen extends AppCompatActivity {
    ImageButton cart_click , profile , hamberger ,explore;
    public int flag = 0;
    public DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.home_screen);
        addListenerOnButton();

    }

    public void addListenerOnButton(){
        //navigate to the cart page
        cart_click = (ImageButton)findViewById(R.id.cart_icon);
        cart_click.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),CartSection.class);
                startActivity(intent);
            }
        });
        //------------------------

        //navigate to user profile page
        profile = (ImageButton)findViewById(R.id.profile_button);
        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),ProfilePage.class);
                startActivity(intent);
            }
        });
        //----------------

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = (DrawerLayout)findViewById(R.id.my_drawer_layout);
        hamberger = (ImageButton)findViewById(R.id.menu_icon);
        hamberger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        explore = (ImageButton)findViewById(R.id.explore_button);
        explore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),Explore.class);
                startActivity(intent);
            }
        });

        }


      //this function works when user clicks on the add to cart icon its send required data of the product to the cart section
       /*public void add_to_cart(View v){
           //navigate to the cart page with required data
                   Intent intent = new Intent(getApplicationContext(),CartSection.class);
                   LinearLayout parent_of_atc = (LinearLayout)v.getParent();

                   //got the price
                   TextView price = (TextView)parent_of_atc.getChildAt(0);
                   String the_price = price.getText().toString();
                   //---------

                   LinearLayout grandparent_of_atc = (LinearLayout)parent_of_atc.getParent();
                   LinearLayout child_0_of_grandparent_of_atc = (LinearLayout)grandparent_of_atc.getChildAt(0);
                   ImageView product_image = (ImageView)child_0_of_grandparent_of_atc.getChildAt(0);
                   //got the name of the image
                   Drawable name_of_image = product_image.getDrawable();
                   //-----------

                   LinearLayout img_desc_parent = (LinearLayout)child_0_of_grandparent_of_atc.getChildAt(1);

                   TextView prdct_name = (TextView)img_desc_parent.getChildAt(0);
                   //got the name of the product
                   String product_name = prdct_name.getText().toString();
                   //-----------

                   TextView prdct_desc = (TextView)img_desc_parent.getChildAt(1);
                   //got the description of the product
                   String product_description = prdct_desc.getText().toString();
                   //--------------------

                   //now binding all the details in bundle and sending it to the cart section
                    Bundle bundle = new Bundle();
                    bundle.putString("source",String.valueOf(name_of_image));
                    bundle.putString("name",product_name);
                    bundle.putString("description",product_description);
                    bundle.putString("price",the_price);
                   //-----------------------------------

                   //adding bundle to the intent
                    intent.putExtras(bundle);
                   //-----------
                   startActivity(intent);

           //------------------------
       }*/
      //---------------------------

}