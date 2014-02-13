package com.todo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import javax.inject.Inject;

public class HelloAndroidActivity extends Activity {

  private static final String TAG = "HelloAndroidActivity";
  private static final int FIND_STATUS = 0;
  private static final int ADD_SUCC_STATUS = 1;

  @InjectView(R.id.listView)
  ListView listView;
  @InjectView(R.id.emptyTextView)
  TextView emptyTextView;

  @Inject
  Manager manager;

  Cursor cursor;
  MyCursorAdapter adpater;
  Handler handler = new Handler() {

    @Override
    public void handleMessage(Message msg) {
      //super.handleMessage(msg);
      switch (msg.what) {
        case FIND_STATUS:
          adpater.changeCursor(cursor);
          if (cursor.getCount() == 0) {
            emptyTextView.setVisibility(View.VISIBLE);
          } else {
            emptyTextView.setVisibility(View.GONE);
          }
          break;
        default:
          break;
      }
    }
  };

  /**
   * Called when the activity is first created.
   *
   * @param savedInstanceState If the activity is being re-initialized after
   *                           previously being shut down then this Bundle contains the data it most
   *                           recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    ButterKnife.inject(this);
    TodoAppliaction app = (TodoAppliaction) getApplication();
    app.inject(this);

    adpater = new MyCursorAdapter(this, cursor, R.layout.todo_list);
    listView.setAdapter(adpater);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getApplicationContext(), EditActivity.class);
        cursor.moveToPosition(position);
        int _id = cursor.getInt(0);
        String title = cursor.getString(1);
        String content = cursor.getString(2);
        String createTime = cursor.getString(3);
        i.putExtra(TodoManager.ID, _id);
        i.putExtra(TodoManager.TITLE, title);
        i.putExtra(TodoManager.CONTENT, content);
        i.putExtra(TodoManager.CREATE_TIME, createTime);
        startActivity(i);
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    findList();
  }

  @OnClick(R.id.bottomArea)
  public void newTodo() {
    startActivity(new Intent(this, EditActivity.class));
  }

  private void findList() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        cursor = manager.findList();
        handler.sendEmptyMessage(FIND_STATUS);
      }
    }).start();
  }

  private class MyCursorAdapter extends CursorAdapter {

    private int viewId;

    public MyCursorAdapter(Context context, Cursor c, int resId) {
      super(context, c, false);
      this.viewId = resId;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
      View view = getLayoutInflater().inflate(viewId, null);
      return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
      Log.i(TAG, "view : " + view);
      try {
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String title = cursor.getString(cursor.getColumnIndex("title"));
        String content = cursor.getString(cursor.getColumnIndex("content"));
        String createTime = cursor.getString(cursor.getColumnIndex("createTime"));
        ViewHolder holder;
        if (view.getTag() == null) {
          holder = new ViewHolder(view);
          view.setTag(holder);
        } else {
          holder = (ViewHolder) view.getTag();
        }
        holder.idView.setText(id + "");
        holder.titleView.setText(title);
        holder.contentView.setText(content);
        holder.createTimeView.setText(createTime);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  class ViewHolder {
    @InjectView(R.id.idView)
    TextView idView;
    @InjectView(R.id.titleView)
    TextView titleView;
    @InjectView(R.id.contentView)
    TextView contentView;
    @InjectView(R.id.createTimeView)
    TextView createTimeView;

    public ViewHolder(View view) {
      ButterKnife.inject(this, view);
    }
  }

}

