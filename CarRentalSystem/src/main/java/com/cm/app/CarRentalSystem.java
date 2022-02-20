package com.cm.app;

import com.cm.app.model.CarRental;
import com.cm.app.model.Customer;
import com.cm.app.model.Rental;
import com.cm.app.model.Vehicle;
import com.cm.app.services.CsvReader;
import com.cm.app.services.CsvWriter;
import com.cm.app.services.RentalsMapper;
import com.cm.app.services.VehiclesMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRentalSystem {
    public static void main(String[] args) throws IOException {
        CsvReader csvReader = new CsvReader();
        CsvWriter csvWriter = new CsvWriter();
        RentalsMapper rentalsMapper = new RentalsMapper();
        VehiclesMapper vehiclesMapper = new VehiclesMapper();

        List<List<String>> rawVehicles = csvReader.readFromPath("src/main/resources/vehicles.csv");
        List<Vehicle> vehicles = vehiclesMapper.mapFrom(rawVehicles);
        List<Rental> rentals = new ArrayList<>(Arrays.asList());

        Vehicle bmw = new Vehicle(3, "BMW", "X", 5, "123IOP");
        Customer john = new Customer("12345678XYZ", "John", "Smith");
        Customer marie = new Customer("12345678ABC", "Marie", "Smith");
        Customer peter = new Customer("12345678QWE", "Peter", "Smith");
        List<Customer> customers = new ArrayList(Arrays.asList(john, marie, peter));

        CarRental carRental = new CarRental(vehicles, customers, rentals);

        carRental.addNewRental(new Rental(john, bmw, LocalDate.of(2022, 1, 15), LocalDate.of(2022, 1, 19)));
        carRental.addNewRental(new Rental(marie, bmw, LocalDate.of(2022, 2, 15), LocalDate.of(2022, 3, 19)));

        exportRentalsCsv(csvWriter, rentalsMapper, carRental);
    }

    private static void exportRentalsCsv(CsvWriter csvWriter, RentalsMapper rentalsMapper, CarRental carRental) throws IOException {
        List<List<String>> rawRentals = rentalsMapper.mapToRaw(carRental.getRentals());
        csvWriter.writeToCsvFile(rawRentals, new File("src/main/resources/exported-rentals.csv"));
    }

}
