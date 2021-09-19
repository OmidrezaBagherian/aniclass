package ir.omidrezabagherian.aniclass.view;

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

import ir.omidrezabagherian.aniclass.R;

public class AddClassFragment extends Fragment {

    private TextInputEditText textInputEditTextAddClassLessonName, textInputEditTextAddClassUniversityName, textInputEditTextAddClassDepartmentName, textInputEditTextAddClassLink, textInputEditTextAddClassAboutClass, textInputEditTextAddClassPasswordClass, textInputEditTextAddClassConfirmPasswordClass;
    private CheckBox checkBoxAddClassSetPasswordClass;
    private Button buttonAddClassAddClass;
    private boolean setPasswordAddClassIsChecked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_class, container, false);

        textInputEditTextAddClassLessonName = view.findViewById(R.id.textinput_edittext_add_class_lesson_name);
        textInputEditTextAddClassUniversityName = view.findViewById(R.id.textinput_edittext_add_class_university_name);
        textInputEditTextAddClassDepartmentName = view.findViewById(R.id.textinput_edittext_add_class_department_name);
        textInputEditTextAddClassLink = view.findViewById(R.id.textinput_edittext_add_class_department_link);
        textInputEditTextAddClassAboutClass = view.findViewById(R.id.textinput_edittext_add_class_about_class);
        textInputEditTextAddClassPasswordClass = view.findViewById(R.id.textinput_edittext_add_class_password_class);
        textInputEditTextAddClassConfirmPasswordClass = view.findViewById(R.id.textinput_edittext_add_class_confirm_password_class);
        checkBoxAddClassSetPasswordClass = view.findViewById(R.id.chackbox_add_class_set_password_class);
        buttonAddClassAddClass = view.findViewById(R.id.button_add_class_add_class);

        checkBoxAddClassSetPasswordClass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setPasswordAddClassIsChecked = true;
                    textInputEditTextAddClassPasswordClass.setEnabled(true);
                    textInputEditTextAddClassConfirmPasswordClass.setEnabled(true);
                } else {
                    setPasswordAddClassIsChecked = false;
                    textInputEditTextAddClassPasswordClass.setEnabled(false);
                    textInputEditTextAddClassConfirmPasswordClass.setEnabled(false);
                }

            }
        });

        buttonAddClassAddClass.setOnClickListener(v -> addClass());

        return view;
    }

    private void addClass() {
        String lessonName = textInputEditTextAddClassLessonName.getText().toString();
        String universityName = textInputEditTextAddClassLessonName.getText().toString();
        String departmentName = textInputEditTextAddClassLessonName.getText().toString();
        String aboutClass = textInputEditTextAddClassLessonName.getText().toString();

        if (setPasswordAddClassIsChecked == true) {
            String passwordClass = textInputEditTextAddClassLessonName.getText().toString();
            String confirmPasswordClass = textInputEditTextAddClassLessonName.getText().toString();

            Toast.makeText(getActivity(), "کلاس با رمز", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "کلاس بی رمز", Toast.LENGTH_SHORT).show();

        }
    }

}