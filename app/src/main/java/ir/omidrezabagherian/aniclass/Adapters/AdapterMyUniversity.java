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

public class AdapterMyUniversity extends RecyclerView.Adapter<AdapterMyUniversity.MyViewHolder> {

    private Context context;
    private String universityName[];

    public AdapterMyUniversity(Context context, String[] universityName){
        this.context = context;
        this.universityName = universityName;
    }

    @NonNull
    @Override
    public AdapterMyUniversity.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_my_university_teacher, parent, false);

        return new AdapterMyUniversity.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMyUniversity.MyViewHolder holder, int position) {
        holder.textViewUniversityName.setText(universityName[position]);

        holder.imageViewUniversityDelete.setOnClickListener(v -> deleteUniversity());
    }

    private void deleteUniversity(){
        Toast.makeText(context, "حذف شد", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return universityName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewUniversityName;
        private ImageView imageViewUniversityDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewUniversityName = itemView.findViewById(R.id.university_teacher_name);
            imageViewUniversityDelete = itemView.findViewById(R.id.university_teacher_delete);

        }
    }
}
