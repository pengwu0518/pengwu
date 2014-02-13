package com.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by kate on 14-2-12.
 */
@Module(
    injects = {
        HelloAndroidActivity.class,
        EditActivity.class
    }
)
public class TodoModule {

    Context context;

    public TodoModule(Context context){
      this.context = context;
    }

    @Provides @Singleton
    public Manager provideManager(TodoManager manager){
      return manager;
    }
    @Provides
    public SQLiteDatabase provideDataBase(){
      return (new DBHelper(context)).getReadableDatabase();
    }
}
