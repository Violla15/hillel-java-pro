package ua.ithillel.homeworks.homework18.convert;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ua.ithillel.homeworks.homework18.entity.Car;
import ua.ithillel.homeworks.homework18.entity.CarsWrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConvertCarToXML {

    public void convertCarToXml(List<Car> cars, String filePath) {
        List<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() != null) {
                carList.add(car);
            }
        }
        CarsWrapper wrapperCar = new CarsWrapper();
        wrapperCar.setCars(carList);

        try {
            JAXBContext context = JAXBContext.newInstance(Car.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(wrapperCar, new File(filePath));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
