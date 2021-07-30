package ir.omidrezabagherian.aniclass.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import ir.omidrezabagherian.aniclass.R;

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

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("detail");
        String title = bundle.getString("title");
        String code  = bundle.getString("code");
        String teacherName = bundle.getString("teacherName");
        String department = bundle.getString("dpartment");
        String link = bundle.getString("link");
        String decs = bundle.getString("desc");
        
        textViewDetailClassTitleLesson.setText(title);
        textViewDetailClassCodeLesson.setText(code);
        textViewDetailClassTeacherName.setText(teacherName);
        textViewDetailClassDepartment.setText(department);
        textViewDetailClassAbout.setText(decs + "\n" + link );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}