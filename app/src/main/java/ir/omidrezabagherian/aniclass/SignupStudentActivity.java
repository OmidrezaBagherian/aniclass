package ir.omidrezabagherian.aniclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class SignupStudentActivity extends AppCompatActivity {

    private Toolbar toolbarSignupStudent;
    private DrawerLayout drawerLayoutSignupStudent;
    private NavigationView navigationViewSignupStudent;
    private EditText editTextSignupStudentName, editTextSignupStudentFamily, editTextSignupStudentEmail, editTextSignupStudentNationalCode, editTextSignupStudentPassword, editTextSignupStudentConfirmPassword;
    private Button buttonSignupStudentSignUp;
    private TextView textViewSignupStudentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_student);

        toolbarSignupStudent = (Toolbar) findViewById(R.id.toolbar_signup_student);
        drawerLayoutSignupStudent = (DrawerLayout) findViewById(R.id.drawerlayout_signup_student);
        navigationViewSignupStudent = (NavigationView) findViewById(R.id.navigationview_signup_student);
        editTextSignupStudentName = (EditText) findViewById(R.id.edittext_signup_student_name);
        editTextSignupStudentFamily = (EditText) findViewById(R.id.edittext_signup_student_family);
        editTextSignupStudentEmail = (EditText) findViewById(R.id.edittext_signup_student_email);
        editTextSignupStudentNationalCode = (EditText) findViewById(R.id.edittext_signup_student_nationalcode);
        editTextSignupStudentPassword = (EditText) findViewById(R.id.edittext_signup_student_password);
        editTextSignupStudentConfirmPassword = (EditText) findViewById(R.id.edittext_signup_student_confirm_password);
        buttonSignupStudentSignUp = (Button) findViewById(R.id.button_signup_student_signup);
        textViewSignupStudentLogin = (TextView) findViewById(R.id.textview_signup_student_login);

        toolbarSignupStudent.setTitle(R.string.text_login_title_toolbar);
        setSupportActionBar(toolbarSignupStudent);

        navigationViewSignupStudent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_main_login:
                        Intent goToLogin = new Intent(SignupStudentActivity.this, LoginActivity.class);
                        startActivity(goToLogin);
                        break;
                    case R.id.item_menu_main_signup_student:
                        drawerLayoutSignupStudent.closeDrawers();
                        break;
                    case R.id.item_menu_main_signup_teacher:
                        Intent goToSignUpTeacher = new Intent(SignupStudentActivity.this, SignupTeacherActivity.class);
                        startActivity(goToSignUpTeacher);
                        break;
                }
                return false;
            }
        });

        textViewSignupStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutSignupStudent.openDrawer(Gravity.RIGHT);
            }
        });

    }


}