package ir.omidrezabagherian.aniclass.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.omidrezabagherian.aniclass.R;
import ir.omidrezabagherian.aniclass.core.Base;
import ir.omidrezabagherian.aniclass.local.room.entity.UserEntity;
import ir.omidrezabagherian.aniclass.local.shared_pref.AniclassSharedPref;

public class SignupStudentActivity extends AppCompatActivity {

    private Toolbar toolbarSignupStudent;
    private EditText editTextSignupStudentName, editTextSignupStudentFamily, editTextSignupStudentEmail, editTextSignupStudentNationalCode, editTextSignupStudentPassword, editTextSignupStudentConfirmPassword;
    private Button buttonSignupStudentSignUp;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    
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
                    return;
                }
                
                if (family.length() <= 2) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_character_family, Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if (email.equals("")) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_empty_email, Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if (nationalcode.equals("")) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_empty_nationalcode, Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if (password.length() <= 7) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_length_password, Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if(!password.trim().equals(confirm_password.trim())) {
                    Toast.makeText(SignupStudentActivity.this, R.string.text_toast_signup_student_confirm_password, Toast.LENGTH_SHORT).show();
                    return;
                }
                
                UserEntity user = new UserEntity();
                user.email = email;
                user.name  = name;
                user.family = family;
                user.nationalCode = nationalcode;
                user.password = password;
                
                signupStudent(user);
            }
        });


    }
    
    private void signupStudent(UserEntity user) {
        compositeDisposable.add(Base.getDao().userSignup(user)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(id -> {
                Log.i("TEST" , "THIS IS : " + id);
                user.id = id;
                AniclassSharedPref.signup(user);
                startActivity(new Intent(SignupStudentActivity.this, MainStudentActivity.class));
                finish();
            } , error -> {
                Log.i("TEST" , "error : " + error.getMessage());
            }));
    }
    
    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}