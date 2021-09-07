package ir.omidrezabagherian.aniclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.omidrezabagherian.aniclass.Adapters.AdapterManagementSession;
import ir.omidrezabagherian.aniclass.Adapters.AdapterMySession;

public class MySessionFragment extends Fragment {

    private RecyclerView recyclerViewMySession;

    String sessionTitle[] = {
            "سیستم عامل - جلسه اول",
            "سیستم عامل - جلسه دوم"
    };

    String lessonTitle[] = {
            "سیستم عامل",
            "سیستم عامل"
    };

    String lessonCode[] = {
            "122001",
            "122001"
    };

    String departmentTitle[] = {
            "فنی مهندسی",
            "فنی مهندسی"
    };

    String teacherName[] = {
            "استاد ترابی",
            "استاد ترابی"
    };

    String universityName[] = {
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_session, container, false);

        recyclerViewMySession = view.findViewById(R.id.recyclerview_my_session_student);

        AdapterMySession adapterMySession = new AdapterMySession(getActivity(), sessionTitle, lessonTitle, lessonCode, departmentTitle, teacherName, universityName);
        recyclerViewMySession.setAdapter(adapterMySession);
        recyclerViewMySession.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}