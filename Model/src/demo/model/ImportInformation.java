package demo.model;

import java.util.List;

public class ImportInformation {
    private String memberOrderID;
    private String memberID;
    private String memberName;
    private String staffID;
    private String staffName;
    private String memberRole;
    private String memberProvince;
    private String memberDistrict;
    private String memberWard;
    private String memberAddress;
    private String memberIDCard;
    private String memberLoginAccount;
    private String memberPhoneNumber;
    private String memberPassword;
    private String EZ;
    private String dauNoi;
    private String MK;
    private String NVPT;
    private String CHPT;
    
    public ImportInformation() {
        super();
    }

    public ImportInformation(List<String> listValue){
        this.memberOrderID = listValue.get(0);
        this.memberID = listValue.get(1);
        this.memberName = listValue.get(2);
        this.staffID = listValue.get(3);
        this.staffName = listValue.get(4);
        this.memberRole = listValue.get(5);
        this.memberProvince = listValue.get(6);
        this.memberDistrict = listValue.get(7);
        this.memberWard = listValue.get(8);
        this.memberAddress = listValue.get(9);
        this.memberIDCard = listValue.get(10);
        this.memberLoginAccount = listValue.get(11);
        this.memberPhoneNumber = listValue.get(12);
        this.memberPassword = listValue.get(13);
        this.EZ = listValue.get(14);
        this.dauNoi= listValue.get(15);
        this.MK = listValue.get(16);
        this.NVPT = listValue.get(17);
        this.CHPT = listValue.get(18);
    }

    public void setMemberOrderID(String memberOrderID) {
        this.memberOrderID = memberOrderID;
    }

    public String getMemberOrderID() {
        return memberOrderID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberProvince(String memberProvince) {
        this.memberProvince = memberProvince;
    }

    public String getMemberProvince() {
        return memberProvince;
    }

    public void setMemberDistrict(String memberDistrict) {
        this.memberDistrict = memberDistrict;
    }

    public String getMemberDistrict() {
        return memberDistrict;
    }

    public void setMemberWard(String memberWard) {
        this.memberWard = memberWard;
    }

    public String getMemberWard() {
        return memberWard;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberIDCard(String memberIDCard) {
        this.memberIDCard = memberIDCard;
    }

    public String getMemberIDCard() {
        return memberIDCard;
    }

    public void setMemberLoginAccount(String memberLoginAccount) {
        this.memberLoginAccount = memberLoginAccount;
    }

    public String getMemberLoginAccount() {
        return memberLoginAccount;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setEZ(String EZ) {
        this.EZ = EZ;
    }

    public String getEZ() {
        return EZ;
    }

    public void setDauNoi(String dauNoi) {
        this.dauNoi = dauNoi;
    }

    public String getDauNoi() {
        return dauNoi;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public String getMK() {
        return MK;
    }

    public void setNVPT(String NVPT) {
        this.NVPT = NVPT;
    }

    public String getNVPT() {
        return NVPT;
    }

    public void setCHPT(String CHPT) {
        this.CHPT = CHPT;
    }

    public String getCHPT() {
        return CHPT;
    }
}
