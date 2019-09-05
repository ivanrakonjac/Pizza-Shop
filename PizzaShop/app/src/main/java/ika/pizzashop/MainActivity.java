package ika.pizzashop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, Margarita.class);
        startActivity(intent);
    }
    public void openCapricciosa(View view)
    {
        Intent intent = new Intent(MainActivity.this, capricciosa.class);
        startActivity(intent);
    }
    public void openPeperoni(View view)
    {
        Intent intent = new Intent(MainActivity.this, Peperoni.class);
        startActivity(intent);
    }

}
