package ir.omidrezabagherian.aniclass.view;

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

import ir.omidrezabagherian.aniclass.R;

public class SettingTeacherFragment extends Fragment {

    private TextInputEditText textInputEditTextSettingTeacherName, textInputEditTextSettingTeacherFamily, textInputEditTextSettingTeacherEmail, textInputEditTextSettingTeacherNationalCode, textInputEditTextSettingTeacherPassword;
    private ImageView imageViewSettingTeacherName, imageViewSettingTeacherFamily, imageViewSettingTeacherEmail, imageViewSettingTeacherNationalCode, imageViewSettingTeacherPassword;
    private TextInputEditText textInputEditTextDialogChangeTeacherName, textInputEditTextDialogChangeTeacherFamily, textInputEditTextDialogChangeTeacherNewEmail, textInputEditTextDialogChangeTeacherConfirmNewEmail, textInputEditTextDialogChangeTeacherNationalCode, textInputEditTextDialogChangeTeacherNewPassword, textInputEditTextDialogChangeTeacherConfirmNewPassword;
    private Button buttonSettingTeacherSendEdit, buttonDialogChangeTeacherNameApply, buttonDialogChangeTeacherNameCancel, buttonDialogChangeTeacherFamilyApply, buttonDialogChangeTeacherFamilyCancel, buttonDialogChangeTeacherEmailApply, buttonDialogChangeTeacherEmailCancel, buttonDialogChangeTeacherNationalCodeApply, buttonDialogChangeTeacherNationalCodeCancel, buttonDialogChangeTeacherPasswordApply, buttonDialogChangeTeacherPasswordCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_teacher, container, false);

        textInputEditTextSettingTeacherName = view.findViewById(R.id.textinput_edittext_setting_teacher_text_name);
        textInputEditTextSettingTeacherFamily = view.findViewById(R.id.textinput_edittext_setting_teacher_text_family);
        textInputEditTextSettingTeacherEmail = view.findViewById(R.id.textinput_edittext_setting_teacher_text_email);
        textInputEditTextSettingTeacherNationalCode = view.findViewById(R.id.textinput_edittext_setting_teacher_text_nationalcode);
        textInputEditTextSettingTeacherPassword = view.findViewById(R.id.textinput_edittext_setting_teacher_text_password);
        imageViewSettingTeacherName = view.findViewById(R.id.imageview_setting_teacher_edit_name);
        imageViewSettingTeacherFamily = view.findViewById(R.id.imageview_setting_teacher_edit_family);
        imageViewSettingTeacherEmail = view.findViewById(R.id.imageview_setting_teacher_edit_email);
        imageViewSettingTeacherNationalCode = view.findViewById(R.id.imageview_setting_teacher_edit_nationalcode);
        imageViewSettingTeacherPassword = view.findViewById(R.id.imageview_setting_teacher_edit_password);
        buttonSettingTeacherSendEdit = view.findViewById(R.id.button_teacher_send_edit);

        textInputEditTextSettingTeacherName.setText("امیدرضا");
        textInputEditTextSettingTeacherFamily.setText("باقریان اسفندانی");
        textInputEditTextSettingTeacherEmail.setText("Omidreza@gmail.com");
        textInputEditTextSettingTeacherNationalCode.setText("2080990081");
        textInputEditTextSettingTeacherPassword.setText("Omid2001");

        imageViewSettingTeacherName.setOnClickListener(v -> changeNameTeacher());

        imageViewSettingTeacherFamily.setOnClickListener(v -> changeFamilyTeacher());

        imageViewSettingTeacherEmail.setOnClickListener(v -> changeEmailTeacher());

        imageViewSettingTeacherNationalCode.setOnClickListener(v -> changeNationalCodeTeacher());

        imageViewSettingTeacherNationalCode.setOnClickListener(v -> changePasswordTeacher());

        buttonSettingTeacherSendEdit.setOnClickListener(v -> sendEditTeacher());

        return view;
    }

    private void changeNameTeacher() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_name, null);
        textInputEditTextDialogChangeTeacherName = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_name_text);
        buttonDialogChangeTeacherNameApply = dialogView.findViewById(R.id.button_dialog_setting_name_apply);
        buttonDialogChangeTeacherNameCancel = dialogView.findViewById(R.id.button_dialog_setting_name_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeName = dialogBuilder.create();
        dialogChangeName.show();

        buttonDialogChangeTeacherNameCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeName.dismiss();
            }
        });

        buttonDialogChangeTeacherNameApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textInputEditTextDialogChangeTeacherName.getText().toString();

                if (name.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_name_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingTeacherName.setText(name);
                dialogChangeName.dismiss();

            }
        });

    }

    private void changeFamilyTeacher() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_family, null);
        textInputEditTextDialogChangeTeacherFamily = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_family_text);
        buttonDialogChangeTeacherFamilyApply = dialogView.findViewById(R.id.button_dialog_setting_family_apply);
        buttonDialogChangeTeacherFamilyCancel = dialogView.findViewById(R.id.button_dialog_setting_family_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeFamily = dialogBuilder.create();
        dialogChangeFamily.show();

        buttonDialogChangeTeacherFamilyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeFamily.dismiss();
            }
        });

        buttonDialogChangeTeacherFamilyApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String family = textInputEditTextDialogChangeTeacherFamily.getText().toString();

                if (family.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_family_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingTeacherFamily.setText(family);
                dialogChangeFamily.dismiss();

            }
        });

    }

    private void changeEmailTeacher() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_email, null);
        textInputEditTextDialogChangeTeacherNewEmail = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_new_email_text);
        textInputEditTextDialogChangeTeacherConfirmNewEmail = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_confirm_new_email_text);
        buttonDialogChangeTeacherEmailApply = dialogView.findViewById(R.id.button_dialog_setting_email_apply);
        buttonDialogChangeTeacherEmailCancel = dialogView.findViewById(R.id.button_dialog_setting_email_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeEmail = dialogBuilder.create();
        dialogChangeEmail.show();

        buttonDialogChangeTeacherEmailCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeEmail.dismiss();
            }
        });

        buttonDialogChangeTeacherEmailApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEmail = textInputEditTextDialogChangeTeacherNewEmail.getText().toString();
                String confirmNewEmail = textInputEditTextDialogChangeTeacherConfirmNewEmail.getText().toString();

                if (newEmail.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_email_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!newEmail.equals(confirmNewEmail)) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_email_is_check, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingTeacherEmail.setText(newEmail);
                dialogChangeEmail.dismiss();

            }
        });

    }

    private void changeNationalCodeTeacher() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_nationalcode, null);
        textInputEditTextDialogChangeTeacherNationalCode = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_nationalcode_text);
        buttonDialogChangeTeacherNationalCodeApply = dialogView.findViewById(R.id.button_dialog_setting_nationalcode_apply);
        buttonDialogChangeTeacherNationalCodeCancel = dialogView.findViewById(R.id.button_dialog_setting_nationalcode_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangeNationalCode = dialogBuilder.create();
        dialogChangeNationalCode.show();

        buttonDialogChangeTeacherNationalCodeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangeNationalCode.dismiss();
            }
        });

        buttonDialogChangeTeacherNationalCodeApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nationalCode = textInputEditTextDialogChangeTeacherNationalCode.getText().toString();

                if (nationalCode.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_nationalcode_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingTeacherNationalCode.setText(nationalCode);
                dialogChangeNationalCode.dismiss();

            }
        });

    }

    private void changePasswordTeacher() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_setting_password, null);
        textInputEditTextDialogChangeTeacherNewPassword = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_new_password_text);
        textInputEditTextDialogChangeTeacherConfirmNewPassword = dialogView.findViewById(R.id.textinput_edittext_dialog_setting_confirm_new_password_text);
        buttonDialogChangeTeacherPasswordApply = dialogView.findViewById(R.id.button_dialog_setting_password_apply);
        buttonDialogChangeTeacherPasswordCancel = dialogView.findViewById(R.id.button_dialog_setting_password_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogChangePassword = dialogBuilder.create();
        dialogChangePassword.show();

        buttonDialogChangeTeacherPasswordCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChangePassword.dismiss();
            }
        });

        buttonDialogChangeTeacherPasswordApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = textInputEditTextDialogChangeTeacherNewPassword.getText().toString();
                String confirmNewPassword = textInputEditTextDialogChangeTeacherConfirmNewPassword.getText().toString();

                if (newPassword.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_password_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!confirmNewPassword.equals(confirmNewPassword)) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_new_password_is_check, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextSettingTeacherPassword.setText(newPassword);
                dialogChangePassword.dismiss();

            }
        });

    }

    private void sendEditTeacher() {
        String name = textInputEditTextSettingTeacherName.getText().toString();
        String family = textInputEditTextSettingTeacherFamily.getText().toString();
        String email = textInputEditTextSettingTeacherEmail.getText().toString();
        String nationalCode = textInputEditTextSettingTeacherNationalCode.getText().toString();
        String password = textInputEditTextSettingTeacherPassword.getText().toString();

        Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), family, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), email, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), nationalCode, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), password, Toast.LENGTH_SHORT).show();

        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new ProfileTeacherFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();

    }

}