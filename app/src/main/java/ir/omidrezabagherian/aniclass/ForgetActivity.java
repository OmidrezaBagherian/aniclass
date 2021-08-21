package ir.omidrezabagherian.aniclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ForgetActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextForgetNationalCode, textInputEditTextForgetEmail, textInputEditTextForgetSecurityQuestion, textInputEditTextDialogForgetNewPassword, textInputEditTextDialogForgetConfirmNewPassword;
    private Button buttonForgetCheckInformation, buttonDialogForgetChangePassword, buttonDialogForgetCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        textInputEditTextForgetNationalCode = (TextInputEditText) findViewById(R.id.textinput_edittext_forget_nationalcode);
        textInputEditTextForgetEmail = (TextInputEditText) findViewById(R.id.textinput_edittext_forget_email);
        textInputEditTextForgetSecurityQuestion = (TextInputEditText) findViewById(R.id.textinput_edittext_forget_security_question);
        buttonForgetCheckInformation = (Button) findViewById(R.id.button_forget_check_information);

        buttonForgetCheckInformation.setOnClickListener(v -> changePassword());

    }

    private void changePassword(){
        String nationalCode = textInputEditTextForgetNationalCode.getText().toString();
        String email = textInputEditTextForgetEmail.getText().toString();
        String securityQuestion = textInputEditTextForgetSecurityQuestion.getText().toString();



        if (nationalCode.equals("2080990081") && email.equals("Omidreza@gmail.com") && securityQuestion.equals("Mahdiyeh")) {
            openDialog();
        } else {
            Toast.makeText(this, R.string.text_forget_toast_information_is_empty, Toast.LENGTH_SHORT).show();
        }
    }

    private void openDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ForgetActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_forget_password, null);
        textInputEditTextDialogForgetNewPassword = (TextInputEditText) dialogView.findViewById(R.id.textinput_edittext_dialog_forget_new_password);
        textInputEditTextDialogForgetConfirmNewPassword = (TextInputEditText) dialogView.findViewById(R.id.textinput_edittext_dialog_forget_confirm_new_password);
        buttonDialogForgetChangePassword = (Button) dialogView.findViewById(R.id.button_dialog_forget_change_password);
        buttonDialogForgetCancel = (Button) dialogView.findViewById(R.id.button_dialog_forget_close);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogForgetPassword = dialogBuilder.create();
        dialogForgetPassword.show();

        buttonDialogForgetCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogForgetPassword.dismiss();
            }
        });

        buttonDialogForgetChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = textInputEditTextDialogForgetNewPassword.getText().toString();
                String confirmNewPassword = textInputEditTextDialogForgetConfirmNewPassword.getText().toString();

                if (newPassword.length() <= 7) {
                    Toast.makeText(ForgetActivity.this, R.string.text_dialog_forget_toast_password_length, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!newPassword.equals(confirmNewPassword)) {
                    Toast.makeText(ForgetActivity.this, R.string.text_dialog_forget_toast_password_check, Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(ForgetActivity.this, R.string.text_dialog_forget_toast_change_password, Toast.LENGTH_SHORT).show();
                dialogForgetPassword.dismiss();
                Intent loginPage = new Intent(ForgetActivity.this,LoginActivity.class);
                startActivity(loginPage);

            }
        });

    }

}