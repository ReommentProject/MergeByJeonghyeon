package com.example.recyclerviewinsidefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class recyclerviewFragment extends Fragment {


    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
    Api api = RetrofitClient.getMyApi();
    Call<List<Content>> call = RetrofitClient.getInstance().getMyApi().getMainContent();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        RecyclerView recyclerView;//
        recyclerView = view.findViewById(R.id.recyclerView);//
        recyclerView.setLayoutManager(linearLayoutManager);//

        call.enqueue(new Callback<List<Content>>() {
            @Override
            public void onResponse(Call<List<Content>> call, Response<List<Content>> response) {
                List<Content> contentList = response.body();
                HelperAdapter helperAdapter = new HelperAdapter(getContext(), contentList);
                recyclerView.setAdapter(helperAdapter);
            }
            @Override
            public void onFailure(Call<List<Content>> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured in get", Toast.LENGTH_LONG).show();
            }

        });
        return view;
    }
}