package ir.omidrezabagherian.aniclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ir.omidrezabagherian.aniclass.Adapters.AdapterManagementClass;

public class ManagementClassFragment extends Fragment {

    private RecyclerView recyclerViewManagementClass;
    private FloatingActionButton floatingActionButtonManagementClass;

    String lessonTitle[] = {
            "سیستم عامل"
    };

    String lessonCode[] = {
            "122001"
    };

    String departmentTitle[] = {
            "فنی مهندسی"
    };

    String teacherName[] = {
            "استاد ترابی"
    };

    String universityName[] = {
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه"
    };

    String aboutClass[] = {
            "سیستم عامل با استاد ترابی"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_management_class, container, false);

        recyclerViewManagementClass = view.findViewById(R.id.recyclerview_management_class_teacher);
        floatingActionButtonManagementClass = view.findViewById(R.id.floating_actionbutton_management_class_teacher);

        AdapterManagementClass adapterManagementClass = new AdapterManagementClass(getActivity(), lessonTitle, lessonCode, departmentTitle, teacherName, universityName, aboutClass);
        recyclerViewManagementClass.setAdapter(adapterManagementClass);
        recyclerViewManagementClass.setLayoutManager(new LinearLayoutManager(getActivity()));

        floatingActionButtonManagementClass.setOnClickListener(v -> addClass());

        return view;
    }

    private void addClass(){
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new AddClassFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit();
    }

}