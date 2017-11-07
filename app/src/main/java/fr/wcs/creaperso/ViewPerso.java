package fr.wcs.creaperso;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewPerso extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_perso);
        Intent fromMainActivity=getIntent();
        Personnage perso=fromMainActivity.getExtras().getParcelable("PERSONNAGE");
        Stats stats=perso.getStats();
        if (perso != null) {
            TextView viewName=findViewById(R.id.viewName);
            viewName.setText(perso.getName());
            TextView viewLevel=findViewById(R.id.viewLevel);
            viewLevel.setText(String.valueOf(perso.getLevel()));

            TextView viewForceTotal=findViewById(R.id.viewForceTotal);
            viewForceTotal.setText(String.valueOf(stats.getForce()));
            TextView viewDexteriteTotal=findViewById(R.id.viewDexteriteTotal);
            viewDexteriteTotal.setText(String.valueOf(stats.getDexterite()));
            TextView viewConstitutionTotal=findViewById(R.id.viewConstitutionTotal);
            viewConstitutionTotal.setText(String.valueOf(stats.getConstitution()));
            TextView viewIntelligenceTotal=findViewById(R.id.viewIntelligenceTotal);
            viewIntelligenceTotal.setText(String.valueOf(stats.getIntelligence()));
            TextView viewSagesseTotal=findViewById(R.id.viewSagesseTotal);
            viewSagesseTotal.setText(String.valueOf(stats.getSagesse()));
            TextView viewCharismeTotal=findViewById(R.id.viewCharismeTotal);
            viewCharismeTotal.setText(String.valueOf(stats.getCharisme()));

            TextView viewForceModif=findViewById(R.id.viewForceModif);
            viewForceModif.setText(String.valueOf(getModif(stats.getForce())));
            TextView viewDexteriteModif=findViewById(R.id.viewDexteriteModif);
            viewDexteriteModif.setText(String.valueOf(getModif(stats.getDexterite())));
            TextView viewConstitutionModif=findViewById(R.id.viewConstitutionModif);
            viewConstitutionModif.setText(String.valueOf(getModif(stats.getConstitution())));
            TextView viewIntelligenceModif=findViewById(R.id.viewIntelligenceModif);
            viewIntelligenceModif.setText(String.valueOf(getModif(stats.getIntelligence())));
            TextView viewSagesseModif=findViewById(R.id.viewSagesseModif);
            viewSagesseModif.setText(String.valueOf(getModif(stats.getSagesse())));
            TextView viewCharismeModif=findViewById(R.id.viewCharismeModif);
            viewCharismeModif.setText(String.valueOf(getModif(stats.getCharisme())));

            TextView viewReflexes=findViewById(R.id.viewReflexes);
            viewReflexes.setText(String.valueOf(stats.getReflexes()));
            TextView viewVigueur=findViewById(R.id.viewVigueur);
            viewVigueur.setText(String.valueOf(stats.getVigueur()));
            TextView viewVolonte=findViewById(R.id.viewVolonte);
            viewVolonte.setText(String.valueOf(stats.getVolonte()));

            TextView viewCA=findViewById(R.id.viewCA);
            viewCA.setText(String.valueOf(stats.getCa()));
        }
    }
    Integer getModif(int stat){
        int modif=-5;
        for(int i=1;i<stat;i+=2){modif++;}
        return modif;
    }
}
