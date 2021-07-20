package ir.omidrezabagherian.aniclass.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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

public class SignupTeacherActivity extends AppCompatActivity {

    private Toolbar toolbarSignupTeacher;
    private EditText editTextSignupTeacherRegisterCode, editTextSignupTeacherName, editTextSignupTeacherFamily, editTextSignupTeacherEmail, editTextSignupTeacherNationalCode, editTextSignupTeacherPassword, editTextSignupTeacherConfirmPassword;
    private Button buttonSignupTeacherCheckRegisterCode, buttonSignupTeacherSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_teacher);

        toolbarSignupTeacher = (Toolbar) findViewById(R.id.toolbar_signup_teacher);
        editTextSignupTeacherRegisterCode = (EditText) findViewById(R.id.edittext_signup_teacher_register_code);
        buttonSignupTeacherCheckRegisterCode = (Button) findViewById(R.id.button_signup_teacher_search_register_code);
        editTextSignupTeacherName = (EditText) findViewById(R.id.edittext_signup_teacher_name);
        editTextSignupTeacherFamily = (EditText) findViewById(R.id.edittext_signup_teacher_family);
        editTextSignupTeacherEmail = (EditText) findViewById(R.id.edittext_signup_teacher_email);
        editTextSignupTeacherNationalCode = (EditText) findViewById(R.id.edittext_signup_teacher_nationalcode);
        editTextSignupTeacherPassword = (EditText) findViewById(R.id.edittext_signup_teacher_password);
        editTextSignupTeacherConfirmPassword = (EditText) findViewById(R.id.edittext_signup_teacher_confirm_password);
        buttonSignupTeacherSignUp = (Button) findViewById(R.id.button_signup_teacher_signup);

        toolbarSignupTeacher.setTitle(R.string.text_signup_teacher_title_toolbar);
        setSupportActionBar(toolbarSignupTeacher);

        buttonSignupTeacherCheckRegisterCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editTextSignupTeacherRegisterCode.getText().toString();
                if (code.equals("1234567890")) {
                    editTextSignupTeacherName.setEnabled(true);
                    editTextSignupTeacherFamily.setEnabled(true);
                    editTextSignupTeacherEmail.setEnabled(true);
                    editTextSignupTeacherNationalCode.setEnabled(true);
                    editTextSignupTeacherPassword.setEnabled(true);
                    editTextSignupTeacherConfirmPassword.setEnabled(true);
                } else {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_register_code, Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSignupTeacherSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextSignupTeacherName.getText().toString();
                String family = editTextSignupTeacherFamily.getText().toString();
                String email = editTextSignupTeacherEmail.getText().toString();
                String nationalcode = editTextSignupTeacherNationalCode.getText().toString();
                String password = editTextSignupTeacherPassword.getText().toString();
                String confirm_password = editTextSignupTeacherConfirmPassword.getText().toString();
                if (name.length() <= 2) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_character_name, Toast.LENGTH_SHORT).show();
                } else {
                    //Send email to database
                }
                if (family.length() <= 2) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_character_family, Toast.LENGTH_SHORT).show();
                } else {
                    //Send email to database
                }
                if (email.equals("")) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_empty_email, Toast.LENGTH_SHORT).show();
                } else {
                    if (email.equals("Omid@gmail.com")) {
                        Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_available_email, Toast.LENGTH_SHORT).show();
                    } else {
                        //Send email to database
                    }
                }
                if (nationalcode.equals("")) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_empty_nationalcode, Toast.LENGTH_SHORT).show();
                } else {
                    if (nationalcode.equals("2092561634")) {
                        Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_available_nationalcode, Toast.LENGTH_SHORT).show();
                    } else {
                        //Send nationalcode to database
                    }
                }
                if (password.length() <= 7) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_length_password, Toast.LENGTH_SHORT).show();
                } else {
                    if (confirm_password.equals(password)) {
                        //Send password to database
                    } else {
                        Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_confirm_password, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}