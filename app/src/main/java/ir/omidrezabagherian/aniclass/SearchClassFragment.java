package ir.omidrezabagherian.aniclass;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SearchClassFragment extends Fragment {

    private TextInputEditText textInputEditTextSearchClassTextSearch;
    private ImageView imageViewSearchClassStartSearch, imageViewSearchClassFilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_class, container, false);

        textInputEditTextSearchClassTextSearch = view.findViewById(R.id.textinput_edittext_search_class_text_search);
        imageViewSearchClassFilter = view.findViewById(R.id.imageview_search_class_filter);
        imageViewSearchClassStartSearch = view.findViewById(R.id.imageview_search_class_start_search);

        imageViewSearchClassFilter.setOnClickListener(v -> filter());

        imageViewSearchClassStartSearch.setOnClickListener(v -> startSearch());

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