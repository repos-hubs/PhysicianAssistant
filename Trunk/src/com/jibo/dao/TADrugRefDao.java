package com.jibo.dao;

import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.QueryBuilder;
import de.greenrobot.dao.WhereCondition;

import com.jibo.entity.TADrugRef;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * DAO for table TADrugRef.
 */
public class TADrugRefDao extends AbstractDao<TADrugRef, String> {

	public static final String TABLENAME = "TADrugRef";

	/**
	 * Properties of entity TADrugRef.<br/>
	 * Can be used for QueryBuilder and for referencing column names.
	 */
	public static class Properties {
		public final static Property Id = new Property(0, String.class, "id",
				true, "TAID");
		public final static Property Level = new Property(1, String.class,
				"level", false, "TALevel");
		public final static Property NameEn = new Property(2, String.class,
				"nameEn", false, "TAEN");
		public final static Property NameCn = new Property(3, String.class,
				"nameCn", false, "TACN");
		public final static Property ChangeDate = new Property(4, String.class,
				"changeDate", false, "ChangeDate");
	};

	public TADrugRefDao(DaoConfig config) {
		super(config);
	}

	public TADrugRefDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}

	/** Creates the underlying database table. */
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		db.execSQL("CREATE TABLE " + constraint + "'TADrugRef' (" + //
				"'TAID' TEXT PRIMARY KEY NOT NULL ," + // 0: id
				"'TALevel' TEXT," + // 1: level
				"'TAEN' TEXT," + // 2: nameEn
				"'TACN' TEXT," + // 3: nameCn
				"'ChangeDate' TEXT);"); // 4: changeDate
	}

	/** Drops the underlying database table. */
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "")
				+ "'TADrugRef'";
		db.execSQL(sql);
	}

	/** @inheritdoc */
	@Override
	protected void bindValues(SQLiteStatement stmt, TADrugRef entity) {
		stmt.clearBindings();

		String id = entity.getId();
		if (id != null) {
			stmt.bindString(1, id);
		}

		String level = entity.getLevel();
		if (level != null) {
			stmt.bindString(2, level);
		}

		String nameEn = entity.getNameEn();
		if (nameEn != null) {
			stmt.bindString(3, nameEn);
		}

		String nameCn = entity.getNameCn();
		if (nameCn != null) {
			stmt.bindString(4, nameCn);
		}

		String changeDate = entity.getChangeDate();
		if (changeDate != null) {
			stmt.bindString(5, changeDate);
		}
	}

	/** @inheritdoc */
	@Override
	public String readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
	}

	/** @inheritdoc */
	@Override
	public TADrugRef readEntity(Cursor cursor, int offset) {
		TADrugRef entity = new TADrugRef(
				//
				cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
				cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // level
				cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // nameEn
				cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // nameCn
				cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // changeDate
		);
		return entity;
	}

	/** @inheritdoc */
	@Override
	public void readEntity(Cursor cursor, TADrugRef entity, int offset) {
		entity.setId(cursor.isNull(offset + 0) ? null : cursor
				.getString(offset + 0));
		entity.setLevel(cursor.isNull(offset + 1) ? null : cursor
				.getString(offset + 1));
		entity.setNameEn(cursor.isNull(offset + 2) ? null : cursor
				.getString(offset + 2));
		entity.setNameCn(cursor.isNull(offset + 3) ? null : cursor
				.getString(offset + 3));
		entity.setChangeDate(cursor.isNull(offset + 4) ? null : cursor
				.getString(offset + 4));
	}

	/** @inheritdoc */
	@Override
	protected String updateKeyAfterInsert(TADrugRef entity, long rowId) {
		return entity.getId();
	}

	/** @inheritdoc */
	@Override
	public String getKey(TADrugRef entity) {
		if (entity != null) {
			return entity.getId();
		} else {
			return null;
		}
	}

	/** @inheritdoc */
	@Override
	protected boolean isEntityUpdateable() {
		return true;
	}

	/***
	 * 获取药品分类列表 <共四级列表>
	 * 
	 * @param entity
	 *            参数为空时，默认为获取第一级列表
	 * @return
	 */
	public List<TADrugRef> getTADrugDefList(TADrugRef entity) {
		int level = null == entity ? 0 : Integer.parseInt(entity.getLevel());
		QueryBuilder<TADrugRef> builder = queryBuilder();
		List<TADrugRef> list = null;
		switch (level) {
		case 0:// 获取一级类别列表
			list = builder.where(
					new WhereCondition.StringCondition(
							"TAID IN (SELECT DISTINCT TA1ID FROM TADrug )")).orderAsc(Properties.Id)
					.list();
//			// 添加类别*其他*
//			list.add(new TADrugRef(null, "1", "other", "其他", null));
			break;
		case 1:// 获取第三级类别列表
				// TADrug表中的TA1ID字段为空对应的大类别为*其他*
			if (null == entity.getId())
				builder.where(new WhereCondition.StringCondition(
						"TAID IN (SELECT DISTINCT TA3ID FROM TADrug WHERE TA1ID ISNULL)")).orderAsc(Properties.Id);
			else
				// 一般的药品大类
				builder.where(new WhereCondition.StringCondition(
						"TAID IN (SELECT DISTINCT TA3ID FROM TADrug WHERE TA1ID = '"
								+ entity.getId() + "')")).orderAsc(Properties.Id);
			list = builder.listLazy();
			break;
		}
		return list;
	}
}
