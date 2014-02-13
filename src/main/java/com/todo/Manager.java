package com.todo;

import android.database.Cursor;

/**
 * Created by kate on 14-2-12.
 */
public interface Manager {

  Cursor findList();
  void add(String title, String content);
  void del(int id);
  void update(int id, String title, String content);
}
