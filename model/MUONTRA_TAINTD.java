package model;

import java.sql.Date;

public class MUONTRA_TAINTD {
	private int MAMT_20180168;
	private int MA_DG_20180168;
	private int MA_TT_20180168;
	private Date NGAY_MUON_20180168;
	private Date NGAY_HENTRA_20180168;
	
	public MUONTRA_TAINTD() {
		
	}
	public MUONTRA_TAINTD(int MAMT_20180168,int MA_DG_20180168,int MA_TT_20180168,Date NGAY_MUON_20180168,
			Date NGAY_HENTRA_20180168) {
		this.MAMT_20180168 = MAMT_20180168;
		this.MA_DG_20180168 = MA_DG_20180168;
		this.MA_TT_20180168 = MA_TT_20180168 ;		
		this.NGAY_HENTRA_20180168 = NGAY_HENTRA_20180168;
		this.NGAY_MUON_20180168 = NGAY_MUON_20180168;
	}

	public int getMAMT_20180168() {
		return MAMT_20180168;
	}
	public void setMAMT_20180168(int mAMT_20180168) {
		MAMT_20180168 = mAMT_20180168;
	}
	public int getMA_DG_20180168() {
		return MA_DG_20180168;
	}
	public void setMA_DG_20180168(int mA_DG_20180168) {
		MA_DG_20180168 = mA_DG_20180168;
	}
	public int getMA_TT_20180168() {
		return MA_TT_20180168;
	}
	public void setMA_TT_20180168(int mA_TT_20180168) {
		MA_TT_20180168 = mA_TT_20180168;
	}
	public Date getNGAY_MUON_20180168() {
		return NGAY_MUON_20180168;
	}
	public void setNGAY_MUON_20180168(Date nGAY_MUON_20180168) {
		NGAY_MUON_20180168 = nGAY_MUON_20180168;
	}
	public Date getNGAY_HENTRA_20180168() {
		return NGAY_HENTRA_20180168;
	}
	public void setNGAY_HENTRA_20180168(Date nGAY_HENTRA_20180168) {
		NGAY_HENTRA_20180168 = nGAY_HENTRA_20180168;
	}
     
}