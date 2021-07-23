package com.example.covidvaccination.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidvaccination.R;
import com.example.covidvaccination.model.VaccineModel;

import java.util.List;

public class VaccinationInfoAdapter extends RecyclerView.Adapter<VaccinationInfoAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<VaccineModel> list_vaccine_center;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.vaccination_info_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VaccinationInfoAdapter.ViewHolder holder, int position) {
        holder.vaccinationCenter.setText(list_vaccine_center.get(position).getVaccineCenter());
        holder.vaccinationCenterAdd.setText(list_vaccine_center.get(position).getVaccinationCenterAddress());
        holder.vaccinationTiming.setText(list_vaccine_center.get(position).getVaccinationTimings() + " - " +
        list_vaccine_center.get(position).getVaccineCenterTime());
        holder.vaccineName.setText(list_vaccine_center.get(position).getVaccineName());
        holder.vaccinationAvailable.setText(list_vaccine_center.get(position).getVaccineAvailable());
        holder.vaccinePrice.setText(list_vaccine_center.get(position).getVaccinationCharges());
        holder.vaccinationAge.setText(list_vaccine_center.get(position).getVaccinationAge());




    }

    @Override
    public int getItemCount() {
        return list_vaccine_center.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView vaccinationCenter;
        TextView vaccinationCenterAdd;
        TextView vaccinationTiming;
        TextView vaccineName;
        TextView vaccinePrice;
        TextView vaccinationAge;
        TextView vaccinationAvailable;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            vaccinationAge = itemView.findViewById(R.id.vaccineCenter);
            vaccinationAvailable = itemView.findViewById(R.id.isAvailable);
            vaccinePrice = itemView.findViewById(R.id.vaccinePrice);
            vaccineName = itemView.findViewById(R.id.vaccineName);
            vaccinationTiming = itemView.findViewById(R.id.vaccineTimings);
            vaccinationCenter = itemView.findViewById(R.id.vaccineCenter);
            vaccinationCenterAdd = itemView.findViewById(R.id.vaccineLocation);



        }
    }
}
