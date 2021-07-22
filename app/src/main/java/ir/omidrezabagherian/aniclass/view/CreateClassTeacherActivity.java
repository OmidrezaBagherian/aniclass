package ir.omidrezabagherian.aniclass.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import ir.omidrezabagherian.aniclass.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class CreateClassTeacherActivity extends AppCompatActivity {

    private Toolbar toolbarCreateClassTeacher;
    private DrawerLayout drawerLayoutCreateClassTeacher;
    private NavigationView navigationViewCreateClassTeacher;
    private EditText editTextCreateClassTeacherTitleLesson, editTextCreateClassTeacherCodeLesson, editTextCreateClassTeacherCapacity, editTextCreateClassTeacherLink, editTextCreateClassTeacherAbout;
    private Spinner spinnerCreateClassTeacherChoiceDepartment, spinnerCreateClassTeacherChoiceUniversity;
    private Button buttonCreateClassTeacherCreateClass;

    String[] departments = {
            "فناوری اطلاعات",
            "علوم مهندسی",
            "مالی و مدیریت",
            "هنر و گرافیک",
            "دانش و سلامت",
            "معماری",
            "مد و پوشاک",
            "صنایع دستی",
            "دروس عمومی"
    };
    String[] universities = {
            "دانشگاه فنی حرفه ای پسرانه کرج",
            "دانشگاه فنی حرفه ای دخترانه کرج"
    };

    String department, university;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class_teacher);

        toolbarCreateClassTeacher = findViewById(R.id.toolbar_create_class);
        drawerLayoutCreateClassTeacher = findViewById(R.id.drawerlayout_create_class);
        navigationViewCreateClassTeacher = findViewById(R.id.navigationview_create_class);
        editTextCreateClassTeacherTitleLesson = findViewById(R.id.edittext_create_class_title_lesson);
        editTextCreateClassTeacherCodeLesson = findViewById(R.id.edittext_create_class_code_lesson);
        editTextCreateClassTeacherCapacity = findViewById(R.id.edittext_create_class_capacity);
        editTextCreateClassTeacherLink = findViewById(R.id.edittext_create_class_link);
        spinnerCreateClassTeacherChoiceDepartment = findViewById(R.id.spinner_create_class_choice_department);
        spinnerCreateClassTeacherChoiceUniversity = findViewById(R.id.spinner_create_class_choice_university);
        editTextCreateClassTeacherAbout = findViewById(R.id.edittext_create_class_about);
        buttonCreateClassTeacherCreateClass = findViewById(R.id.button_create_class_create_class);


        toolbarCreateClassTeacher.setTitle(R.string.text_create_class_teacher_title_toolbar);
        setSupportActionBar(toolbarCreateClassTeacher);
        ActionBar actionBarCreateClassTeacher = getSupportActionBar();
        actionBarCreateClassTeacher.setDisplayHomeAsUpEnabled(true);
        actionBarCreateClassTeacher.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewCreateClassTeacher.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_teacher_create_new_class:
                        drawerLayoutCreateClassTeacher.closeDrawers();
                        break;
                    case R.id.item_menu_teacher_management_class:
                        Intent goToManagement = new Intent(CreateClassTeacherActivity.this, ManagementTeacherActivity.class);
                        startActivity(goToManagement);
                        break;
                    case R.id.item_menu_teacher_setting:
                        Intent goToSetting = new Intent(CreateClassTeacherActivity.this, SettingTeacherActivity.class);
                        startActivity(goToSetting);
                        break;
                    case R.id.item_menu_teacher_exit:
                        //exit shared
                        break;
                }
                return false;
            }
        });

        ArrayAdapter arrayAdapterDepartment = new ArrayAdapter(this, android.R.layout.simple_spinner_item, departments);
        arrayAdapterDepartment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCreateClassTeacherChoiceDepartment.setAdapter(arrayAdapterDepartment);

        spinnerCreateClassTeacherChoiceDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = departments[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter arrayAdapterUniversity = new ArrayAdapter(this, android.R.layout.simple_spinner_item, universities);
        arrayAdapterUniversity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCreateClassTeacherChoiceUniversity.setAdapter(arrayAdapterUniversity);

        spinnerCreateClassTeacherChoiceUniversity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                university = universities[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonCreateClassTeacherCreateClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleLesson = editTextCreateClassTeacherTitleLesson.getText().toString();
                String codeLesson = editTextCreateClassTeacherCodeLesson.getText().toString();
                String capacity = editTextCreateClassTeacherCodeLesson.getText().toString();
                String link = editTextCreateClassTeacherLink.getText().toString();
                String about = editTextCreateClassTeacherAbout.getText().toString();

                if (titleLesson.length() <= 2) {
                    Toast.makeText(CreateClassTeacherActivity.this, R.string.text_create_class_teacher_titleLesson, Toast.LENGTH_SHORT).show();
                }
                if (codeLesson.equals("")) {
                    Toast.makeText(CreateClassTeacherActivity.this, R.string.text_create_class_teacher_codeLesson, Toast.LENGTH_SHORT).show();
                }
                if (capacity.equals("")) {
                    Toast.makeText(CreateClassTeacherActivity.this, R.string.text_create_class_teacher_capacity, Toast.LENGTH_SHORT).show();
                }
                if (link.length() <= 10) {
                    Toast.makeText(CreateClassTeacherActivity.this, R.string.text_create_class_teacher_link, Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(CreateClassTeacherActivity.this, department, Toast.LENGTH_SHORT).show();
                Toast.makeText(CreateClassTeacherActivity.this, university, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayoutCreateClassTeacher.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}