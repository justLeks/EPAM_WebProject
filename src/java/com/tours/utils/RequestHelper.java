package com.tours.utils;

import com.tours.commands.AddTourCommand;
import com.tours.commands.AddTourPageCommand;
import com.tours.commands.AllToursPageCommand;
import com.tours.commands.Command;
import com.tours.commands.DangerousCommand;
import com.tours.commands.DashboardPageCommand;
import com.tours.commands.ExcursionPageCommand;
import com.tours.commands.ShoppingPageCommand;
import com.tours.commands.VacationPageCommand;
import com.tours.commands.ErrorCommand;
import com.tours.commands.LangENCommand;
import com.tours.commands.LangUACommand;
import com.tours.commands.LoginCheckCommand;
import com.tours.commands.LoginPageCommand;
import com.tours.commands.LogoutCommand;
import com.tours.commands.MainPageCommand;
import com.tours.commands.OrderTourCommand;
import com.tours.commands.PersonalRoomPageCommand;
import com.tours.commands.RegisterCommand;
import com.tours.commands.RegisterPageCommand;
import com.tours.commands.ShowOrdersCommand;
import com.tours.commands.TourConfirmCommand;
import com.tours.commands.TourPayCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class RequestHelper {

    private static RequestHelper instance = null;
    private HashMap<String, Command> commands = new HashMap<>();

    private RequestHelper() {
        commands.put("mainPage", new MainPageCommand());
        commands.put("vacationPage", new VacationPageCommand());
        commands.put("excursionPage", new ExcursionPageCommand());
        commands.put("shoppingPage", new ShoppingPageCommand());
        commands.put("loginPage", new LoginPageCommand());
        commands.put("registerPage", new RegisterPageCommand());
        commands.put("loginCheckCommand", new LoginCheckCommand());
        commands.put("dashboardPage", new DashboardPageCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("register", new RegisterCommand());
        commands.put("addTourPage", new AddTourPageCommand());
        commands.put("addTour", new AddTourCommand());
        commands.put("order", new OrderTourCommand());
        commands.put("allToursPage", new AllToursPageCommand());
        commands.put("showOrders", new ShowOrdersCommand());
        commands.put("english", new LangENCommand());
        commands.put("ukrainian", new LangUACommand());
        commands.put("room", new PersonalRoomPageCommand());
        commands.put("pay", new TourPayCommand());
        commands.put("confirm", new TourConfirmCommand());
        commands.put("exception", new DangerousCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        Command command = commands.get(action);
        if (command == null) {
            command = new ErrorCommand();
        }
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }
}
