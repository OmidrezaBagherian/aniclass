package ir.omidrezabagherian.aniclass.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.api.PersianPickerDate;
import ir.hamsaa.persiandatepicker.api.PersianPickerListener;
import ir.hamsaa.persiandatepicker.util.PersianCalendarUtils;
import ir.omidrezabagherian.aniclass.R;

public class EditSessionFragment extends Fragment {

    private TextInputEditText textInputEditTextEditSessionName, textInputEditTextEditSessionDate;
    private ImageView imageViewAddSessionSetDate;
    private PersianDatePickerDialog persianCalendarEditSession;
    private static final String TAG = "TeacherActivity";
    private AutoCompleteTextView autoCompleteTextViewSelectTime;
    private Button buttonEditSessionApply;

    private String sessionName, sessionDate, sessionTime;

    private String times[] = {
            "07:00",
            "08:00",
            "09:00",
            "10:00",
            "11:00",
            "12:00",
            "13:00",
            "11:00",
            "12:00",
            "13:00",
            "14:00",
            "15:00",
            "16:00",
            "17:00",
            "18:00",
            "19:00",
            "20:00",
            "21:00"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_session, container, false);

        textInputEditTextEditSessionName = view.findViewById(R.id.textinput_edittext_dialog_edit_session_session_name_text);
        textInputEditTextEditSessionDate = view.findViewById(R.id.textinput_edittext_dialog_edit_session_session_date_text);
        imageViewAddSessionSetDate = view.findViewById(R.id.imageview_edit_session_set_date);
        autoCompleteTextViewSelectTime = view.findViewById(R.id.auto_complete_edit_session_select_time);
        buttonEditSessionApply = view.findViewById(R.id.button_edit_session_apply);

        imageViewAddSessionSetDate.setOnClickListener(v -> editDate());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, times);
        autoCompleteTextViewSelectTime.setAdapter(arrayAdapter);

        sessionName = textInputEditTextEditSessionName.getText().toString();

        autoCompleteTextViewSelectTime.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sessionTime = times[position];
            }
        });

        buttonEditSessionApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), sessionName + " - " + sessionDate + " - " + sessionTime, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void editDate() {
        persianCalendarEditSession = new PersianDatePickerDialog(getActivity())
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1400)
                .setAllButtonsTextSize(12)
                .setMaxYear(1410)
                .setInitDate(1400, 7, 1)
                .setActionTextColor(Color.GRAY)
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)
                .setListener(new PersianPickerListener() {
                    @Override
                    public void onDateSelected(PersianPickerDate persianPickerDate) {
                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getTimestamp());//675930448000
                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getGregorianDate());//Mon Jun 03 10:57:28 GMT+04:30 1991
                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getPersianLongDate());// دوشنبه  13  خرداد  1370
                        Log.d(TAG, "onDateSelected: " + persianPickerDate.getPersianMonthName());//خرداد
                        Log.d(TAG, "onDateSelected: " + PersianCalendarUtils.isPersianLeapYear(persianPickerDate.getPersianYear()));//true
                        textInputEditTextEditSessionDate.setText(persianPickerDate.getPersianYear() + "/" + persianPickerDate.getPersianMonth() + "/" + persianPickerDate.getPersianDay());
                        sessionDate = persianPickerDate.getPersianYear() + "/" + persianPickerDate.getPersianMonth() + "/" + persianPickerDate.getPersianDay();
                    }

                    @Override
                    public void onDismissed() {
                        Toast.makeText(getActivity(), "Dismissed", Toast.LENGTH_SHORT).show();
                    }
                });

        persianCalendarEditSession.show();
    }
}