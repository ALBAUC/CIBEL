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

import java.util.ArrayList;

import es.unican.appriegospersonales.common.MyApplication;
import es.unican.appriegospersonales.common.adapters.RVRiesgosAdapter;
import es.unican.appriesgospersonales.R;

public class TabRisksView extends Fragment {
    private TabRisksPresenter presenter;
    private RecyclerView risksRV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TabRisksPresenter(this);
        presenter.init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_perfil_controles, container, false);
        risksRV = layout.findViewById(R.id.itemsAplicados_rv);

        risksRV.setLayoutManager(new LinearLayoutManager(getContext()));
        risksRV.setAdapter(new RVRiesgosAdapter(getContext(), new ArrayList<>(presenter.getRiesgosActuales()), presenter.getPerfilControls()));

        DividerItemDecoration dividerA = new DividerItemDecoration(
                risksRV.getContext(),
                DividerItemDecoration.VERTICAL);
        risksRV.addItemDecoration(dividerA);
        return layout;
    }

    public MyApplication getMyApplication() {
        return (MyApplication) requireActivity().getApplication();
    }
}


