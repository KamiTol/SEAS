package SEAS.Model.Service;

import SEAS.Model.Domain.*;
import SEAS.Model.Repository.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ModuleService extends UnicastRemoteObject implements ModuleServiceInterface {

    private TicketRepository ticketRepository = new TicketRepository("FinalProyectSEAS/src/main/resources/json/tickets.json");
    private TrainRepository trainRepository = new TrainRepository("FinalProyectSEAS/src/main/resources/json/trains.json");
    private UserRepository userRepository = new UserRepository("FinalProyectSEAS/src/main/resources/json/users.json");
    private RouteRepository routeRepository = new RouteRepository("FinalProyectSEAS/src/main/resources/json/routes.json");
    private ScheduleRepository scheduleRepository = new ScheduleRepository("FinalProyectSEAS/src/main/resources/json/schedules.json");

    public ModuleService() throws RemoteException {
        super();
    }

    @Override
    public boolean buyTicket(Ticket ticket) {
        return ticketRepository.insert(ticket);
    }

    @Override
    public boolean searchTicket(String idTicket) {
        return ticketRepository.getTicket(idTicket) != null;
    }

    @Override
    public boolean addTrain(Train train) {
        return trainRepository.insert(train);
    }

    @Override
    public boolean removeTrain(String idTrain) {
        return trainRepository.delete(idTrain);
    }

    @Override
    public boolean editTrain(Train train) {
        return trainRepository.update(train);
    }

    @Override
    public List<Train> getTrains() {
        return trainRepository.getTrains();
    }

    @Override
    public boolean addUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public boolean deleteUser(String idUser) {
        return userRepository.delete(idUser);
    }

    @Override
    public boolean editUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public boolean addRoute(Route route) throws Exception {
        return routeRepository.insert(route);
    }

    @Override
    public boolean removeRoute(Route route) throws Exception {
        return routeRepository.delete(route.getStart(), route.getEnd());
    }

    @Override
    public boolean editRoute(Route route) throws Exception {
        return routeRepository.update(route);
    }

    @Override
    public List<Route> getRoutes() throws Exception {
        return routeRepository.getRoutes();
    }

    @Override
    public boolean login(String user, String password) {
        User foundUser = userRepository.getUser(user);
        return foundUser != null && foundUser.getPassword().equals(password);
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleRepository.getSchedules();
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        return scheduleRepository.insert(schedule);
    }
    @Override
    public boolean removeSchedule(String idSchedule) {
        return scheduleRepository.delete(idSchedule);
    }
    @Override
    public boolean updateScheduleDepartureDate(Schedule schedule, String newDate) {
        schedule.setDepartureDate(newDate);
        return scheduleRepository.update(schedule);
    }

    public boolean checkBaggageWeight(Baggage baggage) {
    final double MAX_ALLOWED_WEIGHT = 50.0;
    return baggage.getWeight() <= MAX_ALLOWED_WEIGHT;
    }
}

