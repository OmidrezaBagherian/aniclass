package ir.omidrezabagherian.aniclass.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import ir.omidrezabagherian.aniclass.R;

public class AdapterManagementClass extends RecyclerView.Adapter<AdapterManagementClass.MyViewHolder> {

    private Context context;
    private String lessonTitle[], lessonCode[], departmentTitle[], teacherName[], universityName[], aboutClass[];

    public AdapterManagementClass(Context context, String[] lessonTitle, String[] lessonCode, String[] departmentTitle, String[] teacherName, String[] universityName, String[] aboutClass) {
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
        View view = inflater.inflate(R.layout.cardview_management_class_student, parent, false);

        return new AdapterManagementClass.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewLessonTitle.setText(lessonTitle[position]);
        holder.textViewLessonCode.setText(lessonCode[position]);
        holder.textViewLessonDepartmentTitle.setText(departmentTitle[position]);
        holder.textViewLessonTeacherName.setText(teacherName[position]);
        holder.textViewLessonUniversityName.setText(universityName[position]);
        holder.textViewLessonAboutClass.setText(aboutClass[position]);

        holder.buttonEditClassTeacher.setOnClickListener(v -> editClass());
        holder.buttonDeleteClassTeacher.setOnClickListener(v -> deleteClass());
        holder.buttonManagementSessionTeacher.setOnClickListener(v -> managementSession());

    }

    private void editClass() {
        Toast.makeText(context, "ویرایش", Toast.LENGTH_SHORT).show();
        /* FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new EditClassFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit(); */
    }

    private void deleteClass() {
        Toast.makeText(context, "حذف شد", Toast.LENGTH_SHORT).show();
    }

    private void managementSession() {
        Toast.makeText(context, "مدیریت جلسات", Toast.LENGTH_SHORT).show();
        /* FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        Fragment fragment = new EditClassFragment();
        fragmentTransaction.replace(R.id.framelayout_teacher, fragment);
        fragmentTransaction.commit(); */
    }

    @Override
    public int getItemCount() {
        return lessonTitle.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewLessonTitle, textViewLessonCode, textViewLessonDepartmentTitle, textViewLessonTeacherName, textViewLessonUniversityName, textViewLessonAboutClass;
        private Button buttonManagementSessionTeacher, buttonEditClassTeacher,buttonDeleteClassTeacher;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewLessonTitle = itemView.findViewById(R.id.management_class_lesson_title);
            textViewLessonCode = itemView.findViewById(R.id.management_class_lesson_code);
            textViewLessonDepartmentTitle = itemView.findViewById(R.id.management_class_name_department);
            textViewLessonTeacherName = itemView.findViewById(R.id.management_class_name_teacher);
            textViewLessonUniversityName = itemView.findViewById(R.id.management_class_name_university);
            textViewLessonAboutClass = itemView.findViewById(R.id.management_class_about_class);
            buttonEditClassTeacher = itemView.findViewById(R.id.management_class_edit_class);
            buttonDeleteClassTeacher = itemView.findViewById(R.id.management_class_delete_class);
            buttonManagementSessionTeacher = itemView.findViewById(R.id.management_class_management_session);

        }
    }
}
