package ir.omidrezabagherian.aniclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudentActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        bottomNavigationView = findViewById(R.id.bottom_navigation_student);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_student,new ProfileStudentFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                        Toast.makeText(StudentActivity.this, R.string.text_menu_student_my_classes, Toast.LENGTH_SHORT).show();
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