package com.zinabadinov.jdbclab4.view;

import com.zinabadinov.jdbclab4.controller.*;
import com.zinabadinov.jdbclab4.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.events.Event;

import java.util.*;

@Component
public class MyView {
    @Autowired
    private sold_energyController soldEnergyController;

    @Autowired
    private solar_stationController solarStationController;

    @Autowired
    private panel_angelsController panelAngelsController;

    @Autowired
    private panelController panelController;

    @Autowired
    private owner_sController ownerSController;

    @Autowired
    private instalation_dateController instalationDateController;

    @Autowired
    private electricity_priceController electricityPriceController;

    @Autowired
    private battary_chargeController battaryChargeController;

    @Autowired
    private amount_of_stationController amountOfStationController;

    //private final Map<String,String> menu;

    //private final Map<String,PrintTable> methodsMenu;

    private final Scanner input = new Scanner(System.in);

    private final sold_energy nullSoldEnergy = new sold_energy(null,null,null);

    public MyView() {
        /*menu = new LinkedHashMap<>();
        menu.put("A", " A - Select all table");
        menu.put("1", " 11 - Create sold_energy");
        menu.put("2", " 12 - Update sold_energy");
        menu.put("3", " 13 - Delete from sold_energy");
        menu.put("4", " 14 - Find all sold_energy");
        menu.put("5", " 15 - Find sold_energy by ID");
        menu.put("Q", "Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("11",this::createSoldEnergy);
        methodsMenu.put("12",this::createsoldenergy);
        methodsMenu.put("13",this::createsoldenergy);
        methodsMenu.put("14",this::createsoldenergy);
        methodsMenu.put("15",this::createsoldenergy);*/
    }

    public void printAllTables() {
        System.out.println("\n_____________All__soldEnergy___________________________\n");
        List<sold_energy> workers = soldEnergyController.findAll();
        workers.forEach(System.out::println);

        System.out.println("\n_____________All__solarStation____________________________\n");
        List<solar_station>  workers0 = solarStationController.findAll();
        workers0.forEach(System.out::println);

        System.out.println("\n_____________All__panelAngels___________________________\n");
        List<panel_angels>  workers1 = panelAngelsController.findAll();
        workers1.forEach(System.out::println);

        System.out.println("\n_____________All__panel___________________\n");
        List<panel> workers2 = panelController.findAll();
        workers2.forEach(System.out::println);

        System.out.println("\n_____________All__ownerSController____________________________\n");
        List<owner_s>  workers3 = ownerSController.findAll();
        workers3.forEach(System.out::println);

        System.out.println("\n_____________All__instalationDateController____________________\n");
        List<instalation_date>  workers4 = instalationDateController.findAll();
        workers4.forEach(System.out::println);

        System.out.println("\n_____________All__electricityPriceController_____________\n");
        List<electricity_price> workers5 = electricityPriceController.findAll();
        workers5.forEach(System.out::println);

        System.out.println("\n_____________All__battaryChargeController____________________\n");
        List<battary_charge> workers6 = battaryChargeController.findAll();
        workers6.forEach(System.out::println);

        System.out.println("\n_____________All__amountOfStationController___________\n");
        List<amount_of_station> workers7 = amountOfStationController.findAll();
        workers7.forEach(System.out::println);


    }
    private void printMenu() {
        System.out.print(
                "___________________MY___PROGRAM________________________\n"+
                        "| 1- print all tables\n" +
                        "| 2- select specific table \n" +
                        "| q- stop program\n" +
                        "--------------------------------------------------------\n" +
                        "Select action \n>>>"
        );
    }

    private void printTables() {
        System.out.print(
                "___________________MY___PROGRAM________________________\n"+
                        "| 3- select sold_energy\n" +
                        "| 4- select solarStation\n" +
                        "| 5- select panelAngels\n" +
                        "| 6- select panel\n" +
                        "| 7- select owner_s\n" +
                        "| 8- select instalationDate\n" +
                        "| 9- select electricityPrice\n" +
                        "| 10- select battaryCharge\n" +
                        "| 11- select amountOfStation\n" +
                        "| 12- main menu\n" +
                        "--------------------------------------------------------\n" +
                        "Select action \n>>>"
        );
    }

