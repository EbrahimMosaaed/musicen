package com.example.music;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {

    private String mSongTitle;
    private String mSongArtist;
    private String mSongDuration;
    private int mSongId;
    private int mSongLyrics;
    private int mSongImg;

    protected Music(Parcel in) {
        mSongTitle = in.readString();
        mSongArtist = in.readString();
        mSongDuration = in.readString();
        mSongId = in.readInt();
        mSongLyrics = in.readInt();
        mSongImg = in.readInt();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {

        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongTitle);
        dest.writeString(mSongArtist);
        dest.writeString(mSongDuration);
        dest.writeInt(mSongId);
        dest.writeInt(mSongLyrics);
        dest.writeInt(mSongImg);
    }


    Music(String title, String artist, String duration,int songId,int lyrics ,  int img) {
        this.mSongTitle = title;
        this.mSongArtist = artist;
        this.mSongDuration = duration;
        this.mSongId = songId;
        this.mSongLyrics = lyrics;
        this.mSongImg = img;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongDuration() {
        return mSongDuration;
    }

    public int getSongId() {
        return mSongId;
    }

    public int getSongLyrics() {
        return mSongLyrics;
    }

    public int getSongImg() {
        return mSongImg;
    }
}
