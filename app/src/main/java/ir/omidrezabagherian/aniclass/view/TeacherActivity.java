package ir.omidrezabagherian.aniclass.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ir.omidrezabagherian.aniclass.R;

public class TeacherActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationViewTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        bottomNavigationViewTeacher = findViewById(R.id.bottom_navigation_teacher);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_teacher,new ProfileTeacherFragment()).commit();

        bottomNavigationViewTeacher.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.menu_teacher_profile:
                        selectedFragment = new ProfileTeacherFragment();
                        break;
                    case R.id.menu_teacher_management_homework:
                        selectedFragment = new ManagementHomeworkFragment();
                        break;
                    case R.id.menu_teacher_management_class:
                        selectedFragment = new ManagementClassFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_teacher,selectedFragment).commit();

                return true;
            }
        });

    }
}