package Tests;

import Model.Doctor;
import Service.Appointment;
import Service.AppointmentStrategy.SortByOpinion;
import Service.AppointmentStrategy.SortByTime;
import Service.Opinion;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SortingTests {

        @Test
        public void SortByOpinionTest() {

            List<Doctor> doctorsList = new ArrayList<>();

            Opinion[] opinions = {
                    new Opinion(1,""), new Opinion(2, ""),
                    new Opinion(3, ""), new Opinion(4, ""),
                    new Opinion(5, "")
            };

            // average = 2.67
            Doctor doc1 = new Doctor();
            doc1.setOpinion(opinions[2]);
            doc1.setOpinion(opinions[3]);
            doc1.setOpinion(opinions[0]);
            doc1.setDoctorId(1111);
            doctorsList.add(doc1);

            // average = 3.33
            Doctor doc2 = new Doctor();
            doc2.setOpinion(opinions[0]);
            doc2.setOpinion(opinions[4]);
            doc2.setOpinion(opinions[3]);
            doc2.setDoctorId(2222);
            doctorsList.add(doc2);

            // average = 4.67
            Doctor doc3 = new Doctor();
            doc3.setOpinion(opinions[4]);
            doc3.setOpinion(opinions[3]);
            doc3.setOpinion(opinions[4]);
            doc3.setDoctorId(3333);
            doctorsList.add(doc3);

            // average = 2.00
            Doctor doc4 = new Doctor();
            doc4.setOpinion(opinions[1]);
            doc4.setOpinion(opinions[0]);
            doc4.setOpinion(opinions[2]);
            doc4.setDoctorId(4444);
            doctorsList.add(doc4);

            // expected result
            List<Doctor> sortedDoctors = new ArrayList<>();
            sortedDoctors.add(doc3);
            sortedDoctors.add(doc2);
            sortedDoctors.add(doc1);
            sortedDoctors.add(doc4);

            doctorsList.sort(new SortByOpinion.DoctorCompareOpinion());

            assertEquals(sortedDoctors, doctorsList);

            sortedDoctors.remove(doc2);
            sortedDoctors.add(doc2);

            assertNotEquals(sortedDoctors, doctorsList);

        }

        @Test
        public void SortByTimeTest() {

            List<Appointment> appointmentsList = new ArrayList<>();
            LocalDate date = LocalDate.of(2023, 1, 24);

            Appointment app1 = new Appointment(date, LocalTime.of(16, 0), 0, "");
            Appointment app2 = new Appointment(date, LocalTime.of(14, 0), 0, "");
            Appointment app3 = new Appointment(date, LocalTime.of(17, 0), 0, "");
            Appointment app4 = new Appointment(date, LocalTime.of(15, 0), 0, "");
            Appointment app5 = new Appointment(date, LocalTime.of(10, 0), 0, "");
            Appointment app6 = new Appointment(date, LocalTime.of(11, 0), 0, "");
            Appointment app7 = new Appointment(date, LocalTime.of(14, 0), 0, "");
            Appointment app8 = new Appointment(date, LocalTime.of(9, 0), 0, "");
            Appointment app9 = new Appointment(date, LocalTime.of(11, 0), 0, "");
            Appointment app10 = new Appointment(date, LocalTime.of(10, 0), 0, "");

            appointmentsList.add(app1);
            appointmentsList.add(app2);
            appointmentsList.add(app3);
            appointmentsList.add(app4);
            appointmentsList.add(app5);
            appointmentsList.add(app6);
            appointmentsList.add(app7);
            appointmentsList.add(app8);
            appointmentsList.add(app9);
            appointmentsList.add(app10);

            // expected result
            List<Appointment> sortedAppointments = new ArrayList<>();
            sortedAppointments.add(app8);
            sortedAppointments.add(app5);
            sortedAppointments.add(app10);
            sortedAppointments.add(app6);
            sortedAppointments.add(app9);
            sortedAppointments.add(app2);
            sortedAppointments.add(app7);
            sortedAppointments.add(app4);
            sortedAppointments.add(app1);
            sortedAppointments.add(app3);

            appointmentsList.sort(new SortByTime.AppointmentSortByDate());

            assertEquals(sortedAppointments, appointmentsList);

            sortedAppointments.remove(app2);
            sortedAppointments.add(app2);

            assertNotEquals(sortedAppointments, appointmentsList);

        }

}
