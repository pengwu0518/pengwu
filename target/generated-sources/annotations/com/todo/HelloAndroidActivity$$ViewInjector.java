// Generated code from Butter Knife. Do not modify!
package com.todo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HelloAndroidActivity$$ViewInjector {
  public static void inject(Finder finder, final com.todo.HelloAndroidActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131230731);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230731' for field 'listView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.listView = (android.widget.ListView) view;
    view = finder.findById(source, 2131230732);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230732' for field 'emptyTextView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.emptyTextView = (android.widget.TextView) view;
    view = finder.findById(source, 2131230730);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230730' for method 'newTodo' was not found. If this view is optional add '@Optional' annotation.");
    }
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.newTodo();
        }
      });
  }

  public static void reset(com.todo.HelloAndroidActivity target) {
    target.listView = null;
    target.emptyTextView = null;
  }
}
