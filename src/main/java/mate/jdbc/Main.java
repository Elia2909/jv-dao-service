package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer renaultManufacturer = new Manufacturer("Renault", "France");
        Manufacturer toyotaManufacturer = new Manufacturer("BWM", "Germany");
        Manufacturer mercedesManufacturer = new Manufacturer("Mercedes", "Germany");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println(manufacturerService.create(renaultManufacturer));
        System.out.println(manufacturerService.create(mercedesManufacturer));
        System.out.println(manufacturerService.create(toyotaManufacturer));

        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.get(3L));

        mercedesManufacturer.setName("Mercedes Benz");
        System.out.println(manufacturerService.update(mercedesManufacturer));

        System.out.println(manufacturerService.delete(3L));

        List<Manufacturer> all = manufacturerService.getAll();
        System.out.println(all);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob", "123456");
        Driver john = new Driver("John", "7890123");
        System.out.println(driverService.create(bob));
        System.out.println(driverService.create(john));

        System.out.println(driverService.get(1L));

        bob.setName("Alice");
        System.out.println(driverService.update(bob));
        System.out.println(driverService.delete(1L));
        System.out.println(driverService.getAll());
    }
}
