package model;

public class SACH_TAINTD {
	 int idsach;
	 String TENSACH_20180168;
	 String TACGIA_20180168;
	 String NHAXB_20180168;
	int NAMXB_20180168;
	int DONGIA_20180168;
	 String GIOITHIEU_20180168;

	
	public SACH_TAINTD (){
	}
	
	public SACH_TAINTD(int idsach,String TENSACH_20180168,String TACGIA_20180168,String NHAXB_20180168,
			int NAMXB_20180168,int DONGIA_20180168,String GIOITHIEU_20180168 ) {
		this.idsach = idsach ;
		this.TENSACH_20180168 = TENSACH_20180168;
		this.TACGIA_20180168 = TACGIA_20180168;
		this.NHAXB_20180168 =  NHAXB_20180168;
		this.NAMXB_20180168 = NAMXB_20180168;
		this.DONGIA_20180168 = DONGIA_20180168;
		this.GIOITHIEU_20180168 =GIOITHIEU_20180168;
	}
				



	public int getIdsach() {
		return idsach;
	}

	public void setIdsach(int idsach) {
		this.idsach = idsach;
	}

	public String getGIOITHIEU_20180168() {
		return GIOITHIEU_20180168;
	}

	public void setGIOITHIEU_20180168(String gIOITHIEU_20180168) {
		GIOITHIEU_20180168 = gIOITHIEU_20180168;
	}


	public String getTENSACH_20180168() {
		return TENSACH_20180168;
	}

	public void setTENSACH_20180168(String tENSACH_20180168) {
		TENSACH_20180168 = tENSACH_20180168;
	}

	public String getTACGIA_20180168() {
		return TACGIA_20180168;
	}

	public void setTACGIA_20180168(String tACGIA_20180168) {
		TACGIA_20180168 = tACGIA_20180168;
	}

	public String getNHAXB_20180168() {
		return NHAXB_20180168;
	}

	public void setNHAXB_20180168(String nHAXB_20180168) {
		NHAXB_20180168 = nHAXB_20180168;
	}




	public int getNAMXB_20180168() {
		return NAMXB_20180168;
	}

	public void setNAMXB_20180168(int nAMXB_20180168) {
		NAMXB_20180168 = nAMXB_20180168;
	}

	public int getDONGIA_20180168() {
		return DONGIA_20180168;
	}

	public void setDONGIA_20180168(int dONGIA_20180168) {
		DONGIA_20180168 = dONGIA_20180168;
	}
	
}
