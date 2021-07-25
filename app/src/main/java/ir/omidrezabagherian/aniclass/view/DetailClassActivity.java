package ir.omidrezabagherian.aniclass.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import ir.omidrezabagherian.aniclass.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class DetailClassActivity extends AppCompatActivity {

    private Toolbar toolbarDetailClass;
    private TextView textViewDetailClassTitleLesson, textViewDetailClassCodeLesson, textViewDetailClassTeacherName, textViewDetailClassDepartment, textViewDetailClassAbout;
    private RecyclerView recyclerViewDetailClassLinks;

    String[] data = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_class);

        toolbarDetailClass = (Toolbar) findViewById(R.id.toolbar_detail_class);
        textViewDetailClassTitleLesson = (TextView) findViewById(R.id.textview_detail_class_input_title_lesson);
        textViewDetailClassCodeLesson = (TextView) findViewById(R.id.textview_detail_class_input_code_lesson);
        textViewDetailClassTeacherName = (TextView) findViewById(R.id.textview_detail_class_input_teacher_name);
        textViewDetailClassDepartment = (TextView) findViewById(R.id.textview_detail_class_input_department);
        textViewDetailClassAbout = (TextView) findViewById(R.id.textview_detail_class_input_about);
        recyclerViewDetailClassLinks = (RecyclerView) findViewById(R.id.recyclerview_detail_class_links);

        toolbarDetailClass.setTitle(R.string.text_detail_class_title_toolbar);
        setSupportActionBar(toolbarDetailClass);
        ActionBar actionBarCreateClassTeacher = getSupportActionBar();
        actionBarCreateClassTeacher.setDisplayHomeAsUpEnabled(true);
        actionBarCreateClassTeacher.setHomeAsUpIndicator(R.drawable.ic_round_back);

        data[0] = "پایگاه داده";
        textViewDetailClassTitleLesson.setText(data[0]);
        data[1] = "1022310";
        textViewDetailClassCodeLesson.setText(data[1]);
        data[2] = "مسعود ترابی";
        textViewDetailClassTeacherName.setText(data[2]);
        data[3] = "فنی مهندسی";
        textViewDetailClassDepartment.setText(data[3]);
        data[4] = "این کلاس برای دانشجویان ورودی 98 می باشد";
        textViewDetailClassAbout.setText(data[4]);
        data[5] = "جلسه اول";
        data[6] = "14:00";
        data[7] = "1400/07/01";
        data[8] = "https://www.google.com/";
        /*String titleLesson = "پایگاه داده";
        textViewDetailClassTitleLesson.setText(titleLesson);
        int codeLesson = 1022310;
        textViewDetailClassCodeLesson.setText(String.valueOf(codeLesson));
        String teacherName = "مسعود ترابی";
        textViewDetailClassTeacherName.setText(teacherName);
        String department = "فنی مهندسی";
        textViewDetailClassDepartment.setText(department);
        String about = "این کلاس برای دانشجویان ورودی 98 می باشد";
        textViewDetailClassAbout.setText(about);*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent goToMain = new Intent(DetailClassActivity.this, MainStudentActivity.class);
                startActivity(goToMain);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}