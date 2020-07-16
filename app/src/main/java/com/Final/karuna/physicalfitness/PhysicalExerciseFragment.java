package com.Final.karuna.physicalfitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Final.karuna.CommonModel;
import com.Final.karuna.CommonRecyclerAdapter;
import com.Final.karuna.R;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalAbsExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalBackExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalBicepsExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalChestExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalLegsExercises;

import java.util.ArrayList;
import java.util.List;

public class PhysicalExerciseFragment extends Fragment {

    CardView chest, biceps, abs, back, legs;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PhysicalExerciseFragment(){}

    public static PhysicalExerciseFragment newInstance(String param1, String param2) {
        PhysicalExerciseFragment fragment = new PhysicalExerciseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_physical_exercise, container, false);
        chest = view.findViewById(R.id.op_chest);
        biceps = view.findViewById(R.id.op_biceps);
        abs = view.findViewById(R.id.op_abs);
        back = view.findViewById(R.id.op_back);
        legs = view.findViewById(R.id.op_legs);

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PhysicalChestExercises.class));
            }
        });

        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PhysicalBicepsExercises.class));
            }
        });

        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PhysicalAbsExercises.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PhysicalBackExercises.class));
            }
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PhysicalLegsExercises.class));
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
}
