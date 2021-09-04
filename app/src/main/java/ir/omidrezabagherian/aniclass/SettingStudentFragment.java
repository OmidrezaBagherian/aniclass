package ir.omidrezabagherian.aniclass;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SettingStudentFragment extends Fragment {

    private TextInputEditText textInputEditTextSettingStudentName, textInputEditTextSettingStudentFamily, textInputEditTextSettingStudentEmail, textInputEditTextSettingStudentNationalCode, textInputEditTextSettingStudentPassword;
    private ImageView imageViewSettingStudentName, imageViewSettingStudentFamily, imageViewSettingStudentEmail, imageViewSettingStudentNationalCode, imageViewSettingStudentPassword;
    private TextInputEditText textInputEditTextDialogChangeStudentName, textInputEditTextDialogChangeStudentFamily, textInputEditTextDialogChangeStudentNewEmail, textInputEditTextDialogChangeStudentConfirmNewEmail, textInputEditTextDialogChangeStudentNationalCode,textInputEditTextDialogChangeStudentNewPassword, textInputEditTextDialogChangeStudentConfirmNewPassword;
    private Button buttonSettingStudentSendEdit, buttonDialogChangeStudentNameApply, buttonDialogChangeStudentNameCancel, buttonDialogChangeStudentFamilyApply, buttonDialogChangeStudentFamilyCancel, buttonDialogChangeStudentEmailApply, buttonDialogChangeStudentEmailCancel,buttonDialogChangeStudentNationalCodeApply, buttonDialogChangeStudentNationalCodeCancel,buttonDialogChangeStudentPasswordApply, buttonDialogChangeStudentPasswordCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_student, container, false);

        textInputEditTextSettingStudentName = view.findViewById(R.id.textinput_edittext_setting_student_text_name);
        textInputEditTextSettingStudentFamily = view.findViewById(R.id.textinput_edittext_setting_student_text_family);
        textInputEditTextSettingStudentEmail = view.findViewById(R.id.textinput_edittext_setting_student_text_email);
        textInputEditTextSettingStudentNationalCode = view.findViewById(R.id.textinput_edittext_setting_student_text_nationalcode);
        textInputEditTextSettingStudentPassword = view.findViewById(R.id.textinput_edittext_setting_student_text_password);
        imageViewSettingStudentName = view.findViewById(R.id.imageview_setting_student_edit_name);
        imageViewSettingStudentFamily = view.findViewById(R.id.imageview_setting_student_edit_family);
        imageViewSettingStudentEmail = view.findViewById(R.id.imageview_setting_student_edit_email);
        imageViewSettingStudentNationalCode = view.findViewById(R.id.imageview_setting_student_edit_nationalcode);
        imageViewSettingStudentPassword = view.findViewById(R.id.imageview_setting_student_edit_password);
        buttonSettingStudentSendEdit = view.findViewById(R.id.button_student_send_edit);

        textInputEditTextSettingStudentName.setText("امیدرضا");
        textInputEditTextSettingStudentFamily.setText("باقریان اسفندانی");
        textInputEditTextSettingStudentEmail.setText("Omidreza@gmail.com");
        textInputEditTextSettingStudentNationalCode.setText("2080990081");
        textInputEditTextSettingStudentPassword.setText("Omid2001");

        imageViewSettingStudentName.setOnClickListener(v -> changeNameStudent());

        imageViewSettingStudentFamily.setOnClickListener(v -> changeFamilyStudent());

        imageViewSettingStudentEmail.setOnClickListener(v -> changeEmailStudent());

        imageViewSettingStudentNationalCode.setOnClickListener(v -> changeNationalCodeStudent());

        imageViewSettingStudentPassword.setOnClickListener(v -> changePasswordStudent());

        buttonSettingStudentSendEdit.setOnClickListener(v -> sendEditTeacher());

        return view;
    }

    private void changeNameStudent() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_name, null);
        textInputEditTextDialogChangeStudentName = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_name_text);
        buttonDialogChangeStudentNameApply = dialogView.findViewById(R.id.button_dialog_setting_name_apply);
        buttonDialogChangeStudentNameCancel = dialogView.findViewById(R.id.button_dialog_setting_name_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeName = dialogBuilder.create();
        dialogChangeName.show();

        buttonDialogChangeStudentNameCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeName.dismiss();
            }
        });

        buttonDialogChangeStudentNameApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textInputEditTextDialogChangeStudentName.getText().toString();

                if (name.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_name_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingStudentName.setText(name);
                dialogChangeName.dismiss();

            }
        });

    }

    private void changeFamilyStudent() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_family, null);
        textInputEditTextDialogChangeStudentFamily = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_family_text);
        buttonDialogChangeStudentFamilyApply = dialogView.findViewById(R.id.button_dialog_setting_family_apply);
        buttonDialogChangeStudentFamilyCancel = dialogView.findViewById(R.id.button_dialog_setting_family_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeFamily = dialogBuilder.create();
        dialogChangeFamily.show();

        buttonDialogChangeStudentFamilyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeFamily.dismiss();
            }
        });

        buttonDialogChangeStudentFamilyApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String family = textInputEditTextDialogChangeStudentFamily.getText().toString();

                if (family.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_family_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingStudentFamily.setText(family);
                dialogChangeFamily.dismiss();

            }
        });

    }

    private void changeEmailStudent() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_email, null);
        textInputEditTextDialogChangeStudentNewEmail = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_new_email_text);
        textInputEditTextDialogChangeStudentConfirmNewEmail = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_confirm_new_email_text);
        buttonDialogChangeStudentEmailApply = dialogView.findViewById(R.id.button_dialog_setting_email_apply);
        buttonDialogChangeStudentEmailCancel = dialogView.findViewById(R.id.button_dialog_setting_email_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeEmail = dialogBuilder.create();
        dialogChangeEmail.show();

        buttonDialogChangeStudentEmailCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeEmail.dismiss();
            }
        });

        buttonDialogChangeStudentEmailApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEmail = textInputEditTextDialogChangeStudentNewEmail.getText().toString();
                String confirmNewEmail = textInputEditTextDialogChangeStudentConfirmNewEmail.getText().toString();

                if (newEmail.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_email_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!newEmail.equals(confirmNewEmail)) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_email_is_check, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingStudentEmail.setText(newEmail);
                dialogChangeEmail.dismiss();

            }
        });

    }

    private void changeNationalCodeStudent() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_nationalcode, null);
        textInputEditTextDialogChangeStudentNationalCode = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_nationalcode_text);
        buttonDialogChangeStudentNationalCodeApply = dialogView.findViewById(R.id.button_dialog_setting_nationalcode_apply);
        buttonDialogChangeStudentNationalCodeCancel = dialogView.findViewById(R.id.button_dialog_setting_nationalcode_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeNationalCode = dialogBuilder.create();
        dialogChangeNationalCode.show();

        buttonDialogChangeStudentNationalCodeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeNationalCode.dismiss();
            }
        });

        buttonDialogChangeStudentNationalCodeApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nationalCode = textInputEditTextDialogChangeStudentNationalCode.getText().toString();

                if (nationalCode.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_nationalcode_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingStudentNationalCode.setText(nationalCode);
                dialogChangeNationalCode.dismiss();

            }
        });

    }

    private void changePasswordStudent() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_password, null);
        textInputEditTextDialogChangeStudentNewPassword = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_new_password_text);
        textInputEditTextDialogChangeStudentConfirmNewPassword = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_confirm_new_password_text);
        buttonDialogChangeStudentPasswordApply = dialogView.findViewById(R.id.button_dialog_setting_password_apply);
        buttonDialogChangeStudentPasswordCancel = dialogView.findViewById(R.id.button_dialog_setting_password_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangePassword = dialogBuilder.create();
        dialogChangePassword.show();

        buttonDialogChangeStudentPasswordCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangePassword.dismiss();
            }
        });

        buttonDialogChangeStudentPasswordApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = textInputEditTextDialogChangeStudentNewPassword.getText().toString();
                String confirmNewPassword = textInputEditTextDialogChangeStudentConfirmNewPassword.getText().toString();

                if (newPassword.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_password_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!confirmNewPassword.equals(confirmNewPassword)) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_password_is_check, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingStudentPassword.setText(newPassword);
                dialogChangePassword.dismiss();

            }
        });

    }

    private void sendEditTeacher(){
        String name = textInputEditTextSettingStudentName.getText().toString();
        String family = textInputEditTextSettingStudentFamily.getText().toString();
        String email = textInputEditTextSettingStudentEmail.getText().toString();
        String nationalCode = textInputEditTextSettingStudentNationalCode.getText().toString();
        String password = textInputEditTextSettingStudentPassword.getText().toString();

        Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), family, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), email, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), nationalCode, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), password, Toast.LENGTH_SHORT).show();

        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new ProfileStudentFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();

    }

}