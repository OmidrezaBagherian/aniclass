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
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;

public class SettingStudentActivity extends AppCompatActivity {

    private Toolbar toolbarSettingStudent;
    private DrawerLayout drawerLayoutSettingStudent;
    private NavigationView navigationViewSettingStudent;
    private EditText editTextSettingStudentOldName, editTextSettingStudentNewName, editTextSettingStudentOldFamily, editTextSettingStudentNewFamily, editTextSettingStudentOldEmail, editTextSettingStudentNewEmail, editTextSettingStudentOldNationalCode, editTextSettingStudentNewNationalCode, editTextSettingStudentOldPassword, editTextSettingStudentNewPassword, editTextSettingStudentConfirmNewPassword;
    private Button buttonSettingStudentApplyChangeNameFamily, buttonSettingStudentApplyChangeEmail, buttonSettingStudentApplyChangeNationalCode, buttonSettingStudentApplyChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_student);

        toolbarSettingStudent = (Toolbar) findViewById(R.id.toolbar_setting_student);
        drawerLayoutSettingStudent = (DrawerLayout) findViewById(R.id.drawerlayout_setting_student);
        navigationViewSettingStudent = (NavigationView) findViewById(R.id.navigationview_setting_student);
        editTextSettingStudentOldName = (EditText) findViewById(R.id.edittext_setting_student_old_name);
        editTextSettingStudentNewName = (EditText) findViewById(R.id.edittext_setting_student_new_name);
        editTextSettingStudentOldFamily = (EditText) findViewById(R.id.edittext_setting_student_old_family);
        editTextSettingStudentNewFamily = (EditText) findViewById(R.id.edittext_setting_student_new_family);
        buttonSettingStudentApplyChangeNameFamily = (Button) findViewById(R.id.button_setting_student_apply_change_name_family);
        editTextSettingStudentOldEmail = (EditText) findViewById(R.id.edittext_setting_student_old_email);
        editTextSettingStudentNewEmail = (EditText) findViewById(R.id.edittext_setting_student_new_email);
        buttonSettingStudentApplyChangeEmail = (Button) findViewById(R.id.button_setting_student_apply_change_email);
        editTextSettingStudentOldNationalCode = (EditText) findViewById(R.id.edittext_setting_student_old_nationalcode);
        editTextSettingStudentNewNationalCode = (EditText) findViewById(R.id.edittext_setting_student_new_nationalcode);
        buttonSettingStudentApplyChangeNationalCode = (Button) findViewById(R.id.button_setting_student_apply_change_nationalcode);
        editTextSettingStudentOldPassword = (EditText) findViewById(R.id.edittext_setting_student_old_password);
        editTextSettingStudentNewPassword = (EditText) findViewById(R.id.edittext_setting_student_new_password);
        editTextSettingStudentConfirmNewPassword = (EditText) findViewById(R.id.edittext_setting_student_confirm_new_password);
        buttonSettingStudentApplyChangePassword = (Button) findViewById(R.id.button_setting_student_apply_change_password);

        toolbarSettingStudent.setTitle(R.string.text_followed_student_title_toolbar);
        setSupportActionBar(toolbarSettingStudent);
        ActionBar actionBarFollowedStudent = getSupportActionBar();
        actionBarFollowedStudent.setDisplayHomeAsUpEnabled(true);
        actionBarFollowedStudent.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewSettingStudent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_student_main:
                        Intent goToMain = new Intent(SettingStudentActivity.this, MainStudentActivity.class);
                        startActivity(goToMain);
                        break;
                    case R.id.item_menu_student_class_saved:
                        Intent goToFollowed = new Intent(SettingStudentActivity.this, FollowedStudentActivity.class);
                        startActivity(goToFollowed);
                        break;
                    case R.id.item_menu_student_setting:
                        drawerLayoutSettingStudent.closeDrawers();
                        break;
                    case R.id.item_menu_student_exit:
                        //exit shared
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayoutSettingStudent.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}