package es.unican.appriegospersonales.activities.controles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import es.unican.appriegospersonales.activities.apps.AppsView;
import es.unican.appriegospersonales.activities.main.MainView;
import es.unican.appriegospersonales.common.MyApplication;
import es.unican.appriegospersonales.common.adapters.RVControlesAdapter;
import es.unican.appriesgospersonales.R;

public class ControlesView extends Fragment implements IControlesContract.View, MainView.RefreshableFragment {
    private IControlesContract.Presenter presenter;
    private RecyclerView controles_rv;

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
        presenter = new ControlesPresenter(this);
        presenter.init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_controles, container, false);
        controles_rv = layout.findViewById(R.id.controles_rv);
        controles_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        controles_rv.setAdapter(new RVControlesAdapter(getContext(), presenter.getControles(), presenter.getPerfilControls()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                controles_rv.getContext(),
                DividerItemDecoration.VERTICAL);
        controles_rv.addItemDecoration(dividerItemDecoration);

        return layout;
    }

    @Override
    public MyApplication getMyApplication() {
        return (MyApplication) requireActivity().getApplication();
    }

    @Override
    public void refreshData() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new ControlesView())
                .commit();
    }
}
