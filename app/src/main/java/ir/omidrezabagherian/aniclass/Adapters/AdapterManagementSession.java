package ir.omidrezabagherian.aniclass.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ir.omidrezabagherian.aniclass.R;

public class AdapterManagementSession extends RecyclerView.Adapter<AdapterManagementSession.MyViewHolder> {

    private Context context;
    private String sessionTitle[],lessonTitle[], lessonCode[], departmentTitle[], teacherName[], universityName[];

    public AdapterManagementSession(Context context, String[] sessionTitle, String[] lessonTitle, String[] lessonCode, String[] departmentTitle, String[] teacherName, String[] universityName) {
        this.context = context;
        this.lessonTitle = lessonTitle;
        this.sessionTitle = sessionTitle;
        this.lessonCode = lessonCode;
        this.departmentTitle = departmentTitle;
        this.teacherName = teacherName;
        this.universityName = universityName;
    }

    @NonNull
    @Override
    public AdapterManagementSession.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_management_session_teacher, parent, false);

        return new AdapterManagementSession.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterManagementSession.MyViewHolder holder, int position) {
        holder.textViewSessionTitle.setText(sessionTitle[position]);
        holder.textViewLessonTitle.setText(lessonTitle[position]);
        holder.textViewLessonCode.setText(lessonCode[position]);
        holder.textViewLessonDepartmentTitle.setText(departmentTitle[position]);
        holder.textViewLessonTeacherName.setText(teacherName[position]);
        holder.textViewLessonUniversityName.setText(universityName[position]);

        holder.buttonEditSessionTeacher.setOnClickListener(v -> editSession());
        holder.buttonRemoveSessionTeacher.setOnClickListener(v -> removeSession());

    }

    private void editSession() {
        Toast.makeText(context, "ویرایش", Toast.LENGTH_SHORT).show();
    }

    private void removeSession() {
        Toast.makeText(context, "حذف شد", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return sessionTitle.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewSessionTitle, textViewLessonTitle, textViewLessonCode, textViewLessonDepartmentTitle, textViewLessonTeacherName, textViewLessonUniversityName;
        private Button buttonEditSessionTeacher, buttonRemoveSessionTeacher;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSessionTitle = itemView.findViewById(R.id.management_class_name_session);
            textViewLessonTitle  = itemView.findViewById(R.id.management_class_lesson_title);
            textViewLessonCode  = itemView.findViewById(R.id.management_class_lesson_code);
            textViewLessonDepartmentTitle = itemView.findViewById(R.id.management_class_name_department);
            textViewLessonTeacherName = itemView.findViewById(R.id.management_class_name_teacher);
            textViewLessonUniversityName = itemView.findViewById(R.id.management_class_name_university);
            buttonEditSessionTeacher = itemView.findViewById(R.id.management_class_edit_session);
            buttonRemoveSessionTeacher = itemView.findViewById(R.id.management_class_remove_session);

        }
    }
}
