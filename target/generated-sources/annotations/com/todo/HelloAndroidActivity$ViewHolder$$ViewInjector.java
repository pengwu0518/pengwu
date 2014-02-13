// Generated code from Butter Knife. Do not modify!
package com.todo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HelloAndroidActivity$ViewHolder$$ViewInjector {
  public static void inject(Finder finder, final com.todo.HelloAndroidActivity.ViewHolder target, Object source) {
    View view;
    view = finder.findById(source, 2131230736);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230736' for field 'idView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.idView = (android.widget.TextView) view;
    view = finder.findById(source, 2131230733);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230733' for field 'titleView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.titleView = (android.widget.TextView) view;
    view = finder.findById(source, 2131230735);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230735' for field 'contentView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.contentView = (android.widget.TextView) view;
    view = finder.findById(source, 2131230734);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230734' for field 'createTimeView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.createTimeView = (android.widget.TextView) view;
  }

  public static void reset(com.todo.HelloAndroidActivity.ViewHolder target) {
    target.idView = null;
    target.titleView = null;
    target.contentView = null;
    target.createTimeView = null;
  }
}