    private void printTableFun(String table) {
        System.out.print(
                "___________________"+ table +"________________________\n"+
                        "| 3.3- create new item\n" +
                        "| 3.4- print table\n" +
                        "| 3.5- delete item\n" +
                        "| 3.6- find item by id\n" +
                        "| 3.7- update item\n" +
                        "| 3.8- main menu\n" +
                        "--------------------------------------------------------\n" +
                        "Select action \n>>>"
        );
    }

    private void createUpdateItem(GeneralController gc, boolean isCreate) {
        if(isCreate)
            System.out.println("\n________________create_________________");
        else
            System.out.println("\n________________update_________________");
        if(gc instanceof sold_energyController) {
            createSoldEnergy(isCreate);
        }else if(gc instanceof solar_stationController){
            createSolarStation(isCreate);
        }else if(gc instanceof panel_angelsController){
            createPanelAngels(isCreate);
        }else if(gc instanceof panelController){
            createPanel(isCreate);
        }else if(gc instanceof owner_sController){
            createOwner(isCreate);
        }else if(gc instanceof instalation_dateController) {
            createInstalationDate(isCreate);
        }else if(gc instanceof electricity_priceController){
            createElectricityPrice(isCreate);
        }else if(gc instanceof battary_chargeController) {
            createBattaryCharge(isCreate);
        }else if(gc instanceof amount_of_stationController) {
            createAmountOfStation(isCreate);
        } else {
            System.out.println("\n-----------incorect-input-------------\n");
        }
    }

    private void printTable(GeneralController gc) {
        System.out.println("\n________________print________________\n");
        var list = gc.findAll();
        list.forEach(System.out::println);
    }


    private void deleteItem(GeneralController gc) {
        System.out.print("\n________________delete________________\nEnter id \n>>>");
        Integer id = Integer.parseInt(input.nextLine());
        int res = gc.delete(id);
        System.out.println("________________affected_" + res + "_rows____________");
    }

    private void findItemById(GeneralController gc) {
        System.out.print("\n________________find________________\nEnter id \n>>>");
        Integer id = Integer.parseInt(input.nextLine());
        Optional res = gc.findById(id);
        if(res.isPresent()) {
            System.out.println(res.get());
        }else {
            System.out.println("\n__________item_does_not_exist______\n");
        }
    }

    private void selectTable() {
        String table = input.nextLine();
        GeneralController gc;
        if(table.equals("3")) {
            gc = soldEnergyController;
            table = "soldEnergy";
        }else if (table.equals("4")) {
            gc = solarStationController;
            table = "solarStation";
        } else if(table.equals("5")) {
            gc = panelAngelsController;
            table = "panelAngels";
        } else if(table.equals("6")) {
            gc = panelController;
            table = "panel";
        } else if(table.equals("7")) {
            gc = ownerSController;
            table = "owner_s";
        } else if(table.equals("8")) {
            gc = instalationDateController;
            table = "instalationDate";
        } else if(table.equals("9")) {
            gc = electricityPriceController;
            table = "electricityPrice";
        } else if(table.equals("10")) {
            gc = battaryChargeController;
            table = "battaryCharge";
        } else if(table.equals("11")) {
            gc = amountOfStationController;
            table = "amountOfStation";
        }
        else {
            System.out.println("\n-----------incorect-input-------------\n");
            return;
        }
        String chose;
        do {
            printTableFun(table);
            chose = input.nextLine();
            if(chose.equals("3.3")) {
                createUpdateItem(gc, true);
            } else if(chose.equals("3.4")) {
                printTable(gc);
            } else if(chose.equals("3.5")) {
                deleteItem(gc);
            } else if (chose.equals("3.6")) {
                findItemById(gc);
            } else if (chose.equals("3.7")) {
                createUpdateItem(gc, false);
            }
        }while (!chose.equalsIgnoreCase("3.8"));
    }

    public void show() {
        String str;
        do {
            printMenu();
            str = input.nextLine();
            if(str.equals("1")) {
                printAllTables();
            } else if(str.equals("2")) {
                printTables();
                selectTable();
            }
        } while (!str.equalsIgnoreCase("q"));
    }

