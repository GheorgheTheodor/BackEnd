import java.util.*;

public class PickRandPers {
    public static void main(String[] args) {

        LinkedHashMap<String, Float> peopleprobability = new LinkedHashMap<String, Float>();
        ArrayList<String> people = new ArrayList<>(Arrays.asList("isuf.muca@crystal-system.eu",
                "danjel.halili@crystal-system.eu",
                "flavio.lorenci@crystal-system.eu",
                "elia.omeri@crystal-system.eu",
                "ardit.elezi@crystal-system.eu",
                "luka.buziu@crystal-system.eu",
                "megi.lala@crystal-system.eu",
                "irena.shahini@crystal-system.eu",
                "indrit.vaka@crystal-system.eu",
                "griselda.muci@crystal-system.eu",
                "theodor.gheorghe@crystal-system.eu",
                "ioan.cocianu@crystal-system.eu",
                "teofil.mitrea@crystal-system.eu",
                "eduard.tiutiu@crystal-system.eu",
                "george.dobrota@crystal-system.eu",
                "stefanita.plesa@crystal-system.eu",
                "adrian-nicolae.tigau@crystal-system.eu",
                "emanuel.grabovschi@crystal-system.eu",
                "george.sirbu@crystal-system.eu",
                "andrei.state@crystal-system.eu",
                "florin-adrian.dumitru@crystal-system.eu",
                "victor.hincu@crystal-system.eu"));

        float equalProb = (float) 100 / people.size();
        for (int i = 0; i < people.size(); i++) {
            peopleprobability.put(people.get(i), equalProb * (i + 1));

        }


        ArrayList<String> listselPeople = new ArrayList<String>();
        String selectedPeople = "";
        Scanner txt = new Scanner(System.in);
        System.out.println("Type anything to get random people or type exit to end the program.");

        while (!txt.nextLine().equals("exit")) {


            float random = (float) (0 + Math.random() * (100 - 0));
            float antVal = 0;
            float addVal = 0;

            for (Map.Entry<String, Float> entry : peopleprobability.entrySet()) {
                if (random <= entry.getValue()) {
                    if (!entry.getKey().equals(selectedPeople)) {
                        System.out.println(entry.getKey());
                        selectedPeople = entry.getKey();
                        addVal = ((entry.getValue() - antVal) / 2) / people.size() - 1;
                        for (Map.Entry<String, Float> entry1 : peopleprobability.entrySet()) {
                            if (entry1.getKey().equals(selectedPeople)) {
                                peopleprobability.put(entry1.getKey(), (antVal + entry.getValue()) / 2);
                            } else {
                                peopleprobability.put(entry1.getKey(), entry1.getValue() + addVal);
                            }
                        }
                        listselPeople.add(selectedPeople);
                        System.out.println("List of selected people in order: " + listselPeople);
                        System.out.println("Type anything to get random people or type exit to end the program.");
                        break;
                    }
                } else {
                    antVal = entry.getValue();
                }
            }

        }
    }
}