package model;

import java.sql.Date;

public class CHITIET_MUONTRA_TAINTD {
	private int id;
	private int MAMT_20180168;
	private int MASACH_20180168;
	private Date NGAY_TRA_20180168;
	private boolean TRANG_THAI_SACH_20180168  = true;
	private int TIEN_PHAT_20180168;
	private String GHI_CHU_20180168;
	
	public CHITIET_MUONTRA_TAINTD() {
		
	}
	public CHITIET_MUONTRA_TAINTD (int id,int MAMT_20180168,int MASACH_20180168,Date NGAY_TRA_20180168,boolean TRANG_THAI_SACH_20180168,
			int TIEN_PHAT_20180168,String GHI_CHU_20180168) {
		this.id = id;
		this.MAMT_20180168 = MAMT_20180168;
		this.MASACH_20180168 = MASACH_20180168;
		this.NGAY_TRA_20180168 = NGAY_TRA_20180168 ;
		this.TIEN_PHAT_20180168 = TIEN_PHAT_20180168 ;
		this.TRANG_THAI_SACH_20180168 = TRANG_THAI_SACH_20180168;
		this.GHI_CHU_20180168 = GHI_CHU_20180168;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMAMT_20180168() {
		return MAMT_20180168;
	}
	public void setMAMT_20180168(int mAMT_20180168) {
		MAMT_20180168 = mAMT_20180168;
	}
	public int getMASACH_20180168() {
		return MASACH_20180168;
	}
	public void setMASACH_20180168(int mASACH_20180168) {
		MASACH_20180168 = mASACH_20180168;
	}
	public Date getNGAY_TRA_20180168() {
		return NGAY_TRA_20180168;
	}
	public void setNGAY_TRA_20180168(Date nGAY_TRA_20180168) {
		NGAY_TRA_20180168 = nGAY_TRA_20180168;
	}
	public boolean isTRANG_THAI_SACH_20180168() {
		return TRANG_THAI_SACH_20180168;
	}
	public void setTRANG_THAI_SACH_20180168(boolean tRANG_THAI_SACH_20180168) {
		TRANG_THAI_SACH_20180168 = tRANG_THAI_SACH_20180168;
	}
	public int getTIEN_PHAT_20180168() {
		return TIEN_PHAT_20180168;
	}
	public void setTIEN_PHAT_20180168(int tIEN_PHAT_20180168) {
		TIEN_PHAT_20180168 = tIEN_PHAT_20180168;
	}
	public String getGHI_CHU_20180168() {
		return GHI_CHU_20180168;
	}
	public void setGHI_CHU_20180168(String gHI_CHU_20180168) {
		GHI_CHU_20180168 = gHI_CHU_20180168;
	}
	

}
