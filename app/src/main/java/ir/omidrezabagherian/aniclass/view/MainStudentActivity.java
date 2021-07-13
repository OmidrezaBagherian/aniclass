package ir.omidrezabagherian.aniclass.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.omidrezabagherian.aniclass.R;

public class MainStudentActivity extends AppCompatActivity {

    private Toolbar toolbarMainStudent;
    private DrawerLayout drawerLayoutMainStudent;
    private NavigationView navigationViewMainStudent;
    private EditText editTextMainStudentSearchClass;
    private ImageView imageViewMainStudentApplySearch;
    private Spinner spinnerMainStudentCity, spinnerMainStudentDepartment, spinnerMainStudentUniversity;
    private RecyclerView recyclerViewMainStudentClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);

        toolbarMainStudent = (Toolbar) findViewById(R.id.toolbar_main_student);
        drawerLayoutMainStudent = (DrawerLayout) findViewById(R.id.drawerlayout_main_student);
        navigationViewMainStudent = (NavigationView) findViewById(R.id.navigationview_main_student);
        editTextMainStudentSearchClass = (EditText) findViewById(R.id.edittext_main_student_search_class);
        imageViewMainStudentApplySearch = (ImageView) findViewById(R.id.imageview_main_student_apply_search);
        spinnerMainStudentCity = (Spinner) findViewById(R.id.spinner_main_student_choice_city);
        spinnerMainStudentDepartment = (Spinner) findViewById(R.id.spinner_main_student_choice_department);
        spinnerMainStudentUniversity = (Spinner) findViewById(R.id.spinner_main_student_choice_university);
        recyclerViewMainStudentClasses = (RecyclerView) findViewById(R.id.recyclerview_main_student_classes);

        toolbarMainStudent.setTitle(R.string.text_main_student_title_toolbar);
        setSupportActionBar(toolbarMainStudent);
        ActionBar actionBarMainStudent = getSupportActionBar();
        actionBarMainStudent.setDisplayHomeAsUpEnabled(true);
        actionBarMainStudent.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewMainStudent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_student_main:
                        drawerLayoutMainStudent.closeDrawers();
                        break;
                    case R.id.item_menu_student_class_saved:
                        Intent goToFollowed = new Intent(MainStudentActivity.this, FollowedStudentActivity.class);
                        startActivity(goToFollowed);
                        break;
                    case R.id.item_menu_student_setting:
                        Intent goToSetting = new Intent(MainStudentActivity.this, SettingStudentActivity.class);
                        startActivity(goToSetting);
                        break;
                    case R.id.item_menu_student_exit:
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
                drawerLayoutMainStudent.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}