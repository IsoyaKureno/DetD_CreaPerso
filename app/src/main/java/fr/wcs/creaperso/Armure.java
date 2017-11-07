package fr.wcs.creaperso;

import android.os.Parcel;
import android.os.Parcelable;

public class Armure implements Parcelable{
    private String nom;
    private int bonusArmor,maxDex;

    Armure(String nom,int bonusArmor,int maxDex){
        this.nom=nom;
        this.bonusArmor=bonusArmor;
        this.maxDex=maxDex;
    }

    Armure(){}

    private Armure(Parcel in) {
        nom = in.readString();
        bonusArmor = in.readInt();
        maxDex = in.readInt();
    }
    public static final Creator<Armure> CREATOR = new Creator<Armure>() {
        @Override public Armure createFromParcel(Parcel in) {return new Armure(in);}
        @Override public Armure[] newArray(int size) {return new Armure[size];}
    };
    @Override public int describeContents() {return 0;}
    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeInt(bonusArmor);
        parcel.writeInt(maxDex);
    }

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getBonusArmor() {return bonusArmor;}
    public void setBonusArmor(int bonusArmor) {this.bonusArmor = bonusArmor;}

    public int getMaxDex() {return maxDex;}
    public void setMaxDex(int maxDex) {this.maxDex = maxDex;}
}
