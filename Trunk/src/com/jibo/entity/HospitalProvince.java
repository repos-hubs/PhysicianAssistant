package com.jibo.entity;

import java.util.List;
import com.jibo.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.jibo.dao.HospitalCityDao;
import com.jibo.dao.HospitalProvinceDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table hospital_region.
 * 
 * 省份直辖市信息表
 * 
 */
public class HospitalProvince {

    private String name;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

	/** Used for active entity operations. */
    private transient HospitalProvinceDao myDao;

    private List<HospitalCity> hospitalCityList;

    public HospitalProvince() {
    }
    


    public HospitalProvince(String name) {
        this.name = name;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHospitalProvinceDao() : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public synchronized List<HospitalCity> getHospitalCityList() {
        if (hospitalCityList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HospitalCityDao targetDao = daoSession.getHospitalCityDao();
            hospitalCityList = targetDao._queryHospitalProvince_HospitalCityList(name);
        }
        return hospitalCityList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetHospitalCityList() {
        hospitalCityList = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    @Override
	public String toString() {
		return  name ;
	}    
    @Override
 	public boolean equals(Object o) {
 		return o.toString().equals(name);
 	}
}
