package fr.wcs.creaperso;

import android.os.Parcel;
import android.os.Parcelable;

public class Equipement implements Parcelable{
    private Arme arme;
    private Armure armure;
    private Boolean armeEquipee,armureEquipee;

    Equipement(Arme arme,Armure armure){
        this.arme=arme;
        this.armure=armure;
        this.armeEquipee=false;
        this.armureEquipee=false;
    }

    private Equipement(Parcel in) {
        arme = in.readParcelable(Arme.class.getClassLoader());
        armure = in.readParcelable(Armure.class.getClassLoader());
    }
    public static final Creator<Equipement> CREATOR = new Creator<Equipement>() {
        @Override public Equipement createFromParcel(Parcel in) {return new Equipement(in);}
        @Override public Equipement[] newArray(int size) {return new Equipement[size];}
    };
    @Override public int describeContents() {return 0;}
    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(arme,i);
        parcel.writeParcelable(armure,i);
    }


    public Arme getArme() {return arme;}
    public void setArme(Arme arme) {this.arme = arme;}

    public Armure getArmure() {return armure;}
    public void setArmure(Armure armure) {this.armure = armure;}

    public Boolean getArmeEquipee() {return armeEquipee;}
    public void setArmeEquipee(Boolean armeEquipee) {this.armeEquipee = armeEquipee;}

    public Boolean getArmureEquipee() {return armureEquipee;}
    public void setArmureEquipee(Boolean armureEquipee) {this.armureEquipee = armureEquipee;}
}
