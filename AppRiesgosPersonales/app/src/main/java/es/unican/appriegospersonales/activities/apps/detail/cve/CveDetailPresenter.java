package es.unican.appriegospersonales.activities.apps.detail.cve;

import es.unican.appriegospersonales.model.Vulnerabilidad;

public class CveDetailPresenter implements ICveDetailContract.Presenter {

    private final ICveDetailContract.View view;
    private Vulnerabilidad vulnerabilidad;

    public CveDetailPresenter(Vulnerabilidad vulnerabilidad, CveDetailView cveDetailView) {
        this.view = cveDetailView;
        this.vulnerabilidad = vulnerabilidad;
    }

    @Override
    public void init() {

    }

    @Override
    public double getCveBaseScore() {
        return vulnerabilidad.getBaseScore();
    }

    @Override
    public String getCveId() {
        return vulnerabilidad.getIdCVE();
    }

    @Override
    public String getCveDescripcion() {
        return vulnerabilidad.getDescripcion();
    }

    @Override
    public String getCveConfidenciality() {
        return vulnerabilidad.getConfidentialityImpact();
    }

    @Override
    public String getCveIntegrity() {
        return vulnerabilidad.getIntegrityImpact();
    }

    @Override
    public String getCveAvailability() {
        return vulnerabilidad.getAvailabilityImpact();
    }
}