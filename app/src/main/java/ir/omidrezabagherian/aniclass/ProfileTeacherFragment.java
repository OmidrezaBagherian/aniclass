package ir.omidrezabagherian.aniclass;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileTeacherFragment extends Fragment {

    private TextView textViewProfileTeacherName, textViewProfileTeacherEmail;
    private CardView cardViewProfileTeacherManagementClass, cardViewProfileTeacherManagementHomework, cardViewProfileTeacherManagementUniversity, cardViewProfileTeacherManagementDepartment, cardViewProfileTeacherSetting, cardViewProfileTeacherExitAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_teacher, container, false);

        textViewProfileTeacherName = view.findViewById(R.id.textview_profile_teacher_name);
        textViewProfileTeacherEmail = view.findViewById(R.id.textview_profile_teacher_email);
        cardViewProfileTeacherManagementClass = view.findViewById(R.id.cardview_profile_teacher_management_class);
        cardViewProfileTeacherManagementHomework = view.findViewById(R.id.cardview_profile_teacher_management_homework);
        cardViewProfileTeacherManagementUniversity = view.findViewById(R.id.cardview_profile_teacher_management_university);
        cardViewProfileTeacherManagementDepartment = view.findViewById(R.id.cardview_profile_teacher_management_department);
        cardViewProfileTeacherSetting = view.findViewById(R.id.cardview_profile_teacher_setting);
        cardViewProfileTeacherExitAccount = view.findViewById(R.id.cardview_profile_teacher_exit);

        textViewProfileTeacherName.setText(R.string.text_profile_teacher_textview_name_and_family);
        textViewProfileTeacherEmail.setText(R.string.text_profile_teacher_textview_email);

        cardViewProfileTeacherManagementClass.setOnClickListener(v -> managementClass());

        cardViewProfileTeacherManagementHomework.setOnClickListener(v -> managementHomework());

        cardViewProfileTeacherManagementUniversity.setOnClickListener(v -> managementUniversity());

        cardViewProfileTeacherManagementDepartment.setOnClickListener(v -> managementDepartment());

        cardViewProfileTeacherSetting.setOnClickListener(v -> setting());

        cardViewProfileTeacherExitAccount.setOnClickListener(v -> exitAccount());

        return view;
    }

    private void managementClass() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new ManagementClassFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit();
    }

    private void managementHomework() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new ManagementHomeworkFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit();
    }

    private void managementUniversity() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new AddUniversityFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit();
    }

    private void managementDepartment() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new AddDepartmentFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit();
    }

    private void setting() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new SettingTeacherFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit();
    }

    private void exitAccount() {
        Intent loginPage = new Intent(getActivity(), LoginActivity.class);
        startActivity(loginPage);
        getActivity().finish();
    }

}