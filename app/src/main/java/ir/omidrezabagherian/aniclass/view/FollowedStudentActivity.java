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

import com.google.android.material.navigation.NavigationView;

public class FollowedStudentActivity extends AppCompatActivity {

    private Toolbar toolbarFollowedStudent;
    private DrawerLayout drawerLayoutFollowedStudent;
    private NavigationView navigationViewFollowedStudent;
    private RecyclerView recyclerViewFollowedStudentClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followed_student);

        toolbarFollowedStudent = (Toolbar) findViewById(R.id.toolbar_followed_student);
        drawerLayoutFollowedStudent = (DrawerLayout) findViewById(R.id.drawerlayout_followed_student);
        navigationViewFollowedStudent = (NavigationView) findViewById(R.id.navigationview_followed_student);
        recyclerViewFollowedStudentClasses = (RecyclerView) findViewById(R.id.recyclerview_followed_class_student_classes);

        toolbarFollowedStudent.setTitle(R.string.text_followed_student_title_toolbar);
        setSupportActionBar(toolbarFollowedStudent);
        ActionBar actionBarFollowedStudent = getSupportActionBar();
        actionBarFollowedStudent.setDisplayHomeAsUpEnabled(true);
        actionBarFollowedStudent.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewFollowedStudent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_student_main:
                        Intent goToMain = new Intent(FollowedStudentActivity.this, MainStudentActivity.class);
                        startActivity(goToMain);
                        break;
                    case R.id.item_menu_student_class_saved:
                        drawerLayoutFollowedStudent.closeDrawers();
                        break;
                    case R.id.item_menu_student_setting:
                        Intent goToSetting = new Intent(FollowedStudentActivity.this, SettingStudentActivity.class);
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
                drawerLayoutFollowedStudent.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}