// Generated code from Butter Knife. Do not modify!
package com.todo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HelloAndroidActivity$MyCursorAdapter$ViewHolder$$ViewInjector {
  public static void inject(Finder finder, final com.todo.HelloAndroidActivity.MyCursorAdapter.ViewHolder target, Object source) {
    View view;
    view = finder.findById(source, 2131230724);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230724' for field 'titleView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.titleView = (android.widget.TextView) view;
  }

  public static void reset(com.todo.HelloAndroidActivity.MyCursorAdapter.ViewHolder target) {
    target.titleView = null;
  }
}
