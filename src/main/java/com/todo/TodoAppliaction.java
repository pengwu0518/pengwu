package com.todo;

import android.app.Application;
import dagger.ObjectGraph;

/**
 * Created by kate on 14-2-12.
 */
public class TodoAppliaction extends Application {

  private static final String TAG = "TodoApplication";
  ObjectGraph graph;

  @Override
  public void onCreate() {
    super.onCreate();
    graph = ObjectGraph.create(new TodoModule(this));
  }

  void inject(Object obj){
    graph.inject(obj);
  }
}
