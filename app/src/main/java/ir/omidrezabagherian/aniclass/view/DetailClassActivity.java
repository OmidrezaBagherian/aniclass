package ir.omidrezabagherian.aniclass.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import ir.omidrezabagherian.aniclass.R;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class DetailClassActivity extends AppCompatActivity {

    private Toolbar toolbarDetailClass;
    private TextView textViewDetailClassTitleLesson, textViewDetailClassCodeLesson, textViewDetailClassTeacherName, textViewDetailClassDepartment, textViewDetailClassAbout;
    private RecyclerView recyclerViewDetailClassLinks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_class);

        toolbarDetailClass = (Toolbar) findViewById(R.id.toolbar_detail_class);
        textViewDetailClassTitleLesson = (TextView) findViewById(R.id.textview_detail_class_input_title_lesson);
        textViewDetailClassCodeLesson = (TextView) findViewById(R.id.textview_detail_class_input_code_lesson);
        textViewDetailClassTeacherName = (TextView) findViewById(R.id.textview_detail_class_teacher_name);
        textViewDetailClassDepartment = (TextView) findViewById(R.id.textview_detail_class_department);
        textViewDetailClassAbout = (TextView) findViewById(R.id.textview_detail_class_about);
        recyclerViewDetailClassLinks = (RecyclerView) findViewById(R.id.recyclerview_detail_class_links);

        toolbarDetailClass.setTitle(R.string.text_detail_class_title_toolbar);
        setSupportActionBar(toolbarDetailClass);


    }
}