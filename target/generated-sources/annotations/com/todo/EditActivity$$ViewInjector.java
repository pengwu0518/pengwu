// Generated code from Butter Knife. Do not modify!
package com.todo;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EditActivity$$ViewInjector {
  public static void inject(Finder finder, final com.todo.EditActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131230724);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230724' for field 'titleEditText' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.titleEditText = (android.widget.EditText) view;
    view = finder.findById(source, 2131230726);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230726' for field 'contentEditText' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.contentEditText = (android.widget.EditText) view;
    view = finder.findById(source, 2131230727);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230727' for field 'createTimeTextView' was not found. If this view is optional add '@Optional' annotation.");
    }
    target.createTimeTextView = (android.widget.TextView) view;
    view = finder.findById(source, 2131230728);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230728' for method 'doSave' was not found. If this view is optional add '@Optional' annotation.");
    }
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.doSave();
        }
      });
    view = finder.findById(source, 2131230729);
    if (view == null) {
      throw new IllegalStateException("Required view with id '2131230729' for method 'doDelete' was not found. If this view is optional add '@Optional' annotation.");
    }
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.doDelete();
        }
      });
  }

  public static void reset(com.todo.EditActivity target) {
    target.titleEditText = null;
    target.contentEditText = null;
    target.createTimeTextView = null;
  }
}
