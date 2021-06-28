package com.company;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    public String name;
    public String address;
    private List<Account> accountList = new ArrayList<>();
    ;
    private List<Customer> customerList = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public Branch(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCustomer(Customer customer) {
        int check = 0;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdentitynumber() == customer.getIdentitynumber()) {
                check = 1;
                break;
            }
        }
        if (check == 0) {
            customerList.add(customer);
            customerList.get(customerList.size() - 1).setBranch(this.getName());
        } else System.out.println("Allready had customer");
    }

    public void removeCustomer(Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdentitynumber() == customer.getIdentitynumber()) {
                if (customerList.get(i).isIsaccount()) {
                    for (int j = 0; j < accountList.size(); j++) {
                        if (accountList.get(j).getID() == customerList.get(i).getAccount().getID()) {
                            accountList.remove(j);
                            break;
                        }
                    }
                }
                customerList.remove(i);
                break;
            }
        }
    }

    public void editCustomer(Customer customer, Customer newCustomer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdentitynumber() == customer.getIdentitynumber()) {
                customerList.get(i).setName(newCustomer.getName());
                customerList.get(i).setIdentitynumber(newCustomer.getIdentitynumber());
                customerList.get(i).setPhonenumber(newCustomer.getPhonenumber());
                break;
            }
        }
    }

    public void addAccount(Customer customer, Account account) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdentitynumber() == customer.getIdentitynumber()) {
                if (customerList.get(i).isIsaccount() == false) {
                    customerList.get(i).setAccount(account);
                    accountList.add(account);
                    customerList.get(i).setIsaccount(true);
                } else System.out.println("Allready had account");
                break;
            }
        }
    }

    public void addBalance(Customer customer, int money) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdentitynumber() == customer.getIdentitynumber()) {
                if (customerList.get(i).isIsaccount()) {
                    customerList.get(i).getAccount().addBalance(money);
                } else System.out.println("No accound found");
                break;
            } else System.out.println("No customer found");
        }
    }

    public void withDrawBalance(Customer customer, int money) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdentitynumber() == customer.getIdentitynumber()) {
                if (customerList.get(i).isIsaccount()) {
                    customerList.get(i).getAccount().withdrawBalance(money);
                } else System.out.println("No accound found");
                break;
            } else System.out.println("No customer found");
        }
    }

    public boolean iswithDrawBalance(Customer customer, int money) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdentitynumber() == customer.getIdentitynumber()) {
                if (customerList.get(i).isIsaccount()) {
                    if (customerList.get(i).getAccount().getBalance() >= money)
                        return true;
                }
                break;
            }
        }
        return false;
    }

}
