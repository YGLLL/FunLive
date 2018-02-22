package com.github.yglll.funlive.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.github.yglll.funlive.net.bean.RoomInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/20   21:18
 **/
public class FunLiveDB {
    private SQLiteDatabase sqLiteDatabase;
    private static FunLiveDB funLiveDB;

    private FunLiveDB(Context context){
        FunLiveDbHelper funLiveDbHelper=new FunLiveDbHelper(context);
        /*
        * SQLiteOpenHelper 中有两个非常重要的方法，
        * getReadableDatabase() 和getWritableDatabase()。
        * 这两个方法都可以创建或打开一个现有的数据库（如果数据库已存在则直接打开，否则创建一个新的数据库），
        * 并返回一个可对数据库进行读写操作的对象。
        * 不同的是，当数据库不可写入的时候（如磁盘空间已满）
        * getReadableDatabase()方法返回的对象将以只读的方式去打开数据库，
        * 而getWritableDatabase()方法则将出现异常。
        */
        sqLiteDatabase=funLiveDbHelper.getWritableDatabase();
    }
    public synchronized static FunLiveDB getInstance(Context context){
        if(funLiveDB==null){
            return funLiveDB=new FunLiveDB(context);
        }else {
            return funLiveDB;
        }
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public List<RoomInfo> getAllRoomInfo(String tableName){
        return getRoomInfo(-1,tableName);
    }
    public List<RoomInfo> getRoomInfo(int roomId, String tableName) {
        List<RoomInfo> roomInfoList=new ArrayList<>();
        Cursor cursor;
        if(roomId==-1){
            cursor=sqLiteDatabase.query(tableName,null,null,null,null,null,null);
        }else {
            cursor=sqLiteDatabase.query(tableName,null,"room_id=?",new String[]{String.valueOf(roomId)},null,null,null);
        }
        if(cursor.moveToFirst()){
            do {
                RoomInfo roomInfo=new RoomInfo();
                roomInfo.setHn(cursor.getInt(cursor.getColumnIndex("hn")));
                roomInfo.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                roomInfo.setOnline(cursor.getInt(cursor.getColumnIndex("online")));
                roomInfo.setOwner_uid(cursor.getString(cursor.getColumnIndex("owner_uid")));
                roomInfo.setRoom_id(cursor.getInt(cursor.getColumnIndex("room_id")));
                roomInfo.setRoom_name(cursor.getString(cursor.getColumnIndex("room_name")));
                roomInfo.setRoom_src(cursor.getString(cursor.getColumnIndex("room_src")));
                roomInfo.setUrl(cursor.getString(cursor.getColumnIndex("url")));
                roomInfoList.add(roomInfo);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return roomInfoList;
    }

    public void setRoomInfo(RoomInfo roomInfo,String tableName) {
        //限制最大写入数据
        //int limit=10;
        //while (getTableSize(tableName)>limit){
        //    deleteRoomFromId(0,tableName);
        //}
        ContentValues contentValues=new ContentValues();
        contentValues.put("room_id",roomInfo.getRoom_id());
        contentValues.put("room_src",roomInfo.getRoom_src());
        contentValues.put("room_name",roomInfo.getRoom_name());
        contentValues.put("owner_uid",roomInfo.getOwner_uid());
        contentValues.put("online",roomInfo.getOnline());
        contentValues.put("hn",roomInfo.getHn());
        contentValues.put("nickname",roomInfo.getNickname());
        contentValues.put("url",roomInfo.getUrl());
        sqLiteDatabase.insert(tableName,null,contentValues);
        contentValues.clear();
    }

    public int getTableSize(String tableName){
        int size=0;
        Cursor cursor=sqLiteDatabase.query(tableName,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {
                size++;
            }while (cursor.moveToNext());
        }
        cursor.close();
        return size;
    }

    public void deleteRoom(int roomId,String tableName){
        sqLiteDatabase.delete(tableName,"room_id=?",new String[]{String.valueOf(roomId)});
    }
    public void deleteRoomFromId(int id,String tableName){
        sqLiteDatabase.delete(tableName,"id=?",new String[]{String.valueOf(id)});
    }
}
