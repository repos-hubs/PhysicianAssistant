package com.jibo.entity;

import com.jibo.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.jibo.dao.AdminRouteInfoDao;
import com.jibo.dao.BrandInfoDao;
import com.jibo.dao.CompanyInfoDao;
import com.jibo.dao.DrugDetailInfoDao;
import com.jibo.dao.DrugInfoDao;
import com.jibo.dao.FormulationInfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table InsertBasicInfo.
 * 
 * 药品详细记录联系主表。连接公司，药品，商品，剂型等
 * 
 * 关联药品DrugInfo多对一，关联商品BrandInfo多对一，关联给药途径AdminRouteInfo多对一，
 * 关联公司CompanyInfo多对一，关联剂型FormulationInfo多对一，关联详细内容DrugDetailTypeInfo一对多
 */
public class DrugDetailInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String sourceId;
	private String drugId;// 药品id
	private String brandId;// 商品id
	private String companyId;// 公司id
	private String adminRouteID;// 给药途径id
	private String formulationID;// 剂型id
	private String specification;// 规格内容
	private String changeDate;

	/** Used to resolve relations */
	private transient DaoSession daoSession;

	/** Used for active entity operations. */
	private transient DrugDetailInfoDao myDao;

	private CompanyInfo companyInfo;
	private String companyInfo__resolvedKey;

	private AdminRouteInfo adminRouteInfo;
	private String adminRouteInfo__resolvedKey;

	private FormulationInfo formulationInfo;
	private String formulationInfo__resolvedKey;

	private BrandInfo brandInfo;
	private String brandInfo__resolvedKey;

	private DrugInfo drugInfo;
	private String drugInfo__resolvedKey;

	public DrugDetailInfo() {
	}

	public DrugDetailInfo(String id) {
		this.id = id;
	}

	public DrugDetailInfo(String id, String sourceId, String drugId,
			String brandId, String companyId, String adminRouteID,
			String formulationID, String specification, String changeDate) {
		this.id = id;
		this.sourceId = sourceId;
		this.drugId = drugId;
		this.brandId = brandId;
		this.companyId = companyId;
		this.adminRouteID = adminRouteID;
		this.formulationID = formulationID;
		this.specification = specification;
		this.changeDate = changeDate;
	}

	/** called by internal mechanisms, do not call yourself. */
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getDrugDetailInfoDao() : null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getAdminRouteID() {
		return adminRouteID;
	}

	public void setAdminRouteID(String adminRouteID) {
		this.adminRouteID = adminRouteID;
	}

	public String getFormulationID() {
		return formulationID;
	}

	public void setFormulationID(String formulationID) {
		this.formulationID = formulationID;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	/** To-one relationship, resolved on first access. */
	public CompanyInfo getCompanyInfo() {
		if (companyInfo__resolvedKey == null
				|| companyInfo__resolvedKey != companyId) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			CompanyInfoDao targetDao = daoSession.getCompanyInfoDao();
			companyInfo = targetDao.load(companyId);
			companyInfo__resolvedKey = companyId;
		}
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
		companyId = companyInfo == null ? null : companyInfo.getId();
		companyInfo__resolvedKey = companyId;
	}

	/** To-one relationship, resolved on first access. */
	public AdminRouteInfo getAdminRouteInfo() {
		if (adminRouteInfo__resolvedKey == null
				|| adminRouteInfo__resolvedKey != adminRouteID) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			AdminRouteInfoDao targetDao = daoSession.getAdminRouteInfoDao();
			adminRouteInfo = targetDao.load(adminRouteID);
			adminRouteInfo__resolvedKey = adminRouteID;
		}
		return adminRouteInfo;
	}

	public void setAdminRouteInfo(AdminRouteInfo adminRouteInfo) {
		this.adminRouteInfo = adminRouteInfo;
		adminRouteID = adminRouteInfo == null ? null : adminRouteInfo.getId();
		adminRouteInfo__resolvedKey = adminRouteID;
	}

	/** To-one relationship, resolved on first access. */
	public FormulationInfo getFormulationInfo() {
		if (formulationInfo__resolvedKey == null
				|| formulationInfo__resolvedKey != formulationID) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			FormulationInfoDao targetDao = daoSession.getFormulationInfoDao();
			formulationInfo = targetDao.load(formulationID);
			formulationInfo__resolvedKey = formulationID;
		}
		return formulationInfo;
	}

	public void setFormulationInfo(FormulationInfo formulationInfo) {
		this.formulationInfo = formulationInfo;
		formulationID = formulationInfo == null ? null : formulationInfo
				.getId();
		formulationInfo__resolvedKey = formulationID;
	}

	/** To-one relationship, resolved on first access. */
	public BrandInfo getBrandInfo() {
		if (brandInfo__resolvedKey == null || brandInfo__resolvedKey != brandId) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			BrandInfoDao targetDao = daoSession.getBrandInfoDao();
			brandInfo = targetDao.load(brandId);
			brandInfo__resolvedKey = brandId;
		}
		return brandInfo;
	}

	public void setBrandInfo(BrandInfo brandInfo) {
		this.brandInfo = brandInfo;
		brandId = brandInfo == null ? null : brandInfo.getId();
		brandInfo__resolvedKey = brandId;
	}

	/** To-one relationship, resolved on first access. */
	public DrugInfo getDrugInfo() {
		if (drugInfo__resolvedKey == null || drugInfo__resolvedKey != drugId) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			DrugInfoDao targetDao = daoSession.getDrugInfoDao();
			drugInfo = targetDao.load(drugId);
			drugInfo__resolvedKey = drugId;
		}
		return drugInfo;
	}

	public void setDrugInfo(DrugInfo drugInfo) {
		this.drugInfo = drugInfo;
		drugId = drugInfo == null ? null : drugInfo.getId();
		drugInfo__resolvedKey = drugId;
	}

	/**
	 * Convenient call for {@link AbstractDao#delete(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void delete() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.delete(this);
	}

	/**
	 * Convenient call for {@link AbstractDao#update(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void update() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.update(this);
	}

	/**
	 * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void refresh() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.refresh(this);
	}

}
