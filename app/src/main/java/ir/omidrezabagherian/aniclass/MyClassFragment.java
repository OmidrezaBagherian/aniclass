package ir.omidrezabagherian.aniclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.omidrezabagherian.aniclass.Adapters.AdapterMyClass;

public class MyClassFragment extends Fragment {

    private RecyclerView recyclerViewMyClass;

    String lessonTitle[] = {
            "سیستم عامل",
            "پایگاه داده",
            "زبان فنی",
            "زبان انگلیسی"
    };

    String lessonCode[] = {
            "122001",
            "122352",
            "122523",
            "982452"
    };

    String departmentTitle[] = {
            "فنی مهندسی",
            "فنی مهندسی",
            "فنی مهندسی",
            "عمومی"
    };

    String teacherName[] = {
            "استاد ترابی",
            "استاد ایمانی",
            "استاد حسنی",
            "استاد جمالی"
    };

    String universityName[] = {
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - دخترانه"
    };

    String aboutClass[] = {
            "سیستم عامل با استاد ترابی",
            "پایگاه داده با استاد ایمانی",
            "زبان فنی با استاد حسنی",
            "زبان انگلیسی با استاد جمالی"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_class, container, false);

        recyclerViewMyClass = view.findViewById(R.id.recyclerview_my_class_student);

        AdapterMyClass adapterMyClass = new AdapterMyClass(getActivity(), lessonTitle, lessonCode, departmentTitle, teacherName, universityName, aboutClass);
        recyclerViewMyClass.setAdapter(adapterMyClass);
        recyclerViewMyClass.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}