package com.todo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import javax.inject.Inject;
import java.text.SimpleDateFormat;

/**
 * Created by kate on 14-2-12.
 */

public class TodoManager implements Manager {

  private static final String TAG = "TodoManger";
  private static final String TB_NAME = "todo";
  public static final String ID = "id";
  public static final String TITLE = "title";
  public static final String CONTENT = "content";
  public static final String CREATE_TIME = "createTime";

  SQLiteDatabase db;

  @Inject
  public TodoManager(SQLiteDatabase db) {
    this.db = db;
  }


  @Override
  public Cursor findList() {
    Log.i(TAG, "findList...");
//      Cursor cursor = db.query(TB_NAME, new String[]{ID, TITLE, CONTENT, CREATE_TIME}, null, new String[]{}, null, null, null);
    Cursor cursor = db.rawQuery("select id as _id, title, content, createTime from todo", null);
    Log.i(TAG, "count : " + cursor.getCount());
    return cursor;
  }

  @Override
  public void add(String title, String content) {
    Log.i(TAG, "add...");
    ContentValues values = new ContentValues();
    values.put(TITLE, title);
    values.put(CONTENT, content);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    values.put(CREATE_TIME, sdf.format(System.currentTimeMillis()));
    long id = db.insert(TB_NAME, null, values);
    Log.i(TAG, "id : " + id);
  }

  @Override
  public void del(int id) {
    Log.i(TAG, "del...");
    db.delete(TB_NAME, " id = ? ", new String[]{id + ""});
  }

  @Override
  public void update(int id, String title, String content) {
    Log.i(TAG, "update...");
    ContentValues values = new ContentValues();
    values.put(TITLE, title);
    values.put(CONTENT, content);
    db.update(TB_NAME, values, " id = ? ", new String[]{id + ""});
  }
}
