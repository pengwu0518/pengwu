package com.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kate on 14-2-12.
 */
public class DBHelper extends SQLiteOpenHelper {

  private static final String TAG = "DBHelper";

  private static final String NAME = "todo";
  private static final int VERSION = 1;

  public DBHelper(Context context) {
    super(context, NAME, null, VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    Log.i(TAG,"onCreate...");
    db.execSQL("create table todo(id INTEGER PRIMARY KEY AUTOINCREMENT, title text not null, content text not null, createTime text not null)");
    db.execSQL("insert into todo(title,content,createTime) values(?,?,?)",new Object[]{"zhangsan","吃饭",System.currentTimeMillis() + ""});
    db.execSQL("insert into todo(title,content,createTime) values(?,?,?)",new Object[]{"lisi","唱歌",System.currentTimeMillis() + ""});
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.i(TAG,"onUpgrade...");
  }
}
