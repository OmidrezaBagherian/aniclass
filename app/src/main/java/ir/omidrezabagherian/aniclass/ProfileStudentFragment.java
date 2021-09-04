package ir.omidrezabagherian.aniclass;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileStudentFragment extends Fragment {

    private TextView textViewProfileStudentName, textViewProfileStudentEmail;
    private CardView cardViewProfileStudentSearchClass, cardViewProfileStudentMyClasses, cardViewProfileStudentMyHomeWork, cardViewProfileStudentSetting, cardViewProfileStudentExitAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_student, container, false);

        textViewProfileStudentName = view.findViewById(R.id.textview_profile_student_name);
        textViewProfileStudentEmail = view.findViewById(R.id.textview_profile_student_email);
        cardViewProfileStudentSearchClass = view.findViewById(R.id.cardview_profile_student_search_class);
        cardViewProfileStudentMyClasses = view.findViewById(R.id.cardview_profile_student_my_classes);
        cardViewProfileStudentMyHomeWork = view.findViewById(R.id.cardview_profile_student_my_homework);
        cardViewProfileStudentSetting = view.findViewById(R.id.cardview_profile_student_setting);
        cardViewProfileStudentExitAccount = view.findViewById(R.id.cardview_profile_student_exit);

        textViewProfileStudentName.setText(R.string.text_profile_student_textview_name_and_family);
        textViewProfileStudentEmail.setText(R.string.text_profile_student_textview_email);

        cardViewProfileStudentSearchClass.setOnClickListener(v -> searchClass());

        cardViewProfileStudentMyClasses.setOnClickListener(v -> myClasses());

        cardViewProfileStudentMyHomeWork.setOnClickListener(v -> myHomeWork());

        cardViewProfileStudentSetting.setOnClickListener(v -> setting());

        cardViewProfileStudentExitAccount.setOnClickListener(v -> exitAccount());

        return view;
    }

    private void searchClass() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new SearchClassFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();
    }

    private void myClasses() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new MyClassFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();
    }

    private void myHomeWork() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new HomeWorkFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();
    }

    private void setting() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new SettingStudentFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();
    }

    private void exitAccount() {
        Intent loginPage = new Intent(getActivity(), LoginActivity.class);
        startActivity(loginPage);
        getActivity().finish();
    }

}