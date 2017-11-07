package fr.wcs.creaperso;
import android.os.Parcel;
import android.os.Parcelable;

class Stats implements Parcelable {
    private Integer force,dexterite,constitution,intelligence,sagesse,charisme,reflexes,vigueur,volonte,ca;
    Stats(Integer force,Integer dex,Integer con,Integer intel,Integer sag,Integer cha){
        this.force=force;
        this.dexterite=dex;
        this.constitution=con;
        this.intelligence=intel;
        this.sagesse=sag;
        this.charisme=cha;
        this.reflexes=10;
        this.vigueur=10;
        this.volonte=10;
        this.ca=10;
    }
    private Stats(Parcel in){
        this.force=in.readInt();
        this.dexterite=in.readInt();
        this.constitution=in.readInt();
        this.intelligence=in.readInt();
        this.sagesse=in.readInt();
        this.charisme=in.readInt();
        this.reflexes=in.readInt();
        this.vigueur=in.readInt();
        this.volonte=in.readInt();
        this.ca=in.readInt();
    }
    public static final Creator<Stats>CREATOR = new Creator<Stats>() {
        @Override public Stats createFromParcel(Parcel in) {return new Stats(in);}
        @Override public Stats[] newArray(int size) {return new Stats[size];}
    };
    @Override public int describeContents() {return 0;}
    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(force);
        parcel.writeInt(dexterite);
        parcel.writeInt(constitution);
        parcel.writeInt(intelligence);
        parcel.writeInt(sagesse);
        parcel.writeInt(charisme);
        parcel.writeInt(reflexes);
        parcel.writeInt(vigueur);
        parcel.writeInt(volonte);
        parcel.writeInt(ca);
    }
    Integer getForce() {return force;}
    Integer getDexterite() {return dexterite;}
    Integer getConstitution() {return constitution;}
    Integer getIntelligence() {return intelligence;}
    Integer getSagesse() {return sagesse;}
    Integer getCharisme() {return charisme;}

    void setReflexes() {this.reflexes=10+getModif(this.dexterite);}
    Integer getReflexes() {return reflexes;}
    void setVigueur() {this.vigueur=10+getModif(this.constitution);}
    Integer getVigueur() {return vigueur;}
    void setVolonte() {this.volonte=10+getModif(this.sagesse);}
    Integer getVolonte() {return volonte;}

    void setCa() {this.ca=10+getModif(this.dexterite);}
    Integer getCa() {return ca;}

    private Integer getModif(int stat){
        int modif=-5;
        for(int i=1;i<stat;i+=2){modif++;}
        return modif;
    }
}
