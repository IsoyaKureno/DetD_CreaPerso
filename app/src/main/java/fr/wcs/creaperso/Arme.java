package fr.wcs.creaperso;

import android.os.Parcel;
import android.os.Parcelable;

public class Arme implements Parcelable{
    private String nom,degats,typeDommage;
    private int limCrit,multiCrit;

    Arme(String nom,String degats,int limCrit,int multiCrit,String typeDommage){
        this.nom=nom;
        this.degats=degats;
        this.limCrit=limCrit;
        this.multiCrit=multiCrit;
        this.typeDommage=typeDommage;
    }

    Arme(){}

    private Arme(Parcel in) {
        nom = in.readString();
        degats = in.readString();
        limCrit = in.readInt();
        multiCrit = in.readInt();
        typeDommage = in.readString();
    }
    public static final Creator<Arme> CREATOR = new Creator<Arme>() {
        @Override public Arme createFromParcel(Parcel in) {return new Arme(in);}
        @Override public Arme[] newArray(int size) {return new Arme[size];}
    };

    @Override public int describeContents() {return 0;}
    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeString(degats);
        parcel.writeInt(limCrit);
        parcel.writeInt(multiCrit);
        parcel.writeString(typeDommage);
    }

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getDegats() {return degats;}
    public void setDegats(String degats) {this.degats = degats;}

    public int getLimCrit() {return limCrit;}
    public void setLimCrit(int limCrit) {this.limCrit = limCrit;}

    public int getMultiCrit() {return multiCrit;}
    public void setMultiCrit(int multiCrit) {this.multiCrit = multiCrit;}

    public String getTypeDommage() {return typeDommage;}
    public void setTypeDommage(String typeDommage) {this.typeDommage = typeDommage;}
}