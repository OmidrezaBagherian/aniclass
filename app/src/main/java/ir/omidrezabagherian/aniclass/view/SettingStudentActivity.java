package ir.omidrezabagherian.aniclass.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import ir.omidrezabagherian.aniclass.R;

public class SettingStudentActivity extends AppCompatActivity {

    private Toolbar toolbarSetting;
    private DrawerLayout drawerLayoutSetting;
    private NavigationView navigationViewSetting;
    private EditText editTextSettingOldName, editTextSettingNewName, editTextSettingOldFamily, editTextSettingNewFamily, editTextSettingOldEmail, editTextSettingNewEmail, editTextSettingOldNationalCode, editTextSettingNewNationalCode, editTextSettingOldPassword, editTextSettingNewPassword, editTextSettingConfirmNewPassword;
    private Button buttonSettingApplyChangeNameFamily, buttonSettingApplyChangeEmail, buttonSettingApplyChangeNationalCode, buttonSettingApplyChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_student);

        toolbarSetting = (Toolbar) findViewById(R.id.toolbar_setting);
        drawerLayoutSetting = (DrawerLayout) findViewById(R.id.drawerlayout_setting);
        navigationViewSetting = (NavigationView) findViewById(R.id.navigationview_setting);
        editTextSettingOldName = (EditText) findViewById(R.id.edittext_setting_old_name);
        editTextSettingNewName = (EditText) findViewById(R.id.edittext_setting_new_name);
        editTextSettingOldFamily = (EditText) findViewById(R.id.edittext_setting_old_family);
        editTextSettingNewFamily = (EditText) findViewById(R.id.edittext_setting_new_family);
        buttonSettingApplyChangeNameFamily = (Button) findViewById(R.id.button_setting_apply_change_name_family);
        editTextSettingOldEmail = (EditText) findViewById(R.id.edittext_setting_old_email);
        editTextSettingNewEmail = (EditText) findViewById(R.id.edittext_setting_new_email);
        buttonSettingApplyChangeEmail = (Button) findViewById(R.id.button_setting_apply_change_email);
        editTextSettingOldNationalCode = (EditText) findViewById(R.id.edittext_setting_old_nationalcode);
        editTextSettingNewNationalCode = (EditText) findViewById(R.id.edittext_setting_new_nationalcode);
        buttonSettingApplyChangeNationalCode = (Button) findViewById(R.id.button_setting_apply_change_nationalcode);
        editTextSettingOldPassword = (EditText) findViewById(R.id.edittext_setting_old_password);
        editTextSettingNewPassword = (EditText) findViewById(R.id.edittext_setting_new_password);
        editTextSettingConfirmNewPassword = (EditText) findViewById(R.id.edittext_setting_confirm_new_password);
        buttonSettingApplyChangePassword = (Button) findViewById(R.id.button_setting_apply_change_password);

        toolbarSetting.setTitle(R.string.text_followed_student_title_toolbar);
        setSupportActionBar(toolbarSetting);
        ActionBar actionBarSetting = getSupportActionBar();
        actionBarSetting.setDisplayHomeAsUpEnabled(true);
        actionBarSetting.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewSetting.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
                        drawerLayoutSetting.closeDrawers();
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
                drawerLayoutSetting.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}