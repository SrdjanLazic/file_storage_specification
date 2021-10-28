package rs.edu.raf.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {
        FileStorage fileStorage = new LocalFileStorageImplementation();
        //Scanner input =  new Scanner(System.in);
        //String command = input.nextLine();

        //fileStorage.list();

        //fileStorage.move("D:/skladiste/hello.txt", "D:/");

        //fileStorage.list(".txt", Operations.FILTER_EXTENSION);

        //fileStorage.list("fajl", Operations.FILTER_FILENAME);
//        fileStorage.list(null, Operations.SORT_BY_DATE_MODIFIED_ASC);
//        fileStorage.list(null, Operations.SORT_BY_DATE_MODIFIED_DESC);
//        fileStorage.list(null, Operations.SORT_BY_NAME_ASC);
//        fileStorage.list(null, Operations.SORT_BY_NAME_DESC);


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(fileStorage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


//        while (true){
//            System.out.println("Izaberite jednu od opcija:\n");
//            System.out.println("1. Kreiranje direktorijuma i praznih fajlova");
//            System.out.println("2. Smestanje jednog ili vise fajlova");
//            System.out.println("3. Brisanje direktorijuma i fajlova iz skladista");
//            System.out.println("4. Pregled sadrzaja skladista");
//            System.out.println("5. Premestanje fajlova iz jednog direktorijuma u drugi");
//            System.out.println("6. Preuzimanje fajlova iz skladista\n");
//            System.out.println("Unesi broj opcije:\n");
//
//            String option = input.nextLine();
//            switch (option){
//                case "4":
//                    System.out.println("Izaberite jednu od opcija:\n");
//                    System.out.println("1. Vrati sve nazive fajlova u direktorijumu");
//
//
//            }
//
//        }
    }

}
