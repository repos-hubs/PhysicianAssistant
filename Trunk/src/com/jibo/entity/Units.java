package com.jibo.entity;

import java.util.List;
import com.jibo.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.jibo.dao.UnitValuesDao;
import com.jibo.dao.UnitsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table units.
 * 
 * * ҽѧ��ʽģ�� - ��ʽ��ϸ����
 * 
 * 
 */
public class Units implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3195704572654038881L;
	private Integer id;
    /** Not-null value. */
    private String nameCn;
    private Integer round;
    private Integer max;
    private Integer min;
    private Integer formulaId;
    private Integer order;
    private Integer type;
    private Integer nameEn;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient UnitsDao myDao;

    private List<UnitValues> unitValuesList;

    public Units() {
    }

    public Units(Integer id) {
        this.id = id;
    }

    public Units(Integer id, String nameCn, Integer round, Integer max, Integer min, Integer formulaId, Integer order, Integer type, Integer nameEn) {
        this.id = id;
        this.nameCn = nameCn;
        this.round = round;
        this.max = max;
        this.min = min;
        this.formulaId = formulaId;
        this.order = order;
        this.type = type;
        this.nameEn = nameEn;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUnitsDao() : null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getNameCn() {
        return nameCn;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Integer formulaId) {
        this.formulaId = formulaId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNameEn() {
        return nameEn;
    }

    public void setNameEn(Integer nameEn) {
        this.nameEn = nameEn;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public synchronized List<UnitValues> getUnitValuesList() {
        if (unitValuesList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UnitValuesDao targetDao = daoSession.getUnitValuesDao();
            unitValuesList = targetDao._queryUnits_UnitValuesList(id);
        }
        return unitValuesList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetUnitValuesList() {
        unitValuesList = null;
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

}