    private void createSoldEnergy(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'amount_of_sold_energy': ");
        Integer amountOfSoldEnergy = Integer.parseInt(input.nextLine());
        System.out.println("Input 'solar_station_id': ");
        Integer solarStationId = Integer.parseInt(input.nextLine());
        sold_energy soldEnergy = new sold_energy(0,amountOfSoldEnergy,solarStationId);

        if(isCreate) {
            System.out.println("Created SoldEnergy\n" + soldEnergy);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? soldEnergyController.create(soldEnergy) : soldEnergyController.update(id, soldEnergy);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createSolarStation(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'country': ");
        String country = input.nextLine();
        System.out.println("Input 'type_station': ");
        String type_station = input.nextLine();
        System.out.println("Input 'capacity': ");
        Integer capacity = Integer.parseInt(input.nextLine());
        solar_station solarStation = new solar_station(0,country,type_station,capacity);

        if (isCreate) {
            System.out.println("Created solar_station\n" + solarStation);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? solarStationController.create(solarStation) : solarStationController.update(id, solarStation);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createPanelAngels(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'tilt': ");
        Integer tilt = Integer.parseInt(input.nextLine());
        System.out.println("Input 'panel_id': ");
        Integer panel_id = Integer.parseInt(input.nextLine());
        panel_angels panelAngels = new panel_angels(0,tilt,panel_id);

        if (isCreate) {
            System.out.println("Created PanelAngels\n" + panelAngels);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? panelAngelsController.create(panelAngels) : panelAngelsController.update(id, panelAngels);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createPanel(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'amount_of_panel': ");
        Integer amount_of_panel = Integer.parseInt(input.nextLine());
        System.out.println("Input 'solar_station_id': ");
        Integer solar_station_id = Integer.parseInt(input.nextLine());
        panel panel = new panel(0,amount_of_panel,solar_station_id);

        if (isCreate) {
            System.out.println("Created panel\n" + panel);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? panelController.create(panel) : panelController.update(id, panel);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createOwner(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'surname': ");
        String surname = input.nextLine();
        owner_s owner = new owner_s(0,name,surname);

        if (isCreate) {
            System.out.println("Created panel\n" + owner);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? ownerSController.create(owner) : ownerSController.update(id, owner);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createInstalationDate(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'ins_date': ");
        String ins_date = input.nextLine();
        System.out.println("Input 'solar_station_id': ");
        Integer solar_station_id = Integer.parseInt(input.nextLine());
        instalation_date instalationDate = new instalation_date(0,ins_date,solar_station_id);

        if (isCreate) {
            System.out.println("Created panel\n" + instalationDate);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? instalationDateController.create(instalationDate) : instalationDateController.update(id, instalationDate);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createElectricityPrice(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'price': ");
        Integer price = Integer.parseInt(input.nextLine());
        System.out.println("Input 'solar_station_id': ");
        Integer solar_station_id = Integer.parseInt(input.nextLine());
        electricity_price electricity_price = new electricity_price(0,price,solar_station_id);

        if (isCreate) {
            System.out.println("Created panel\n" + electricity_price);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? electricityPriceController.create(electricity_price) : electricityPriceController.update(id, electricity_price);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createBattaryCharge(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'type_of_charge': ");
        String type_of_charge = input.nextLine();
        System.out.println("Input 'solar_station_id': ");
        Integer solar_station_id = Integer.parseInt(input.nextLine());
        battary_charge battaryCharge = new battary_charge(0,type_of_charge,solar_station_id);

        if (isCreate) {
            System.out.println("Created panel\n" + battaryCharge);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? battaryChargeController.create(battaryCharge) : battaryChargeController.update(id, battaryCharge);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

    private void createAmountOfStation(boolean isCreate){
        Integer id = 0;
        System.out.println("Input 'amount': ");
        Integer amount = Integer.parseInt(input.nextLine());
        System.out.println("Input 'owner_s_id': ");
        Integer owner_s_id = Integer.parseInt(input.nextLine());
        amount_of_station amountOfStation = new amount_of_station(0,amount,owner_s_id);

        if (isCreate) {
            System.out.println("Created panel\n" + amountOfStation);
        } else {
            System.out.print("id\n>>>");
            id = Integer.parseInt(input.nextLine());
        }

        int res = isCreate ? amountOfStationController.create(amountOfStation) : amountOfStationController.update(id, amountOfStation);
        System.out.println("\n________________affected_" + res + "_rows____________");
    }

}
