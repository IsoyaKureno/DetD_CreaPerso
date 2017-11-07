package fr.wcs.creaperso;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerArme=findViewById(R.id.spinnerArme);
        final List<String> listArme = new ArrayList<>();
        DatabaseReference armeRef = mDatabase.getReference("Armes");
        armeRef.addValueEventListener(new ValueEventListener() {
            @Override public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    Arme arme = dsp.getValue(Arme.class);
                    listArme.add(arme.getNom());
                }
            }
            @Override public void onCancelled(DatabaseError databaseError) {}
        });
        ArrayAdapter<String> armeDataAdapter = new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_spinner_item, listArme);
        armeDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArme.setAdapter(armeDataAdapter);



        Spinner spinnerArmure=findViewById(R.id.spinnerArmure);
        final List<String> listArmure = new ArrayList<>();
        DatabaseReference armureRef = mDatabase.getReference("Armures");
        armureRef.addValueEventListener(new ValueEventListener() {
            @Override public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    Armure armure = dsp.getValue(Armure.class);
                    listArmure.add(armure.getNom());
                }
            }
            @Override public void onCancelled(DatabaseError databaseError) {}
        });
        ArrayAdapter<String> armureDataAdapter = new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_spinner_item, listArmure);
        armureDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArmure.setAdapter(armureDataAdapter);



        Button buttonCreate=findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                EditText editName=findViewById(R.id.editName);
                String nom=editName.getText().toString();

                EditText editLevel=findViewById(R.id.editLevel);
                int level=Integer.parseInt(editLevel.getText().toString());

                EditText editForce=findViewById(R.id.editForce);
                int force=Integer.parseInt(editForce.getText().toString());

                EditText editDexterite=findViewById(R.id.editDexterite);
                int dexterite=Integer.parseInt(editDexterite.getText().toString());

                EditText editConstitution=findViewById(R.id.editConstitution);
                int constitution=Integer.parseInt(editConstitution.getText().toString());

                EditText editIntelligence=findViewById(R.id.editIntelligence);
                int intelligence=Integer.parseInt(editIntelligence.getText().toString());

                EditText editSagesse=findViewById(R.id.editSagesse);
                int sagesse=Integer.parseInt(editSagesse.getText().toString());

                EditText editCharisme=findViewById(R.id.editCharisme);
                int charisme=Integer.parseInt(editCharisme.getText().toString());

                Stats stats=new Stats(force,dexterite,constitution,intelligence,sagesse,charisme);
                Personnage perso=new Personnage(nom,level,stats);
                perso.getStats().setReflexes();
                perso.getStats().setVigueur();
                perso.getStats().setVolonte();
                perso.getStats().setCa();

                Intent toViewPerso=new Intent(MainActivity.this,ViewPerso.class);
                toViewPerso.putExtra("PERSONNAGE",perso);
                startActivity(toViewPerso);
            }
        });
    }
}
