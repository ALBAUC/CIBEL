package es.unican.appriegospersonales.activities.apps.tipo;

import es.unican.appriegospersonales.common.MyApplication;
import es.unican.appriegospersonales.model.Activo;
import java.util.List;

public interface ICatalogoTipoContract {
    interface View {
        MyApplication getMyApplication();
    }

    interface Presenter {

        void init();

        String getTipoName();

        List<Activo> getActivosDeTipo();

        List<Activo> getActivosTipoOrdenadosPorSeguridadDesc();

        List<Activo> getActivosTipoOrdenadosPorSostAsc();

        List<Activo> getActivosTipoOrdenadosPorSostDesc();

        List<Activo> getActivosTipoOrdenadosPorSeguridadAsc();

        List<Activo> getActivosPerfil();

        Activo getAssetByName(String appName);
    }
}
