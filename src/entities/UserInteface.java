package entities;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInteface {

    private ReservationSystem reservationSystem = new ReservationSystem();

    public void start(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1. Fazer Reserva");
            System.out.println("2. Ver Reserva");
            System.out.println("3. Cancelar Reserva ");
            System.out.println("4. Sair");

            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    String name = sc.nextLine();
                    System.out.println("Data: ");
                    String date = sc.nextLine();
                    System.out.println("Número de Hóspedes: ");
                    int numberOfGuests = sc.nextInt();
                    sc.nextLine();

                    Reservation reservation = reservationSystem.makeReservation(name, date, numberOfGuests);
                    System.out.println("Reserva feita com ID " + reservation.getId());
                    break;
                case 2:
                    System.out.println("Reservas:");
                    for (Reservation r : reservationSystem.getReservations()) {
                        System.out.println(r.getId());
                    }
                    break;
                case 3:
                    System.out.println("Cancelar Reserva por ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (reservationSystem.cancelReservation(id)) {
                        System.out.println("Reserva cancelada");
                    } else {
                        System.out.println("Reserva não encontrada");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Escolha inválida");
            }
            System.out.println();

        }

    }
}
