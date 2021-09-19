package ir.omidrezabagherian.aniclass.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import ir.omidrezabagherian.aniclass.Adapters.AdapterSearchClass;
import ir.omidrezabagherian.aniclass.R;

public class SearchClassFragment extends Fragment {

    private TextInputEditText textInputEditTextSearchClassTextSearch;
    private ImageView imageViewSearchClassStartSearch, imageViewSearchClassFilter;
    private RecyclerView recyclerViewSearchClass;

    String lessonTitle[] = {
            "سیستم عامل",
            "پایگاه داده",
            "زبان فنی",
            "زبان انگلیسی",
            "زبان فارسی"
    };

    String lessonCode[] = {
            "122001",
            "122352",
            "122523",
            "982452",
            "562515"
    };

    String departmentTitle[] = {
            "فنی مهندسی",
            "فنی مهندسی",
            "فنی مهندسی",
            "عمومی",
            "عمومی"
    };

    String teacherName[] = {
            "استاد ترابی",
            "استاد ایمانی",
            "استاد حسنی",
            "استاد جمالی",
            "استاد اسفندیاری"
    };

    String universityName[] = {
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - پسرانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - دخترانه",
            "دانشگاه فنی حرفه ای دخترانه کرج - دخترانه"
    };

    String aboutClass[] = {
            "سیستم عامل با استاد ترابی",
            "پایگاه داده با استاد ایمانی",
            "زبان فنی با استاد حسنی",
            "زبان انگلیسی با استاد جمالی",
            "زبان فارسی با استاد اسفندیاری"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_class, container, false);

        textInputEditTextSearchClassTextSearch = view.findViewById(R.id.textinput_edittext_search_class_text_search);
        imageViewSearchClassFilter = view.findViewById(R.id.imageview_search_class_filter);
        imageViewSearchClassStartSearch = view.findViewById(R.id.imageview_search_class_start_search);

        imageViewSearchClassFilter.setOnClickListener(v -> filter());

        imageViewSearchClassStartSearch.setOnClickListener(v -> startSearch());

        recyclerViewSearchClass = view.findViewById(R.id.recyclerview_search_class);

        AdapterSearchClass adapterSearchClass = new AdapterSearchClass(getActivity(),lessonTitle,lessonCode,departmentTitle,teacherName,universityName,aboutClass);
        recyclerViewSearchClass.setAdapter(adapterSearchClass);
        recyclerViewSearchClass.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    private void filter() {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new FilterSearchFragment();
        fragmentTransaction.replace(R.id.framelayout_student, fragment);
        fragmentTransaction.commit();
    }

    private void startSearch() {
        String textSearch = textInputEditTextSearchClassTextSearch.getText().toString();

        if (textSearch.equals("")) {
            Toast.makeText(getActivity(), "عبارتی برای جستجو وارد نشده است", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "عبارت جستجو شد", Toast.LENGTH_SHORT).show();
        }
    }

}