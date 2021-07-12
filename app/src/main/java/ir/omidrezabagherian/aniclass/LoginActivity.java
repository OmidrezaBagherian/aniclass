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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbarLogin;
    private EditText editTextLoginNationalCode, editTextLoginPassword;
    private CheckBox checkBoxLoginIsTeacher, checkBoxLoginShowPassword;
    private Button buttonLoginLogin;
    private TextView textViewLoginSignupStudent, textViewLoginSignupTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbarLogin = (Toolbar) findViewById(R.id.toolbar_login);
        editTextLoginNationalCode = (EditText) findViewById(R.id.edittext_login_nationalcode);
        editTextLoginPassword = (EditText) findViewById(R.id.edittext_login_password);
        checkBoxLoginIsTeacher = (CheckBox) findViewById(R.id.checkbox_login_is_teacher);
        checkBoxLoginShowPassword = (CheckBox) findViewById(R.id.checkbox_login_show_password);
        buttonLoginLogin = (Button) findViewById(R.id.button_login_login);
        textViewLoginSignupStudent = (TextView) findViewById(R.id.textview_login_signup_student);
        textViewLoginSignupTeacher = (TextView) findViewById(R.id.textview_login_signup_teacher);

        toolbarLogin.setTitle(R.string.text_login_title_toolbar);
        setSupportActionBar(toolbarLogin);

        textViewLoginSignupStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUpStudent = new Intent(LoginActivity.this, SignupStudentActivity.class);
                startActivity(goToSignUpStudent);
            }
        });

        textViewLoginSignupTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUpTeacher = new Intent(LoginActivity.this, SignupTeacherActivity.class);
                startActivity(goToSignUpTeacher);
            }
        });


    }

}