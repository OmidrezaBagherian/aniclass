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
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;

public class SettingTeacherActivity extends AppCompatActivity {

    private Toolbar toolbarSettingTeacher;
    private DrawerLayout drawerLayoutSettingTeacher;
    private NavigationView navigationViewSettingTeacher;
    private EditText editTextSettingTeacherOldName, editTextSettingTeacherNewName, editTextSettingTeacherOldFamily, editTextSettingTeacherNewFamily, editTextSettingTeacherOldEmail, editTextSettingTeacherNewEmail, editTextSettingTeacherOldNationalCode, editTextSettingTeacherNewNationalCode, editTextSettingTeacherOldPassword, editTextSettingTeacherNewPassword, editTextSettingTeacherConfirmNewPassword;
    private Button buttonSettingTeacherApplyChangeNameFamily, buttonSettingTeacherApplyChangeEmail, buttonSettingTeacherApplyChangeNationalCode, buttonSettingTeacherApplyChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_teacher);

        toolbarSettingTeacher = (Toolbar) findViewById(R.id.toolbar_setting_teacher);
        drawerLayoutSettingTeacher = (DrawerLayout) findViewById(R.id.drawerlayout_setting_teacher);
        navigationViewSettingTeacher = (NavigationView) findViewById(R.id.navigationview_setting_teacher);
        editTextSettingTeacherOldName = (EditText) findViewById(R.id.edittext_setting_teacher_old_name);
        editTextSettingTeacherNewName = (EditText) findViewById(R.id.edittext_setting_teacher_new_name);
        editTextSettingTeacherOldFamily = (EditText) findViewById(R.id.edittext_setting_teacher_old_family);
        editTextSettingTeacherNewFamily = (EditText) findViewById(R.id.edittext_setting_teacher_new_family);
        buttonSettingTeacherApplyChangeNameFamily = (Button) findViewById(R.id.button_setting_teacher_apply_change_name_family);
        editTextSettingTeacherOldEmail = (EditText) findViewById(R.id.edittext_setting_teacher_old_email);
        editTextSettingTeacherNewEmail = (EditText) findViewById(R.id.edittext_setting_teacher_new_email);
        buttonSettingTeacherApplyChangeEmail = (Button) findViewById(R.id.button_setting_teacher_apply_change_email);
        editTextSettingTeacherOldNationalCode = (EditText) findViewById(R.id.edittext_setting_teacher_old_nationalcode);
        editTextSettingTeacherNewNationalCode = (EditText) findViewById(R.id.edittext_setting_teacher_new_nationalcode);
        buttonSettingTeacherApplyChangeNationalCode = (Button) findViewById(R.id.button_setting_teacher_apply_change_nationalcode);
        editTextSettingTeacherOldPassword = (EditText) findViewById(R.id.edittext_setting_teacher_old_password);
        editTextSettingTeacherNewPassword = (EditText) findViewById(R.id.edittext_setting_teacher_new_password);
        editTextSettingTeacherConfirmNewPassword = (EditText) findViewById(R.id.edittext_setting_teacher_confirm_new_password);
        buttonSettingTeacherApplyChangePassword = (Button) findViewById(R.id.button_setting_teacher_apply_change_password);

        toolbarSettingTeacher.setTitle(R.string.text_setting_teacher_title_toolbar);
        setSupportActionBar(toolbarSettingTeacher);
        ActionBar actionBarSettingTeacher = getSupportActionBar();
        actionBarSettingTeacher.setDisplayHomeAsUpEnabled(true);
        actionBarSettingTeacher.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewSettingTeacher.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_teacher_create_new_class:
                        Intent goToCreateClass = new Intent(SettingTeacherActivity.this, CreateClassTeacherActivity.class);
                        startActivity(goToCreateClass);
                        break;
                    case R.id.item_menu_teacher_management_class:
                        Intent goToManagement = new Intent(SettingTeacherActivity.this, ManagementTeacherActivity.class);
                        startActivity(goToManagement);
                        break;
                    case R.id.item_menu_teacher_setting:
                        drawerLayoutSettingTeacher.closeDrawers();
                        break;
                    case R.id.item_menu_teacher_exit:
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
                drawerLayoutSettingTeacher.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}