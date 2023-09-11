package es.unican.appriegospersonales.activities.perfil.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.unican.appriegospersonales.common.MyApplication;
import es.unican.appriegospersonales.common.adapters.RVAppsPerfilAdapter;
import es.unican.appriegospersonales.model.Aplicacion;
import es.unican.appriesgospersonales.R;

public class TabAppsView extends Fragment {
    private TabAppsPresenter presenter;
    private RecyclerView apps_rv;
    private RVAppsPerfilAdapter appsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TabAppsPresenter(this);
        presenter.init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_perfil_apps, container, false);
        apps_rv = layout.findViewById(R.id.appsUsadas_rv);

        apps_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        appsAdapter = new RVAppsPerfilAdapter(getContext(), presenter.getAppsAnhadidas());
        apps_rv.setAdapter(appsAdapter);

        DividerItemDecoration dividerA = new DividerItemDecoration(
                apps_rv.getContext(),
                DividerItemDecoration.VERTICAL);
        apps_rv.addItemDecoration(dividerA);
        return layout;
    }

    public void updateAppList(List<Aplicacion> appsAnhadidas) {
        appsAdapter.updateAppList(appsAnhadidas);
    }

    public MyApplication getMyApplication() {
        return (MyApplication) requireActivity().getApplication();
    }
}


