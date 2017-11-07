package fr.wcs.creaperso;

import android.os.Parcel;
import android.os.Parcelable;

class Personnage implements Parcelable{
    private String name;
    private int level;
    private Stats stats;
    private Equipement equipement;

    Personnage(String n,Integer l,Stats s){
        this.name=n;
        this.level=l;
        this.stats=s;
    }

    private Personnage(Parcel in) {
        name = in.readString();
        level = in.readInt();
        stats = in.readParcelable(Stats.class.getClassLoader());
    }
    public static final Creator<Personnage> CREATOR = new Creator<Personnage>() {
        @Override public Personnage createFromParcel(Parcel in) {return new Personnage(in);}
        @Override public Personnage[] newArray(int size) {return new Personnage[size];}
    };
    @Override public int describeContents() {return 0;}
    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(level);
        parcel.writeParcelable(stats,i);
    }

    String getName() {return name;}

    int getLevel() {return level;}

    Stats getStats() {return stats;}
}
