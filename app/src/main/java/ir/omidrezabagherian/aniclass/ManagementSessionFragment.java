package ir.omidrezabagherian.aniclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.omidrezabagherian.aniclass.Adapters.AdapterManagementClass;
import ir.omidrezabagherian.aniclass.Adapters.AdapterManagementSession;

public class ManagementSessionFragment extends Fragment {

    private RecyclerView recyclerViewManagementSession;

    String sessionTitle[] = {
            "سیستم عامل - جلسه اول"
    };

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_management_session, container, false);
        recyclerViewManagementSession = view.findViewById(R.id.recyclerview_management_session_student);

        AdapterManagementSession adapterManagementSession = new AdapterManagementSession(getActivity(), sessionTitle, lessonTitle, lessonCode, departmentTitle, teacherName, universityName);
        recyclerViewManagementSession.setAdapter(adapterManagementSession);
        recyclerViewManagementSession.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}