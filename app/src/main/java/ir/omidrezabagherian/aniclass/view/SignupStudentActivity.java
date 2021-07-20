package ir.omidrezabagherian.aniclass.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import ir.omidrezabagherian.aniclass.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        toolbarSignupStudent.setTitle(R.string.text_signup_student_title_toolbar);
        setSupportActionBar(toolbarSignupStudent);

        buttonSignupStudentSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextSignupStudentName.getText().toString();
                String family = editTextSignupStudentFamily.getText().toString();
                String email = editTextSignupStudentEmail.getText().toString();
                String nationalcode = editTextSignupStudentNationalCode.getText().toString();
                String password = editTextSignupStudentPassword.getText().toString();
                String confirm_password = editTextSignupStudentConfirmPassword.getText().toString();
                if (name.length() <= 2) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_character_name, Toast.LENGTH_SHORT).show();
                } else {
                    //Send email to database
                }
                if (family.length() <= 2) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_character_family, Toast.LENGTH_SHORT).show();
                } else {
                    //Send email to database
                }
                if (email.equals("")) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_empty_email, Toast.LENGTH_SHORT).show();
                } else {
                    if (email.equals("Omid@gmail.com")) {
                        Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_available_email, Toast.LENGTH_SHORT).show();
                    } else {
                        //Send email to database
                    }
                }
                if (nationalcode.equals("")) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_empty_nationalcode, Toast.LENGTH_SHORT).show();
                } else {
                    if (nationalcode.equals("2092561634")) {
                        Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_available_nationalcode, Toast.LENGTH_SHORT).show();
                    } else {
                        //Send nationalcode to database
                    }
                }
                if (password.length() <= 7) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_length_password, Toast.LENGTH_SHORT).show();
                } else {
                    if (confirm_password.equals(password)) {
                        //Send password to database
                    } else {
                        Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_confirm_password, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

}