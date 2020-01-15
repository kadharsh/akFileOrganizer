import java.io.File;
import java.util.*;
import java.nio.file.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;

public class fileSorter
{
  //public static String dir   // = "C:\\Users\\adharsh\\Desktop\\downloads\\";                ///get this from gui
  public  String typs[] = new String[]{"Images","Docs","Videos","Music","Others"};//Catogory
  public  ArrayList<ArrayList<String>> ext = new ArrayList<ArrayList<String>>();
  public ArrayList<String> imgExt   = new ArrayList<>(); ///get this from gui
  public ArrayList<String> docExt   = new ArrayList<>(); ///get this from gui
  public ArrayList<String> vidExt   = new ArrayList<>(); ///get this from gui
  public ArrayList<String> musicExt = new ArrayList<>();
    
 void addItems(String imgext, String docext, String vidext, String musicext){        //adding extention list to main list
     
    for(String curExt : imgext.split(" ")){
      
      imgExt.add(curExt);
    }
    for(String curExt : vidext.split(" ")){
      vidExt.add(curExt);
    }
    for(String curExt : docext.split(" ")){
      docExt.add(curExt);
    }
    for(String curExt : musicext.split(" ")){
      musicExt.add(curExt);
    }
     ext.add(imgExt); 
     ext.add(docExt);
     ext.add(vidExt);
     ext.add(musicExt);
  }
////////////To create folders///////////////////////////////
   void createFile(String dir)
  {
    for(int var=0;var<(typs.length);var++)
    {
     File file = new File( dir + typs[var]); //to create file names in typs[] to directory dir
     System.out.println(dir + typs[var] );
     if(!file.exists())
       file.mkdirs();                        //creating the folders
    }
  }
///////////Listing elements in folder////////////////////////////////////
  public  ArrayList<File> contents =new ArrayList<File>();
  void listFile(String dir)
  {
    File diroctory = new File(dir);
    File[] files = diroctory.listFiles();  //listing files in directory
    for (File f : files){
      if(!(f.isDirectory() ))
      contents.add(f);                     //creating array with items in directory
      }
  } 
 ////////////sorting to the desierd folder////////////////////////////////////
  
  void sorter(String dir)
  { 
     
    for(File element:contents)             //looping through elements in the folder
    { 
       boolean moved = false;              //To check if moved Alredy
       String str = new String (element.toString());
       for(int i=0;i<ext.size();i++)
            if(!moved){
             for(int j=0; j< (ext.get(i).size());j++) 
               {  //checks if the file matches the catogory or has the extention
                if( str.endsWith(ext.get(i).get(j)) && !moved ) 
                { 
                 Path path1 = Paths.get(str);
                 Path filename = path1.getFileName();
                 Path path2 = Paths.get(( dir + typs[i]+"\\"+ filename )); //setting the desierd location
                 try{
                    Files.move(path1,path2);      //moving to the desiers location
                    moved = true;
                    System.out.println("moved "+filename);
                 }catch(IOException e){
                  /* e.printStackTrace();*/}
             }
            }
           } if(element.isFile()){               //to move other files to the other folder
                Path path1 = Paths.get(str);
                Path filename = path1.getFileName();
                Path path2 = Paths.get(( dir + "Others"+"\\"+ filename ));
                try{
                    Files.move(path1,path2);
                    moved = true;
                    System.out.println("moved "+filename);
                 }catch(IOException e){
                  // e.printStackTrace();
                 }
           }
    }
  }
 /////////main program//////////////////////////////////
  public void startSort(String path, String img, String vid, String doc, String music)
  { 
     path = path + "\\";
  //  System.out.println(img);
     addItems(img, doc, vid, music); 
     System.out.println("Creating File...");
     createFile(path);
     System.out.println("listing File...");
     listFile(path);
     System.out.println("Sorting File...");
     sorter(path);
     System.out.println("Sorting Compleated :)");
     gui.finished();
  }
}
  