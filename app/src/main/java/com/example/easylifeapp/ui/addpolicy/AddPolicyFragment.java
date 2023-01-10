package com.example.easylifeapp.ui.addpolicy;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easylifeapp.R;
import com.example.easylifeapp.databinding.FragmentAddPolicyBinding;

public class AddPolicyFragment extends Fragment {

    private FragmentAddPolicyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AddPolicyViewModel categoryViewModel =
                new ViewModelProvider(this).get(AddPolicyViewModel.class);

        binding = FragmentAddPolicyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}