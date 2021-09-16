package ir.omidrezabagherian.aniclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class EditClassFragment extends Fragment {

    private TextInputEditText textInputEditTextEditClassLessonName, textInputEditTextEditClassUniversityName, textInputEditTextEditClassDepartmentName, textInputEditTextEditClassLink, textInputEditTextEditClassAboutClass, textInputEditTextEditClassPasswordClass, textInputEditTextEditClassConfirmPasswordClass;
    private CheckBox checkBoxEditClassSetPasswordClass;
    private Button buttonEditClassEditClass;
    private boolean setPasswordEditClassIsChecked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_class, container, false);
        textInputEditTextEditClassLessonName = view.findViewById(R.id.textinput_edittext_edit_class_lesson_name);
        textInputEditTextEditClassUniversityName = view.findViewById(R.id.textinput_edittext_edit_class_university_name);
        textInputEditTextEditClassDepartmentName = view.findViewById(R.id.textinput_edittext_edit_class_department_name);
        textInputEditTextEditClassLink = view.findViewById(R.id.textinput_edittext_edit_class_department_link);
        textInputEditTextEditClassAboutClass = view.findViewById(R.id.textinput_edittext_edit_class_about_class);
        textInputEditTextEditClassPasswordClass = view.findViewById(R.id.textinput_edittext_edit_class_password_class);
        textInputEditTextEditClassConfirmPasswordClass = view.findViewById(R.id.textinput_edittext_edit_class_confirm_password_class);
        checkBoxEditClassSetPasswordClass = view.findViewById(R.id.chackbox_edit_class_set_password_class);
        buttonEditClassEditClass = view.findViewById(R.id.button_edit_class_edit_class);

        checkBoxEditClassSetPasswordClass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setPasswordEditClassIsChecked = true;
                    textInputEditTextEditClassPasswordClass.setEnabled(true);
                    textInputEditTextEditClassConfirmPasswordClass.setEnabled(true);
                } else {
                    setPasswordEditClassIsChecked = false;
                    textInputEditTextEditClassPasswordClass.setEnabled(false);
                    textInputEditTextEditClassConfirmPasswordClass.setEnabled(false);
                }

            }
        });

        buttonEditClassEditClass.setOnClickListener(v -> addClass());

        return view;
    }

    private void addClass() {
        String lessonName = textInputEditTextEditClassLessonName.getText().toString();
        String universityName = textInputEditTextEditClassLessonName.getText().toString();
        String departmentName = textInputEditTextEditClassLessonName.getText().toString();
        String aboutClass = textInputEditTextEditClassLessonName.getText().toString();

        if (setPasswordEditClassIsChecked == true) {
            String passwordClass = textInputEditTextEditClassLessonName.getText().toString();
            String confirmPasswordClass = textInputEditTextEditClassLessonName.getText().toString();

            Toast.makeText(getActivity(), "کلاس با رمز", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "کلاس بی رمز", Toast.LENGTH_SHORT).show();

        }
    }
}