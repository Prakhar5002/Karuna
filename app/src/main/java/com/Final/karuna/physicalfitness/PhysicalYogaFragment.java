package com.Final.karuna.physicalfitness;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Final.karuna.CommonModel;
import com.Final.karuna.CommonRecyclerAdapter;
import com.Final.karuna.R;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalAbsExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalBackExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalBicepsExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalChestExercises;
import com.Final.karuna.physicalfitness.physicalexercises.PhysicalLegsExercises;
import com.Final.karuna.physicalfitness.yoga.Pranayam;
import com.Final.karuna.physicalfitness.yoga.YogaBeginner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhysicalYogaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhysicalYogaFragment extends Fragment {

    CardView beginner, advanced, pranayam, patanjali, precautions;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PhysicalYogaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhysicalYogaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhysicalYogaFragment newInstance(String param1, String param2) {
        PhysicalYogaFragment fragment = new PhysicalYogaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_physical_yoga, container, false);
        beginner = view.findViewById(R.id.op_beginner);
        advanced = view.findViewById(R.id.op_advanced);
        pranayam = view.findViewById(R.id.op_pranayam);
        patanjali = view.findViewById(R.id.op_patanjali_ashtang_yog);
        precautions = view.findViewById(R.id.op_precautions);

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), YogaBeginner.class));
            }
        });

        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), YogaBeginner.class));
            }
        });

        pranayam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Pranayam.class));
            }
        });

        patanjali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), YogaBeginner.class));
            }
        });

        precautions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), YogaBeginner.class));
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