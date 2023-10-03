package es.unican.appriegospersonales.activities.apps.detail;

import java.util.List;

import es.unican.appriegospersonales.model.Activo;
import es.unican.appriegospersonales.model.Control;
import es.unican.appriegospersonales.model.Perfil;
import es.unican.appriegospersonales.repository.db.ActivoDao;
import es.unican.appriegospersonales.repository.db.ControlDao;
import es.unican.appriegospersonales.repository.db.DaoSession;
import es.unican.appriegospersonales.repository.db.PerfilDao;

public class AssetDetailPresenter implements IAssetDetailContract.Presenter {

    private final IAssetDetailContract.View view;
    private ActivoDao activoDao;
    private PerfilDao perfilDao;
    private ControlDao controlDao;
    private Activo activo;
    private Perfil perfil;

    public AssetDetailPresenter(Activo activo, IAssetDetailContract.View view) {
        this.activo = activo;
        this.view = view;
    }

    @Override
    public void init() {
        DaoSession daoSession = view.getMyApplication().getDaoSession();
        activoDao = daoSession.getActivoDao();
        perfilDao = daoSession.getPerfilDao();
        controlDao = daoSession.getControlDao();
        perfil = Perfil.getInstance(perfilDao);
    }

    @Override
    public List<Control> getAssetControls() {
        return activo.getCategoria().getControles();
    }

    @Override
    public String getAssetIcon() {
        return activo.getIcono();
    }

    @Override
    public String getAssetName() {
        return activo.getNombre();
    }

    @Override
    public String getAssetCategory() {
        return activo.getCategoria().getNombre();
    }

    @Override
    public void onAddAssetClicked() {
        if (!isAssetAdded()) {
            activo.setFk_perfil(perfil.getId());
            perfil.getActivosAnhadidos().add(activo);
            activoDao.update(activo);
            perfilDao.update(perfil);
        } else {
            activo.setFk_perfil(null);
            perfil.getActivosAnhadidos().remove(activo);
            activoDao.update(activo);
            perfilDao.update(perfil);
        }
    }

    @Override
    public boolean isAssetAdded() {
        return getPerfilAssets().contains(activo);
    }

    @Override
    public List<Activo> getPerfilAssets() {
        List<Activo> perfilAssets = activoDao._queryPerfil_ActivosAnhadidos(perfil.getId());
        return perfilAssets;
    }

    @Override
    public List<Control> getPerfilControls() {
        List<Control> perfilControls = controlDao._queryPerfil_ControlesAnhadidos(perfil.getId());
        return perfilControls;
    }
}