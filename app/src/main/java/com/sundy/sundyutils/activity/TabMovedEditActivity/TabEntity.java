package com.sundy.sundyutils.activity.TabMovedEditActivity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 频道实体类
 * Created by sundi on 2016/12/8.
 */

public class TabEntity implements Parcelable {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.id);
    }

    public TabEntity() {
    }

    protected TabEntity(Parcel in) {
        this.name = in.readString();
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<TabEntity> CREATOR = new Parcelable.Creator<TabEntity>() {
        @Override
        public TabEntity createFromParcel(Parcel source) {
            return new TabEntity(source);
        }

        @Override
        public TabEntity[] newArray(int size) {
            return new TabEntity[size];
        }
    };
}
