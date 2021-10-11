package model;

import java.sql.Date;

public class THUTHU_TAINTD {
	private int id;
	private String TEN_TT_20180168;
	private String GIOITINH_20180168;
	private Date NGAYSINH_20180168;
	private String CMND_20180168;
	private String EMAIL_20180168;
	private int DIENTHOAI_20180168;
	
	public THUTHU_TAINTD() {
		
	}
	
	public THUTHU_TAINTD(int id,String TEN_TT_20180168,String GIOITINH_20180168,Date NGAYSINH_20180168,
			String CMND_20180168,String EMAIL_20180168,int DIENTHOAI_20180168) {
		this.id = id;
		this.TEN_TT_20180168 = TEN_TT_20180168;
		this.GIOITINH_20180168 = GIOITINH_20180168;
		this.NGAYSINH_20180168 = NGAYSINH_20180168;
		this.CMND_20180168 = CMND_20180168 ;
		this.EMAIL_20180168 = EMAIL_20180168;
		this.DIENTHOAI_20180168 = DIENTHOAI_20180168;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getTEN_TT_20180168() {
		return TEN_TT_20180168;
	}

	public void setTEN_TT_20180168(String tEN_TT_20180168) {
		TEN_TT_20180168 = tEN_TT_20180168;
	}



	public String getGIOITINH_20180168() {
		return GIOITINH_20180168;
	}

	public void setGIOITINH_20180168(String gIOITINH_20180168) {
		GIOITINH_20180168 = gIOITINH_20180168;
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
