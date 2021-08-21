package ir.omidrezabagherian.aniclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextLoginUsername, textInputEditTextLoginPassword;
    private TextView textViewLoginForgetPassword, textViewLoginSignUp;
    private Button buttonLoginLogin;

    String[] listStudent = {"1234567890", "123456"};

    String[] listTeacher = {"0987654321", "654321"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextLoginUsername = findViewById(R.id.textinput_edittext_login_username);
        textInputEditTextLoginPassword = findViewById(R.id.textinput_edittext_login_password);
        textViewLoginForgetPassword = (TextView) findViewById(R.id.textview_login_forget_password);
        textViewLoginSignUp = (TextView) findViewById(R.id.textview_login_signup);
        buttonLoginLogin = (Button) findViewById(R.id.button_login_login);



        textViewLoginForgetPassword.setOnClickListener(v -> forgetPassword());

        buttonLoginLogin.setOnClickListener(v -> login());

        textViewLoginSignUp.setOnClickListener(v -> signup());

    }

    /**
     * method forget password
     */
    private void forgetPassword() {
        Intent forgetPage = new Intent(LoginActivity.this, ForgetActivity.class);
        startActivity(forgetPage);
    }

    /**
     * method login
     */
    private void login() {
        String username = textInputEditTextLoginUsername.getText().toString();
        String password = textInputEditTextLoginPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, R.string.text_login_toast_is_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        if (username.equals(listTeacher[0]) && password.equals(listTeacher[1])) {
            Toast.makeText(this, "استاد", Toast.LENGTH_SHORT).show();
        } else if (username.equals(listStudent[0]) && password.equals(listStudent[1])) {
            Toast.makeText(this, "دانشجو", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.text_login_toast_signup, Toast.LENGTH_SHORT).show();
            return;
        }

    }

    /**
     * method signup
     */
    private void signup() {
        Intent signupPage = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(signupPage);
    }

}