package com.example.nisarahmed.app2_login;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {
    CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleMenu= findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.delete, R.mipmap.plus);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.facebook)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.twitter)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.whatsapp)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.google);


        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             Toast.makeText(MainActivity.this, "Facbook Button Clicked", Toast.LENGTH_SHORT).show();
                                                             Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                                                             startActivity(intent);
                                                             break;
                                                         case 1:
                                                             Toast.makeText(MainActivity.this, "Twitter button Clicked", Toast.LENGTH_SHORT).show();
                                                             Intent i=new Intent(MainActivity.this,Main3Activity.class);
                                                             startActivity(i);
                                                             break;
                                                         case 2:
                                                             Toast.makeText(MainActivity.this, "Whatsapp button Clciked", Toast.LENGTH_SHORT).show();
                                                             Intent in=new Intent(MainActivity.this,Main4Activity.class);
                                                             startActivity(in);
                                                             break;
                                                         case 3:
                                                             Toast.makeText(MainActivity.this, "Google button Clcked", Toast.LENGTH_SHORT).show();
                                                            String google="google.com";
                                                            Intent intent1=new Intent(Intent.ACTION_WEB_SEARCH);
                                                            intent1.putExtra(SearchManager.QUERY,google);
                                                            startActivity(intent1);
                                                             //  startActivity(new Intent(MainActivity.this, ThankYouActivity.class));
                                                             break;

                                                     }
                                                 }
                                             }

        );

        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

                                                     @Override
                                                     public void onMenuOpened() {

                                                     }

                                                     @Override
                                                     public void onMenuClosed() {

                                                     }
                                                 }
        );
    }

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
    }

}