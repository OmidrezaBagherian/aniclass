package ir.omidrezabagherian.aniclass;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class FilterSearchFragment extends Fragment {

    public TextInputEditText textInputEditTextFilterClassClassCode, textInputEditTextFilterClassCity, textInputEditTextFilterClassDepartment, textInputEditTextFilterClassUniversity;
    private TextInputEditText textInputEditTextDialogFilterClassClassCode;
    private ImageView imageViewFilterClassClassCode, imageViewFilterClassCity, imageViewFilterClassDepartment, imageViewFilterClassUniversity;
    private Button buttonDialogFilterClassApply, buttonDialogFilterClassCancel;

    private String city[] = {
            "آذربایجان شرقی",
            "آذربایجان شرقی",
            "اردبیل",
            "اصفهان",
            "البرز",
            "ایلام",
            "بوشهر",
            "تهران",
            "چهارمحال و بختیاری",
            "خراسان جنوبی",
            "خراسان رضوی",
            "خراسان شمالی",
            "خوزستان",
            "زنجان",
            "سمنان",
            "سیستان و بلوچستان",
            "فارس",
            "قزوین",
            "قم",
            "کردستان",
            "کرمان",
            "کرمانشاه",
            "کهگیلویه و بویراحمد",
            "گلستان",
            "گیلان",
            "لرستان",
            "مازندران",
            "مرکزی",
            "هرمزگان",
            "همدان",
            "یزد",
            ""
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_search, container, false);

        textInputEditTextFilterClassClassCode = view.findViewById(R.id.textinput_edittext_filter_search_text_class_code);
        textInputEditTextFilterClassCity = view.findViewById(R.id.textinput_edittext_filter_search_text_city);
        textInputEditTextFilterClassDepartment = view.findViewById(R.id.textinput_edittext_filter_search_text_department);
        textInputEditTextFilterClassUniversity = view.findViewById(R.id.textinput_edittext_filter_search_text_university);
        imageViewFilterClassClassCode = view.findViewById(R.id.imageview_filter_search_edit_class_code);
        imageViewFilterClassCity = view.findViewById(R.id.imageview_filter_search_edit_city);
        imageViewFilterClassDepartment = view.findViewById(R.id.imageview_filter_search_edit_department);
        imageViewFilterClassUniversity = view.findViewById(R.id.imageview_filter_search_edit_university);

        imageViewFilterClassClassCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClassCode();
            }
        });
        imageViewFilterClassCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCity();
            }
        });
        imageViewFilterClassDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDepartment();
            }
        });
        imageViewFilterClassUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogUniversity();
            }
        });

        return view;
    }

    private void dialogClassCode() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_filter_search_class_code, null);
        textInputEditTextDialogFilterClassClassCode = dialogView.findViewById(R.id.textinput_edittext_dialog_filter_search_class_code_text);
        buttonDialogFilterClassApply = dialogView.findViewById(R.id.button_dialog_filter_search_student_apply);
        buttonDialogFilterClassCancel = dialogView.findViewById(R.id.button_dialog_filter_search_student_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogFilterClass = dialogBuilder.create();
        dialogFilterClass.show();

        buttonDialogFilterClassCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFilterClass.dismiss();
            }
        });

        buttonDialogFilterClassApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String classCode = textInputEditTextDialogFilterClassClassCode.getText().toString();

                if (classCode.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_filter_search_student_class_code_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputEditTextFilterClassClassCode.setText(classCode);
                dialogFilterClass.dismiss();

            }
        });

    }

    private void dialogCity() {

    }

    private void dialogDepartment() {

    }

    private void dialogUniversity() {

    }
}