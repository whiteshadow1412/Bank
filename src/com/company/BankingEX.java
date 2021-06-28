package com.company;

import java.util.ArrayList;
import java.util.List;

public class BankingEX {
    private List<Branch> branchList = new ArrayList<>();

    public void addBranch(Branch branch) {
        int check = 0;
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName() == branch.getName()) check = 1;
        }
        if (check == 0) branchList.add(branch);
        else System.out.println("Already had branch");
    }

    public void removeBranch(Branch branch) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName() == branch.getName()) {
                branchList.remove(i);
                break;
            }
        }
    }

    public void editBranch(Branch branch, Branch newBranch) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName() == branch.getName()) {
                branchList.get(i).setName(newBranch.getName());
                branchList.get(i).setAddress(newBranch.getAddress());
                break;
            }
        }
    }

    public void displayBalance(Customer customer) {
        int check = 0;
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName() == customer.getBranch()) {
                int j = branchList.get(i).getCustomerList().indexOf(customer);
                if (j != -1) {
                    if (branchList.get(i).getCustomerList().get(j).isIsaccount())
                        branchList.get(i).getCustomerList().get(j).getAccount().displayBalance();
                    else System.out.println("No account found");
                    check = 1;
                    break;
                }
            }
        }
        if (check == 0) System.out.println("No customer found");
    }

    public void addBalance(Customer customer, int money) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName() == customer.getBranch()) {
                branchList.get(i).addBalance(customer, money);
                break;
            }
        }
    }

    public void withDrawBalance(Customer customer, int money) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName() == customer.getBranch()) {
                branchList.get(i).withDrawBalance(customer, money);
                break;
            }
        }
    }

    public void depositBalance(Customer customer1, Customer customer2, int money) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getName() == customer1.getBranch()) {
                branchList.get(i).withDrawBalance(customer1, money);
                if (branchList.get(i).iswithDrawBalance(customer1, money))
                    addBalance(customer2, money);
                break;
            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        BankingEX bankingEX = new BankingEX();
        Branch CauGiay = new Branch("CauGiay");
        bankingEX.addBranch(CauGiay);
        Branch XuanThuy = new Branch("XuanThuy");
        bankingEX.addBranch(XuanThuy);
        Customer Hung = new Customer("Hung", "0964481051", "03020594");
        Account AHung = new Account("123");
        Customer Hai = new Customer("Hai", "0987675847", "03026985");
        Account AHai = new Account("221");
        CauGiay.addCustomer(Hung);
        XuanThuy.addCustomer(Hai);
        CauGiay.addAccount(Hung, AHung);
        XuanThuy.addAccount(Hai, AHai);
        bankingEX.addBalance(Hung, 100);
        bankingEX.withDrawBalance(Hung, 50);
        bankingEX.depositBalance(Hung, Hai, 15);
        bankingEX.displayBalance(Hung);
        bankingEX.displayBalance(Hai);
        Customer Long = new Customer("Long", "0768493345", "123123");
        CauGiay.editCustomer(Hung, Long);
        System.out.println(Hung.getName());
        Branch Lang = new Branch("Lang","123 Duong Lang");
        bankingEX.editBranch(XuanThuy,Lang);
        System.out.println(Lang.address);
        CauGiay.removeCustomer(Hung);
        bankingEX.displayBalance(Hung);
        bankingEX.removeBranch(XuanThuy);
        bankingEX.displayBalance(Hai);
    }
}

