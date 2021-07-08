package ir.omidrezabagherian.aniclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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

public class SignupTeacherActivity extends AppCompatActivity {

    private Toolbar toolbarSignupTeacher;
    private DrawerLayout drawerLayoutSignupTeacher;
    private NavigationView navigationViewSignupTeacher;
    private EditText editTextSignupTeacherRegisterCode, editTextSignupTeacherName, editTextSignupTeacherFamily, editTextSignupTeacherEmail, editTextSignupTeacherNationalCode, editTextSignupTeacherPassword, editTextSignupTeacherConfirmPassword;
    private Button buttonSignupTeacherCheckRegisterCode, buttonSignupTeacherSignUp;
    private TextView textViewSignupTeacherLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_teacher);

        toolbarSignupTeacher = (Toolbar) findViewById(R.id.toolbar_signup_teacher);
        drawerLayoutSignupTeacher = (DrawerLayout) findViewById(R.id.drawerlayout_signup_teacher);
        navigationViewSignupTeacher = (NavigationView) findViewById(R.id.navigationview_signup_teacher);
        editTextSignupTeacherRegisterCode = (EditText) findViewById(R.id.edittext_signup_teacher_register_code);
        buttonSignupTeacherCheckRegisterCode = (Button) findViewById(R.id.button_signup_teacher_search_register_code);
        editTextSignupTeacherName = (EditText) findViewById(R.id.edittext_signup_teacher_name);
        editTextSignupTeacherFamily = (EditText) findViewById(R.id.edittext_signup_teacher_family);
        editTextSignupTeacherEmail = (EditText) findViewById(R.id.edittext_signup_teacher_email);
        editTextSignupTeacherNationalCode = (EditText) findViewById(R.id.edittext_signup_teacher_nationalcode);
        editTextSignupTeacherPassword = (EditText) findViewById(R.id.edittext_signup_teacher_password);
        editTextSignupTeacherConfirmPassword = (EditText) findViewById(R.id.edittext_signup_teacher_confirm_password);
        buttonSignupTeacherSignUp = (Button) findViewById(R.id.button_signup_teacher_signup);
        textViewSignupTeacherLogin = (TextView) findViewById(R.id.textview_signup_student_login);

        toolbarSignupTeacher.setTitle(R.string.text_signup_teacher_title_toolbar);
        setSupportActionBar(toolbarSignupTeacher);

        navigationViewSignupTeacher.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_main_login:
                        Intent goToLogin = new Intent(SignupTeacherActivity.this, LoginActivity.class);
                        startActivity(goToLogin);
                        break;
                    case R.id.item_menu_main_signup_student:
                        Intent goToSignUpStudent = new Intent(SignupTeacherActivity.this, SignupStudentActivity.class);
                        startActivity(goToSignUpStudent);
                        break;
                    case R.id.item_menu_main_signup_teacher:
                        drawerLayoutSignupTeacher.closeDrawers();
                        break;
                }
                return false;
            }
        });

        textViewSignupTeacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutSignupTeacher.openDrawer(Gravity.RIGHT);
            }
        });

    }

}