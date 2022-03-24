package twisk.outils;

import java.io.*;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class KitC {


    public KitC(){

    }

    private void copier(InputStream source, File dest) throws IOException{
        InputStream sourceFile = source;
        OutputStream destinationFile = new FileOutputStream(dest);

        // Lecture par segment de 0.5Mo
        byte buffer [] = new byte[512*1024];
        int nbLecture;
        while((nbLecture = sourceFile.read(buffer)) != -1){
            destinationFile.write(buffer, 0, nbLecture);
        }
        destinationFile.close();
        sourceFile.close();
    }

    /**
     * fonction qui cree un repertoire et recopie les fichiers ressources
     */
    public void creerEnvironnement(){
        try{
            //Creation du repertoire twisk /tmp
            Path directories = Files.createDirectories(Paths.get("tmp/twisk"));
            // Copie des fichiers depuis le projet sous /tmp/twisk
            String [] liste = {"programmeC.o", "def.h", "codeNatif.o"};

            for(String nom: liste){
                /*InputStream source = getClass().getResource("/codeC/"+nom).openStream();
                File destination = new File("/tmp/twisk/"+nom);
                copier(source, destination);*/
                Path source = Paths.get(getClass().getResource("/codeC/"+nom).getPath());
                Path newdir = Paths.get("tmp/twisk/");
                Files.copy(source, newdir.resolve(source.getFileName()), REPLACE_EXISTING);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public void creerFichier(String codeC){
        try {
            System.out.println("here");
            File file = new File("tmp/twisk/client.c");
            FileWriter flot = new FileWriter(file);;
            BufferedWriter flotFiltre = new BufferedWriter(flot);
            flotFiltre.write(codeC);
            flotFiltre.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void compiler(){

        try{
            String commande = "gcc -Wall -fPIC -c tmp/twisk/client.c -o tmp/twisk/client.o";
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec(commande);
            BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String ligne;
            while((ligne = output.readLine()) != null){
                System.out.println(ligne);
            }
            while((ligne = error.readLine()) != null){
                System.out.println(ligne);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void construireLibrairie(){
        try {
            String commande = "gcc -shared tmp/twisk/programmeC.o tmp/twisk/codeNatif.o" +
                    " tmp/twisk/client.o -o tmp/twisk/libTwisk.so";
            Runtime runtime = Runtime.getRuntime();
            Process p;
            p = runtime.exec(commande);
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
