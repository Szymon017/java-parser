package szymon017.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] list_of_files = {"src/main/java/szymon017/parser/files/GOAP_Utility_TeamData.txt", "src/main/java/szymon017/parser/files/GOAP_StateMachine_TeamData.txt", "src/main/java/szymon017/parser/files/Utility_StateMachine_TeamData.txt"};
        String[] list_of_names = {"GOAP vs Utility AI - GOAP", "GOAP vs Utility AI - Utility AI", "GOAP vs State Machine - GOAP", "GOAP vs State Machine - State Machine", "State Machine vs Utility AI - Utility AI", "State Machine vs Utility AI - State Machine"};
        String[] list_of_teams = {"Team: GOAP", "Team: Utility AI","Team: GOAP", "Team: State Machine", "Team: Utility AI", "Team: State Machine"};


        File file1 = new File(list_of_files[2]);
        Scanner sc = new Scanner(file1);

        String FIRST_TEAM = list_of_teams[5];
        String filename = list_of_names[5];

        ArrayList<Data> array = new ArrayList<>();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".txt"));

        int round = 1;
        boolean active_round = true;

        while (sc.hasNextLine()) {
            active_round = true;
            Data model_data = new Data();



            while (active_round) {
                if(sc.hasNextLine()){
                    String line = sc.nextLine();

                if (line.contains("Round")) {
                    model_data.setRound(String.valueOf(round));
                    round++;
                }

                if(line.isEmpty()){
                    active_round = false;
                    array.add(model_data);
                }

                if (line.contains(FIRST_TEAM)) {
                    if (line.contains("Alive Units: ")) {
                        model_data.setAlive_units(Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1)));
                    }
                    if (line.contains("Dead Units: ")) {
                        model_data.setDead_units((Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1))));
                    }
                    if (line.contains("Avarage HP: ")) {
                        String hp_string = line.substring(line.lastIndexOf(" ") + 1);
                        hp_string = hp_string.replace(",",".");
                       model_data.setAverage_hp((Double.parseDouble(hp_string)));
                    }
                    if (line.contains("Health picked ")) {
                        model_data.setHealth_picked((Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1))));
                    }
                    if (line.contains("Evades ")) {
                        model_data.setEvades((Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1))));
                    }
                    if (line.contains("Attacks ")) {
                        model_data.setAttacks((Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1))));
                    }
                }
                    if (line.contains("Time of battle: ")) {
                        String time = line.substring(line.lastIndexOf(":") + 1, line.lastIndexOf(" ") - 1);
                        time = time.replace(",",".");
                        double time_d = Double.parseDouble(time);

                        model_data.setTime_of_battle((time_d));
                    }
                }
            }
        }
        String file_data = "round;alive_units;dead_units;average_hp;evades;attacks;health_picked;round_time\n";
        for (Data object:array) {
            file_data += object.getRound() + ";" + object.getAlive_units() + ";" + object.getDead_units() + ";" + object.getAverage_hp() + ";" + object.getEvades() + ";" + object.getAttacks() + ";" + object.getHealth_picked() + ";" + object.getTime_of_battle() + "\n";
        }
        writer.write(file_data);
        writer.close();
    }
}