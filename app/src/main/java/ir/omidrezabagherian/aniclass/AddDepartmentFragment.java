package ir.omidrezabagherian.aniclass;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import ir.omidrezabagherian.aniclass.Adapters.AdapterMyDepartment;

public class AddDepartmentFragment extends Fragment {

    private RecyclerView recyclerViewMyDepartment;
    private FloatingActionButton floatingActionButtonAddDepartment;
    private AutoCompleteTextView autoCompleteTextViewSelectUniversity;
    private String selectUniversity;
    private TextInputEditText textInputEditTextDialogAddTeacherDepartmentCode;
    private Button buttonDialogAddTeacherDepartmentCodeApply, buttonDialogAddTeacherDepartmentCodeCancel;

    String[] departmentsShow = {
            "عمومی",
            "فنی مهندسی",
            "عمومی",
            "فناوری اطلاعات"
    };

    String[] universitiesShow = {
            "دانشگاه فنی حرفه ای شهید بهشتی کرج",
            "دانشگاه فنی حرفه ای شهدای 17 شهریور کرج",
            "دانشگاه فنی حرفه ای شهدای 17 شهریور کرج",
            "دانشگاه فنی حرفه ای انقلاب اسلامی تهران"
    };

    String[] universities = {
            "دانشگاه فنی حرفه ای شهید بهشتی کرج",
            "دانشگاه فنی حرفه ای شهدای 17 شهریور کرج",
            "دانشگاه فنی حرفه ای شمسی پور تهران",
            "دانشگاه فنی حرفه ای انقلاب اسلامی تهران"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_department, container, false);

        recyclerViewMyDepartment = view.findViewById(R.id.recyclerview_add_department);
        floatingActionButtonAddDepartment = view.findViewById(R.id.floating_actionbutton_add_department);

        AdapterMyDepartment adapterMyDepartment = new AdapterMyDepartment(getActivity(), departmentsShow, universitiesShow);
        recyclerViewMyDepartment.setAdapter(adapterMyDepartment);
        recyclerViewMyDepartment.setLayoutManager(new LinearLayoutManager(getActivity()));

        floatingActionButtonAddDepartment.setOnClickListener(v -> setFloatingActionButtonAddDepartment());

        return view;
    }

    private void setFloatingActionButtonAddDepartment() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_department, null);

        autoCompleteTextViewSelectUniversity = dialogView.findViewById(R.id.auto_complete_dialog_select_university);
        textInputEditTextDialogAddTeacherDepartmentCode = dialogView.findViewById(R.id.textinput_edittext_dialog_add_department_departmentcode_text);
        buttonDialogAddTeacherDepartmentCodeApply = dialogView.findViewById(R.id.button_dialog_add_department_apply);
        buttonDialogAddTeacherDepartmentCodeCancel = dialogView.findViewById(R.id.button_dialog_add_department_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogAddDepartment = dialogBuilder.create();
        dialogAddDepartment.show();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, universities);
        autoCompleteTextViewSelectUniversity.setAdapter(arrayAdapter);

        autoCompleteTextViewSelectUniversity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectUniversity = universities[position];
            }
        });

        buttonDialogAddTeacherDepartmentCodeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAddDepartment.dismiss();
            }
        });

        buttonDialogAddTeacherDepartmentCodeApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String departmentCode=textInputEditTextDialogAddTeacherDepartmentCode.getText().toString();

                if (selectUniversity.equals("دانشگاه فنی حرفه ای شهید بهشتی کرج")){
                    switch (departmentCode){
                        case "100":
                            Toast.makeText(getActivity(), "دپارتمان فناوری اطلاعات اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "200":
                            Toast.makeText(getActivity(), "دپارتمان علوم مهندسی اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "1100":
                            Toast.makeText(getActivity(), "دپارتمان دروس عمومی اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getActivity(), R.string.text_dialog_add_department_is_empty, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                if (selectUniversity.equals("دانشگاه فنی حرفه ای شهدای 17 شهریور کرج")){
                    switch (departmentCode){
                        case "300":
                            Toast.makeText(getActivity(), "دپارتمان معماری اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "700":
                            Toast.makeText(getActivity(), "دپارتمان صنایع دستی اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "1100":
                            Toast.makeText(getActivity(), "دپارتمان دروس عمومی اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getActivity(), R.string.text_dialog_add_department_is_empty, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                if (selectUniversity.equals("دانشگاه فنی حرفه ای شمسی پور تهران")){
                    switch (departmentCode){
                        case "500":
                            Toast.makeText(getActivity(), "دپارتمان هنر و گرافیک اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "800":
                            Toast.makeText(getActivity(), "دپارتمان مد و پوشاک اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "1100":
                            Toast.makeText(getActivity(), "دپارتمان دروس عمومی اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getActivity(), R.string.text_dialog_add_department_is_empty, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                if (selectUniversity.equals("دانشگاه فنی حرفه ای انقلاب اسلامی تهران")){
                    switch (departmentCode){
                        case "200":
                            Toast.makeText(getActivity(), "دپارتمان مالی و مدیریت اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "900":
                            Toast.makeText(getActivity(), "دپارتمان دانش و سلامت اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        case "700":
                            Toast.makeText(getActivity(), "دپارتمان صنایع دستی اطلاعات اضافه شد", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getActivity(), R.string.text_dialog_add_department_is_empty, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

        });

    }


}