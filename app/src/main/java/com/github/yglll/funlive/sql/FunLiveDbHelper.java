package com.github.yglll.funlive.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/2/19.
 */

public class FunLiveDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 0;
    static final String DATABASE_NAME = "live.db";

    public static final String SQL_CREATE_USER_COLLECTION_TABLE="create table UserCollection(" +
            "id integer primary key autoincrement," +
            "room_id integer," +
            "room_src text," +
            "room_name text," +
            "owner_uid text," +
            "online integer," +
            "hn integer," +
            "nickname text," +
            "url text);";
    public static final String SQL_CREATE_USER_HISTORY_TABLE="create table UserHistory(" +
            "id integer primary key autoincrement," +
            "room_id integer," +
            "room_src text," +
            "room_name text," +
            "owner_uid text," +
            "online integer," +
            "hn integer," +
            "nickname text," +
            "url text);";

    public FunLiveDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USER_COLLECTION_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_USER_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS UserCollection");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS UserHistory");
        onCreate(sqLiteDatabase);
    }
}
