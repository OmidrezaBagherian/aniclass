package ir.omidrezabagherian.aniclass;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ProfileStudentFragment extends Fragment {

    private CardView cardViewProfileStudentSearchClass,cardViewProfileStudentMyClasses, cardViewProfileStudentMyHomeWork,cardViewProfileStudentSetting, cardViewProfileStudentExitAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_student, container, false);

        cardViewProfileStudentSearchClass = view.findViewById(R.id.cardview_profile_student_search_class);
        cardViewProfileStudentMyClasses = view.findViewById(R.id.cardview_profile_student_my_classes);
        cardViewProfileStudentMyHomeWork = view.findViewById(R.id.cardview_profile_student_my_homework);
        cardViewProfileStudentSetting = view.findViewById(R.id.cardview_profile_student_setting);
        cardViewProfileStudentExitAccount = view.findViewById(R.id.cardview_profile_student_exit);

        cardViewProfileStudentMyHomeWork.setOnClickListener(v -> myHomeWork());

        return view;
    }

    private void searchClass(){

    }

    private void myClasses(){

    }

    private void myHomeWork(){
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new HomeWorkFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();
    }

    private void setting(){

    }

    private void exitAccount(){

    }

}