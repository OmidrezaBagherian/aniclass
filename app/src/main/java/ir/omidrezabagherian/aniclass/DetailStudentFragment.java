package ir.omidrezabagherian.aniclass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ir.omidrezabagherian.aniclass.R;

public class DetailStudentFragment extends Fragment {

    private TextView textViewDetailStudentLessonTitle, textViewDetailStudentLessonCode, textViewDetailStudentDepartmentName, textViewDetailStudentTeacherName, textViewDetailStudentUniversityName, textViewDetailStudentAboutClass;
    private Button buttonDetailStudentShowSession;

    String lessonTitle = "سیستم عامل";
    String lessonCode = "122001";
    String departmentTitle = "فنی مهندسی";
    String teacherName = "استاد ترابی";
    String universityName = "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه";
    String aboutClass = "سیستم عامل با استاد ترابی";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_student, container, false);

        textViewDetailStudentLessonTitle = view.findViewById(R.id.detail_student_lesson_title);
        textViewDetailStudentLessonCode = view.findViewById(R.id.detail_student_lesson_code);
        textViewDetailStudentDepartmentName = view.findViewById(R.id.detail_student_name_department);
        textViewDetailStudentTeacherName = view.findViewById(R.id.detail_student_name_teacher);
        textViewDetailStudentUniversityName = view.findViewById(R.id.detail_student_name_university);
        textViewDetailStudentAboutClass = view.findViewById(R.id.detail_student_about_class);
        buttonDetailStudentShowSession = view.findViewById(R.id.search_class_show_session);

        textViewDetailStudentLessonTitle.setText(lessonTitle);
        textViewDetailStudentLessonCode.setText(lessonCode);
        textViewDetailStudentDepartmentName.setText(departmentTitle);
        textViewDetailStudentTeacherName.setText(teacherName);
        textViewDetailStudentUniversityName.setText(universityName);
        textViewDetailStudentAboutClass.setText(aboutClass);

        buttonDetailStudentShowSession.setOnClickListener(v -> showSession());

        return view;
    }

    private void showSession() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new DetailStudentFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();
    }

}