package com.github.yglll.funlive.view.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.CallSuper;
import android.view.View;

import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.sql.FunLiveDbHelper;

import es.dmoral.toasty.Toasty;

/**
 * Created by Administrator on 2018/2/20.
 */

public class RoomClickListener implements View.OnClickListener {

    private RoomInfo roomInfo;
    private FunLiveDbHelper funLiveDbHelper;
    private Context mContext;

    public RoomClickListener(Context context,RoomInfo roomInfo){
        this.roomInfo=roomInfo;
        mContext=context;
        funLiveDbHelper=new FunLiveDbHelper(context);
    }

    @Override
    @CallSuper
    public void onClick(View view) {
        //save history
        SQLiteDatabase sqLiteDatabase=funLiveDbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("room_id",roomInfo.getRoom_id());
        contentValues.put("room_src",roomInfo.getRoom_src());
        contentValues.put("room_name",roomInfo.getRoom_name());
        contentValues.put("owner_uid",roomInfo.getOwner_uid());
        contentValues.put("online",roomInfo.getOnline());
        contentValues.put("hn",roomInfo.getHn());
        contentValues.put("nickname",roomInfo.getNickname());
        contentValues.put("url",roomInfo.getUrl());
        sqLiteDatabase.insert("UserHistory",null,contentValues);
        Toasty.info(mContext,"save history");
        read(sqLiteDatabase);
    }

    private void read(SQLiteDatabase sqLiteDatabase){
        Cursor cursor=sqLiteDatabase.query("UserHistory",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                String str =cursor.getString(cursor.getColumnIndex("room_name"));
                Toasty.info(mContext,str);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }
}
