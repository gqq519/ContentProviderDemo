package com.gqq.client;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 实际开发中不建议在主线程进行数据库操作
        Uri bookUri = Uri.parse("content://com.gqq.contentproviderdemo.book.provider/book");
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", 6);
        contentValues.put("name", "活着");
        getContentResolver().insert(bookUri, contentValues);
        Cursor bookCursor = getContentResolver().query(bookUri, new String[]{"_id", "name"}, null, null, null);
        while (bookCursor.moveToNext()) {
            Book book = new Book();
            book.id = bookCursor.getInt(0);
            book.name = bookCursor.getString(1);
            Log.i("TAG", "query book:"+book.toString());
        }
        bookCursor.close();

        Uri userUri = Uri.parse("content://com.gqq.contentproviderdemo.book.provider/user");
        Cursor userCursor = getContentResolver().query(userUri, new String[]{"_id", "name", "sex"}, null, null, null);
        while (userCursor.moveToNext()) {
            User user = new User();
            user.id = userCursor.getInt(0);
            user.name = userCursor.getString(1);
            user.sex = userCursor.getInt(2);
            Log.i("TAG", "query user:"+user.toString());
        }
        userCursor.close();

//        getContentResolver().query(uri, null, null, null, null);
//        getContentResolver().query(uri, null, null, null, null);
//        getContentResolver().query(uri, null, null, null, null);
    }
}
