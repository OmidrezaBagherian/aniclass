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
    private EditText editTextSignupStudentName, editTextSignupStudentFamily, editTextSignupStudentEmail, editTextSignupStudentNationalCode, editTextSignupStudentPassword, editTextSignupStudentConfirmPassword;
    private Button buttonSignupStudentSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_student);

        toolbarSignupStudent = (Toolbar) findViewById(R.id.toolbar_signup_student);
        editTextSignupStudentName = (EditText) findViewById(R.id.edittext_signup_student_name);
        editTextSignupStudentFamily = (EditText) findViewById(R.id.edittext_signup_student_family);
        editTextSignupStudentEmail = (EditText) findViewById(R.id.edittext_signup_student_email);
        editTextSignupStudentNationalCode = (EditText) findViewById(R.id.edittext_signup_student_nationalcode);
        editTextSignupStudentPassword = (EditText) findViewById(R.id.edittext_signup_student_password);
        editTextSignupStudentConfirmPassword = (EditText) findViewById(R.id.edittext_signup_student_confirm_password);
        buttonSignupStudentSignUp = (Button) findViewById(R.id.button_signup_student_signup);

        toolbarSignupStudent.setTitle(R.string.text_signup_teacher_title_toolbar);
        setSupportActionBar(toolbarSignupStudent);

    }


}