package es.unican.appriegospersonales.activities.activos.detail.tabs;

public interface ITabSostenibilidadContract {
    interface View {

    }

    interface Presenter {

        void init();

        int getEcoRating();

        int getDurabilidad();

        int getReparabilidad();

        int getReciclabilidad();

        int getEfClimatica();

        int getEfRecursos();
    }
}