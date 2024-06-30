package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados da " + i + "a aula: ");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String name = sc.nextLine();
            if (ch == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int duration = sc.nextInt();
                list.add(new Video(name, url, duration));
            } else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                list.add(new Task(name, description, questionCount));
            }

            System.out.println();

        }

        System.out.println();

        int sum = 0;
        for (Lesson lesson : list) {
            sum += lesson.duration();
        }

        System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");

        sc.close();
    }

}