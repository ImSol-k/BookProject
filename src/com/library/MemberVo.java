package com.library;

public class MemberVo {

	// 필드
		private int member_num;
		private String member_id;
		private String member_pw;
		private String name;
		private String ph;
		private String address;

		// 생성자
		public MemberVo() {

		}
		
		public MemberVo(String member_pw, String name, String ph, String address) {

		
			this.member_pw = member_pw;
			this.name = name;
			this.ph = ph;
			this.address = address;
		}

		public MemberVo(String member_id, String member_pw, String name, String ph, String address) {

			this.member_id = member_id;
			this.member_pw = member_pw;
			this.name = name;
			this.ph = ph;
			this.address = address;
		}

		public MemberVo(int member_num, String member_id, String member_pw, String name, String ph, String address) {

			this.member_num = member_num;
			this.member_id = member_id;
			this.member_pw = member_pw;
			this.name = name;
			this.ph = ph;
			this.address = address;
		}

		// gs

		public String getMember_id() {
			return member_id;
		}

		public int getMember_num() {
			return member_num;
		}

		public void setMember_num(int member_num) {
			this.member_num = member_num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPh() {
			return ph;
		}

		public void setPh(String ph) {
			this.ph = ph;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setMember_id(String member_id) {
			this.member_id = member_id;
		}

		public String getMember_pw() {
			return member_pw;
		}

		public void setMember_pw(String member_pw) {
			this.member_pw = member_pw;
		}

		// 일반 메소드
		@Override
		public String toString() {
			return "회원정보 > [member_num=" + member_num + ", member_id=" + member_id + ", member_pw=" + member_pw + ", name="
					+ name + ", ph=" + ph + ", address=" + address + "]";
		}
}
