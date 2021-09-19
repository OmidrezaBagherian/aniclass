package ir.omidrezabagherian.aniclass.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ir.omidrezabagherian.aniclass.R;

public class StudentActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationViewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        bottomNavigationViewStudent = findViewById(R.id.bottom_navigation_student);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_student,new ProfileStudentFragment()).commit();

        bottomNavigationViewStudent.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.menu_student_profile:
                        selectedFragment = new ProfileStudentFragment();
                        break;
                    case R.id.menu_student_homework:
                        selectedFragment = new HomeWorkFragment();
                        break;
                    case R.id.menu_student_classes:
                        selectedFragment = new MyClassFragment();
                        break;
                    case R.id.menu_student_search:
                        selectedFragment = new SearchClassFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_student,selectedFragment).commit();

                return true;
            }
        });

    }
}