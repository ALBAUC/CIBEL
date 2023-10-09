package es.unican.appriegospersonales.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Objects;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import es.unican.appriegospersonales.repository.db.DaoSession;
import es.unican.appriegospersonales.repository.db.CategoriaDao;
import es.unican.appriegospersonales.repository.db.ActivoDao;

@SuppressLint("ParcelCreator")
@Entity
public class Activo implements Parcelable {

    @SerializedName("id")
    @NonNull
    @Id
    private Long idActivo;

    private String nombre;

    private String icono;

    @ToOne(joinProperty = "fk_categoria")
    private Categoria categoria;

    private Long fk_categoria;

    private Long fk_perfil;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1317875841)
    private transient ActivoDao myDao;

    @Generated(hash = 1862928815)
    public Activo(@NonNull Long idActivo, String nombre, String icono,
            Long fk_categoria, Long fk_perfil) {
        this.idActivo = idActivo;
        this.nombre = nombre;
        this.icono = icono;
        this.fk_categoria = fk_categoria;
        this.fk_perfil = fk_perfil;
    }

    @Generated(hash = 315079783)
    public Activo() {
    }

    @Generated(hash = 1426606615)
    private transient Long categoria__resolvedKey;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Long getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(Long fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    @NonNull
    public Long getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(@NonNull Long idActivo) {
        this.idActivo = idActivo;
    }

    public Categoria getCat() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Activo{" +
                "idActivo=" + idActivo +
                ", nombre='" + nombre + '\'' +
                ", icono='" + icono + '\'' +
                ", categoria=" + categoria +
                ", fk_categoria=" + fk_categoria +
                ", fk_perfil=" + fk_perfil +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(idActivo);
        parcel.writeString(nombre);
        parcel.writeString(icono);
        parcel.writeValue(categoria);
    }

    public Long getFk_perfil() {
        return this.fk_perfil;
    }

    public void setFk_perfil(Long fk_perfil) {
        this.fk_perfil = fk_perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activo activo = (Activo) o;
        return idActivo.equals(activo.idActivo) && Objects.equals(nombre, activo.nombre) && Objects.equals(icono, activo.icono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActivo, nombre, icono);
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 2068634405)
    public Categoria getCategoria() {
        Long __key = this.fk_categoria;
        if (categoria__resolvedKey == null
                || !categoria__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CategoriaDao targetDao = daoSession.getCategoriaDao();
            Categoria categoriaNew = targetDao.load(__key);
            synchronized (this) {
                categoria = categoriaNew;
                categoria__resolvedKey = __key;
            }
        }
        return categoria;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1420510056)
    public void setCategoria(Categoria categoria) {
        synchronized (this) {
            this.categoria = categoria;
            fk_categoria = categoria == null ? null : categoria.getIdCategoria();
            categoria__resolvedKey = fk_categoria;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1926086416)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getActivoDao() : null;
    }
}
