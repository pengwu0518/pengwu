package com.todo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import javax.inject.Inject;

/**
 * Created by kate on 14-2-13.
 */
public class EditActivity extends Activity {

  @InjectView(R.id.titleEditText)
  EditText titleEditText;
  @InjectView(R.id.contentEditText)
  EditText contentEditText;
  @InjectView(R.id.createTimeTextView)
  TextView createTimeTextView;

  @Inject
  Manager manager;

  int _id = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.edit);
    ButterKnife.inject(this);
    TodoAppliaction app = (TodoAppliaction) getApplication();
    app.inject(this);

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      _id = bundle.getInt(TodoManager.ID);
      titleEditText.setText(bundle.getString(TodoManager.TITLE));
      contentEditText.setText(bundle.getString(TodoManager.CONTENT));
      createTimeTextView.setText(bundle.getString(TodoManager.CREATE_TIME));
    }
  }

  @OnClick(R.id.saveButton)
  public void doSave() {
    final String title = titleEditText.getText().toString();
    final String content = contentEditText.getText().toString();
    new Thread(new Runnable() {
      @Override
      public void run() {
        if (_id == -1) {
          manager.add(title, content);
        } else {
          manager.update(_id, title, content);
        }
      }
    }).start();
    finish();
  }

  @OnClick(R.id.deleteButton)
  public void doDelete() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        manager.del(_id);
      }
    }).start();
    finish();
  }

}
