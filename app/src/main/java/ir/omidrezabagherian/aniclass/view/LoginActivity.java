package ir.omidrezabagherian.aniclass.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.omidrezabagherian.aniclass.R;
import ir.omidrezabagherian.aniclass.local.room.AniClassDataBase;
import ir.omidrezabagherian.aniclass.local.room.dao.AniClassDao;
import ir.omidrezabagherian.aniclass.local.shared_pref.AniclassSharedPref;

public class LoginActivity extends AppCompatActivity {
    
    private Toolbar toolbarLogin;
    private EditText editTextLoginNationalCode, editTextLoginPassword;
    private CheckBox checkBoxLoginIsTeacher, checkBoxLoginShowPassword;
    private Button buttonLoginLogin;
    private TextView textViewLoginSignupStudent, textViewLoginSignupTeacher;
    
    private final AniClassDao dao = AniClassDataBase.getDatabase(getApplicationContext()).getDao();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AniclassSharedPref.isLogined()) {
            if (AniclassSharedPref.isTeacher())
                goManagmentTeacherActivity();
            else
                goMainStudentActivity();
        }
        
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
        
        
        buttonLoginLogin.setOnClickListener(v -> login());
        
        textViewLoginSignupStudent.setOnClickListener(v -> {
            Intent goToSignUpStudent = new Intent(LoginActivity.this, SignupStudentActivity.class);
            startActivity(goToSignUpStudent);
        });
        
        textViewLoginSignupTeacher.setOnClickListener(v -> {
            Intent goToSignUpTeacher = new Intent(LoginActivity.this, SignupTeacherActivity.class);
            startActivity(goToSignUpTeacher);
        });
        
        
    }
    
    
    private void login() {
        if (checkBoxLoginIsTeacher.isChecked()) { // teacher login
            compositeDisposable.add(
                dao.teacherLogin(editTextLoginNationalCode.getText().toString().trim(), editTextLoginPassword.getText().toString().trim()
                ).observeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(teacher -> {
                        AniclassSharedPref.login(teacher);
                        goManagmentTeacherActivity();
                    }, throwable -> {
                        Toast.makeText(this, "اطلاعات کاربری شما اشتباه است!", Toast.LENGTH_LONG).show();
                    }));
        } else { // user login
            compositeDisposable.add(
                dao.userLogin(editTextLoginNationalCode.getText().toString().trim(), editTextLoginPassword.getText().toString().trim()
                ).observeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(user -> {
                        AniclassSharedPref.login(user);
                        goMainStudentActivity();
                    }, throwable -> {
                        Toast.makeText(this, "اطلاعات کاربری شما اشتباه است!", Toast.LENGTH_LONG).show();
                    }));
        }
    }
    
    private void goMainStudentActivity() {
        startActivity(new Intent(LoginActivity.this, MainStudentActivity.class));
        finish();
    }
    
    private void goManagmentTeacherActivity() {
        startActivity(new Intent(LoginActivity.this, ManagementTeacherActivity.class));
        finish();
    }
    
    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        compositeDisposable = null;
        super.onDestroy();
    }
}