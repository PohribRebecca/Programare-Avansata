import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);

        Hospital H0 = new Hospital("H0", 1);
        Hospital H1 = new Hospital("H1", 2);
        Hospital H2 = new Hospital("H2", 2);
        System.out.println(H0);
        System.out.println(H1);
        System.out.println(H2);


        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));
        for (Resident res : r) {
            System.out.println(res);
        }

        Collections.sort(residentList, Comparator.comparing(Resident::getName));
        Set<Hospital> hospitals = new TreeSet<Hospital>();

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        List<Hospital> prefList = new ArrayList<>();
        prefList.add(H0);
        prefList.add(H1);
        prefList.add(H2);
        resPrefMap.put(r[0], prefList);

        List<Hospital> prefList1 = new ArrayList<>();
        prefList1.add(H0);
        prefList1.add(H1);
        prefList1.add(H2);
        resPrefMap.put(r[1], prefList1);

        List<Hospital> prefList2 = new ArrayList<>();
        prefList2.add(H0);
        prefList2.add(H1);
        resPrefMap.put(r[2], prefList2);

        List<Hospital> prefList3 = new ArrayList<>();
        prefList3.add(H0);
        prefList3.add(H2);
        resPrefMap.put(r[3], prefList3);

        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>();
        hosPrefMap.put(H0, Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(H1, Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(H2, Arrays.asList(r[0], r[1], r[3]));

        System.out.println("Residentii care prefera H0 sunt:");
        residentList.stream().filter(res -> resPrefMap.get(res).contains(H0)).forEach(System.out::println);


        List<Hospital> target = Arrays.asList(H0, H2);
        List<Resident> result = residentList.stream().filter(res->resPrefMap.get(res).containsAll(target)).collect(Collectors.toList());

        System.out.println("Residentii care prefera H0 si H2 sunt:");

        for(Resident R : result)
        {
            System.out.println(R);
        }

       /* List<Hospital> resultatR0 = hospitals.stream().filter(hos->hosPrefMap.get(hos).contains(r[0])).collect(Collectors.toList());

        System.out.println("Spitalele care il prefera pe R0 pe primul loc sunt");
        for (Hospital h:resultatR0)
        {
            if(hosPrefMap.get(0)==r[0])
                System.out.println(h);
        }

        for(Map.Entry entry: hosPrefMap.entrySet() )
        {
            if(entry.getValue().get(0)==r[0])
                System.out.println(entry);
        }
       //pentru ultima cerinta am incercat mai multe modalitati de a accesa residentul de pe primul loc, insa nu am reusit si sincer nici nu inteleg ce nu fac bine.
*/


    }


}
