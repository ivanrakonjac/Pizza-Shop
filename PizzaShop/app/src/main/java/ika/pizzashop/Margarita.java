package ika.pizzashop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.data;
import static ika.pizzashop.R.id.mala;
import static ika.pizzashop.R.layout.activity_margarita;

public class Margarita extends AppCompatActivity {
    int q=1;
    String m="";
    int cena=1;
    int cm=320;int cv=580;
    String imePrezime="",adresa="",telefon="",napomena="",kolicina="",tip="MARGARITA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_margarita);
    }

    private void display(int number){
        TextView quantityTextView=(TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayText(String m){
        TextView podaciTextView=(TextView) findViewById(R.id.quantity_text_view);
        podaciTextView.setText("" + m);
    }

    public void increment(View view){
        q=q+1;
        display(q);
    }

    public void decrement(View view){
        if(q>1) {
            q = q - 1;
        }
        else{
            Toast.makeText(Margarita.this,
                    "Ne moze manje!", Toast.LENGTH_LONG).show();
        }
        display(q);
    }
    public void setMessage(View view){
        m="";

        EditText txtname = (EditText)findViewById(R.id.imePrezime);
        imePrezime =  txtname.getText().toString();

        EditText txtadresa = (EditText)findViewById(R.id.adresa);
        adresa =  txtadresa.getText().toString();

        EditText txtelefon = (EditText)findViewById(R.id.telefon);
        telefon =  txtelefon.getText().toString();

        EditText txtnapomena = (EditText)findViewById(R.id.napomena);
        napomena =  txtnapomena.getText().toString();

        TextView txtkolicina = (TextView) findViewById(R.id.quantity_text_view);
        kolicina =  txtkolicina.getText().toString();

        boolean isCheckedMala = ((CheckBox) findViewById(R.id.mala)).isChecked();
        boolean isCheckedVelika = ((CheckBox) findViewById(R.id.velika)).isChecked();

        if(isCheckedMala==false && isCheckedVelika==false){
            Toast.makeText(Margarita.this, "Morate odabrati velicinu!", Toast.LENGTH_SHORT).show();
        }
        else if(isCheckedMala==true && isCheckedVelika==true){
            Toast.makeText(Margarita.this, "Morate odabrati SAMO 1 velicinu!", Toast.LENGTH_SHORT).show();
        }
        if(imePrezime.matches("")){
            Toast.makeText(Margarita.this, "Popuni polje ime!", Toast.LENGTH_SHORT).show();
        }
        if(adresa.matches("")){
            Toast.makeText(Margarita.this, "Popuni polje adresa!", Toast.LENGTH_SHORT).show();
        }
        if(telefon.matches("")){
            Toast.makeText(Margarita.this, "Popuni polje telefon!", Toast.LENGTH_SHORT).show();
        }
        if(kolicina.matches("0")){
            Toast.makeText(Margarita.this, "Morate naruciti bar 1 picu!", Toast.LENGTH_SHORT).show();
        }

        if(!imePrezime.matches("") && !adresa.matches("") && !telefon.matches("") && !kolicina.matches("0") && (isCheckedMala==true || isCheckedVelika==true)){
            cena=1;
            int kol= Integer.parseInt(kolicina);
            m=m+"--PORUDZBINA--"+"\n";
            m=m+"Tip: "+tip+"\n";
            if(isCheckedMala){
                m=m+"Velicina: MALA\n";
                cena=cena*kol*cm;
            }
            else{
                m=m+"Velicina: VELIKA\n";
                cena=cena*kol*cv;
            }
            m=m+"Kolicina: "+kolicina+"\n";

            String c=Integer.toString(cena);
            m=m+"Cena: "+c+" RSD\n\n";

            m=m+"Ime: "+imePrezime+"\n";
            m=m+"Adresa: "+adresa+"\n";
            m=m+"Telefon: "+telefon+"\n";
            m=m+"Napomena: "+napomena+"\n";

            //displayText(m);

            Toast.makeText(Margarita.this, "Mozete naruciti!", Toast.LENGTH_LONG).show();

            Uri uri = Uri.parse("smsto:123456789");
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", m);
            startActivity(intent);
        }
    }
}

/*if ( ( userName.getText().toString().trim().equals("")) )
 {
      Toast.makeText(getApplicationContext(), "User name is empty", Toast.LENGTH_SHORT).show();
 }
 else
 {
      Intent i = new Intent(getApplicationContext(), Login.class);
      startActivity(i);
 }*/