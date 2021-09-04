package ir.omidrezabagherian.aniclass;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import ir.omidrezabagherian.aniclass.Adapters.AdapterMyUniversity;

public class AddUniversityFragment extends Fragment {

    private RecyclerView recyclerViewMyUniversity;
    private FloatingActionButton floatingActionButtonAddUniversity;
    private TextInputEditText textInputEditTextDialogAddTeacherUniversityCode;
    private Button buttonDialogChangeTeacherUniversityCodeApply, buttonDialogChangeTeacherUniversityCodeCancel;
    String[] universities = {
            "دانشگاه فنی حرفه ای شهید بهشتی کرج",
            "دانشگاه فنی حرفه ای شهدای 17 شهریور کرج",
            "دانشگاه فنی حرفه ای شمسی پور تهران",
            "دانشگاه فنی حرفه ای انقلاب اسلامی تهران"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_university, container, false);

        recyclerViewMyUniversity = view.findViewById(R.id.recyclerview_add_university);
        floatingActionButtonAddUniversity = view.findViewById(R.id.floating_actionbutton_add_university);

        AdapterMyUniversity adapterMyUniversity = new AdapterMyUniversity(getActivity(), universities);
        recyclerViewMyUniversity.setAdapter(adapterMyUniversity);
        recyclerViewMyUniversity.setLayoutManager(new LinearLayoutManager(getActivity()));

        floatingActionButtonAddUniversity.setOnClickListener(v -> addUniversity());

        return view;
    }

    private void addUniversity() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_university, null);
        textInputEditTextDialogAddTeacherUniversityCode = dialogView.findViewById(R.id.textinput_edittext_dialog_add_university_text);
        buttonDialogChangeTeacherUniversityCodeApply = dialogView.findViewById(R.id.button_dialog_add_university_apply);
        buttonDialogChangeTeacherUniversityCodeCancel = dialogView.findViewById(R.id.button_dialog_add_university_cancel);

        dialogBuilder.setView(dialogView);
        AlertDialog dialogAddUniversity = dialogBuilder.create();
        dialogAddUniversity.show();

        buttonDialogChangeTeacherUniversityCodeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAddUniversity.dismiss();
            }
        });

        buttonDialogChangeTeacherUniversityCodeApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nationalCode = textInputEditTextDialogAddTeacherUniversityCode.getText().toString();

                if (nationalCode.equals("")) {
                    Toast.makeText(getActivity(), R.string.text_toast_setting_nationalcode_is_empty, Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(getActivity(), "اضافه شد", Toast.LENGTH_SHORT).show();
                dialogAddUniversity.dismiss();

            }
        });
    }
}