package com.company;

public class Customer {
    private boolean Isaccount = false;
    private Account account;
    private String name = "";
    private String phonenumber = "";
    private String Identitynumber = "";
    private String branch = "";


    public Customer(String name, String phonenumber, String identitynumber) {
        this.name = name;
        this.phonenumber = phonenumber;
        Identitynumber = identitynumber;
    }

    public String getIdentitynumber() {
        return Identitynumber;
    }

    public void setIdentitynumber(String identitynumber) {
        Identitynumber = identitynumber;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void addAccount(Account account){
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isIsaccount() {
        return Isaccount;
    }

    public void setIsaccount(boolean isaccount) {
        Isaccount = isaccount;
    }
}
