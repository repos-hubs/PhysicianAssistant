package com.jibo.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.Query;
import de.greenrobot.dao.QueryBuilder;

import com.jibo.entity.HospitalCity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table hospital_city.
*/
public class HospitalCityDao extends AbstractDao<HospitalCity, Void> {

    public static final String TABLENAME = "hospital_city";

    /**
     * Properties of entity HospitalCity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ProvinceName = new Property(0, String.class, "provinceName", false, "add_province");
        public final static Property CityName = new Property(1, String.class, "cityName", false, "add_city");
    };

    private Query<HospitalCity> hospitalProvince_HospitalCityListQuery;

    public HospitalCityDao(DaoConfig config) {
        super(config);
    }
    
    public HospitalCityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'hospital_city' (" + //
                "'add_province' TEXT," + // 0: provinceName
                "'add_city' TEXT);"); // 1: cityName
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'hospital_city'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, HospitalCity entity) {
        stmt.clearBindings();
 
        String provinceName = entity.getProvinceName();
        if (provinceName != null) {
            stmt.bindString(1, provinceName);
        }
 
        String cityName = entity.getCityName();
        if (cityName != null) {
            stmt.bindString(2, cityName);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public HospitalCity readEntity(Cursor cursor, int offset) {
        HospitalCity entity = new HospitalCity( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // provinceName
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // cityName
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, HospitalCity entity, int offset) {
        entity.setProvinceName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCityName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(HospitalCity entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(HospitalCity entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "hospitalCityList" to-many relationship of HospitalProvince. */
    public synchronized List<HospitalCity> _queryHospitalProvince_HospitalCityList(String provinceName) {
        if (hospitalProvince_HospitalCityListQuery == null) {
            QueryBuilder<HospitalCity> queryBuilder = queryBuilder();
            queryBuilder.where(Properties.ProvinceName.eq(provinceName));
            hospitalProvince_HospitalCityListQuery = queryBuilder.build();
        } else {
            hospitalProvince_HospitalCityListQuery.setParameter(0, provinceName);
        }
        return hospitalProvince_HospitalCityListQuery.list();
    }

}
