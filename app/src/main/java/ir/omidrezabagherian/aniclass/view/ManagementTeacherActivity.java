package ir.omidrezabagherian.aniclass.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import ir.omidrezabagherian.aniclass.R;

public class ManagementTeacherActivity extends AppCompatActivity {

    private Toolbar toolbarManagementTeacher;
    private DrawerLayout drawerLayoutManagementTeacher;
    private NavigationView navigationViewManagementTeacher;
    private RecyclerView recyclerViewManagementTeacherClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_teacher);

        toolbarManagementTeacher = (Toolbar) findViewById(R.id.toolbar_management_teacher);
        drawerLayoutManagementTeacher = (DrawerLayout) findViewById(R.id.drawerlayout_management_teacher);
        navigationViewManagementTeacher = (NavigationView) findViewById(R.id.navigationview_management_teacher);
        recyclerViewManagementTeacherClasses = (RecyclerView) findViewById(R.id.recyclerview_management_teacher_classes);

        toolbarManagementTeacher.setTitle(R.string.text_management_student_title_toolbar);
        setSupportActionBar(toolbarManagementTeacher);
        ActionBar actionBarManagementTeacher = getSupportActionBar();
        actionBarManagementTeacher.setDisplayHomeAsUpEnabled(true);
        actionBarManagementTeacher.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewManagementTeacher.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_teacher_create_new_class:
                        Intent goToCreateClass = new Intent(ManagementTeacherActivity.this, CreateClassTeacherActivity.class);
                        startActivity(goToCreateClass);
                        break;
                    case R.id.item_menu_teacher_management_class:
                        drawerLayoutManagementTeacher.closeDrawers();
                        break;
                    case R.id.item_menu_teacher_setting:
                        Intent goToSetting = new Intent(ManagementTeacherActivity.this, SettingTeacherActivity.class);
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
                drawerLayoutManagementTeacher.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}