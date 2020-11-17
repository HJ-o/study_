package org.edwith.webbe.cardmanager.ui;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class CardManagerUI {
    private BufferedReader in;

    private CardManagerUI(){
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static CardManagerUI instance = new CardManagerUI();

    public static CardManagerUI getInstance(){
        return instance;
    }

    public void printMainMenu(){
        System.out.println("------------------------");
        System.out.println("1. ���� �Է�");
        System.out.println("2. ���� �˻�");
        System.out.println("3. ����");
        System.out.println("------------------------");
        System.out.print("�޴��� �Է��ϼ��� : ");
    }

    public int getMenuNumber(){
        try {
            int menuNumber = Integer.parseInt(in.readLine());
            return menuNumber;
        }catch(Exception ex){
            return -1; // ���ڷ� ��ȯ ���� ��� -1�� �����Ѵ�.
        }
    }

    public BusinessCard inputBusinessCard(){
        try {
            System.out.print("�̸��� �Է��ϼ��� : ");
            String name = in.readLine();
            System.out.print("��ȭ��ȣ�� �Է��ϼ���. : ");
            String phone = in.readLine();
            System.out.print("ȸ�� �̸��� �Է��ϼ���. : ");
            String companyName = in.readLine();
            BusinessCard businessCard = new BusinessCard(name, phone, companyName);
            return businessCard;
        }catch(Exception ex){
            System.out.println("�߸��� ���� �Է��߽��ϴ�. ");
            return null;
        }
    }

    public String getSearchKeyword(){
        try {
            System.out.print("�˻��� �̸��� �Է��ϼ���. (like�˻�) : ");
            String searchKeyword = in.readLine();
            return searchKeyword;
        }catch(Exception ex){
            System.out.println("�߸��� ���� �Է��߽��ϴ�. ");
            return null;
        }
    }

    public void printBusinessCards(List<BusinessCard> businessCardList){
    	if(businessCardList.isEmpty()) {
    		System.out.println("��ġ�ϴ� ����� �����ϴ�!");
            System.out.println("---------------------------------------------------------------");
    	} else {
	        for(BusinessCard businessCard: businessCardList){
	            System.out.println(businessCard);
	            System.out.println("---------------------------------------------------------------");
        	}
    	}
    }

    public void printExitMessage(){
        System.out.println("���α׷��� �����մϴ�. :-) ");
    }

    public void printErrorMessage(){
        System.out.println("�߸��� �Է��Դϴ�.");
    }
}
