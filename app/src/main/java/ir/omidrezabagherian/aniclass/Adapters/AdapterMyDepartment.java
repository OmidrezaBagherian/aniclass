package ir.omidrezabagherian.aniclass.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ir.omidrezabagherian.aniclass.R;

public class AdapterMyDepartment extends RecyclerView.Adapter<AdapterMyDepartment.MyViewHolder> {

    private Context context;
    private String departmentName[], universityName[];

    public AdapterMyDepartment(Context context, String departmentName[], String universityName[]) {
        this.context = context;
        this.departmentName = departmentName;
        this.universityName = universityName;
    }

    @NonNull
    @Override
    public AdapterMyDepartment.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_my_department_teacher, parent, false);

        return new AdapterMyDepartment.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMyDepartment.MyViewHolder holder, int position) {
        holder.textViewDepartmentName.setText(departmentName[position]);
        holder.textViewUniversityName.setText(universityName[position]);

        holder.imageViewDepartmentDelete.setOnClickListener(v -> deleteDepartment());
    }

    private void deleteDepartment(){
        Toast.makeText(context, "حذف شد", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return departmentName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewDepartmentName;
        private TextView textViewUniversityName;
        private ImageView imageViewDepartmentDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDepartmentName = itemView.findViewById(R.id.department_teacher_name);
            textViewUniversityName = itemView.findViewById(R.id.department_teacher_university_name);
            imageViewDepartmentDelete = itemView.findViewById(R.id.department_teacher_delete);

        }
    }
}
