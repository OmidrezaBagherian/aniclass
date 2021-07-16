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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;

public class CreateClassTeacherActivity extends AppCompatActivity {

    private Toolbar toolbarCreateClassTeacher;
    private DrawerLayout drawerLayoutCreateClassTeacher;
    private NavigationView navigationViewCreateClassTeacher;
    private EditText editTextCreateClassTeacherTitleLesson, editTextCreateClassTeacherCodeLesson, editTextCreateClassTeacherCapacity, editTextCreateClassTeacherLink,editTextCreateClassTeacherAbout;
    private Spinner spinnerCreateClassTeacherChoiceDepartment,spinnerCreateClassTeacherChoiceUniversity;
    private Button buttonCreateClassTeacherCreateClass;

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