package ir.omidrezabagherian.aniclass.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import ir.omidrezabagherian.aniclass.R;

public class SignUpActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextSignUpName, textInputEditTextSignUpFamily, textInputEditTextSignUpNationalCode, textInputEditTextSignUpEmail, textInputEditTextSignUpPassword, textInputEditTextSignUpConfirmPassword, textInputEditTextSignUpSecurityQuest, textInputEditTextSignUpSignUpTeacherCode;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textInputEditTextSignUpName = findViewById(R.id.textinput_edittext_signup_name);
        textInputEditTextSignUpFamily = findViewById(R.id.textinput_edittext_signup_family);
        textInputEditTextSignUpNationalCode = findViewById(R.id.textinput_edittext_signup_nationalcode);
        textInputEditTextSignUpEmail = findViewById(R.id.textinput_edittext_signup_email);
        textInputEditTextSignUpPassword = findViewById(R.id.textinput_edittext_signup_password);
        textInputEditTextSignUpConfirmPassword = findViewById(R.id.textinput_edittext_signup_confirm_password);
        textInputEditTextSignUpSecurityQuest = findViewById(R.id.textinput_edittext_signup_security_quest);
        textInputEditTextSignUpSignUpTeacherCode = findViewById(R.id.textinput_edittext_signup_signup_teachercode);
        buttonSignUp = findViewById(R.id.button_signup_signup);

        buttonSignUp.setOnClickListener(v -> signup());

    }

    private void signup() {
        int isTeacher = 0;

        String name = textInputEditTextSignUpName.getText().toString();
        String family = textInputEditTextSignUpFamily.getText().toString();
        String nationalCode = textInputEditTextSignUpNationalCode.getText().toString();
        String email = textInputEditTextSignUpEmail.getText().toString();
        String password = textInputEditTextSignUpPassword.getText().toString();
        String confirmPassword = textInputEditTextSignUpConfirmPassword.getText().toString();
        String securityQuest = textInputEditTextSignUpSecurityQuest.getText().toString();
        String teacherCode = textInputEditTextSignUpSignUpTeacherCode.getText().toString();

        if (name.length() <= 2 || family.length() <= 2) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_name_and_family_is_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        if (nationalCode.equals("1111111111")) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_nationalcode_is_available, Toast.LENGTH_SHORT).show();
            return;
        }
        if (nationalCode.length() <= 9) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_nationalcode_is_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.equals("test@email.com")) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_email_is_available, Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.equals("")) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_email_is_available, Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() <= 7) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_password_length, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_password_check, Toast.LENGTH_SHORT).show();
            return;
        }
        if (securityQuest.length() <= 2) {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_security_quest_length, Toast.LENGTH_SHORT).show();
            return;
        }
        if (teacherCode.equals("2336")) {
            signupTeacher();
        } else if (teacherCode.equals("")) {
            signupStudent();
        } else {
            Toast.makeText(SignUpActivity.this, R.string.text_signup_toast_signup_teachercode, Toast.LENGTH_SHORT).show();
            return;
        }


    }

    private void signupStudent() {
        Toast.makeText(this, "ثبت نام دانشجو", Toast.LENGTH_SHORT).show();
    }

    private void signupTeacher() {
        Toast.makeText(this, "ثبت نام استاد", Toast.LENGTH_SHORT).show();
    }

}