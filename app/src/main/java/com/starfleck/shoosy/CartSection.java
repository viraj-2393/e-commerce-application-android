package com.starfleck.shoosy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class CartSection extends AppCompatActivity {

    TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.cart_section);
        //addListenerOnButton();
        //add_item_to_cart();
    }
    public void increase_quantity(View v){
        ImageButton product = (ImageButton)findViewById(v.getId());
        LinearLayout ll = (LinearLayout)product.getParent();
        TextView txt = (TextView)ll.getChildAt(1);
        String num = txt.getText().toString();
        int pr_num = Integer.parseInt(num);
        pr_num++;
        txt.setText(String.valueOf(pr_num));
        //add up the money
        TextView total = (TextView)findViewById(R.id.total_amount);
        String str = total.getText().toString();
        String new_str = str.replace("$","");
        String new_str2 = new_str.replace(".00","");
        int money = Integer.parseInt(new_str2);
        //get the money of the item from the parent it belongs to
          LinearLayout ll2 = (LinearLayout)ll.getParent();
          //get the second child of this parent
           LinearLayout ll3 = (LinearLayout)ll2.getChildAt(1);
             //now get the third child of this layout which is the price
                TextView txt2 = (TextView)ll3.getChildAt(2);
                String txt2_str = txt2.getText().toString();
                String new_txt2_str = txt2_str.replace("$","");
                String new_txt2_str2 = new_txt2_str.replace(".00","");
                int this_amount = Integer.parseInt(new_txt2_str2);
                int grand_total = money + this_amount;
                total.setText("$"+String.valueOf(grand_total)+".00");
             //-----------------------

          //--------------

        //----------

        //-----------
    }
    public void decrease_quantity(View v){
        ImageButton product = (ImageButton)findViewById(v.getId());
        LinearLayout ll = (LinearLayout)product.getParent();
        TextView txt = (TextView)ll.getChildAt(1);
        String num = txt.getText().toString();
        int pr_num = Integer.parseInt(num);
        pr_num--;
        txt.setText(String.valueOf(pr_num));
        //add up the money
        TextView total = (TextView)findViewById(R.id.total_amount);
        String str = total.getText().toString();
        String new_str = str.replace("$","");
        String new_str2 = new_str.replace(".00","");
        int money = Integer.parseInt(new_str2);
        //get the money of the item from the parent it belongs to
        LinearLayout ll2 = (LinearLayout)ll.getParent();
        //get the second child of this parent
        LinearLayout ll3 = (LinearLayout)ll2.getChildAt(1);
        //now get the third child of this layout which is the price
        TextView txt2 = (TextView)ll3.getChildAt(2);
        String txt2_str = txt2.getText().toString();
        String new_txt2_str = txt2_str.replace("$","");
        String new_txt2_str2 = new_txt2_str.replace(".00","");
        int this_amount = Integer.parseInt(new_txt2_str2);
        int grand_total = money - this_amount;
        total.setText("$"+String.valueOf(grand_total)+".00");
        //-----------------------

        //--------------

        //----------

        //-----------

        //check if the item count is zero. If zero erase it
        if(pr_num == 0){
            LinearLayout parent = (LinearLayout)ll.getParent();
            parent.setVisibility(View.GONE);
            return;
        }
        //-------------------
    }

    //adding item to the cart starts here
    /*public void add_item_to_cart(){
        //Log.i("running","Perfectly");
        LinearLayout  item_strip = (LinearLayout)findViewById(R.id.strips_container);
        //unwrapping the data received from the homescreen
         Bundle bundle = getIntent().getExtras();
         String nm = bundle.getString("name");
         TextView name = new TextView(this);
         name.setText(nm);
         //adding image view to the
        item_strip.addView(name);
        //----------------
    }*/
    //adding item to the cart ends here
}