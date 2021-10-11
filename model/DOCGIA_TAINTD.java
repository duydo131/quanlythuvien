package model;

import java.sql.Date;

public class DOCGIA_TAINTD {
	private int id_dg;
	private String TEN_DG_20180168;
	private String GIOITINH_20180168;
	private String DIACHI_20180168;
	private Date NGAYSINH_20180168;
	private String CMND_20180168;
	private String EMAIL_20180168;
	private int DIENTHOAI_20180168;
	
	public DOCGIA_TAINTD() {
		
	}
	
	public DOCGIA_TAINTD(int id_dg,String TEN_DG_20180168,String GIOITINH_20180168,String DIACHI_20180168,Date NGAYSINH_20180168,
			String CMND_20180168,String EMAIL_20180168,int DIENTHOAI_20180168) {
		this.id_dg = id_dg;
		this.TEN_DG_20180168 = TEN_DG_20180168;
		this.GIOITINH_20180168 = GIOITINH_20180168;
		this.DIACHI_20180168 = DIACHI_20180168;
		this.NGAYSINH_20180168 = NGAYSINH_20180168;
		this.CMND_20180168 = CMND_20180168 ;
		this.EMAIL_20180168 = EMAIL_20180168;
		this.DIENTHOAI_20180168 = DIENTHOAI_20180168;
	}



	
	public int getId_dg() {
		return id_dg;
	}

	public void setId_dg(int id_dg) {
		this.id_dg = id_dg;
	}

	public String getTEN_DG_20180168() {
		return TEN_DG_20180168;
	}

	public void setTEN_DG_20180168(String tEN_DG_20180168) {
		TEN_DG_20180168 = tEN_DG_20180168;
	}


	public String getGIOITINH_20180168() {
		return GIOITINH_20180168;
	}

	public void setGIOITINH_20180168(String gIOITINH_20180168) {
		GIOITINH_20180168 = gIOITINH_20180168;
	}

	public String getDIACHI_20180168() {
		return DIACHI_20180168;
	}

	public void setDIACHI_20180168(String dIACHI_20180168) {
		DIACHI_20180168 = dIACHI_20180168;
	}

	public Date getNGAYSINH_20180168() {
		return NGAYSINH_20180168;
	}

	public void setNGAYSINH_20180168(Date nGAYSINH_20180168) {
		NGAYSINH_20180168 = nGAYSINH_20180168;
	}

	public String getCMND_20180168() {
		return CMND_20180168;
	}

	public void setCMND_20180168(String cMND_20180168) {
		CMND_20180168 = cMND_20180168;
	}

	public String getEMAIL_20180168() {
		return EMAIL_20180168;
	}

	public void setEMAIL_20180168(String eMAIL_20180168) {
		EMAIL_20180168 = eMAIL_20180168;
	}

	public int getDIENTHOAI_20180168() {
		return DIENTHOAI_20180168;
	}

	public void setDIENTHOAI_20180168(int dIENTHOAI_20180168) {
		DIENTHOAI_20180168 = dIENTHOAI_20180168;
	}
	
	

}
