package ir.omidrezabagherian.aniclass.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import ir.omidrezabagherian.aniclass.FilterSearchFragment;
import ir.omidrezabagherian.aniclass.R;

public class AdapterSearchClass extends RecyclerView.Adapter<AdapterSearchClass.MyViewHolder> {

    private Context context;
    private String lessonTitle[], lessonCode[], departmentTitle[], teacherName[], universityName[], aboutClass[];

    public AdapterSearchClass(Context context, String[] lessonTitle, String[] lessonCode, String[] departmentTitle, String[] teacherName, String[] universityName, String[] aboutClass) {
        this.context = context;
        this.lessonTitle = lessonTitle;
        this.lessonCode = lessonCode;
        this.departmentTitle = departmentTitle;
        this.teacherName = teacherName;
        this.universityName = universityName;
        this.aboutClass = aboutClass;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_search_class_student, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewLessonTitle.setText(lessonTitle[position]);
        holder.textViewLessonCode.setText(lessonCode[position]);
        holder.textViewLessonDepartmentTitle.setText(departmentTitle[position]);
        holder.textViewLessonTeacherName.setText(teacherName[position]);
        holder.textViewLessonUniversityName.setText(universityName[position]);

        holder.buttonGoDetailStudent.setOnClickListener(v -> goDetail());

        holder.buttonAddClassStudent.setOnClickListener(v -> addClass());

    }

    @Override
    public int getItemCount() {
        return lessonTitle.length;
    }

    private void goDetail() {
        Toast.makeText(context, "وارد شد", Toast.LENGTH_SHORT).show();
    }

    private void addClass() {
        Toast.makeText(context, "اضافه شد", Toast.LENGTH_SHORT).show();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewLessonTitle, textViewLessonCode, textViewLessonDepartmentTitle, textViewLessonTeacherName, textViewLessonUniversityName, textViewLessonAboutClass;
        private Button buttonGoDetailStudent, buttonAddClassStudent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewLessonTitle = itemView.findViewById(R.id.search_class_lesson_title);
            textViewLessonCode = itemView.findViewById(R.id.search_class_lesson_code);
            textViewLessonDepartmentTitle = itemView.findViewById(R.id.search_class_name_department);
            textViewLessonTeacherName = itemView.findViewById(R.id.search_class_name_teacher);
            textViewLessonUniversityName = itemView.findViewById(R.id.search_class_name_university);

            buttonGoDetailStudent = itemView.findViewById(R.id.search_class_show_detail);
            buttonAddClassStudent = itemView.findViewById(R.id.search_class_add_class);

        }
    }
}
