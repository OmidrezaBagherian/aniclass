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
import ir.omidrezabagherian.aniclass.local.room.entity.TeacherEntity;
import ir.omidrezabagherian.aniclass.local.shared_pref.AniclassSharedPref;

public class SignupTeacherActivity extends AppCompatActivity {

    private Toolbar toolbarSignupTeacher;
    private EditText editTextSignupTeacherRegisterCode, editTextSignupTeacherName, editTextSignupTeacherFamily, editTextSignupTeacherEmail, editTextSignupTeacherNationalCode, editTextSignupTeacherPassword, editTextSignupTeacherConfirmPassword;
    private Button buttonSignupTeacherCheckRegisterCode, buttonSignupTeacherSignUp;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    
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
                    return;
                } 
                if (family.length() <= 2) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_character_family, Toast.LENGTH_SHORT).show();
                    return;
                } 
                if (email.equals("")) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_empty_email, Toast.LENGTH_SHORT).show();
                    return;
                } 
                if (nationalcode.equals("")) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_empty_nationalcode, Toast.LENGTH_SHORT).show();
                    return;
                } 
                if (password.length() <= 7) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_length_password, Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.equals(confirm_password)) {
                    Toast.makeText(SignupTeacherActivity.this, R.string.text_toast_signup_teacher_confirm_password, Toast.LENGTH_SHORT).show();
                    return;
                }
    
                TeacherEntity teacher = new TeacherEntity();
                teacher.email = email;
                teacher.name  = name;
                teacher.family = family;
                teacher.nationalCode = nationalcode;
                teacher.password = password;
                
                signupTeacher(teacher);
            }
        });

    }
    
    private void signupTeacher(TeacherEntity teacher) {
        compositeDisposable.add(Base.getDao().teacherSingup(teacher)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(id -> {
                teacher.id = id;
                AniclassSharedPref.signup(teacher);
                startActivity(new Intent(SignupTeacherActivity.this, MainStudentActivity.class));
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